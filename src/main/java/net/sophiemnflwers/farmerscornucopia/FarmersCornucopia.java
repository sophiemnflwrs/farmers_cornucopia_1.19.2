package net.sophiemnflwers.farmerscornucopia;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.sophiemnflwers.farmerscornucopia.common.CommonSetup;
import net.sophiemnflwers.farmerscornucopia.common.Configuration;
import net.sophiemnflwers.farmerscornucopia.common.registry.*;
import net.sophiemnflwers.farmerscornucopia.common.world.configuration.SaltOreConfiguration;
import net.sophiemnflwers.farmerscornucopia.common.world.feature.SaltOreFeature;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.slf4j.Logger;
import vectorwing.farmersdelight.client.ClientSetup;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FarmersCornucopia.MOD_ID)
public class FarmersCornucopia {

    public static final String MOD_ID = "farmerscornucopia";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final CreativeModeTab CREATIVE_TAB = new CreativeModeTab("farmerscornucopiatab") {
        @NonNull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(FCItems.GARLIC.get());
        }
    };

    public FarmersCornucopia() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(CommonSetup::init);
        if (FMLEnvironment.dist.isClient()) {
            modEventBus.addListener(ClientSetup::init);
        }
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Configuration.COMMON_CONFIG);

        FCBlocks.register(modEventBus);
        FCItems.register(modEventBus);
        FCPlacementModifiers.PLACEMENT_MODIFIERS.register(modEventBus);
        FCBiomeFeatures.FEATURES.register(modEventBus);
        FCBiomeModifiers.BIOME_MODIFIER_SERIALIZERS.register(modEventBus);
        SaltOreConfiguration.register(modEventBus);
        SaltOreFeature.register(modEventBus);


    }

        // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
        @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
        public static class ClientModEvents {

    };
}
