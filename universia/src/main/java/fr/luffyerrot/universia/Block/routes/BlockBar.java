package fr.luffyerrot.universia.Block.routes;

import fr.luffyerrot.universia.universiaMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BlockBar extends Block {

    private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0625*7,0 , 0.0625*7, 0.0625*9, 0.0625*16, 0.0625*9);

    public BlockBar(String name) {

        super(Material.IRON);

        this.setSoundType(SoundType.METAL);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setHardness(3.0F);
        this.setResistance(2.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(universiaMod.creativeTabPanneaux);
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
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDING_BOX;
    }

    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn) {
        super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
    }
}
