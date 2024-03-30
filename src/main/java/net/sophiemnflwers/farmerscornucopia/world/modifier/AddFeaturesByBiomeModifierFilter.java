package net.sophiemnflwers.farmerscornucopia.world.modifier;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.sophiemnflwers.farmerscornucopia.registry.ModBiomeModifiers;

import java.util.Optional;

public record AddFeaturesByBiomeModifierFilter (
        HolderSet<Biome> allowedBiomes,
        Optional<HolderSet<Biome>> deniedBiomes,
        Optional<Float> minimumTemperature,
        Optional<Float> maximumTemperature,
        Optional<Float> minimumHumidity,
        Optional<Float> maximumHumidity,
        Optional<HolderSet<Biome>> rainfall,
        Optional<HolderSet<Biome>> snowfall,
        HolderSet<PlacedFeature> features,
        GenerationStep.Decoration step
) implements BiomeModifier {
    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.ADD && this.allowedBiomes.contains(biome)) {
            if (deniedBiomes.isPresent() && this.deniedBiomes.get().contains(biome)) {
                return;
            }
            if (minimumTemperature.isPresent() && biome.get().getBaseTemperature() < minimumTemperature.get()) {
                return;
            }
            if (maximumTemperature.isPresent() && biome.get().getBaseTemperature() > maximumTemperature.get()) {
                return;
            }
            if (minimumHumidity.isPresent() && biome.get().getDownfall() <= minimumHumidity.get()) {
                return;
            }
            if (maximumHumidity.isPresent() && biome.get().getDownfall() >= maximumHumidity.get()) {
                return;
            }
            if (rainfall.isPresent() && biome.get().getPrecipitation() == Biome.Precipitation.RAIN) {
                return;
            }
            if (snowfall.isPresent() && biome.get().getPrecipitation() == Biome.Precipitation.SNOW){
                return;
            }
            BiomeGenerationSettingsBuilder generationSettings = builder.getGenerationSettings();
            this.features.forEach(holder -> generationSettings.addFeature(this.step, holder));
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return ModBiomeModifiers.ADD_FEATURES_BY_FILTER.get();
    }

}

