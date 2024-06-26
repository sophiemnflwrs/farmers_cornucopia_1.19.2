package net.sophiemnflwrs.farmerscornucopia.datagen;

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

        BlockTagProvider blockTags = new BlockTagProvider(generator, FarmersCornucopia.MOD_ID, helper);
        generator.addProvider(event.includeServer(), new BlockTagProvider(generator, FarmersCornucopia.MOD_ID, helper));
        generator.addProvider(event.includeServer(), new ItemTagProvider(generator, blockTags, FarmersCornucopia.MOD_ID, helper));
        generator.addProvider(event.includeServer(), new RecipeProvider(generator));

        BlockStatesProvider blockStates = new BlockStatesProvider(generator, helper);
        generator.addProvider(event.includeClient(), blockStates);
        generator.addProvider(event.includeClient(), new ItemModelsProvider(generator, blockStates.models().existingFileHelper));


    }
}
