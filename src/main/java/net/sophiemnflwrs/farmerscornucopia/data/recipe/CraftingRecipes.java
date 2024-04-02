package net.sophiemnflwrs.farmerscornucopia.data.recipe;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCItems;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.Consumer;

public class CraftingRecipes {
    public static void register(Consumer<FinishedRecipe> consumer) {
        recipesIngredient(consumer);
        recipesFoodStuffs(consumer);
    }

    // ingredient recipes
    private static void recipesIngredient(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(FCItems.CREAM.get(), 2)
                .requires(Items.MILK_BUCKET)
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_milk_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(Items.MILK_BUCKET))
                .save(consumer, new ResourceLocation(FarmersCornucopia.MOD_ID, "cream_from_bucket"));
        ShapelessRecipeBuilder.shapeless(FCItems.CREAM.get(), 1)
                .requires(ModItems.MILK_BOTTLE.get())
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_milk_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MILK_BOTTLE.get()))
                .save(consumer, new ResourceLocation(FarmersCornucopia.MOD_ID, "cream_from_bottle"));
        ShapelessRecipeBuilder.shapeless(FCItems.BUTTER.get(), 1)
                .requires(FCItems.CREAM.get())
                .requires(FCItems.CREAM.get())
                .requires(FCItems.CREAM.get())
                .requires(FCItems.CREAM.get())
                .requires(FCItems.SALT.get())
                .unlockedBy("has_cream", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.CREAM.get()))
                .save(consumer);
    }

    // non-meal food recipes
    private static void recipesFoodStuffs(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(FCItems.GARLIC_BREAD.get(), 2)
                .requires(Items.BREAD)
                .requires(FCItems.GARLIC.get())
                .requires(FCItems.BUTTER.get())
                .unlockedBy("has_garlic", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.GARLIC.get()))
                .save(consumer);
    }
}
