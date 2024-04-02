package net.sophiemnflwrs.farmerscornucopia.common.tag;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;

public class FCTags {

    public static final TagKey<Block> WILD_CROPS = modBlockTag("wild_crops");
    public static final TagKey<Item> WILD_CROPS_ITEM = modItemTag("wild_crops");

    // register
    private static TagKey<Item> modItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(FarmersCornucopia.MOD_ID, path));
    }
    private static TagKey<Block> modBlockTag(String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(FarmersCornucopia.MOD_ID, path));
    }
    private static TagKey<EntityType<?>> modEntityTag(String path) {
        return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(FarmersCornucopia.MOD_ID, path));
    }
}