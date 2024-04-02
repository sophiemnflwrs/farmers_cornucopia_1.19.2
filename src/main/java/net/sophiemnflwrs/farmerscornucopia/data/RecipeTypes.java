package net.sophiemnflwrs.farmerscornucopia.data;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.sophiemnflwrs.farmerscornucopia.data.recipe.CookingRecipes;
import net.sophiemnflwrs.farmerscornucopia.data.recipe.CraftingRecipes;
import net.sophiemnflwrs.farmerscornucopia.data.recipe.CuttingRecipes;
import net.sophiemnflwrs.farmerscornucopia.data.recipe.SmeltingRecipes;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RecipeTypes extends RecipeProvider implements IConditionBuilder {

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
