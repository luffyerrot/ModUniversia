package fr.luffyerrot.universia.Block;

import fr.luffyerrot.universia.universiaMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCTM extends Block {

    public BlockCTM(Material material, String name, String outil) {

        super(material);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(universiaMod.creativeTabCTM);
        this.setHardness(4.0F);
        this.setResistance(1.2F);
        switch(outil) {
        	case "PIOCHE":
        		this.setHarvestLevel("pickaxe", 1);
        		break;
        	case "HACHE":
        		this.setHarvestLevel("axe", 1);
        		break;
        	default:
        		this.setHarvestLevel("pickaxe", 1);
        		break;
        }
    }
}
