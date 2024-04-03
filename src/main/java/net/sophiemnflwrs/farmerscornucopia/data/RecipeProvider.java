package net.sophiemnflwrs.farmerscornucopia.data;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCItems;
import org.checkerframework.checker.nullness.qual.NonNull;
import vectorwing.farmersdelight.common.registry.ModItems;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RecipeProvider extends net.minecraft.data.recipes.RecipeProvider {

    public RecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(@NonNull Consumer<FinishedRecipe> consumer) {

        // CRAFTING

        // ingredients
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

        // non-meal foods
        ShapelessRecipeBuilder.shapeless(FCItems.GARLIC_BREAD.get(), 2)
                .requires(Items.BREAD)
                .requires(FCItems.GARLIC.get())
                .requires(FCItems.BUTTER.get())
                .unlockedBy("has_garlic", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.GARLIC.get()))
                .save(consumer);

    }
}