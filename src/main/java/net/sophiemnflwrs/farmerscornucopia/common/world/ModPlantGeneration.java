package net.sophiemnflwrs.farmerscornucopia.common.world;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.DarkOakFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwrs.farmerscornucopia.common.Configuration;
import net.sophiemnflwrs.farmerscornucopia.common.block.bush.BlueberryBush;
import net.sophiemnflwrs.farmerscornucopia.common.block.shrub.LemonShrub;
import net.sophiemnflwrs.farmerscornucopia.common.block.tree.FruitingLeavesBlock;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCBiomeFeatures;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCBlocks;
import net.sophiemnflwrs.farmerscornucopia.common.world.configuration.WildCropConfiguration;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.List;
import java.util.OptionalInt;

import static net.minecraft.tags.BlockTags.DIRT;
import static net.minecraft.world.level.levelgen.feature.Feature.SIMPLE_BLOCK;

public class ModPlantGeneration {

    // feature generation
    public static Holder<ConfiguredFeature<TreeConfiguration, ?>> FEATURE_OLIVE_TREE;

    public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FEATURE_PATCH_LEMON_SHRUB;

    public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FEATURE_PATCH_BLUEBERRY_BUSH;

    public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_CHILI_PEPPER;
    public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_GARLIC;
    public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_GINGER;

    public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FEATURE_PATCH_VIOLET;

    // placement generation
    public static Holder<PlacedFeature> OLIVE_TREE;

    public static Holder<PlacedFeature> PATCH_LEMON_SHRUB;

    public static Holder<PlacedFeature> PATCH_BLUEBERRY_BUSH;

    public static Holder<PlacedFeature> PATCH_WILD_CHILI_PEPPER;
    public static Holder<PlacedFeature> PATCH_WILD_GARLIC;
    public static Holder<PlacedFeature> PATCH_WILD_GINGER;

    public static Holder<PlacedFeature> PATCH_VIOLET;

    // helper variables
    public static final BlockPos BLOCK_BELOW = new BlockPos(0, -1, 0);
    public static final BlockPos BLOCK_ABOVE = new BlockPos(0, 1, 0);


