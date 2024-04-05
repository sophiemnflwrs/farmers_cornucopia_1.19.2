package net.sophiemnflwrs.farmerscornucopia.common;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.sophiemnflwrs.farmerscornucopia.common.world.ModPlantGeneration;

public class CommonSetup {

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(ModPlantGeneration::registerModPlantGeneration);
    }
}
