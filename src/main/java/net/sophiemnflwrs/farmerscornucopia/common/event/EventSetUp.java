package net.sophiemnflwrs.farmerscornucopia.common.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import vectorwing.farmersdelight.common.crafting.ingredient.ToolActionIngredient;

import static net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia.MOD_ID;

public class EventSetUp {

    @SubscribeEvent
    public static void registerRecipeElements(RegisterEvent event) {
        if (event.getRegistryKey().equals(ForgeRegistries.Keys.RECIPE_SERIALIZERS)) {
            CraftingHelper.register(new ResourceLocation(MOD_ID, "tool_action"), ToolActionIngredient.SERIALIZER);
        }
    }
}
