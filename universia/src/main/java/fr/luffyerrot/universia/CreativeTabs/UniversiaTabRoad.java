package fr.luffyerrot.universia.CreativeTabs;

import fr.luffyerrot.universia.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class UniversiaTabRoad extends CreativeTabs {

    int valeur;

    public UniversiaTabRoad(int valeur, String name) {

        super(name);
        this.valeur = valeur;
    }

    @Override
    public ItemStack getTabIconItem() {

        switch (this.valeur){
            case 0 :
                return new ItemStack(ModBlocks.goudron);
            case 1 :
                return new ItemStack(ModBlocks.blockgoudron);
            case 2 :
                return new ItemStack(ModBlocks.slabgoudron);
        }
        return new ItemStack(ModBlocks.goudron);
    }
}
