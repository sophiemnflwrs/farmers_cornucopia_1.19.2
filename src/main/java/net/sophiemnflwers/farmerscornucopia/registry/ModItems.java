package net.sophiemnflwers.farmerscornucopia.registry;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sophiemnflwers.farmerscornucopia.FarmersCornucopia;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FarmersCornucopia.MOD_ID);

    // helper methods
    public static Properties basicItem() {
        return new Properties().tab(FarmersCornucopia.CREATIVE_TAB);
    }
    public static Properties foodItem(FoodProperties food) {
        return new Properties().food(food).tab(FarmersCornucopia.CREATIVE_TAB);
    }

    // blocks
    public static final RegistryObject<Item> SALT_BLOCK = ITEMS.register("salt_block",
            () -> new BlockItem(ModBlocks.SALT_BLOCK.get(), basicItem()));

    public static final RegistryObject<Item> SALT_ORE = ITEMS.register("salt_ore",
            () -> new BlockItem(ModBlocks.SALT_ORE.get(), basicItem()));

    public static final RegistryObject<Item> DEEPSLATE_SALT_ORE = ITEMS.register("deepslate_salt_ore",
            () -> new BlockItem(ModBlocks.DEEPSLATE_SALT_ORE.get(), basicItem()));

    // wild crops
    public static final RegistryObject<Item> WILD_GARLIC = ITEMS.register("wild_garlic",
            () -> new BlockItem(ModBlocks.WILD_GARLIC.get(), basicItem()));

    // seeds
    public static final RegistryObject<Item> GARLIC_CLOVE = ITEMS.register("garlic_clove",
            () -> new ItemNameBlockItem(ModBlocks.GARLIC_CROP.get(), basicItem()));

    // foodstuffs
    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () -> new Item(foodItem(new FoodProperties.Builder().nutrition(1).saturationMod(1f).build())));

    public static final RegistryObject<Item> GARLIC = ITEMS.register("garlic",
            () -> new Item(foodItem(new FoodProperties.Builder().nutrition(2).saturationMod(0.4f).build())));


    // register
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
