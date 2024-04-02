package net.sophiemnflwrs.farmerscornucopia.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class CookingRecipes {

    public static final int FAST = 100;      // 5 seconds
    public static final int NORMAL = 200;    // 10 seconds
    public static final int SLOW = 400;      // 20 seconds

    public static final float XP_S = 0.5F;
    public static final float XP_M = 1.0F;
    public static final float XP_L = 2.0F;

    public static void register(Consumer<FinishedRecipe> consumer) {
        cookMeals(consumer);
        cookMinecraftSoups(consumer);
        cookMiscellaneous(consumer);
    }

    // meals
    private static void cookMeals(Consumer<FinishedRecipe> consumer) {

    }

    // soups
    private static void cookMinecraftSoups(Consumer<FinishedRecipe> consumer) {

    }

    // misc.
    private static void cookMiscellaneous(Consumer<FinishedRecipe> consumer) {

    }

}


