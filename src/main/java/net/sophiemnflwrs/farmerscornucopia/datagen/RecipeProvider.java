package net.sophiemnflwrs.farmerscornucopia.datagen;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.sophiemnflwrs.farmerscornucopia.datagen.recipe.CookingRecipe;
import net.sophiemnflwrs.farmerscornucopia.datagen.recipe.CraftingRecipe;
import org.checkerframework.checker.nullness.qual.NonNull;

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
        CraftingRecipe.register(consumer);
        CookingRecipe.register(consumer);
    }
}
