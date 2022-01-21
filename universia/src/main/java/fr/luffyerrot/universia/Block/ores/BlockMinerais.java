package fr.luffyerrot.universia.Block.ores;

import fr.luffyerrot.universia.universiaMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMinerais extends Block {
	
    public BlockMinerais(String name)
    {
        super(Material.ROCK);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(universiaMod.creativeTabDeco);
        setHarvestLevel("pickaxe", 2);
        setHardness(10F);
        setResistance(4F);
    }
}