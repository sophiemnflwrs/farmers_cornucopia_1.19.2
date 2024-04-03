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


    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

        COMMON_BUILDER.comment("World generation").push(CATEGORY_WORLD);
            COMMON_BUILDER.comment("Wild Garlic generation").push("wild_garlic");
            CHANCE_WILD_GARLIC = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
                    .defineInRange("chance", 30, 5, Integer.MAX_VALUE);
        COMMON_BUILDER.pop();
            COMMON_BUILDER.comment("Wild Ginger generation").push("wild_ginger");
            CHANCE_WILD_GINGER = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
                    .defineInRange("chance", 30, 5, Integer.MAX_VALUE);
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}
