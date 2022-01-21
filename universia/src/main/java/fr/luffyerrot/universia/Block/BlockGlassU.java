package fr.luffyerrot.universia.Block;

import net.minecraft.block.BlockBeacon;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGlassU extends BlockBreakable {

    public BlockGlassU(boolean ignoreSimilarityIn) {
        super(Material.GLASS, ignoreSimilarityIn);
        setSoundType(SoundType.GLASS);
        this.setLightOpacity(0);
        this.setHardness(2.0F);
        this.setResistance(1.0F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            BlockBeacon.updateColorAsync(worldIn, pos);
        }
    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
}
