package fr.luffyerrot.universia.Item;

import net.minecraft.item.ItemSpade;

public class ItemShovelMod extends ItemSpade{

	public ItemShovelMod(String name, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
}