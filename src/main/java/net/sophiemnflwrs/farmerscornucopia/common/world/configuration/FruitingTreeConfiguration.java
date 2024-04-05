package net.sophiemnflwrs.farmerscornucopia.common.world.configuration;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.DiscreteVoxelShape;

import java.util.HashMap;
import java.util.Set;
import java.util.function.BiConsumer;

public abstract class FruitingTreeConfiguration extends Feature<TreeConfiguration> {
    public Set<BlockPos> logPositions;
    public Set<BlockPos> foliagePositions;

    public HashMap<BlockPos, BlockState> specialLogPositions;
    public HashMap<BlockPos, BlockState> specialFoliagePositions;

    public boolean placeDirt;

    public FruitingTreeConfiguration(Codec<TreeConfiguration> config) {
        this(true, config);
    }

    public FruitingTreeConfiguration(boolean placeDirt, Codec<TreeConfiguration> config) {
        super(config);
        this.placeDirt = placeDirt;
    }

    @Override
    public boolean place(FeaturePlaceContext<TreeConfiguration> context) {
        TreeConfiguration config = context.config();
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos origin = context.origin();

        this.logPositions = Sets.newHashSet();
        this.foliagePositions = Sets.newHashSet();
        this.specialLogPositions = Maps.newHashMap();
        this.specialFoliagePositions = Maps.newHashMap();

        if (this.canSurvive(level, origin)) {
            this.doPlace(context);

            for (BlockPos logPos : this.logPositions) {
                if (!TreeFeature.validTreePos(level, logPos) || logPos.getY() > level.getMaxBuildHeight())
                    return false;
            }

            for (BlockPos foliagePos : this.foliagePositions) {
                if (!TreeFeature.validTreePos(level, foliagePos) || foliagePos.getY() > level.getMaxBuildHeight())
                    return false;
            }

            this.doMidPlace(context);

            this.logPositions.forEach(logPos -> {
                level.setBlock(logPos, this.specialLogPositions.getOrDefault(logPos, config.trunkProvider.getState(random, logPos)), 19);
                if (logPos.getY() == origin.getY() && this.placeDirt) {
                    setDirtAt(level, random, logPos.below(), config);
                }
            });
            this.foliagePositions.forEach(foliagePos -> {
                if (TreeFeature.validTreePos(level, foliagePos)) {
                    BlockState state = this.specialFoliagePositions.getOrDefault(foliagePos, config.foliageProvider.getState(random, foliagePos));

                    if (state.hasProperty(BlockStateProperties.WATERLOGGED)) {
                        state = state.setValue(BlockStateProperties.WATERLOGGED, level.isFluidAtPosition(foliagePos, (fluidState) -> fluidState.isSourceOfType(Fluids.WATER)));
                    }

                    if (!state.isAir()) {
                        level.setBlock(foliagePos, state, 19);
                    }
                }
            });

            Set<BlockPos> decorationPositions = Sets.newHashSet();
            BiConsumer<BlockPos, BlockState> decorationSetter = (decorationPos, state) -> {
                decorationPositions.add(decorationPos.immutable());
                level.setBlock(decorationPos, state, 19);
            };

            if (!config.decorators.isEmpty()) {
                TreeDecorator.Context decoratorContext = new TreeDecorator.Context(level, decorationSetter, random, this.logPositions, this.foliagePositions, Sets.newHashSet());
                config.decorators.forEach((decorator) -> decorator.place(decoratorContext));
            }

            this.doPostPlace(context);

            return BoundingBox.encapsulatingPositions(Iterables.concat(this.logPositions, this.foliagePositions, decorationPositions)).map((boundingBox) -> {
                DiscreteVoxelShape shape = TreeFeature.updateLeaves(level, boundingBox, this.logPositions, decorationPositions, Set.of());
                StructureTemplate.updateShapeAtEdge(level, 3, shape, boundingBox.minX(), boundingBox.minY(), boundingBox.minZ());
                return true;
            }).orElse(false);
        } else {
            return false;
        }
    }

    public abstract BlockState getSapling();

    public boolean canSurvive(WorldGenLevel level, BlockPos pos) {
        return this.getSapling().canSurvive(level, pos);
    }

    public abstract void doPlace(FeaturePlaceContext<TreeConfiguration> context);

    public void doMidPlace(FeaturePlaceContext<TreeConfiguration> context) {
    }

    public void doPostPlace(FeaturePlaceContext<TreeConfiguration> context) {
    }

    public void addLog(BlockPos pos) {
        this.logPositions.add(pos.immutable());
    }

    public void addAxisLog(BlockPos pos, Direction.Axis axis, TreeConfiguration config, RandomSource random) {
        BlockState state = config.trunkProvider.getState(random, pos);
        if (state.hasProperty(BlockStateProperties.AXIS)) {
            this.addSpecialLog(pos, state.setValue(BlockStateProperties.AXIS, axis));
        } else {
            this.addLog(pos);
        }
    }

    public void addAxisLog(BlockPos pos, Direction direction, TreeConfiguration config, RandomSource random) {
        this.addAxisLog(pos, direction.getAxis(), config, random);
    }

    public void addSpecialLog(BlockPos pos, BlockState state) {
        this.addLog(pos);
        this.specialLogPositions.put(pos.immutable(), state);
    }

    public void addFoliage(BlockPos pos) {
        this.foliagePositions.add(pos.immutable());
    }

    public void addSpecialFoliage(BlockPos pos, BlockState state) {
        this.addFoliage(pos);
        this.specialFoliagePositions.put(pos.immutable(), state);
    }

    public static void setDirtAt(WorldGenLevel level, RandomSource random, BlockPos pos, TreeConfiguration config) {
        if (config.forceDirt || level.isStateAtPosition(pos, state -> state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.MYCELIUM))) {
            level.setBlock(pos, config.dirtProvider.getState(random, pos), 19);
        }
    }
}