package net.sophiemnflwers.farmerscornucopia.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.sophiemnflwers.farmerscornucopia.data.recipe.CraftingRecipes;
import net.sophiemnflwers.farmerscornucopia.data.recipe.SmeltingRecipes;
import net.sophiemnflwers.farmerscornucopia.data.recipe.CookingRecipes;
import net.sophiemnflwers.farmerscornucopia.data.recipe.CuttingRecipes;

import java.util.function.Consumer;

public class RecipeTypes extends RecipeProvider {

    public RecipeTypes(DataGenerator generator) {
        super(generator);
    }

    @Override
    public void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        CraftingRecipes.register(consumer);
        SmeltingRecipes.register(consumer);
        CookingRecipes.register(consumer);
        CuttingRecipes.register(consumer);
    }
}
