package net.sophiemnflwers.farmerscornucopia.common;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.sophiemnflwers.farmerscornucopia.common.world.WildCropGeneration;

public class CommonSetup {

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(WildCropGeneration::registerWildCropGeneration);
    }
}
