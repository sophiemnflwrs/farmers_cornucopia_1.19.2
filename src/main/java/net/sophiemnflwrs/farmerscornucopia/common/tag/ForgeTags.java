package net.sophiemnflwrs.farmerscornucopia.common.tag;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ForgeTags {

    // registry
    private static TagKey<Block> forgeBlockTag(String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("forge", path));
    }

    private static TagKey<Item> forgeItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", path));
    }

    // seeds
    public static final TagKey<Item> SEEDS = forgeItemTag("seeds");
    public static final TagKey<Item> SEEDS_GARLIC = forgeItemTag("seeds/garlic");
    public static final TagKey<Item> SEEDS_GINGER = forgeItemTag("seeds/ginger");
    public static final TagKey<Item> SEEDS_LEMON = forgeItemTag("seeds/lemon");

    // crops
    public static final TagKey<Item> CROPS = forgeItemTag("crops");
    public static final TagKey<Item> CROPS_GARLIC = forgeItemTag("crops/garlic");
    public static final TagKey<Item> CROPS_GINGER = forgeItemTag("crops/ginger");
    public static final TagKey<Item> CROPS_OLIVE = forgeItemTag("crops/olive");
    public static final TagKey<Item> CROPS_LEMON = forgeItemTag("crops/lemon");
    public static final TagKey<Item> CROPS_BLUEBERRY = forgeItemTag("crops/blueberry");

    // foodstuffs
    public static final TagKey<Item> FOODSTUFFS = forgeItemTag("foodstuffs");
    public static final TagKey<Item> FOODSTUFFS_SALT = forgeItemTag("foodstuffs/salt");
    public static final TagKey<Item> FOODSTUFFS_OLIVE_OIL = forgeItemTag("foodstuffs/olive_oil");
    public static final TagKey<Item> FOODSTUFFS_CREAM = forgeItemTag("foodstuffs/cream");
    public static final TagKey<Item> FOODSTUFFS_BUTTER = forgeItemTag("foodstuffs/butter");
    public static final TagKey<Item> FOODSTUFFS_AIOLI = forgeItemTag("foodstuffs/aioli");

    public static final TagKey<Item> VEGETABLES = forgeItemTag("vegetables");
    public static final TagKey<Item> VEGETABLES_GARLIC = forgeItemTag("vegetables/garlic");
    public static final TagKey<Item> VEGETABLES_GINGER = forgeItemTag("vegetables/ginger");

    public static final TagKey<Item> FRUITS = forgeItemTag("fruits");
    public static final TagKey<Item> FRUITS_OLIVE = forgeItemTag("fruits/olive");
    public static final TagKey<Item> FRUITS_LEMON = forgeItemTag("fruits/lemon");
    public static final TagKey<Item> FRUITS_BLUEBERRY = forgeItemTag("fruits/blueberry");

    public static final TagKey<Item> BREAD = forgeItemTag("bread");
    public static final TagKey<Item> BREAD_WHEAT = forgeItemTag("bread/wheat");

    public static final TagKey<Item> MILK = forgeItemTag("milk");
    public static final TagKey<Item> MILK_BUCKET = forgeItemTag("milk/milk");
    public static final TagKey<Item> MILK_BOTTLE = forgeItemTag("milk/milk_bottle");
    public static final TagKey<Item> CREAM = forgeItemTag("milk/cream");
    public static final TagKey<Item> BUTTER = forgeItemTag("milk/butter");

}
