package fr.luffyerrot.universia.Block.deco;

import fr.luffyerrot.universia.universiaMod;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SlabDecoHalf extends SlabDeco{

	public SlabDecoHalf(String name, Material material, SoundType sound, BlockSlab half) {
		
		super(name, material, sound, half);
		this.setCreativeTab(universiaMod.creativeTabDeco);
	}

	@Override
	public boolean isDouble() {
		return false;
	}
}
