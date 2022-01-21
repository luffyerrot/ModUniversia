package fr.luffyerrot.universia.Block.plantes;

import java.util.Random;

import fr.luffyerrot.universia.init.ModBlocks;
import fr.luffyerrot.universia.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCropTomateBottom extends BlockCrops {
	
	public static final PropertyInteger TOMATE_AGE = PropertyInteger.create("age", 0, 8);
    private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D), new AxisAlignedBB(0, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D), new AxisAlignedBB(0, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D), new AxisAlignedBB(0, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D), new AxisAlignedBB(0, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D), new AxisAlignedBB(0, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D), new AxisAlignedBB(0, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D), new AxisAlignedBB(0, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D), new AxisAlignedBB(0, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D)};

    public BlockCropTomateBottom(String name){
    	this.setDefaultState(this.blockState.getBaseState().withProperty(this.getAgeProperty(), Integer.valueOf(0)));
        setUnlocalizedName(name);
        setRegistryName(name);
        this.setHardness(0.0F);
        this.setSoundType(SoundType.PLANT);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	if (!worldIn.isRemote) {
    		int age = getAge(state);
            if (age >= this.getMaxAge())
            {
            	worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this.getCrop(), 1)));
                worldIn.setBlockState(pos, this.getDefaultState());
                if (worldIn.getBlockState(pos.up()).getBlock() == ModBlocks.tomate_crop_top) {
                    worldIn.setBlockState(pos.up(), worldIn.getBlockState(pos.up()).getBlock().getDefaultState());
            	}
                return true;
            }
    	}
        return false;
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return CROPS_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
    }

    protected PropertyInteger getAgeProperty()
    {
        return TOMATE_AGE;
    }

    public int getMaxAge()
    {
        return 8;
    }
    
    protected int getAge(IBlockState state)
    {
        return ((Integer)state.getValue(this.getAgeProperty())).intValue();
    }

    public IBlockState withAge(int age)
    {
        return this.getDefaultState().withProperty(this.getAgeProperty(), Integer.valueOf(age));
    }

    public boolean isMaxAge(IBlockState state)
    {
        return ((Integer)state.getValue(this.getAgeProperty())).intValue() >= this.getMaxAge();
    }
    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isAreaLoaded(pos, 1)) return;
        if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
        {
			@SuppressWarnings("static-access")
			float f = this.getGrowthChance(this, worldIn, pos);

            if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0))
            {
            	int i = this.getAge(state);

            	if (i <= this.getMaxAge() - 6)
                {
                    worldIn.setBlockState(pos, this.withAge(i + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
                }
            	else
            	{
        			IBlockState topState = worldIn.getBlockState(pos.up());
                	if (worldIn.getBlockState(pos.up()).getBlock() == ModBlocks.tomate_crop_top)
                	{
                		IBlockState tomateTop = worldIn.getBlockState(pos.up());
                		if (((BlockCropTomateTop) tomateTop.getBlock()).getAge(tomateTop) < ((BlockCropTomateTop) tomateTop.getBlock()).getMaxAge())
                		{
                			BlockCropTomateTop topBlock = (BlockCropTomateTop) worldIn.getBlockState(pos.up()).getBlock();	
                			worldIn.setBlockState(pos.up(), topBlock.withAge(i + 1 - 2), 2);
                            worldIn.setBlockState(pos, this.withAge(i + 1), 2);
                            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos.up(), topState, topState); 
                		}
                	}
            	}
            }
        }   
    }
    
    public void grow(World worldIn, BlockPos pos, IBlockState state)
    {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
        int j = this.getMaxAge() - 6;
    	int excessAge = i - j;
    	
    	if (excessAge <= 0)
    	{
            worldIn.setBlockState(pos, this.withAge(i), 2);
    	}
    	else
    	{
        	if (excessAge > 0 && worldIn.getBlockState(pos.up()).getBlock() == ModBlocks.tomate_crop_top)
        	{
        		IBlockState tomateTopState = worldIn.getBlockState(pos.up());
        		BlockCropMaisTop tomateTopBlock = (BlockCropMaisTop) worldIn.getBlockState(pos.up()).getBlock();
        		int tomateTopAge = tomateTopBlock.getAge(tomateTopState);
        		if (tomateTopAge < tomateTopBlock.getMaxAge())
        		{
        			int newAge = tomateTopAge + excessAge;
        			if (newAge > tomateTopBlock.getMaxAge()) newAge = tomateTopBlock.getMaxAge();
        	        worldIn.setBlockState(pos.up(), tomateTopBlock.withAge(newAge), 2);
                    worldIn.setBlockState(pos, this.withAge(newAge + 2), 2);
        		}
        	}
    	}
    }
    
    protected int getBonemealAgeIncrease(World worldIn)
    {
    	return super.getBonemealAgeIncrease(worldIn) / 4;
    }
    
    protected static float getGrowthChance(Block blockIn, World worldIn, BlockPos pos)
    {
        float f = 1.0F;
        BlockPos blockpos = pos.down();

        for (int i = -1; i <= 1; ++i)
        {
            for (int j = -1; j <= 1; ++j)
            {
                float f1 = 0.0F;
                IBlockState iblockstate = worldIn.getBlockState(blockpos.add(i, 0, j));

                if (iblockstate.getBlock().canSustainPlant(iblockstate, worldIn, blockpos.add(i, 0, j), net.minecraft.util.EnumFacing.UP, (net.minecraftforge.common.IPlantable)blockIn))
                {
                    f1 = 1.0F;

                    if (iblockstate.getBlock().isFertile(worldIn, blockpos.add(i, 0, j)))
                    {
                        f1 = 3.0F;
                    }
                }

                if (i != 0 || j != 0)
                {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        BlockPos blockpos1 = pos.north();
        BlockPos blockpos2 = pos.south();
        BlockPos blockpos3 = pos.west();
        BlockPos blockpos4 = pos.east();
        boolean flag = blockIn == worldIn.getBlockState(blockpos3).getBlock() || blockIn == worldIn.getBlockState(blockpos4).getBlock();
        boolean flag1 = blockIn == worldIn.getBlockState(blockpos1).getBlock() || blockIn == worldIn.getBlockState(blockpos2).getBlock();

        if (flag && flag1)
        {
            f /= 2.0F;
        }
        else
        {
            boolean flag2 = blockIn == worldIn.getBlockState(blockpos3.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos4.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos4.south()).getBlock() || blockIn == worldIn.getBlockState(blockpos3.south()).getBlock();

            if (flag2)
            {
                f /= 2.0F;
            }
        }
        return f;
    }
    
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        IBlockState soil = worldIn.getBlockState(pos.down());
        return (worldIn.getLight(pos) >= 8 || worldIn.canSeeSky(pos)) && soil.getBlock() == Blocks.FARMLAND;
    }
        
    protected Item getSeed()
    {
        return ModItems.tomate_seed;
    }

    protected Item getCrop()
    {
        return ModItems.tomate;
    }
    
    public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune) 
    {
       
    }
    
    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
    	super.onBlockDestroyedByPlayer(worldIn, pos, state);
    	if (worldIn.getBlockState(pos.up()).getBlock() == ModBlocks.tomate_crop_top) {
        	worldIn.setBlockToAir(pos.up());
    	}
    	if (!worldIn.isRemote) {
    		int age = getAge(state);
            if (age >= this.getMaxAge())
            {
            	worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this.getSeed(), 1)));
            	worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this.getCrop(), 1)));
            }
            else
            {
            	worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this.getSeed(), 1)));
            }
    	}
    }
    
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return this.isMaxAge(state) ? this.getCrop() : this.getSeed();
    }
    
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(this.getSeed());
    }
    
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
    	IBlockState upState = worldIn.getBlockState(pos.up());
    	return this.getAge(state) <= this.getMaxAge() - 1 ? true : upState.getBlock() == ModBlocks.tomate_crop_top && !((BlockCropMaisTop) upState.getBlock()).isMaxAge(upState);
    }

    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        this.grow(worldIn, pos, state);
    }
    
    public IBlockState getStateFromMeta(int meta)
    {
        return this.withAge(meta);
    }

    public int getMetaFromState(IBlockState state)
    {
        return this.getAge(state);
    }
    
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {TOMATE_AGE});
    }
}