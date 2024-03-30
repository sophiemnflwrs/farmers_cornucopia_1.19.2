package net.sophiemnflwers.farmerscornucopia.world.feature;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sophiemnflwers.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwers.farmerscornucopia.world.configuration.SaltOreConfiguration;

import java.util.List;

public class SaltOreFeature {

    public static final DeferredRegister<PlacedFeature> SALT_ORE_FEATURE =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, FarmersCornucopia.MOD_ID);

    // helper methods
    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }
    public static List<PlacementModifier> commonOrePlacement(int p_195344_,PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    // placement config
    public static final RegistryObject<PlacedFeature> SALT_ORE_PLACED = SALT_ORE_FEATURE.register("salt_ore_placed",
            () -> new PlacedFeature(SaltOreConfiguration.SALT_ORE.getHolder().get(),
                    commonOrePlacement(40, // veins per chunk
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(120)))));

    // register
    public static void register(IEventBus eventBus) {
        SALT_ORE_FEATURE.register(eventBus);
    }

}
