package fr.luffyerrot.universia.CreativeTabs;

import fr.luffyerrot.universia.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class UniversiaTabPanneaux extends CreativeTabs {

    public UniversiaTabPanneaux(String name) {

        super(name);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModBlocks.panneau_rond3);
    }
}
