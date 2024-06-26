package net.sophiemnflwrs.farmerscornucopia.common.world.configuration;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCBlocks;

import java.util.List;

public class SaltOreConfiguration {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> SALT_ORE_CONFIG =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, FarmersCornucopia.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SALT_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, FCBlocks.SALT_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, FCBlocks.DEEPSLATE_SALT_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SALT_ORE = SALT_ORE_CONFIG.register("salt_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_SALT_ORES.get(), 8)));

    // register
    public static void register(IEventBus eventBus) {
        SALT_ORE_CONFIG.register(eventBus);
    }
}
