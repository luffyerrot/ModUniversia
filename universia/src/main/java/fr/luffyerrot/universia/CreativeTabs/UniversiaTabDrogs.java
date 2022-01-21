package fr.luffyerrot.universia.CreativeTabs;

import fr.luffyerrot.universia.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class UniversiaTabDrogs extends CreativeTabs {

    public UniversiaTabDrogs(String name) {

        super(name);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.bulbe);
    }
}
