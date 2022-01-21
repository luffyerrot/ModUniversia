package fr.luffyerrot.universia.Item;

import fr.luffyerrot.universia.universiaMod;
import net.minecraft.item.Item;

public class ItemArgent extends Item {

    public ItemArgent(String name){

        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(universiaMod.creativeTab);
    }
}
