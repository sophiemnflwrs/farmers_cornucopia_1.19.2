package net.sophiemnflwrs.farmerscornucopia.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwrs.farmerscornucopia.common.block.crop.GarlicCrop;
import net.sophiemnflwrs.farmerscornucopia.common.block.crop.GingerCrop;
import net.sophiemnflwrs.farmerscornucopia.common.block.shrub.LemonSeedling;
import net.sophiemnflwrs.farmerscornucopia.common.block.shrub.LemonShrub;
import net.sophiemnflwrs.farmerscornucopia.common.block.tree.FruitingLeavesBlock;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCBlocks;
import net.sophiemnflwrs.farmerscornucopia.common.utility.FCMiscUtility;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class BlockStatesProvider extends BlockStateProvider {

    private static final int DEFAULT_ANGLE_OFFSET = 180;

    public BlockStatesProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, FarmersCornucopia.MOD_ID, exFileHelper);
    }

    // helper methods
    private String blockName(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }
    public static ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(FarmersCornucopia.MOD_ID, "block/" + path);
    }
    public ModelFile existingModel(Block block) {
        return new ModelFile.ExistingModelFile(resourceBlock(blockName(block)), models().existingFileHelper);
    }
    public ModelFile existingModel(String path) {
        return new ModelFile.ExistingModelFile(resourceBlock(path), models().existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        // crop crates
        this.crateBlock(FCBlocks.GARLIC_CRATE.get(), "garlic");
        this.crateBlock(FCBlocks.GINGER_CRATE.get(), "ginger");
        this.crateBlock(FCBlocks.OLIVE_CRATE.get(), "olive");

        // salt ores + block
        this.simpleBlock(FCBlocks.SALT_ORE.get(), models().cubeAll("salt_ore", resourceBlock("salt_ore")));
        this.simpleBlock(FCBlocks.DEEPSLATE_SALT_ORE.get(), models().cubeAll("deepslate_salt_ore", resourceBlock("deepslate_salt_ore")));
        this.simpleBlock(FCBlocks.SALT_BLOCK.get(), models().cubeAll("salt_block", resourceBlock("salt_block")));

        // trees
        this.logBlock((RotatedPillarBlock) FCBlocks.OLIVE_LOG.get());
        this.logBlock((RotatedPillarBlock) FCBlocks.STRIPPED_OLIVE_LOG.get());
        this.simpleBlock(FCBlocks.OLIVE_LEAVES.get(), models().cubeAll("olive_leaves", resourceBlock("olive_leaves")));
        this.fruitingLeavesBlock(FCBlocks.FRUITING_OLIVE_LEAVES.get(), FruitingLeavesBlock.AGE);
        this.simpleBlock(FCBlocks.OLIVE_PLANKS.get(), models().cubeAll("olive_planks", resourceBlock("olive_planks")));
        this.simpleBlock(FCBlocks.OLIVE_SAPLING.get(), models().cross("olive_sapling", resourceBlock("olive_sapling")).renderType("cutout"));

        // shrubs
        this.shrubSeedlingBlock(FCBlocks.LEMON_SEEDLING.get(), LemonSeedling.AGE);
        this.upperLowerStageBlock(FCBlocks.LEMON_SHRUB.get(), LemonShrub.AGE, LemonShrub.HALF, LemonShrub.STUNTED);

        // wild crops
        this.wildCropBlock(FCBlocks.WILD_GARLIC.get());
        this.wildCropBlock(FCBlocks.WILD_GINGER.get());

        // crops
        this.customStageBlock(FCBlocks.GARLIC_CROP.get(), mcLoc("crop"), "crop", GarlicCrop.AGE, Arrays.asList(0, 0, 1, 1, 2, 2, 2, 3));
        this.customStageBlock(FCBlocks.GINGER_CROP.get(), mcLoc("crop"), "crop", GingerCrop.AGE, Arrays.asList(0, 0, 1, 1, 2, 2, 2, 3));

    }

    // main methods
    public void wildCropBlock(Block block) {
        this.wildCropBlock(block, false);
    }

    public void wildCropBlock(Block block, boolean isBushCrop) {
        if (isBushCrop) {
            this.simpleBlock(block, models().singleTexture(blockName(block), resourceBlock("bush_crop"), "crop", resourceBlock(blockName(block))).renderType("cutout"));
        } else {
            this.simpleBlock(block, models().cross(blockName(block), resourceBlock(blockName(block))).renderType("cutout"));
        }
    }

    public void shrubSeedlingBlock (Block block, IntegerProperty ageProperty) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            int ageSuffix = state.getValue(ageProperty);
            var seedling = existingModel(FCMiscUtility.name(block) + "_stage0");
            if (ageSuffix == 0) {
                return ConfiguredModel.builder().modelFile(seedling).build();
            } var mod = models()
                .withExistingParent(FCMiscUtility.name(block) + "_stage1", FCMiscUtility.rl("minecraft", "block/template_azalea"))
                .texture("side", resourceBlock(FCMiscUtility.name(block) + "_side_stage" + ageSuffix))
                .texture("top", resourceBlock(FCMiscUtility.name(block) + "_top_stage" + ageSuffix))
                .texture("plant", resourceBlock(FCMiscUtility.name(block) + "_stage" + ageSuffix))
                .texture("particle", resourceBlock(FCMiscUtility.name(block) + "_stage" + ageSuffix));
                ConfiguredModel.builder().modelFile(mod).build();

                return ConfiguredModel.builder().modelFile(mod).build();
        });
    }

    public void upperLowerStageBlock(Block block, IntegerProperty ageProperty, EnumProperty<DoubleBlockHalf> halfProperty, Property<?> ignored) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            String name = FCMiscUtility.name(block) + "_" + state.getValue(halfProperty).getSerializedName();
            var mod = models()
                    .withExistingParent("block/" + name + "_stage" + state.getValue(ageProperty), FCMiscUtility.cr(name))
                    .texture("side", resourceBlock(FCMiscUtility.name(block) + "_side_stage" + state.getValue(ageProperty)))
                    .texture("plant", resourceBlock(FCMiscUtility.name(block) + "_" + state.getValue(halfProperty).getSerializedName() + "_stage" + state.getValue(ageProperty)))
                    .texture("particle", resourceBlock(FCMiscUtility.name(block) + "_" + state.getValue(halfProperty).getSerializedName() + "_stage" + state.getValue(ageProperty)));
            if (state.getValue(halfProperty) == DoubleBlockHalf.UPPER) {
                mod.texture("top", resourceBlock(FCMiscUtility.name(block) + "_top_stage" + state.getValue(ageProperty)));
            }
            return ConfiguredModel.builder().modelFile(mod).build();
        }, ignored);
    }

    public void fruitingLeavesBlock(Block block, IntegerProperty ageProperty, Property<?>... ignored) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            String stageName = FCMiscUtility.name(block) + "_stage" + state.getValue(ageProperty);
            return ConfiguredModel.builder()
                    .modelFile(models().cubeAll(stageName, resourceBlock(stageName))).build();
        }, ignored);
    }

    public void customStageBlock(Block block, @Nullable ResourceLocation parent, String textureKey, IntegerProperty ageProperty, List<Integer> suffixes, Property<?>... ignored) {
        getVariantBuilder(block)
                .forAllStatesExcept(state -> {
                    int ageSuffix = state.getValue(ageProperty);
                    String stageName = blockName(block) + "_stage";
                    stageName += suffixes.isEmpty() ? ageSuffix : suffixes.get(Math.min(suffixes.size(), ageSuffix));
                    if (parent == null) {
                        return ConfiguredModel.builder()
                                .modelFile(models().cross(stageName, resourceBlock(stageName)).renderType("cutout")).build();
                    }
                    return ConfiguredModel.builder()
                            .modelFile(models().singleTexture(stageName, parent, textureKey, resourceBlock(stageName)).renderType("cutout")).build();
                }, ignored);
    }

    public void crateBlock(Block block, String cropName) {
        this.simpleBlock(block,
                models().cubeBottomTop(blockName(block), resourceBlock(cropName + "_crate_side"), resourceBlock("crate_bottom"), resourceBlock(cropName + "_crate_top")));
    }
}
