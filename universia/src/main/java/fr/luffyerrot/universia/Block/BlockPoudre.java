package fr.luffyerrot.universia.Block;

import fr.luffyerrot.universia.universiaMod;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;

public class BlockPoudre extends BlockFalling {

	public BlockPoudre (String name) {
		this.setSoundType(SoundType.SAND);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
        this.setHardness(1.5F);
        this.setResistance(1.5F);
        this.setHarvestLevel("shovel", 2);
        this.setCreativeTab(universiaMod.creativeTabCTM);
	}
}
