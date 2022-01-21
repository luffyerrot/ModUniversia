package fr.luffyerrot.universia.Item;

import net.minecraft.item.ItemAxe;

public class ItemAxeMod extends ItemAxe{

	public ItemAxeMod(String name, ToolMaterial material) {
		super(material, 0.0F, 0.0F);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
}