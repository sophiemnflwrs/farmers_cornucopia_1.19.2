package net.sophiemnflwrs.farmerscornucopia.common.world.feature.tree;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.sophiemnflwrs.farmerscornucopia.common.world.ModPlantGeneration;

public class OliveTreeGrower extends AbstractTreeGrower {

    @Override
    public Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean hasFlowers) {
        return ModPlantGeneration.FEATURE_OLIVE_TREE;
    }
}
