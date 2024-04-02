package net.sophiemnflwrs.farmerscornucopia.common.registry;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwrs.farmerscornucopia.common.world.configuration.WildCropConfiguration;
import net.sophiemnflwrs.farmerscornucopia.common.world.feature.WildCropFeature;

public class FCBiomeFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, FarmersCornucopia.MOD_ID);

    public static final RegistryObject<Feature<WildCropConfiguration>> WILD_CROP = FEATURES.register("wild_crop", () -> new WildCropFeature(WildCropConfiguration.CODEC));
}
