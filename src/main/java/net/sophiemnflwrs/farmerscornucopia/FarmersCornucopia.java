package net.sophiemnflwrs.farmerscornucopia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sophiemnflwrs.farmerscornucopia.common.CommonSetup;
import net.sophiemnflwrs.farmerscornucopia.common.Configuration;
import net.sophiemnflwrs.farmerscornucopia.common.registry.*;
import net.sophiemnflwrs.farmerscornucopia.common.world.configuration.SaltOreConfiguration;
import net.sophiemnflwrs.farmerscornucopia.common.world.feature.SaltOreFeature;
import net.sophiemnflwrs.farmerscornucopia.datagen.DataGenerators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.nullness.qual.NonNull;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FarmersCornucopia.MOD_ID)
public class FarmersCornucopia {

    public static final String MOD_ID = "farmerscornucopia";
    private static final Logger LOGGER = LogManager.getLogger();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    // creative tab
    public static final CreativeModeTab CREATIVE_TAB = new CreativeModeTab("farmerscornucopiatab") {
        @NonNull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(FCItems.GARLIC.get());
        }
    };

    public FarmersCornucopia() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(CommonSetup::init);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Configuration.COMMON_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Configuration.CLIENT_CONFIG);

        MinecraftForge.EVENT_BUS.register(DataGenerators.class);

        FCBlocks.register(modEventBus);
        FCItems.register(modEventBus);
        FCPlacementModifiers.PLACEMENT_MODIFIERS.register(modEventBus);
        FCBiomeFeatures.FEATURES.register(modEventBus);
        FCBiomeModifiers.BIOME_MODIFIER_SERIALIZERS.register(modEventBus);
        SaltOreConfiguration.register(modEventBus);
        SaltOreFeature.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

    }

        // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
        @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
        public static class ClientModEvents {

    };
}
