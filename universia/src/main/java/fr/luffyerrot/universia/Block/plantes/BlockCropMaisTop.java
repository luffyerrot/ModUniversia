package fr.luffyerrot.universia.Block.plantes;

import java.util.Random;

import fr.luffyerrot.universia.init.ModBlocks;
import net.minecraft.block.Block;
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

public class BlockCropMaisTop extends BlockCropMaisBottom{
	
	public static final PropertyInteger MAIS_TOP_AGE = PropertyInteger.create("age", 0, 5);
	private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0, -1.0D, 0.0D, 1.0D, 0.0625 * 3, 1.0D), new AxisAlignedBB(0.0D, -1.0D, 0.0D, 1.0D, 0.0625 * 10, 1.0D), new AxisAlignedBB(0.0D, -1.0D, 0.0D, 1.0D, 0.0625 * 13, 1.0D), new AxisAlignedBB(0.0D, -1.0D, 0.0D, 1.0D, 0.0625 * 14, 1.0D), new AxisAlignedBB(0.0D, -1.0D, 0.0D, 1.0D, 0.0625 * 15, 1.0D), new AxisAlignedBB(0.0D, -1.0D, 0.0D, 1.0D, 1.0D, 1.0D)};
    
    public BlockCropMaisTop(String name) {
		super(name);
        this.disableStats();
	}
    
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return CROPS_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
    }
    
    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
    	super.onBlockDestroyedByPlayer(worldIn, pos, state);
    	if (worldIn.getBlockState(pos.down()).getBlock() == ModBlocks.mais_crop_bottom) {
        	worldIn.setBlockToAir(pos.down());
    	}
    }
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	if (!worldIn.isRemote) {
    		int age = getAge(state);
            if (age >= this.getMaxAge())
            {
            	if (worldIn.getBlockState(pos.down()).getBlock() == ModBlocks.mais_crop_bottom) {
            		Block blockDown = worldIn.getBlockState(pos.down()).getBlock();
                	worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY() - 1, pos.getZ(), new ItemStack(this.getCrop(), 1)));
                    worldIn.setBlockState(pos.down(), blockDown.getDefaultState());
                    worldIn.setBlockToAir(pos);
                    return true;
            	}
            }
    	}
        return false;
    }
    
	protected PropertyInteger getAgeProperty()
    {
        return MAIS_TOP_AGE;
    }
	
	public int getMaxAge()
    {
        return 5;
    }
	
    protected boolean canSustainBush(IBlockState state)
    {
        return state.getBlock() == ModBlocks.mais_crop_bottom;
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
        IBlockState maisBottom = worldIn.getBlockState(pos.down());
        return (worldIn.getLight(pos) >= 8 || worldIn.canSeeSky(pos)) && (maisBottom.getBlock() == ModBlocks.mais_crop_bottom); 
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
        return new BlockStateContainer(this, new IProperty[] {MAIS_TOP_AGE});
    }
}