package net.sophiemnflwrs.farmerscornucopia.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = FarmersCornucopia.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        generator.addProvider(event.includeServer(), new BlockTagProvider(generator, FarmersCornucopia.MOD_ID, helper));
        generator.addProvider(event.includeServer(), new ItemTagProvider(generator, FarmersCornucopia.MOD_ID, helper));
        generator.addProvider(event.includeServer(), new RecipeTypeProvider(generator));


    }
}
