package fr.luffyerrot.universia.Block.deco;

import fr.luffyerrot.universia.universiaMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockDeco extends Block{

	public BlockDeco(String name, Material material) {
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(universiaMod.creativeTabDeco);
	}

}
