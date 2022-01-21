package fr.luffyerrot.universia.CreativeTabs;

import fr.luffyerrot.universia.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class UniversiaTab extends CreativeTabs{

    public UniversiaTab(String name) {

        super(name);
        setBackgroundImageName("item_search.png");
    }

    @Override
    public ItemStack getTabIconItem() {

        return new ItemStack(ModItems.batterie);
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }
}
