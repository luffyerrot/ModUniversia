package fr.luffyerrot.universia.Block.machines;

import fr.luffyerrot.universia.universiaMod;
import net.minecraft.block.BlockGlazedTerracotta;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumBlockRenderType;

public class BlockElec extends BlockGlazedTerracotta {

	public BlockElec(String name) {
        super(EnumDyeColor.GRAY);

        this.setSoundType(SoundType.ANVIL);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(universiaMod.creativeTab);
        this.setBlockUnbreakable();
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
}
