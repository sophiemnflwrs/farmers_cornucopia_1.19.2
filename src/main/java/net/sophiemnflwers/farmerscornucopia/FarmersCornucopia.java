package net.sophiemnflwers.farmerscornucopia;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sophiemnflwers.farmerscornucopia.registry.ModBiomeModifiers;
import net.sophiemnflwers.farmerscornucopia.registry.ModBlocks;
import net.sophiemnflwers.farmerscornucopia.registry.ModItems;
import net.sophiemnflwers.farmerscornucopia.world.configuration.SaltOreConfiguration;
import net.sophiemnflwers.farmerscornucopia.world.feature.SaltOreFeature;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FarmersCornucopia.MOD_ID)
public class FarmersCornucopia {

    public static final String MOD_ID = "farmerscornucopia";
    private static final Logger LOGGER = LogUtils.getLogger();

    public FarmersCornucopia() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModBiomeModifiers.BIOME_MODIFIER_SERIALIZERS.register(modEventBus);
        SaltOreConfiguration.register(modEventBus);
        SaltOreFeature.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    // creative tab fuckery
    public static final CreativeModeTab CREATIVE_TAB = new CreativeModeTab("farmerscornucopiatab") {
        @NonNull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.GARLIC.get());
        }
        public void fillItemList(@NotNull NonNullList<ItemStack> p_40778_) {
            for (Item item : Registry.ITEM) {
                item.fillItemCategory(this, p_40778_);
            }
        }

        // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
        @SuppressWarnings("removal")
        @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
        public static class ClientModEvents {

            // make plant sprites have transparent pixels
            @SubscribeEvent
            public static void onClientSetup(FMLClientSetupEvent event) {
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_GARLIC.get(), RenderType.cutoutMipped());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.GARLIC_CROP.get(), RenderType.cutoutMipped());
            }
        }
    };
}
