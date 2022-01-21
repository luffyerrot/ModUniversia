package fr.luffyerrot.universia.Block.routes;

import fr.luffyerrot.universia.universiaMod;
import net.minecraft.block.BlockGlazedTerracotta;
import net.minecraft.block.SoundType;
import net.minecraft.item.EnumDyeColor;

public class BlockEntierRoute extends BlockGlazedTerracotta {

    public BlockEntierRoute(String name) {
        super(EnumDyeColor.BLACK);

        this.setSoundType(SoundType.STONE);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setHardness(5.0F);
        this.setResistance(4.0F);
        this.setHarvestLevel("pickaxe", 3);
        this.setCreativeTab(universiaMod.creativeTabFullRoad);
    }
}
