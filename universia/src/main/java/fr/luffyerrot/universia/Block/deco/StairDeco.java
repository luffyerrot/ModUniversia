package fr.luffyerrot.universia.Block.deco;

import fr.luffyerrot.universia.universiaMod;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class StairDeco extends BlockStairs{

	public StairDeco(String name, IBlockState modelState) {
		super(modelState);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(universiaMod.creativeTabDeco);
	}
}
