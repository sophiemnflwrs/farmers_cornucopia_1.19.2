package net.sophiemnflwers.farmerscornucopia.registry;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sophiemnflwers.farmerscornucopia.FarmersCornucopia;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FarmersCornucopia.MOD_ID);

    // helper methods for sorting
    public static Properties basicItem() {
        return new Properties().tab(FarmersCornucopia.CREATIVE_TAB);
    }

    public static Properties foodItem(FoodProperties food) {
        return new Properties().food(food).tab(FarmersCornucopia.CREATIVE_TAB);

    }
    // foodstuffs
    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () -> new Item(foodItem(new FoodProperties.Builder().nutrition(1).saturationMod(1f).build()).tab(FarmersCornucopia.CREATIVE_TAB)));

    public static final RegistryObject<Item> GARLIC = ITEMS.register("garlic",
            () -> new Item(foodItem(new FoodProperties.Builder().nutrition(2).saturationMod(2f).build()).tab(FarmersCornucopia.CREATIVE_TAB)));

    public static final RegistryObject<Item> GARLIC_CLOVE = ITEMS.register("garlic_clove",
            () -> new Item(foodItem(new FoodProperties.Builder().nutrition(1).saturationMod(1f).build()).tab(FarmersCornucopia.CREATIVE_TAB)));







    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
