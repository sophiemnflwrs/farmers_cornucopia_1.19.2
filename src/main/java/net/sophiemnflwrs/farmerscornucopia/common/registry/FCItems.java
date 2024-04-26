package net.sophiemnflwrs.farmerscornucopia.common.registry;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwrs.farmerscornucopia.common.FoodValues;
import net.sophiemnflwrs.farmerscornucopia.common.item.DrinkableItem;
import net.sophiemnflwrs.farmerscornucopia.common.item.drinks.CreamItem;

public class FCItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FarmersCornucopia.MOD_ID);

    // helper methods
    public static Properties basicItem() {
        return new Properties().tab(FarmersCornucopia.CREATIVE_TAB);
    }
    public static Properties foodItem(FoodProperties food) {
        return new Properties().food(food).tab(FarmersCornucopia.CREATIVE_TAB);
    }
    public static Item.Properties drinkItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(FarmersCornucopia.CREATIVE_TAB);
    }

    // crop crates
    public static final RegistryObject<Item> GARLIC_CRATE = ITEMS.register("garlic_crate",
            () -> new BlockItem(FCBlocks.GARLIC_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> GINGER_CRATE = ITEMS.register("ginger_crate",
            () -> new BlockItem(FCBlocks.GINGER_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> OLIVE_CRATE = ITEMS.register("olive_crate",
            () -> new BlockItem(FCBlocks.OLIVE_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> LEMON_CRATE = ITEMS.register("lemon_crate",
                () -> new BlockItem(FCBlocks.LEMON_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> BLUEBERRY_CRATE = ITEMS.register("blueberry_crate",
            () -> new BlockItem(FCBlocks.BLUEBERRY_CRATE.get(), basicItem()));

    // salt blocks
    public static final RegistryObject<Item> SALT_BLOCK = ITEMS.register("salt_block",
            () -> new BlockItem(FCBlocks.SALT_BLOCK.get(), basicItem()));
    public static final RegistryObject<Item> SALT_ORE = ITEMS.register("salt_ore",
            () -> new BlockItem(FCBlocks.SALT_ORE.get(), basicItem()));
    public static final RegistryObject<Item> DEEPSLATE_SALT_ORE = ITEMS.register("deepslate_salt_ore",
            () -> new BlockItem(FCBlocks.DEEPSLATE_SALT_ORE.get(), basicItem()));

    // trees
    public static final RegistryObject<Item> OLIVE_LOG = ITEMS.register("olive_log",
            () -> new BlockItem(FCBlocks.OLIVE_LOG.get(), basicItem()));
    public static final RegistryObject<Item> STRIPPED_OLIVE_LOG = ITEMS.register("stripped_olive_log",
            () -> new BlockItem(FCBlocks.STRIPPED_OLIVE_LOG.get(), basicItem()));
    public static final RegistryObject<Item> OLIVE_LEAVES = ITEMS.register("olive_leaves",
            () -> new BlockItem(FCBlocks.OLIVE_LEAVES.get(), basicItem()));
    public static final RegistryObject<Item> FRUITING_OLIVE_LEAVES = ITEMS.register("fruiting_olive_leaves",
            () -> new BlockItem(FCBlocks.FRUITING_OLIVE_LEAVES.get(), basicItem()));
    public static final RegistryObject<Item> OLIVE_PLANKS = ITEMS.register("olive_planks",
            () -> new BlockItem(FCBlocks.OLIVE_PLANKS.get(), basicItem()));
    public static final RegistryObject<Item> OLIVE_SAPLING = ITEMS.register("olive_sapling",
            () -> new BlockItem(FCBlocks.OLIVE_SAPLING.get(), basicItem()));

    // wild crops
    public static final RegistryObject<Item> WILD_GARLIC = ITEMS.register("wild_garlic",
            () -> new BlockItem(FCBlocks.WILD_GARLIC.get(), basicItem()));
    public static final RegistryObject<Item> WILD_GINGER = ITEMS.register("wild_ginger",
            () -> new BlockItem(FCBlocks.WILD_GINGER.get(), basicItem()));

    // foodstuffs
    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () -> new Item(foodItem(FoodValues.SALT)));
    public static final RegistryObject<Item> CREAM = ITEMS.register("cream",
            () -> new CreamItem(drinkItem(FoodValues.CREAM)));
    public static final RegistryObject<Item> BUTTER = ITEMS.register("butter",
            () -> new Item(foodItem(FoodValues.BUTTER)));
    public static final RegistryObject<Item> OLIVE_OIL = ITEMS.register("olive_oil",
            () -> new DrinkableItem(drinkItem(FoodValues.OLIVE_OIL)));
    public static final RegistryObject<Item> AIOLI = ITEMS.register("aioli",
            () -> new Item(foodItem(FoodValues.AIOLI)));

    // crops
    public static final RegistryObject<Item> GARLIC = ITEMS.register("garlic",
            () -> new Item(foodItem(FoodValues.GARLIC)));
    public static final RegistryObject<Item> GINGER = ITEMS.register("ginger",
            () -> new Item(foodItem(FoodValues.GINGER)));

    public static final RegistryObject<Item> OLIVE = ITEMS.register("olive",
            () -> new Item(foodItem(FoodValues.OLIVE)));
    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon",
            () -> new Item(foodItem(FoodValues.LEMON)));
    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry",
            () -> new Item(foodItem(FoodValues.BLUEBERRY)));

    // seeds
    public static final RegistryObject<Item> GARLIC_CLOVE = ITEMS.register("garlic_clove",
            () -> new ItemNameBlockItem(FCBlocks.GARLIC_CROP.get(), foodItem(FoodValues.GARLIC_CLOVE)));
    public static final RegistryObject<Item> GINGER_SEEDS = ITEMS.register("ginger_seeds",
            () -> new ItemNameBlockItem(FCBlocks.GINGER_CROP.get(), basicItem()));
    public static final RegistryObject<Item> LEMON_SEEDS = ITEMS.register("lemon_seeds",
            () -> new ItemNameBlockItem(FCBlocks.LEMON_SEEDLING.get(), basicItem()));
    public static final RegistryObject<Item> BLUEBERRY_SEEDS = ITEMS.register("blueberry_seeds",
            () -> new ItemNameBlockItem(FCBlocks.BLUEBERRY_BUSH.get(), basicItem()));

    // drinks
    public static final RegistryObject<Item> LEMONADE = ITEMS.register("lemonade",
            () -> new DrinkableItem(drinkItem(FoodValues.LEMONADE)));

    // meals + food items
    public static final RegistryObject<Item> GARLIC_BREAD = ITEMS.register("garlic_bread",
            () -> new Item(foodItem(FoodValues.GARLIC_BREAD)));

    // register
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
