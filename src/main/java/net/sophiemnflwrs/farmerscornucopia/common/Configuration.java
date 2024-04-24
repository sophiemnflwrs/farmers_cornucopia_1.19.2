package net.sophiemnflwrs.farmerscornucopia.common;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Configuration {

    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static final String CATEGORY_WORLD = "world";
    public static ForgeConfigSpec.BooleanValue GENERATE_WILD_GARLIC;
    public static ForgeConfigSpec.IntValue CHANCE_WILD_GARLIC;
    public static ForgeConfigSpec.BooleanValue GENERATE_WILD_GINGER;
    public static ForgeConfigSpec.IntValue CHANCE_WILD_GINGER;

    public static ForgeConfigSpec.BooleanValue GENERATE_LEMON_SHRUB;
    public static ForgeConfigSpec.IntValue CHANCE_LEMON_SHRUB;

    public static ForgeConfigSpec.BooleanValue GENERATE_OLIVE_TREE;
    public static ForgeConfigSpec.IntValue CHANCE_OLIVE_TREE;

    public static final String CATEGORY_CLIENT = "client";
    public static ForgeConfigSpec.BooleanValue FOOD_EFFECT_TOOLTIP;


    static {

        // common
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

        COMMON_BUILDER.comment("World generation").push(CATEGORY_WORLD);

            // wild crops
            COMMON_BUILDER.comment("Wild Garlic generation").push("wild_garlic");
                CHANCE_WILD_GARLIC = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
                        .defineInRange("chance", 30, 0, Integer.MAX_VALUE);
                COMMON_BUILDER.pop();
            COMMON_BUILDER.comment("Wild Ginger generation").push("wild_ginger");
                CHANCE_WILD_GINGER = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
                        .defineInRange("chance", 30, 0, Integer.MAX_VALUE);
                COMMON_BUILDER.pop();

            // shrubs
            COMMON_BUILDER.comment("Lemon Shrub generation").push("wild_ginger");
                CHANCE_LEMON_SHRUB = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
                        .defineInRange("chance", 20, 0, Integer.MAX_VALUE);
                COMMON_BUILDER.pop();

            // trees
            COMMON_BUILDER.comment("Olive Tree generation").push("olive_tree");
                CHANCE_OLIVE_TREE = COMMON_BUILDER.comment("Chance of generating trees. Smaller values = more frequent.")
                        .defineInRange("chance", 40, 0, Integer.MAX_VALUE);
                COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();

        //client
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

        CLIENT_BUILDER.comment("Client settings").push(CATEGORY_CLIENT);
            FOOD_EFFECT_TOOLTIP = CLIENT_BUILDER.comment("Should meal and drink tooltips display which effects they provide?")
                    .define("foodEffectTooltip", true);
            CLIENT_BUILDER.pop();

        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }
}
