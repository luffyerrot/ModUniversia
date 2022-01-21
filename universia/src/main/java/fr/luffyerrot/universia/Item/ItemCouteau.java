package fr.luffyerrot.universia.Item;

import fr.luffyerrot.universia.universiaMod;
import net.minecraft.item.Item;

public class ItemCouteau extends Item {

    public ItemCouteau(String name){

    	setUnlocalizedName(name);
    	setRegistryName(name);
    	setCreativeTab(universiaMod.creativeTabFoodAndLife);
    	this.setMaxDamage(20);
    }
}