    // configuration of that generation
    public static void registerModPlantGeneration() {

        // feature config
        FEATURE_OLIVE_TREE = register(new ResourceLocation(FarmersCornucopia.MOD_ID, "olive_tree"),
                FCBiomeFeatures.FRUITING_TREES.get(), new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(FCBlocks.OLIVE_LOG.get()),
                        new DarkOakTrunkPlacer(6, 3, 1),
                        new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(FCBlocks.OLIVE_LEAVES.get().defaultBlockState(), 4)
                                .add(FCBlocks.FRUITING_OLIVE_LEAVES.get().defaultBlockState().setValue(FruitingLeavesBlock.AGE, 4), 1)),
                        new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),
                        new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())).build());

        FEATURE_PATCH_LEMON_SHRUB = register(new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_lemon_shrub"),
                RandomPatchFeature.RANDOM_PATCH, shrubConfig(FCBlocks.LEMON_SHRUB.get().defaultBlockState().setValue(LemonShrub.AGE, LemonShrub.MAX_AGE), BlockPredicate.matchesTag(BLOCK_BELOW, DIRT)));

        FEATURE_PATCH_BLUEBERRY_BUSH = register(new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_blueberry_bush"),
                RandomPatchFeature.RANDOM_PATCH, bushConfig(FCBlocks.BLUEBERRY_BUSH.get().defaultBlockState().setValue(BlueberryBush.AGE, BlueberryBush.MAX_AGE), BlockPredicate.matchesTag(BLOCK_BELOW, DIRT)));

        FEATURE_PATCH_WILD_CHILI_PEPPER = register(new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_wild_chili_pepper"),
                FCBiomeFeatures.WILD_CROP.get(), wildCropConfig(FCBlocks.WILD_CHILI_PEPPER.get(), Blocks.GRASS, BlockPredicate.matchesTag(BLOCK_BELOW, ModTags.TERRAIN)));
        FEATURE_PATCH_WILD_GARLIC = register(new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_wild_garlic"),
                FCBiomeFeatures.WILD_CROP.get(), wildCropConfig(FCBlocks.WILD_GARLIC.get(), Blocks.GRASS, BlockPredicate.matchesTag(BLOCK_BELOW, DIRT)));
        FEATURE_PATCH_WILD_GINGER = register(new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_wild_ginger"),
                FCBiomeFeatures.WILD_CROP.get(), wildCropConfig(FCBlocks.WILD_GINGER.get(), Blocks.FERN, BlockPredicate.matchesTag(BLOCK_BELOW, DIRT)));

        FEATURE_PATCH_VIOLET = register(new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_violet"),
                RandomPatchFeature.FLOWER, flowerConfig(FCBlocks.VIOLET.get(), BlockPredicate.matchesTag(BLOCK_BELOW, DIRT)));

        // placement config
        OLIVE_TREE = registerPlacement(new ResourceLocation(FarmersCornucopia.MOD_ID, "olive_tree"),
                FEATURE_OLIVE_TREE, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_OLIVE_TREE.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(FCBlocks.OLIVE_SAPLING.get()), PlacementUtils.isEmpty(), BiomeFilter.biome());

        PATCH_LEMON_SHRUB = registerPlacement(new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_lemon_shrub"),
                FEATURE_PATCH_LEMON_SHRUB, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_LEMON_SHRUB.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        PATCH_BLUEBERRY_BUSH = registerPlacement(new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_blueberry_bush"),
                FEATURE_PATCH_BLUEBERRY_BUSH, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_BLUEBERRY_BUSH.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        PATCH_WILD_CHILI_PEPPER = registerPlacement(new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_wild_chili_pepper"),
                FEATURE_PATCH_WILD_GARLIC, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_CHILI_PEPPER.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        PATCH_WILD_GARLIC = registerPlacement(new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_wild_garlic"),
                FEATURE_PATCH_WILD_GARLIC, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_GARLIC.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        PATCH_WILD_GINGER = registerPlacement(new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_wild_ginger"),
                FEATURE_PATCH_WILD_GINGER, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_GINGER.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        PATCH_VIOLET = registerPlacement(new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_violet"),
                FEATURE_PATCH_VIOLET, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_VIOLET.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    }

    // helper methods
    public static Holder<PlacedFeature> plantBlockConfig(Block block, BlockPredicate plantedOn) {
        return PlacementUtils.filtered(
                SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(block)),
                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, plantedOn));
    }

    // main methods
    public static RandomPatchConfiguration shrubConfig(BlockState block, BlockPredicate plantedOn) {
        return new RandomPatchConfiguration(256, 4, 3, PlacementUtils.filtered(FCBiomeFeatures.FRUITING_SHRUBS.get(),
                new SimpleBlockConfiguration(BlockStateProvider.simple(block)), BlockPredicate.allOf(plantedOn, BlockPredicate.ONLY_IN_AIR_PREDICATE)));
    }

    public static RandomPatchConfiguration bushConfig(BlockState block, BlockPredicate plantedOn) {
        return new RandomPatchConfiguration(256, 4, 3, PlacementUtils.filtered(FCBiomeFeatures.FRUITING_BUSH.get(),
                new SimpleBlockConfiguration(BlockStateProvider.simple(block)), BlockPredicate.allOf(plantedOn, BlockPredicate.ONLY_IN_AIR_PREDICATE)));
    }

    public static WildCropConfiguration wildCropConfig(Block primaryBlock, Block secondaryBlock, BlockPredicate plantedOn) {
        return new WildCropConfiguration(256, 6, 3, plantBlockConfig(primaryBlock, plantedOn), plantBlockConfig(secondaryBlock, plantedOn), null);
    }

    public static RandomPatchConfiguration flowerConfig(Block block, BlockPredicate plantedOn) {
        return new RandomPatchConfiguration(256, 6, 3, plantBlockConfig(block, plantedOn));
    }

    // register
    static Holder<PlacedFeature> registerPlacement(ResourceLocation id, Holder<? extends ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
        return BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, id, new PlacedFeature(Holder.hackyErase(feature), List.of(modifiers)));
    }
    protected static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> register(ResourceLocation id, F feature, FC featureConfig) {
        return register(BuiltinRegistries.CONFIGURED_FEATURE, id, new ConfiguredFeature<>(feature, featureConfig));
    }
    private static <V extends T, T> Holder<V> register(Registry<T> registry, ResourceLocation id, V value) {
        return (Holder<V>) BuiltinRegistries.<T>register(registry, id, value);
    }
}
