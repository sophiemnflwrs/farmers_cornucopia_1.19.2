package net.sophiemnflwers.farmerscornucopia.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab FARMERS_CORNUCOPIA_TAB = new CreativeModeTab("farmerscornucopiatab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.GARLIC.get());
        }
    };
}
