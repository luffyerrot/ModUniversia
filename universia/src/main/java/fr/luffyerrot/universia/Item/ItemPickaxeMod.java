package fr.luffyerrot.universia.Item;

import net.minecraft.item.ItemPickaxe;

public class ItemPickaxeMod extends ItemPickaxe{

	public ItemPickaxeMod(String name, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
}