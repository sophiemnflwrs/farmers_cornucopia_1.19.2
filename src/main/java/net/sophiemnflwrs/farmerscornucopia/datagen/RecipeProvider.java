package net.sophiemnflwrs.farmerscornucopia.datagen;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
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

        // crop crates
        ShapedRecipeBuilder.shaped(FCItems.GARLIC_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', FCItems.GARLIC.get())
                .unlockedBy("has_garlic", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.GARLIC.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(FCItems.GARLIC.get(), 9)
                .requires(FCItems.GARLIC_CRATE.get())
                .unlockedBy("has_garlic_crate", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.GARLIC_CRATE.get()))
                .save(consumer, new ResourceLocation(FarmersCornucopia.MOD_ID, "garlic_from_crate"));
        ShapedRecipeBuilder.shaped(FCItems.GINGER_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', FCItems.GINGER.get())
                .unlockedBy("has_ginger", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.GINGER.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(FCItems.GINGER.get(), 9)
                .requires(FCItems.GINGER_CRATE.get())
                .unlockedBy("has_ginger_crate", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.GINGER_CRATE.get()))
                .save(consumer, new ResourceLocation(FarmersCornucopia.MOD_ID, "ginger_from_crate"));
        ShapedRecipeBuilder.shaped(FCItems.OLIVE_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', FCItems.OLIVE.get())
                .unlockedBy("has_olive", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.OLIVE.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(FCItems.OLIVE.get(), 9)
                .requires(FCItems.OLIVE_CRATE.get())
                .unlockedBy("has_olive_crate", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.OLIVE_CRATE.get()))
                .save(consumer, new ResourceLocation(FarmersCornucopia.MOD_ID, "olive_from_crate"));

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
                .unlockedBy("has_milk_bottle", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MILK_BOTTLE.get()))
                .save(consumer, new ResourceLocation(FarmersCornucopia.MOD_ID, "cream_from_bottle"));
        ShapelessRecipeBuilder.shapeless(FCItems.BUTTER.get(), 1)
                .requires(FCItems.CREAM.get())
                .requires(FCItems.CREAM.get())
                .requires(FCItems.CREAM.get())
                .requires(FCItems.CREAM.get())
                .requires(FCItems.SALT.get())
                .unlockedBy("has_cream", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.CREAM.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(FCItems.OLIVE_OIL.get(), 1)
                .requires(FCItems.OLIVE.get())
                .requires(FCItems.OLIVE.get())
                .requires(FCItems.OLIVE.get())
                .requires(FCItems.OLIVE.get())
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_olive", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.OLIVE.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(FCItems.AIOLI.get(), 1)
                .requires(Items.EGG)
                .requires(FCItems.OLIVE_OIL.get())
                .requires(FCItems.GARLIC.get())
                .requires(FCItems.LEMON.get())
                .requires(FCItems.SALT.get())
                .unlockedBy("has_olive_oil", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.OLIVE_OIL.get()))
                .save(consumer);

        // drinks
        ShapelessRecipeBuilder.shapeless(FCItems.LEMONADE.get(), 3)
                .requires(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)))
                .requires(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)))
                .requires(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)))
                .requires(Items.SUGAR)
                .requires(FCItems.LEMON.get())
                .unlockedBy("has_lemon", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.LEMON.get()))
                .save(consumer);

        // foods + meals
        ShapelessRecipeBuilder.shapeless(FCItems.GARLIC_BREAD.get(), 2)
                .requires(Items.BREAD)
                .requires(FCItems.GARLIC.get())
                .requires(FCItems.BUTTER.get())
                .unlockedBy("has_garlic", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.GARLIC.get()))
                .save(consumer);

    }
}
