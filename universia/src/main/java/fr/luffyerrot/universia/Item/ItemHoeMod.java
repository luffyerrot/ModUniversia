package fr.luffyerrot.universia.Item;

import net.minecraft.item.ItemHoe;

public class ItemHoeMod extends ItemHoe{

	public ItemHoeMod(String name, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
}