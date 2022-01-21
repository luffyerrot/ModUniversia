package fr.luffyerrot.universia.Item;

import fr.luffyerrot.universia.universiaMod;
import net.minecraft.item.ItemFood;

public class ItemFoodCustom extends ItemFood{
	
	public ItemFoodCustom(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setCreativeTab(universiaMod.creativeTabFoodAndLife);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}
