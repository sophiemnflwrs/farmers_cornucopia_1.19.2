package net.sophiemnflwers.farmerscornucopia.registry;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sophiemnflwers.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwers.farmerscornucopia.world.modifier.AddFeaturesByBiomeModifierFilter;

import java.util.Optional;

public class ModBiomeModifiers {

    public static DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, FarmersCornucopia.MOD_ID);

    public static RegistryObject<Codec<AddFeaturesByBiomeModifierFilter>> ADD_FEATURES_BY_FILTER = BIOME_MODIFIER_SERIALIZERS.register("add_features_by_filter", () ->
            RecordCodecBuilder.create(builder -> builder.group(
                    Biome.LIST_CODEC.fieldOf("allowed_biomes").forGetter(AddFeaturesByBiomeModifierFilter::allowedBiomes),
                    Biome.LIST_CODEC.optionalFieldOf("denied_biomes").orElse(Optional.empty()).forGetter(AddFeaturesByBiomeModifierFilter::deniedBiomes),
                    Codec.FLOAT.optionalFieldOf("min_temperature").orElse(Optional.empty()).forGetter(AddFeaturesByBiomeModifierFilter::minimumTemperature),
                    Codec.FLOAT.optionalFieldOf("max_temperature").orElse(Optional.empty()).forGetter(AddFeaturesByBiomeModifierFilter::maximumTemperature),
                    Codec.FLOAT.optionalFieldOf("min_humidity").orElse(Optional.empty()).forGetter(AddFeaturesByBiomeModifierFilter::minimumHumidity),
                    Codec.FLOAT.optionalFieldOf("max_humidity").orElse(Optional.empty()).forGetter(AddFeaturesByBiomeModifierFilter::maximumHumidity),
                    Biome.LIST_CODEC.optionalFieldOf("rainfall").orElse(Optional.empty()).forGetter(AddFeaturesByBiomeModifierFilter::rainfall),
                    Biome.LIST_CODEC.optionalFieldOf("snowfall").orElse(Optional.empty()).forGetter(AddFeaturesByBiomeModifierFilter::snowfall),
                    PlacedFeature.LIST_CODEC.fieldOf("features").forGetter(AddFeaturesByBiomeModifierFilter::features),
                    GenerationStep.Decoration.CODEC.fieldOf("step").forGetter(AddFeaturesByBiomeModifierFilter::step)
            ).apply(builder, AddFeaturesByBiomeModifierFilter::new)));
}
