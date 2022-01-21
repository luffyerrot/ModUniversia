package fr.luffyerrot.universia.Block.deco;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import fr.luffyerrot.universia.TileEntity.TileEntityRampBlockEast;
import fr.luffyerrot.universia.TileEntity.TileEntityRampBlockNorth;
import fr.luffyerrot.universia.TileEntity.TileEntityRampBlockSouth;
import fr.luffyerrot.universia.TileEntity.TileEntityRampBlockWest;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRamp extends BlockHorizontal implements ITileEntityProvider{

    protected static final AxisAlignedBB ALL_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	
    protected static final AxisAlignedBB WEST_AABB1 = new AxisAlignedBB(0.0625*16D, 0.0D, 0.0D, 0.0D, 0.0625*1D, 0.0625*16D);
    protected static final AxisAlignedBB WEST_AABB2 = new AxisAlignedBB(0.0625*16D, 0.0625*1D, 0.0D, 0.0625*1D, 0.0625*2D, 0.0625*16D);
    protected static final AxisAlignedBB WEST_AABB3 = new AxisAlignedBB(0.0625*16D, 0.0625*2D, 0.0D, 0.0625*2D, 0.0625*3D, 0.0625*16D);
    protected static final AxisAlignedBB WEST_AABB4 = new AxisAlignedBB(0.0625*16D, 0.0625*3D, 0.0D, 0.0625*3D, 0.0625*4D, 0.0625*16D);
    protected static final AxisAlignedBB WEST_AABB5 = new AxisAlignedBB(0.0625*16D, 0.0625*4D, 0.0D, 0.0625*4D, 0.0625*5D, 0.0625*16D);
    protected static final AxisAlignedBB WEST_AABB6 = new AxisAlignedBB(0.0625*16D, 0.0625*5D, 0.0D, 0.0625*5D, 0.0625*6D, 0.0625*16D);
    protected static final AxisAlignedBB WEST_AABB7 = new AxisAlignedBB(0.0625*16D, 0.0625*6D, 0.0D, 0.0625*6D, 0.0625*7D, 0.0625*16D);
    protected static final AxisAlignedBB WEST_AABB8 = new AxisAlignedBB(0.0625*16D, 0.0625*7D, 0.0D, 0.0625*7D, 0.0625*8D, 0.0625*16D);
    protected static final AxisAlignedBB WEST_AABB9 = new AxisAlignedBB(0.0625*16D, 0.0625*8D, 0.0D, 0.0625*8D, 0.0625*9D, 0.0625*16D);
    protected static final AxisAlignedBB WEST_AABB10 = new AxisAlignedBB(0.0625*16D, 0.0625*9D, 0.0D, 0.0625*9D, 0.0625*10D, 0.0625*16D);
    protected static final AxisAlignedBB WEST_AABB11 = new AxisAlignedBB(0.0625*16D, 0.0625*10D, 0.0D, 0.0625*10D, 0.0625*11D, 0.0625*16D);
    protected static final AxisAlignedBB WEST_AABB12 = new AxisAlignedBB(0.0625*16D, 0.0625*11D, 0.0D, 0.0625*11D, 0.0625*12D, 0.0625*16D);
    protected static final AxisAlignedBB WEST_AABB13 = new AxisAlignedBB(0.0625*16D, 0.0625*12D, 0.0D, 0.0625*12D, 0.0625*13D, 0.0625*16D);
    protected static final AxisAlignedBB WEST_AABB14 = new AxisAlignedBB(0.0625*16D, 0.0625*13D, 0.0D, 0.0625*13D, 0.0625*14D, 0.0625*16D);
    protected static final AxisAlignedBB WEST_AABB15 = new AxisAlignedBB(0.0625*16D, 0.0625*14D, 0.0D, 0.0625*14D, 0.0625*15D, 0.0625*16D);
    protected static final AxisAlignedBB WEST_AABB16 = new AxisAlignedBB(0.0625*16D, 0.0625*15D, 0.0D, 0.0625*15D, 0.0625*16D, 0.0625*16D);

    protected static final AxisAlignedBB SOUTH_AABB1 = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0625*16D, 0.0625*1D, 0.0625*16D);
    protected static final AxisAlignedBB SOUTH_AABB2 = new AxisAlignedBB(0.0D, 0.0625*1D, 0.0D, 0.0625*16D, 0.0625*2D, 0.0625*15D);
    protected static final AxisAlignedBB SOUTH_AABB3 = new AxisAlignedBB(0.0D, 0.0625*2D, 0.0D, 0.0625*16D, 0.0625*3D, 0.0625*14D);
    protected static final AxisAlignedBB SOUTH_AABB4 = new AxisAlignedBB(0.0D, 0.0625*3D, 0.0D, 0.0625*16D, 0.0625*4D, 0.0625*13D);
    protected static final AxisAlignedBB SOUTH_AABB5 = new AxisAlignedBB(0.0D, 0.0625*4D, 0.0D, 0.0625*16D, 0.0625*5D, 0.0625*12D);
    protected static final AxisAlignedBB SOUTH_AABB6 = new AxisAlignedBB(0.0D, 0.0625*5D, 0.0D, 0.0625*16D, 0.0625*6D, 0.0625*11D);
    protected static final AxisAlignedBB SOUTH_AABB7 = new AxisAlignedBB(0.0D, 0.0625*6D, 0.0D, 0.0625*16D, 0.0625*7D, 0.0625*10D);
    protected static final AxisAlignedBB SOUTH_AABB8 = new AxisAlignedBB(0.0D, 0.0625*7D, 0.0D, 0.0625*16D, 0.0625*8D, 0.0625*9D);
    protected static final AxisAlignedBB SOUTH_AABB9 = new AxisAlignedBB(0.0D, 0.0625*8D, 0.0D, 0.0625*16D, 0.0625*9D, 0.0625*8D);
    protected static final AxisAlignedBB SOUTH_AABB10 = new AxisAlignedBB(0.0D, 0.0625*9D, 0.0D, 0.0625*16D, 0.0625*10D, 0.0625*7D);
    protected static final AxisAlignedBB SOUTH_AABB11 = new AxisAlignedBB(0.0D, 0.0625*10D, 0.0D, 0.0625*16D, 0.0625*11D, 0.0625*6D);
    protected static final AxisAlignedBB SOUTH_AABB12 = new AxisAlignedBB(0.0D, 0.0625*11D, 0.0D, 0.0625*16D, 0.0625*12D, 0.0625*5D);
    protected static final AxisAlignedBB SOUTH_AABB13 = new AxisAlignedBB(0.0D, 0.0625*12D, 0.0D, 0.0625*16D, 0.0625*13D, 0.0625*4D);
    protected static final AxisAlignedBB SOUTH_AABB14 = new AxisAlignedBB(0.0D, 0.0625*13D, 0.0D, 0.0625*16D, 0.0625*14D, 0.0625*3D);
    protected static final AxisAlignedBB SOUTH_AABB15 = new AxisAlignedBB(0.0D, 0.0625*14D, 0.0D, 0.0625*16D, 0.0625*15D, 0.0625*2D);
    protected static final AxisAlignedBB SOUTH_AABB16 = new AxisAlignedBB(0.0D, 0.0625*15D, 0.0D, 0.0625*16D, 0.0625*16D, 0.0625*1D);

    protected static final AxisAlignedBB EAST_AABB1 = new AxisAlignedBB(0.0625*16D, 0.0D, 0.0625*16D, 0.0D, 0.0625*1D, 0.0D);
    protected static final AxisAlignedBB EAST_AABB2 = new AxisAlignedBB(0.0625*15D, 0.0625*1D, 0.0625*16D, 0.0D, 0.0625*2D, 0.0D);
    protected static final AxisAlignedBB EAST_AABB3 = new AxisAlignedBB(0.0625*14D, 0.0625*2D, 0.0625*16D, 0.0D, 0.0625*3D, 0.0D);
    protected static final AxisAlignedBB EAST_AABB4 = new AxisAlignedBB(0.0625*13D, 0.0625*3D, 0.0625*16D, 0.0D, 0.0625*4D, 0.0D);
    protected static final AxisAlignedBB EAST_AABB5 = new AxisAlignedBB(0.0625*12D, 0.0625*4D, 0.0625*16D, 0.0D, 0.0625*5D, 0.0D);
    protected static final AxisAlignedBB EAST_AABB6 = new AxisAlignedBB(0.0625*11D, 0.0625*5D, 0.0625*16D, 0.0D, 0.0625*6D, 0.0D);
    protected static final AxisAlignedBB EAST_AABB7 = new AxisAlignedBB(0.0625*10D, 0.0625*6D, 0.0625*16D, 0.0D, 0.0625*7D, 0.0D);
    protected static final AxisAlignedBB EAST_AABB8 = new AxisAlignedBB(0.0625*9D, 0.0625*7D, 0.0625*16D, 0.0D, 0.0625*8D, 0.0D);
    protected static final AxisAlignedBB EAST_AABB9 = new AxisAlignedBB(0.0625*8D, 0.0625*8D, 0.0625*16D, 0.0D, 0.0625*9D, 0.0D);
    protected static final AxisAlignedBB EAST_AABB10 = new AxisAlignedBB(0.0625*7D, 0.0625*9D, 0.0625*16D, 0.0D, 0.0625*10D, 0.0D);
    protected static final AxisAlignedBB EAST_AABB11 = new AxisAlignedBB(0.0625*6D, 0.0625*10D, 0.0625*16D, 0.0D, 0.0625*11D, 0.0D);
    protected static final AxisAlignedBB EAST_AABB12 = new AxisAlignedBB(0.0625*5D, 0.0625*11D, 0.0625*16D, 0.0D, 0.0625*12D, 0.0D);
    protected static final AxisAlignedBB EAST_AABB13 = new AxisAlignedBB(0.0625*4D, 0.0625*12D, 0.0625*16D, 0.0D, 0.0625*13D, 0.0D);
    protected static final AxisAlignedBB EAST_AABB14 = new AxisAlignedBB(0.0625*3D, 0.0625*13D, 0.0625*16D, 0.0D, 0.0625*14D, 0.0D);
    protected static final AxisAlignedBB EAST_AABB15 = new AxisAlignedBB(0.0625*2D, 0.0625*14D, 0.0625*16D, 0.0D, 0.0625*15D, 0.0D);
    protected static final AxisAlignedBB EAST_AABB16 = new AxisAlignedBB(0.0625*1D, 0.0625*15D, 0.0625*16D, 0.0D, 0.0625*16D, 0.0D);

    protected static final AxisAlignedBB NORTH_AABB1 = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0625*16D, 0.0625*1D, 0.0625*16D);
    protected static final AxisAlignedBB NORTH_AABB2 = new AxisAlignedBB(0.0D, 0.0625*1D, 0.0625*1D, 0.0625*16D, 0.0625*2D, 0.0625*16D);
    protected static final AxisAlignedBB NORTH_AABB3 = new AxisAlignedBB(0.0D, 0.0625*2D, 0.0625*2D, 0.0625*16D, 0.0625*3D, 0.0625*16D);
    protected static final AxisAlignedBB NORTH_AABB4 = new AxisAlignedBB(0.0D, 0.0625*3D, 0.0625*3D, 0.0625*16D, 0.0625*4D, 0.0625*16D);
    protected static final AxisAlignedBB NORTH_AABB5 = new AxisAlignedBB(0.0D, 0.0625*4D, 0.0625*4D, 0.0625*16D, 0.0625*5D, 0.0625*16D);
    protected static final AxisAlignedBB NORTH_AABB6 = new AxisAlignedBB(0.0D, 0.0625*5D, 0.0625*5D, 0.0625*16D, 0.0625*6D, 0.0625*16D);
    protected static final AxisAlignedBB NORTH_AABB7 = new AxisAlignedBB(0.0D, 0.0625*6D, 0.0625*6D, 0.0625*16D, 0.0625*7D, 0.0625*16D);
    protected static final AxisAlignedBB NORTH_AABB8 = new AxisAlignedBB(0.0D, 0.0625*7D, 0.0625*7D, 0.0625*16D, 0.0625*8D, 0.0625*16D);
    protected static final AxisAlignedBB NORTH_AABB9 = new AxisAlignedBB(0.0D, 0.0625*8D, 0.0625*8D, 0.0625*16D, 0.0625*9D, 0.0625*16D);
    protected static final AxisAlignedBB NORTH_AABB10 = new AxisAlignedBB(0.0D, 0.0625*9D, 0.0625*9D, 0.0625*16D, 0.0625*10D, 0.0625*16D);
    protected static final AxisAlignedBB NORTH_AABB11 = new AxisAlignedBB(0.0D, 0.0625*10D, 0.0625*10D, 0.0625*16D, 0.0625*11D, 0.0625*16D);
    protected static final AxisAlignedBB NORTH_AABB12 = new AxisAlignedBB(0.0D, 0.0625*11D, 0.0625*11D, 0.0625*16D, 0.0625*12D, 0.0625*16D);
    protected static final AxisAlignedBB NORTH_AABB13 = new AxisAlignedBB(0.0D, 0.0625*12D, 0.0625*12D, 0.0625*16D, 0.0625*13D, 0.0625*16D);
    protected static final AxisAlignedBB NORTH_AABB14 = new AxisAlignedBB(0.0D, 0.0625*13D, 0.0625*13D, 0.0625*16D, 0.0625*14D, 0.0625*16D);
    protected static final AxisAlignedBB NORTH_AABB15 = new AxisAlignedBB(0.0D, 0.0625*14D, 0.0625*14D, 0.0625*16D, 0.0625*15D, 0.0625*16D);
    protected static final AxisAlignedBB NORTH_AABB16 = new AxisAlignedBB(0.0D, 0.0625*15D, 0.0625*15D, 0.0625*16D, 0.0625*16D, 0.0625*16D);
	
	public BlockRamp(String name, Material materialIn) {
		super(materialIn);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
        this.setHardness(1.4F);
        this.setSoundType(SoundType.STONE);
	}
	
	@Override
	public boolean addDestroyEffects(World world, BlockPos pos, ParticleManager manager) {
		return super.addDestroyEffects(world, pos, manager);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		if (this.getStateFromMeta(meta).getValue(FACING) == EnumFacing.NORTH)
        {
			return new TileEntityRampBlockNorth();
        } else if (this.getStateFromMeta(meta).getValue(FACING) == EnumFacing.WEST) {

			return new TileEntityRampBlockWest();
        } else if (this.getStateFromMeta(meta).getValue(FACING) == EnumFacing.SOUTH) {

			return new TileEntityRampBlockSouth();
        } else {

			return new TileEntityRampBlockEast();
        }
	}

	public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
    
    
    
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        super.breakBlock(worldIn, pos, state);
        worldIn.removeTileEntity(pos);
    }
    
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }

    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
        return i;
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return ALL_AABB;
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
        
        if (state.getValue(FACING) == EnumFacing.NORTH) {
        	list.add(NORTH_AABB1);
            list.add(NORTH_AABB2);
            list.add(NORTH_AABB3);
            list.add(NORTH_AABB4);
            list.add(NORTH_AABB5);
            list.add(NORTH_AABB6);
            list.add(NORTH_AABB7);
            list.add(NORTH_AABB8);
            list.add(NORTH_AABB9);
            list.add(NORTH_AABB10);
            list.add(NORTH_AABB11);
            list.add(NORTH_AABB12);
            list.add(NORTH_AABB13);
            list.add(NORTH_AABB14);
            list.add(NORTH_AABB15);
            list.add(NORTH_AABB16);
        } else if (state.getValue(FACING) == EnumFacing.WEST) {

        	list.add(WEST_AABB1);
            list.add(WEST_AABB2);
            list.add(WEST_AABB3);
            list.add(WEST_AABB4);
            list.add(WEST_AABB5);
            list.add(WEST_AABB6);
            list.add(WEST_AABB7);
            list.add(WEST_AABB8);
            list.add(WEST_AABB9);
            list.add(WEST_AABB10);
            list.add(WEST_AABB11);
            list.add(WEST_AABB12);
            list.add(WEST_AABB13);
            list.add(WEST_AABB14);
            list.add(WEST_AABB15);
            list.add(WEST_AABB16);
        } else if (state.getValue(FACING) == EnumFacing.SOUTH) {

        	list.add(SOUTH_AABB1);
            list.add(SOUTH_AABB2);
            list.add(SOUTH_AABB3);
            list.add(SOUTH_AABB4);
            list.add(SOUTH_AABB5);
            list.add(SOUTH_AABB6);
            list.add(SOUTH_AABB7);
            list.add(SOUTH_AABB8);
            list.add(SOUTH_AABB9);
            list.add(SOUTH_AABB10);
            list.add(SOUTH_AABB11);
            list.add(SOUTH_AABB12);
            list.add(SOUTH_AABB13);
            list.add(SOUTH_AABB14);
            list.add(SOUTH_AABB15);
            list.add(SOUTH_AABB16);
        } else {

        	list.add(EAST_AABB1);
            list.add(EAST_AABB2);
            list.add(EAST_AABB3);
            list.add(EAST_AABB4);
            list.add(EAST_AABB5);
            list.add(EAST_AABB6);
            list.add(EAST_AABB7);
            list.add(EAST_AABB8);
            list.add(EAST_AABB9);
            list.add(EAST_AABB10);
            list.add(EAST_AABB11);
            list.add(EAST_AABB12);
            list.add(EAST_AABB13);
            list.add(EAST_AABB14);
            list.add(EAST_AABB15);
            list.add(EAST_AABB16);
        }
        return list;
    }
}
