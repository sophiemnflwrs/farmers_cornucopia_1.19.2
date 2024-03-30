package net.sophiemnflwers.farmerscornucopia;

import net.minecraft.world.food.FoodProperties;

public class FoodValues {

    // effect duration
    public static final int BRIEF_DURATION = 600;    // 30 seconds
    public static final int SHORT_DURATION = 1200;    // 1 minute
    public static final int MEDIUM_DURATION = 3600;    // 3 minutes
    public static final int LONG_DURATION = 6000;    // 5 minutes

    // raw crops
    public static final FoodProperties GARLIC = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.4f).build();

    // misc. foodstuffs
    public static final FoodProperties GARLIC_CLOVE = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.2f).build();
    public static final FoodProperties SALT = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.1f).build();

}
