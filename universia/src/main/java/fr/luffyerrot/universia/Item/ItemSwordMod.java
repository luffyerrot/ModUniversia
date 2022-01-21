package fr.luffyerrot.universia.Item;

import net.minecraft.item.ItemSword;

public class ItemSwordMod extends ItemSword{

	public ItemSwordMod(String name, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}

}
