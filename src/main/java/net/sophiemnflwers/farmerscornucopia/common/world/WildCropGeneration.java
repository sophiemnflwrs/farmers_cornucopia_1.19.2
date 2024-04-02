package net.sophiemnflwers.farmerscornucopia.common.world;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.sophiemnflwers.farmerscornucopia.common.Configuration;
import net.sophiemnflwers.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwers.farmerscornucopia.common.registry.FCBiomeFeatures;
import net.sophiemnflwers.farmerscornucopia.common.registry.FCBlocks;
import net.sophiemnflwers.farmerscornucopia.common.world.configuration.WildCropConfiguration;

import java.util.List;

public class WildCropGeneration {

    // helper methods
    public static Holder<PlacedFeature> plantBlockConfig(Block block, BlockPredicate plantedOn) {
        return PlacementUtils.filtered(
                Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(block)),
                BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, plantedOn));
    }
    public static Holder<PlacedFeature> floorBlockConfig(Block block, BlockPredicate replaces) {
        return PlacementUtils.filtered(
                Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(block)),
                BlockPredicate.allOf(BlockPredicate.replaceable(BLOCK_ABOVE), replaces));
    }

    // main helper methods
    public static WildCropConfiguration wildCropConfig(Block primaryBlock, Block secondaryBlock, BlockPredicate plantedOn) {
        return new WildCropConfiguration(128, 6, 3, plantBlockConfig(primaryBlock, plantedOn), plantBlockConfig(secondaryBlock, plantedOn), null);
    }

    // generation
    public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_GARLIC;

    public static Holder<PlacedFeature> PATCH_WILD_GARLIC;

    public static final BlockPos BLOCK_BELOW = new BlockPos(0, -1, 0);
    public static final BlockPos BLOCK_ABOVE = new BlockPos(0, 1, 0);

    public static void registerWildCropGeneration() {

        // feature config
        FEATURE_PATCH_WILD_GARLIC = register(new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_wild_garlic"),
                FCBiomeFeatures.WILD_CROP.get(), wildCropConfig(FCBlocks.WILD_GARLIC.get(), Blocks.GRASS, BlockPredicate.matchesTag(BLOCK_BELOW, BlockTags.DIRT)));

        // placement config
        PATCH_WILD_GARLIC = registerPlacement(new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_wild_garlic"),
                FEATURE_PATCH_WILD_GARLIC, RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_GARLIC.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
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
