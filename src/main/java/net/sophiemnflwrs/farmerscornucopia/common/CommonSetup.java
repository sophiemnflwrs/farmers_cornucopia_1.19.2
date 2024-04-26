package net.sophiemnflwrs.farmerscornucopia.common;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCBlocks;
import net.sophiemnflwrs.farmerscornucopia.common.world.ModPlantGeneration;

public class CommonSetup {

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(ModPlantGeneration::registerModPlantGeneration);

        // init potted plants
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(FCBlocks.VIOLET.getId(), FCBlocks.POTTED_VIOLET);
    }
}
