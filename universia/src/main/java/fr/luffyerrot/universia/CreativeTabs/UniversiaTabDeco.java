package fr.luffyerrot.universia.CreativeTabs;

import fr.luffyerrot.universia.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class UniversiaTabDeco extends CreativeTabs {

    public UniversiaTabDeco(String name) {

        super(name);
        setBackgroundImageName("item_search.png");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Item.getItemFromBlock(ModBlocks.glass));
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }
}
