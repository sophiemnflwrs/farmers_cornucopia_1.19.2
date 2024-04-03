package net.sophiemnflwrs.farmerscornucopia.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCBlocks;
import net.sophiemnflwrs.farmerscornucopia.common.tag.FCTags;

import javax.annotation.Nullable;

public class BlockTagProvider extends BlockTagsProvider {

    public BlockTagProvider(DataGenerator generatorIn, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.registerModTags();
        this.registerMinecraftTags();
        this.registerForgeTags();
        this.registerBlockMineables();
    }

    protected void registerBlockMineables() {
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(
                FCBlocks.SALT_BLOCK.get(),
                FCBlocks.SALT_ORE.get(),
                FCBlocks.DEEPSLATE_SALT_ORE.get()
        );
    }

    protected void registerForgeTags() {
        
    }

    protected void registerMinecraftTags() {
        tag(net.minecraft.tags.BlockTags.CROPS).add(
                FCBlocks.GARLIC_CROP.get()
        );
        tag(net.minecraft.tags.BlockTags.SMALL_FLOWERS).add(
                FCBlocks.WILD_GARLIC.get()
        );
    }

    protected void registerModTags() {
        tag(FCTags.WILD_CROPS).add(
                FCBlocks.WILD_GARLIC.get()
        );
    }

}
