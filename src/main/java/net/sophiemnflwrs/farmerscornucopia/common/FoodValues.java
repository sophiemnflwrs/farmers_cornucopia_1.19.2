package net.sophiemnflwrs.farmerscornucopia.common;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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
    public static final FoodProperties GINGER = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.6f).build();

    // misc. foodstuffs
    public static final FoodProperties GARLIC_CLOVE = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.2f).build();
    public static final FoodProperties SALT = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.1f).build();
    public static final FoodProperties CREAM = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.4f).build();
    public static final FoodProperties BUTTER = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.4f).build();

    // meals
    public static final FoodProperties GARLIC_BREAD = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), 0.2f).build();


}
