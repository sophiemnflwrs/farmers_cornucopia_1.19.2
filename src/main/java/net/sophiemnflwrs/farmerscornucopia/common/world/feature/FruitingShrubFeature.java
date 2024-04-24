package net.sophiemnflwrs.farmerscornucopia.common.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class FruitingShrubFeature extends Feature<RandomPatchConfiguration> {
    public FruitingShrubFeature(Codec<RandomPatchConfiguration> codec) {
        super(codec);
    }

    // places the given feature at the given location. features are placed within a 3x3 region of chunks, centering on the chunk being generated.

    @Override
    public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
        RandomPatchConfiguration config = context.config();
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        int i = 0;
        int tries = config.tries();
        int xzSpread = config.xzSpread() + 1;
        int ySpread = config.ySpread() + 1;

        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        Holder<PlacedFeature> feature = config.feature();
        if (feature != null) {
            for (int j = 0; j < tries; ++j) {
                mutablePos.setWithOffset(origin, random.nextInt(xzSpread) - random.nextInt(xzSpread), random.nextInt(ySpread) - random.nextInt(ySpread), random.nextInt(xzSpread) - random.nextInt(xzSpread));
                if (config.feature().value().place(level, context.chunkGenerator(), random, mutablePos)) {
                    ++i;
                }
            }
        }

        return i > 0;
    }
}
