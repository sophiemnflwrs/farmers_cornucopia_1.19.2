package net.sophiemnflwrs.farmerscornucopia.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwrs.farmerscornucopia.common.block.crops.GarlicCrop;
import net.sophiemnflwrs.farmerscornucopia.common.block.crops.GingerCrop;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCBlocks;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class BlockStatesProvider extends BlockStateProvider {

    private static final int DEFAULT_ANGLE_OFFSET = 180;

    public BlockStatesProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, FarmersCornucopia.MOD_ID, exFileHelper);
    }

    // helper methods
    private String blockName(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }
    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(FarmersCornucopia.MOD_ID, "block/" + path);
    }
    public ModelFile existingModel(Block block) {
        return new ModelFile.ExistingModelFile(resourceBlock(blockName(block)), models().existingFileHelper);
    }
    public ModelFile existingModel(String path) {
        return new ModelFile.ExistingModelFile(resourceBlock(path), models().existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        // salt ores + blocks
        this.simpleBlock(FCBlocks.SALT_ORE.get(), models().cubeAll("salt_ore", resourceBlock("salt_ore")));
        this.simpleBlock(FCBlocks.DEEPSLATE_SALT_ORE.get(), models().cubeAll("deepslate_salt_ore", resourceBlock("deepslate_salt_ore")));
        this.simpleBlock(FCBlocks.SALT_BLOCK.get(), models().cubeAll("salt_block", resourceBlock("salt_block")));

        // wild crops
        this.wildCropBlock(FCBlocks.WILD_GARLIC.get());
        this.wildCropBlock(FCBlocks.WILD_GINGER.get());

        // crops
        this.customStageBlock(FCBlocks.GARLIC_CROP.get(), mcLoc("crop"), "crop", GarlicCrop.AGE, Arrays.asList(0, 0, 1, 1, 2, 2, 2, 3));
        this.customStageBlock(FCBlocks.GINGER_CROP.get(), mcLoc("crop"), "crop", GingerCrop.AGE, Arrays.asList(0, 0, 1, 1, 2, 2, 2, 3));
    }

    // main methods
    public void wildCropBlock(Block block) {
        this.wildCropBlock(block, false);
    }
    public void wildCropBlock(Block block, boolean isBushCrop) {
        if (isBushCrop) {
            this.simpleBlock(block, models().singleTexture(blockName(block), resourceBlock("bush_crop"), "crop", resourceBlock(blockName(block))).renderType("cutout"));
        } else {
            this.simpleBlock(block, models().cross(blockName(block), resourceBlock(blockName(block))).renderType("cutout"));
        }
    }
    public void customStageBlock(Block block, @Nullable ResourceLocation parent, String textureKey, IntegerProperty ageProperty, List<Integer> suffixes, Property<?>... ignored) {
        getVariantBuilder(block)
                .forAllStatesExcept(state -> {
                    int ageSuffix = state.getValue(ageProperty);
                    String stageName = blockName(block) + "_stage";
                    stageName += suffixes.isEmpty() ? ageSuffix : suffixes.get(Math.min(suffixes.size(), ageSuffix));
                    if (parent == null) {
                        return ConfiguredModel.builder()
                                .modelFile(models().cross(stageName, resourceBlock(stageName)).renderType("cutout")).build();
                    }
                    return ConfiguredModel.builder()
                            .modelFile(models().singleTexture(stageName, parent, textureKey, resourceBlock(stageName)).renderType("cutout")).build();
                }, ignored);
    }
}
