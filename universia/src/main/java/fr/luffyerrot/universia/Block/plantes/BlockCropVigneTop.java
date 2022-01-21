package fr.luffyerrot.universia.Block.plantes;

import java.util.Random;

import javax.annotation.Nullable;

import fr.luffyerrot.universia.init.ModBlocks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCropVigneTop extends BlockCropVigneBottom{
	
	public static final PropertyInteger VIGNE_TOP_AGE = PropertyInteger.create("age", 0, 6);
	private static final AxisAlignedBB[] CROPS1_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0625 * 5D, 1.0D, 0.0625 * 2D, 0.0625 * 11D), new AxisAlignedBB(0.0D, 0.0D, 0.0625 * 5D, 1.0D, 0.0625 * 4D, 0.0625 * 11D), new AxisAlignedBB(0.0D, 0.0D, 0.0625 * 5D, 1.0D, 0.0625 * 6D, 0.0625 * 11D), new AxisAlignedBB(0.0D, 0.0D, 0.0625 * 4D, 1.0D, 0.0625 * 8D, 0.0625 * 12D), new AxisAlignedBB(0.0D, 0.0D, 0.0625 * 4D, 1.0D, 0.0625 * 8D, 0.0625 * 12D), new AxisAlignedBB(0.0D, 0.0D, 0.0625 * 4D, 1.0D, 0.0625 * 8D, 0.0625 * 12D), new AxisAlignedBB(0.0D, 0.0D, 0.0625 * 4D, 1.0D, 0.0625 * 8D, 0.0625 * 12D)};
	private static final AxisAlignedBB[] CROPS2_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0625 * 5D, 0.0D, 0.0D, 0.0625 * 11D, 0.0625 * 2D, 1.0D), new AxisAlignedBB(0.0625 * 5D, 0.0D, 0.0D, 0.0625 * 11D, 0.0625 * 4D, 1.0D), new AxisAlignedBB(0.0625 * 5D, 0.0D, 0.0D, 0.0625 * 11D, 0.0625 * 6D, 1.0D), new AxisAlignedBB(0.0625 * 4D, 0.0D, 0.0D, 0.0625 * 12D, 0.0625 * 8D, 1.0D), new AxisAlignedBB(0.0625 * 4D, 0.0D, 0.0D, 0.0625 * 12D, 0.0625 * 8D, 1.0D), new AxisAlignedBB(0.0625 * 4D, 0.0D, 0.0D, 0.0625 * 12D, 0.0625 * 8D, 1.0D), new AxisAlignedBB(0.0625 * 4D, 0.0D, 0.0D, 0.0625 * 12D, 0.0625 * 8D, 1.0D)};
	
    public BlockCropVigneTop(String name) {
		super(name);
        this.disableStats();
	}
    
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
    	if (state.getValue(FACING) == EnumFacing.SOUTH || state.getValue(FACING) == EnumFacing.NORTH) {
            return CROPS1_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
    	} else if (state.getValue(FACING) == EnumFacing.EAST || state.getValue(FACING) == EnumFacing.WEST) {
            return CROPS2_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
    	}
    	return null;
    }
    
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
    	if (state.getValue(FACING) == EnumFacing.SOUTH || state.getValue(FACING) == EnumFacing.NORTH) {
            return CROPS1_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
    	} else if (state.getValue(FACING) == EnumFacing.EAST || state.getValue(FACING) == EnumFacing.WEST) {
            return CROPS2_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
    	}
    	return null;
    }
    
    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
    	if (worldIn.getBlockState(pos.down()).getBlock() == ModBlocks.vigne_crop_bottom) {
    		if (worldIn.getBlockState(pos.down()).getValue(FACING) == EnumFacing.SOUTH || worldIn.getBlockState(pos.down()).getValue(FACING) == EnumFacing.NORTH) {
            	worldIn.setBlockToAir(pos.east());
            	worldIn.setBlockToAir(pos.down());
            	worldIn.setBlockToAir(pos.west());
        	} else {
            	worldIn.setBlockToAir(pos.north());
            	worldIn.setBlockToAir(pos.down());
            	worldIn.setBlockToAir(pos.south());
        	}
    	} else {
    		if (worldIn.getBlockState(pos.north().down()).getBlock() == ModBlocks.vigne_crop_bottom) {
            	worldIn.setBlockToAir(pos.north());
            	worldIn.setBlockToAir(pos.north().down());
            	worldIn.setBlockToAir(pos.north().north());
    		}
    		if (worldIn.getBlockState(pos.east().down()).getBlock() == ModBlocks.vigne_crop_bottom) {
            	worldIn.setBlockToAir(pos.east());
            	worldIn.setBlockToAir(pos.east().down());
            	worldIn.setBlockToAir(pos.east().east());
    		}
    		if (worldIn.getBlockState(pos.south().down()).getBlock() == ModBlocks.vigne_crop_bottom) {
            	worldIn.setBlockToAir(pos.south());
            	worldIn.setBlockToAir(pos.south().down());
            	worldIn.setBlockToAir(pos.south().south());
    		}
    		if (worldIn.getBlockState(pos.west().down()).getBlock() == ModBlocks.vigne_crop_bottom) {
            	worldIn.setBlockToAir(pos.west());
            	worldIn.setBlockToAir(pos.west().down());
            	worldIn.setBlockToAir(pos.west().west());
    		}
    	}
    }
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	if (!worldIn.isRemote) {
    		int age = getAge(state);
            if (age >= this.getMaxAge())
            {
            	worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY() - 1, pos.getZ(), new ItemStack(this.getCrop(), 1)));
                worldIn.setBlockState(pos, this.withAgeAndFace(3, this.getFace(worldIn.getBlockState(pos))));
                return true;
            }
    	}
        return false;
    }
    
	protected PropertyInteger getAgeProperty()
    {
        return VIGNE_TOP_AGE;
    }
	
	public int getMaxAge()
    {
        return 6;
    }
	
    protected boolean canSustainBush(IBlockState state)
    {
    	return true;
    }
    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {}
    
    public void grow(World worldIn, BlockPos pos, IBlockState state)
    {
        /*int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
        int j = this.getMaxAge();

        if (i > j)
        {
            i = j;
        }

        worldIn.setBlockState(pos, this.withAge(i), 2);*/
    	return;
    }
	
    public float getGrowthChance(World par1World, int par2, int par3, int par4)
    {
        return 0.0F;
    }
    
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        //IBlockState maisBottom = worldIn.getBlockState(pos.down());
        //return (worldIn.getLight(pos) >= 8 || worldIn.canSeeSky(pos)) && (maisBottom.getBlock() == ModBlocks.mais_crop_bottom); 
        return true;
    }
    
    public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
    	
    }
    
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
    	return !this.isMaxAge(state);
    }
    
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VIGNE_TOP_AGE, FACING});
    }
}