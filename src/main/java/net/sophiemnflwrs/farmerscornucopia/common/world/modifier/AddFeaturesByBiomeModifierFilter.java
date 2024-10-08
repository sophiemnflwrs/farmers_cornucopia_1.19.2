package net.sophiemnflwrs.farmerscornucopia.common.world.modifier;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCBiomeModifiers;

import java.util.Optional;

// credit to vectorwing for a majority of this code!

public record AddFeaturesByBiomeModifierFilter (
        HolderSet<Biome> allowedBiomes,
        Optional<HolderSet<Biome>> deniedBiomes,
        Optional<Float> minimumTemperature,
        Optional<Float> maximumTemperature,
        Optional<Float> minimumHumidity,
        Optional<Float> maximumHumidity,
        HolderSet<PlacedFeature> features,
        GenerationStep.Decoration step
) implements BiomeModifier {

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.ADD && this.allowedBiomes.contains(biome)) {
            if (deniedBiomes.isPresent() && this.deniedBiomes.get().contains(biome)) {
                return;
            }
            if (minimumTemperature.isPresent() && biome.get().getBaseTemperature() <= minimumTemperature.get()) {
                return;
            }
            if (maximumTemperature.isPresent() && biome.get().getBaseTemperature() >= maximumTemperature.get()) {
                return;
            }
            if (minimumHumidity.isPresent() && biome.get().getModifiedClimateSettings().downfall() <= minimumHumidity.get()) {
                return;
            }
            if (maximumHumidity.isPresent() && biome.get().getModifiedClimateSettings().downfall() >= maximumHumidity.get()) {
                return;
            }
            BiomeGenerationSettingsBuilder generationSettings = builder.getGenerationSettings();
            this.features.forEach(holder -> generationSettings.addFeature(this.step, holder));
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return FCBiomeModifiers.ADD_FEATURES_BY_FILTER.get();
    }

}

