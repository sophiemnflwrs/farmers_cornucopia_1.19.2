package net.sophiemnflwrs.farmerscornucopia.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
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
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                FCBlocks.SALT_BLOCK.get(),
                FCBlocks.SALT_ORE.get(),
                FCBlocks.DEEPSLATE_SALT_ORE.get()
        );
        tag(BlockTags.MINEABLE_WITH_AXE).add(
                FCBlocks.OLIVE_LOG.get(),
                FCBlocks.STRIPPED_OLIVE_LOG.get(),
                FCBlocks.OLIVE_PLANKS.get(),
                FCBlocks.GARLIC_CRATE.get(),
                FCBlocks.GINGER_CRATE.get(),
                FCBlocks.OLIVE_CRATE.get()
        );
    }

    protected void registerForgeTags() {
        
    }

    protected void registerMinecraftTags() {
        tag(BlockTags.CROPS).add(FCBlocks.GARLIC_CROP.get());
        tag(BlockTags.CROPS).add(FCBlocks.GINGER_CROP.get());

        tag(BlockTags.LEAVES).add(FCBlocks.OLIVE_LEAVES.get());

        tag(BlockTags.LOGS).add(FCBlocks.OLIVE_LOG.get());
        tag(BlockTags.LOGS).add(FCBlocks.STRIPPED_OLIVE_LOG.get());

        tag(BlockTags.PLANKS).add(FCBlocks.OLIVE_PLANKS.get());

        tag(BlockTags.SAPLINGS).add(FCBlocks.OLIVE_SAPLING.get());

        tag(BlockTags.SMALL_FLOWERS).add(FCBlocks.WILD_GARLIC.get());
        tag(BlockTags.SMALL_FLOWERS).add(FCBlocks.WILD_GINGER.get());
        tag(BlockTags.SMALL_FLOWERS).add(FCBlocks.LEMON_SEEDLING.get());

    }

    protected void registerModTags() {
        tag(FCTags.WILD_CROPS).add(FCBlocks.WILD_GARLIC.get());
        tag(FCTags.WILD_CROPS).add(FCBlocks.WILD_GINGER.get());

        tag(FCTags.FRUITING_SHRUB).add(FCBlocks.LEMON_SEEDLING.get());
        tag(FCTags.FRUITING_SHRUB).add(FCBlocks.LEMON_SHRUB.get());

        tag(FCTags.FRUITING_LEAVES).add(FCBlocks.FRUITING_OLIVE_LEAVES.get());
    }

}
