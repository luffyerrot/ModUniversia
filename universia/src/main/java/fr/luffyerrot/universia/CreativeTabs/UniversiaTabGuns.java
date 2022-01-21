package fr.luffyerrot.universia.CreativeTabs;

import fr.luffyerrot.universia.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class UniversiaTabGuns extends CreativeTabs {

    public UniversiaTabGuns(String name) {

        super(name);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.canon_double);
    }
}
