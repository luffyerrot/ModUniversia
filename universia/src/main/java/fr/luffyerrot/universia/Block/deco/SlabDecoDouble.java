package fr.luffyerrot.universia.Block.deco;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SlabDecoDouble extends SlabDeco{

	public SlabDecoDouble(String name, Material material, SoundType sound, BlockSlab half) {
		super(name, material, sound, half);
	}
	
	@Override
	public boolean isDouble() {
		return true;
	}
}
