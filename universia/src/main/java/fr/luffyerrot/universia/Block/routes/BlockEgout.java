package fr.luffyerrot.universia.Block.routes;

import com.google.common.collect.Lists;
import fr.luffyerrot.universia.universiaMod;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BlockEgout extends BlockTrapDoor {

    protected static final AxisAlignedBB BOTTOM_AABB = new AxisAlignedBB(0.0D, 0.0625*2D, 0.0D, 1.0D, 0.0625*6D, 1.0D);
    protected static final AxisAlignedBB TOP_AABB = new AxisAlignedBB(0.0D, 0.0625*10D, 0.0D, 0.0625*16D, 0.0625*14D, 0.0625*16D);

    protected static final AxisAlignedBB OPEN_BOTTOM_AABB1 = new AxisAlignedBB(0.0D, 0.0625*2D, 0.0D, 0.0625*16D, 0.0625*6D, 0.0625*2D);
    protected static final AxisAlignedBB OPEN_BOTTOM_AABB2 = new AxisAlignedBB(0.0D, 0.0625*2D, 0.0625*14D, 0.0625*16D, 0.0625*6D, 0.0625*16D);
    protected static final AxisAlignedBB OPEN_BOTTOM_AABB3 = new AxisAlignedBB(0.0D, 0.0625*2D, 0.0625*2D, 0.0625*2D, 0.0625*6D, 0.0625*14D);
    protected static final AxisAlignedBB OPEN_BOTTOM_AABB4 = new AxisAlignedBB(0.0625*14D, 0.0625*2D, 0.0625*2D, 0.0625*16D, 0.0625*6D, 0.0625*14D);

    protected static final AxisAlignedBB OPEN_TOP_AABB1 = new AxisAlignedBB(0.0D, 0.0625*10D, 0.0D, 0.0625*16D, 0.0625*14D, 0.0625*2D);
    protected static final AxisAlignedBB OPEN_TOP_AABB2 = new AxisAlignedBB(0.0D, 0.0625*10D, 0.0625*14D, 0.0625*16D, 0.0625*14D, 0.0625*16D);
    protected static final AxisAlignedBB OPEN_TOP_AABB3 = new AxisAlignedBB(0.0D, 0.0625*10D, 0.0625*2D, 0.0625*2D, 0.0625*14D, 0.0625*14D);
    protected static final AxisAlignedBB OPEN_TOP_AABB4 = new AxisAlignedBB(0.0625*14D, 0.0625*10D, 0.0625*2D, 0.0625*16D, 0.0625*14D, 0.0625*14D);

    public BlockEgout(String name) {
        super(Material.ROCK);
        setUnlocalizedName(name);
        setRegistryName(name);
        this.setHardness(5.0F);
        this.setResistance(4.0F);
        this.setHarvestLevel("pickaxe", 3);
        setCreativeTab(universiaMod.creativeTab);
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
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        AxisAlignedBB axisalignedbb;

        if (state.getValue(HALF) == BlockTrapDoor.DoorHalf.TOP)
        {
            axisalignedbb = TOP_AABB;
        }
        else
        {
            axisalignedbb = BOTTOM_AABB;
        }
        return axisalignedbb;
    }

    @SuppressWarnings("deprecation")
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState)
    {
        if (!isActualState)
        {
            state = this.getActualState(state, worldIn, pos);
        }

        for (AxisAlignedBB axisalignedbb : getCollisionBoxList(state))
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, axisalignedbb);
        }
    }

    private static List<AxisAlignedBB> getCollisionBoxList(IBlockState state)
    {
        List<AxisAlignedBB> list = Lists.<AxisAlignedBB>newArrayList();

        if (state.getValue(OPEN)) {
            if (state.getValue(HALF) == BlockTrapDoor.DoorHalf.TOP)
            {
                list.add(OPEN_TOP_AABB1);
                list.add(OPEN_TOP_AABB2);
                list.add(OPEN_TOP_AABB3);
                list.add(OPEN_TOP_AABB4);
            }else {
                list.add(OPEN_BOTTOM_AABB1);
                list.add(OPEN_BOTTOM_AABB2);
                list.add(OPEN_BOTTOM_AABB3);
                list.add(OPEN_BOTTOM_AABB4);
            }
        } else {
            if (state.getValue(HALF) == BlockTrapDoor.DoorHalf.TOP)
            {
                list.add(TOP_AABB);
            }
            else
            {
                list.add(BOTTOM_AABB);
            }
        }
        return list;
    }
}
