package net.sophiemnflwrs.farmerscornucopia.common;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.sophiemnflwrs.farmerscornucopia.common.effect.FCEffects;

public class FoodValues {

    // effect duration
    public static final int BRIEF_DURATION = 600;    // 30 seconds
    public static final int SHORT_DURATION = 1200;    // 1 minute
    public static final int MEDIUM_DURATION = 3600;    // 3 minutes
    public static final int LONG_DURATION = 6000;    // 5 minutes

    // raw veg
    public static final FoodProperties GARLIC = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.4f)
            .build();
    public static final FoodProperties GINGER = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.6f)
            .build();

    // raw fruits
    public static final FoodProperties OLIVE = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.3f)
            .build();
    public static final FoodProperties LEMON = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(FCEffects.CORROSION.get(), 100, 0), 1.0F)
            .build();
    public static final FoodProperties BLUEBERRY = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.2f)
            .build();

    // edible seeds
    public static final FoodProperties GARLIC_CLOVE = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.2f)
            .build();

    // foodstuffs
    public static final FoodProperties SALT = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.1f)
            .build();
    public static final FoodProperties CREAM = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.4f)
            .build();
    public static final FoodProperties BUTTER = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.4f)
            .build();
    public static final FoodProperties OLIVE_OIL = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.3f)
            .build();
    public static final FoodProperties AIOLI = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.6f)
            .build();

    // preserves
    public static final FoodProperties VIOLET_JELLY = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.3f)
            .build();
    public static final FoodProperties BLUEBERRY_JAM = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.3f)
            .build();
    public static final FoodProperties LEMON_MARMALADE = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.3f)
            .effect(() -> new MobEffectInstance(FCEffects.CORROSION.get(), 200, 0), 1.0F)
            .build();

    // drinks
    public static final FoodProperties LEMONADE = (new FoodProperties.Builder())
            .nutrition(3).saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(FCEffects.CORROSION.get(), 300, 0), 1.0F)
            .build();

    // meals
    public static final FoodProperties GARLIC_BREAD = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), 0.2f)
            .build();
    public  static final FoodProperties BLUEBERRY_MUFFIN = (new FoodProperties.Builder())
            .nutrition(4).saturationMod(0.4f)
            .build();

}
