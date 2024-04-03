package net.sophiemnflwrs.farmerscornucopia.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCItems;
import net.sophiemnflwrs.farmerscornucopia.common.tag.FCTags;
import net.sophiemnflwrs.farmerscornucopia.common.tag.ForgeTags;
import vectorwing.farmersdelight.common.registry.ModItems;

import javax.annotation.Nullable;

public class ItemTagProvider extends ItemTagsProvider {

    public ItemTagProvider(DataGenerator generatorIn, BlockTagsProvider blockTagProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, blockTagProvider, modId, existingFileHelper);
    }

    @Override
        protected void addTags() {
            copy(FCTags.WILD_CROPS, FCTags.WILD_CROPS_ITEM);
            copy(BlockTags.SMALL_FLOWERS, net.minecraft.tags.ItemTags.SMALL_FLOWERS);

            this.registerForgeTags();
    }

    @SuppressWarnings("unchecked")
    private void registerForgeTags() {

        tag(ForgeTags.SEEDS).addTags(ForgeTags.SEEDS_GARLIC, ForgeTags.SEEDS_GINGER);
            tag(ForgeTags.SEEDS_GARLIC).add(FCItems.GARLIC_CLOVE.get());
            tag(ForgeTags.SEEDS_GINGER).add(FCItems.GINGER_SEEDS.get());

        tag(ForgeTags.CROPS).addTags(ForgeTags.CROPS_GARLIC, ForgeTags.CROPS_GINGER);
            tag(ForgeTags.CROPS_GARLIC).add(FCItems.GARLIC.get());
            tag(ForgeTags.CROPS_GINGER).add(FCItems.GINGER.get());

        tag(ForgeTags.FOODSTUFFS).addTags(ForgeTags.FOODSTUFFS_SALT);
            tag(ForgeTags.FOODSTUFFS_SALT).add(FCItems.SALT.get());

        tag(ForgeTags.VEGETABLES).addTags(ForgeTags.VEGETABLES_GARLIC);
            tag(ForgeTags.VEGETABLES_GARLIC).add(FCItems.GARLIC.get());

        tag(ForgeTags.BREAD).addTag(ForgeTags.BREAD_WHEAT);
            tag(ForgeTags.BREAD_WHEAT).add(Items.BREAD);

        tag(ForgeTags.MILK).addTags(ForgeTags.MILK_BUCKET, ForgeTags.MILK_BOTTLE, ForgeTags.CREAM, ForgeTags.BUTTER);
            tag(ForgeTags.MILK_BUCKET).add(Items.MILK_BUCKET);
            tag(ForgeTags.MILK_BOTTLE).add(ModItems.MILK_BOTTLE.get());
            tag(ForgeTags.CREAM).add(FCItems.CREAM.get());
            tag(ForgeTags.BUTTER).add(FCItems.BUTTER.get());

    }
}

