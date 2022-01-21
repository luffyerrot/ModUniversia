package fr.luffyerrot.universia.Block.plantes;

import java.util.Random;

import fr.luffyerrot.universia.init.ModBlocks;
import fr.luffyerrot.universia.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCropVigneBottom extends BlockCrops {
	
	public static final PropertyInteger VIGNE_AGE = PropertyInteger.create("age", 0, 6);
    private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0625*4D, 0.0D, 0.0625*4D, 0.0625*12D, 0.0625*4D, 0.0625*12D), new AxisAlignedBB(0.0625*4D, 0.0D, 0.0625*4D, 0.0625*12D, 0.0625*6D, 0.0625*12D), new AxisAlignedBB(0.0625*4D, 0.0D, 0.0625*4D, 0.0625*12D, 0.0625*8D, 0.0625*12D), new AxisAlignedBB(0.0625*4D, 0.0D, 0.0625*4D, 0.0625*12D, 0.0625*10D, 0.0625*12D), new AxisAlignedBB(0.0625*4D, 0.0D, 0.0625*4D, 0.0625*12D, 0.0625*12D, 0.0625*12D), new AxisAlignedBB(0.0625*4D, 0.0D, 0.0625*4D, 0.0625*12D, 0.0625*14D, 0.0625*12D), new AxisAlignedBB(0.0625*4D, 0.0D, 0.0625*4D, 0.0625*12D, 0.0625*16D, 0.0625*12D)};

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    
    public BlockCropVigneBottom(String name){
    	this.setDefaultState(this.blockState.getBaseState().withProperty(this.getAgeProperty(), Integer.valueOf(0)));
        setUnlocalizedName(name);
        setRegistryName(name);
        this.setHardness(0.6F);
        this.setSoundType(SoundType.PLANT);
    }
    
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return CROPS_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return CROPS_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
    }

    protected PropertyInteger getAgeProperty()
    {
        return VIGNE_AGE;
    }
    
    protected PropertyDirection getFacingProperty()
    {
        return FACING;
    }

    public int getMaxAge()
    {
        return 6;
    }
    
    protected int getAge(IBlockState state)
    {
        return ((Integer)state.getValue(this.getAgeProperty())).intValue();
    }
    
    protected EnumFacing getFace(IBlockState state)
    {
        return ((EnumFacing)state.getValue(this.getFacingProperty()));
    }

    public IBlockState withAge(int age)
    {
        return this.getDefaultState().withProperty(this.getAgeProperty(), Integer.valueOf(age));
    }
    
    public IBlockState withAgeAndFace(int age, EnumFacing face)
    {
        return this.getDefaultState().withProperty(this.getAgeProperty(), Integer.valueOf(age)).withProperty(this.getFacingProperty(), face);
    }

    public boolean isMaxAge(IBlockState state)
    {
        return ((Integer)state.getValue(this.getAgeProperty())).intValue() >= this.getMaxAge();
    }
    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isAreaLoaded(pos, 2)) return;
        if (this.getAge(state) <= 2) {
        	if (worldIn.getBlockState(pos.north()).getBlock() == ModBlocks.vigne_crop_bottom || worldIn.getBlockState(pos.north().north()).getBlock() == ModBlocks.vigne_crop_bottom ||
            		worldIn.getBlockState(pos.north().east()).getBlock() == ModBlocks.vigne_crop_bottom || worldIn.getBlockState(pos.east().east()).getBlock() == ModBlocks.vigne_crop_bottom ||
            		worldIn.getBlockState(pos.east()).getBlock() == ModBlocks.vigne_crop_bottom || worldIn.getBlockState(pos.east().south()).getBlock() == ModBlocks.vigne_crop_bottom ||
            		worldIn.getBlockState(pos.south().south()).getBlock() == ModBlocks.vigne_crop_bottom || worldIn.getBlockState(pos.south()).getBlock() == ModBlocks.vigne_crop_bottom ||
            		worldIn.getBlockState(pos.south().west()).getBlock() == ModBlocks.vigne_crop_bottom || worldIn.getBlockState(pos.west().west()).getBlock() == ModBlocks.vigne_crop_bottom ||
            		worldIn.getBlockState(pos.west()).getBlock() == ModBlocks.vigne_crop_bottom || worldIn.getBlockState(pos.west().north()).getBlock() == ModBlocks.vigne_crop_bottom) {
            	worldIn.setBlockToAir(pos);
            	worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this.getSeed(), 1)));
            } 
        }
        
        if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
        {
			@SuppressWarnings("static-access")
			float f = this.getGrowthChance(this, worldIn, pos);

            if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0))
            {
            	int i = this.getAge(state);

            	if (i < this.getMaxAge())
                {
                    worldIn.setBlockState(pos, this.withAgeAndFace(i + 1, this.getFace(state)), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
                }
            	else
            	{            
        			IBlockState topState = worldIn.getBlockState(pos.up());
        			IBlockState topStateSide1 = null;
        			IBlockState topStateSide2 = null; 
        			
        			if (state.getValue(FACING) == EnumFacing.EAST || state.getValue(FACING) == EnumFacing.WEST) {

            			topStateSide1 = worldIn.getBlockState(pos.up().south());
            			topStateSide2 = worldIn.getBlockState(pos.up().north());
            			if (topState.getBlock() == Blocks.AIR && topStateSide1.getBlock() == Blocks.AIR && topStateSide2.getBlock() == Blocks.AIR)
                    	{
                    		worldIn.setBlockState(pos.up(), ((BlockCropVigneTop) ModBlocks.vigne_crop_top).withAgeAndFace(0, this.getFace(state)));
                    		worldIn.setBlockState(pos.up().south(), ((BlockCropVigneTop) ModBlocks.vigne_crop_top).withAgeAndFace(0, this.getFace(state)));
                    		worldIn.setBlockState(pos.up().north(), ((BlockCropVigneTop) ModBlocks.vigne_crop_top).withAgeAndFace(0, this.getFace(state)));
                    	} else if (topState.getBlock() == ModBlocks.vigne_crop_top && topStateSide1.getBlock() == ModBlocks.vigne_crop_top && topStateSide2.getBlock() == ModBlocks.vigne_crop_top) {
                    		
                    		int x = ((BlockCropVigneTop)worldIn.getBlockState(pos.up()).getBlock()).getAge(worldIn.getBlockState(pos.up()));
                    		int y = ((BlockCropVigneTop)worldIn.getBlockState(pos.up().south()).getBlock()).getAge(worldIn.getBlockState(pos.up().south()));
                    		int z = ((BlockCropVigneTop)worldIn.getBlockState(pos.up().north()).getBlock()).getAge(worldIn.getBlockState(pos.up().north()));
            				
                    		if (!(worldIn.getBlockState(pos.up()).getBlock() == Blocks.AIR) && worldIn.getBlockState(pos.up()).getBlock() == ModBlocks.vigne_crop_top && x < ((BlockCropVigneTop)worldIn.getBlockState(pos.up()).getBlock()).getMaxAge())
            				{
	                    		if (((BlockCropVigneTop) topState.getBlock()).getAge(topState) < ((BlockCropVigneTop) topState.getBlock()).getMaxAge())
	                    		{
	                    			BlockCropVigneTop topBlock = (BlockCropVigneTop) worldIn.getBlockState(pos.up()).getBlock();	
	                    			worldIn.setBlockState(pos.up(), topBlock.withAgeAndFace(x + 1, this.getFace(state)), 2);	
	                                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos.up(), topState, topState); 
	                    		}
	                    	}
                    		if (!(worldIn.getBlockState(pos.up().south()).getBlock() == Blocks.AIR) && worldIn.getBlockState(pos.up().south()).getBlock() == ModBlocks.vigne_crop_top && y < ((BlockCropVigneTop)worldIn.getBlockState(pos.up().south()).getBlock()).getMaxAge())
            				{
	                    		if (((BlockCropVigneTop) topStateSide1.getBlock()).getAge(topStateSide1) < ((BlockCropVigneTop) topStateSide1.getBlock()).getMaxAge())
	                    		{
	                    			BlockCropVigneTop topBlockSide1 = (BlockCropVigneTop) worldIn.getBlockState(pos.up().south()).getBlock();	
	                    			worldIn.setBlockState(pos.up().south(), topBlockSide1.withAgeAndFace(y + 1, this.getFace(state)), 2);	
	                                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos.up().south(), topStateSide1, topStateSide1); 
	                    		}
	                    	}
                    		if (!(worldIn.getBlockState(pos.up().north()).getBlock() == Blocks.AIR) && worldIn.getBlockState(pos.up().north()).getBlock() == ModBlocks.vigne_crop_top && z < ((BlockCropVigneTop)worldIn.getBlockState(pos.up().north()).getBlock()).getMaxAge())
            				{
	                    		if (((BlockCropVigneTop) topStateSide2.getBlock()).getAge(topStateSide2) < ((BlockCropVigneTop) topStateSide2.getBlock()).getMaxAge())
	                    		{
	                    			BlockCropVigneTop topBlockSide2 = (BlockCropVigneTop) worldIn.getBlockState(pos.up().north()).getBlock();	
	                    			worldIn.setBlockState(pos.up().north(), topBlockSide2.withAgeAndFace(z + 1, this.getFace(state)), 2);	
	                                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos.up().north(), topStateSide2, topStateSide2); 
	                    		}
	                    	}
	        			}
        			} else 
        			//---------------------------------------------------------------------
        			if (state.getValue(FACING) == EnumFacing.NORTH || state.getValue(FACING) == EnumFacing.SOUTH) {

            			topStateSide1 = worldIn.getBlockState(pos.up().east());
            			topStateSide2 = worldIn.getBlockState(pos.up().west());
            			if (topState.getBlock() == Blocks.AIR && topStateSide1.getBlock() == Blocks.AIR && topStateSide2.getBlock() == Blocks.AIR)
                    	{
                    		worldIn.setBlockState(pos.up(), ((BlockCropVigneTop) ModBlocks.vigne_crop_top).withAgeAndFace(0, this.getFace(state)));
                    		worldIn.setBlockState(pos.up().east(), ((BlockCropVigneTop) ModBlocks.vigne_crop_top).withAgeAndFace(0, this.getFace(state)));
                    		worldIn.setBlockState(pos.up().west(), ((BlockCropVigneTop) ModBlocks.vigne_crop_top).withAgeAndFace(0, this.getFace(state)));
                    	} else if (topState.getBlock() == ModBlocks.vigne_crop_top && topStateSide1.getBlock() == ModBlocks.vigne_crop_top && topStateSide2.getBlock() == ModBlocks.vigne_crop_top) {
                    		
                    		int x = ((BlockCropVigneTop)worldIn.getBlockState(pos.up()).getBlock()).getAge(worldIn.getBlockState(pos.up()));
                    		int y = ((BlockCropVigneTop)worldIn.getBlockState(pos.up().east()).getBlock()).getAge(worldIn.getBlockState(pos.up().east()));
                    		int z = ((BlockCropVigneTop)worldIn.getBlockState(pos.up().west()).getBlock()).getAge(worldIn.getBlockState(pos.up().west()));
            				
                    		if (!(worldIn.getBlockState(pos.up()).getBlock() == Blocks.AIR) && worldIn.getBlockState(pos.up()).getBlock() == ModBlocks.vigne_crop_top && x < ((BlockCropVigneTop)worldIn.getBlockState(pos.up()).getBlock()).getMaxAge())
            				{
	                    		if (((BlockCropVigneTop) topState.getBlock()).getAge(topState) < ((BlockCropVigneTop) topState.getBlock()).getMaxAge())
	                    		{
	                    			BlockCropVigneTop topBlock = (BlockCropVigneTop) worldIn.getBlockState(pos.up()).getBlock();	
	                    			worldIn.setBlockState(pos.up(), topBlock.withAgeAndFace(x + 1, this.getFace(state)), 2);	
	                                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos.up(), topState, topState); 
	                    		}
	                    	}
                    		if (!(worldIn.getBlockState(pos.up().east()).getBlock() == Blocks.AIR) && worldIn.getBlockState(pos.up().east()).getBlock() == ModBlocks.vigne_crop_top && y < ((BlockCropVigneTop)worldIn.getBlockState(pos.up().east()).getBlock()).getMaxAge())
            				{
	                    		if (((BlockCropVigneTop) topStateSide1.getBlock()).getAge(topStateSide1) < ((BlockCropVigneTop) topStateSide1.getBlock()).getMaxAge())
	                    		{
	                    			BlockCropVigneTop topBlockSide1 = (BlockCropVigneTop) worldIn.getBlockState(pos.up().east()).getBlock();	
	                    			worldIn.setBlockState(pos.up().east(), topBlockSide1.withAgeAndFace(y + 1, this.getFace(state)), 2);	
	                                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos.up().east(), topStateSide1, topStateSide1); 
	                    		}
	                    	}
                    		if (!(worldIn.getBlockState(pos.up().west()).getBlock() == Blocks.AIR) && worldIn.getBlockState(pos.up().west()).getBlock() == ModBlocks.vigne_crop_top && z < ((BlockCropVigneTop)worldIn.getBlockState(pos.up().west()).getBlock()).getMaxAge())
            				{
	                    		if (((BlockCropVigneTop) topStateSide2.getBlock()).getAge(topStateSide2) < ((BlockCropVigneTop) topStateSide2.getBlock()).getMaxAge())
	                    		{
	                    			BlockCropVigneTop topBlockSide2 = (BlockCropVigneTop) worldIn.getBlockState(pos.up().west()).getBlock();	
	                    			worldIn.setBlockState(pos.up().west(), topBlockSide2.withAgeAndFace(z + 1, this.getFace(state)), 2);	
	                                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos.up().west(), topStateSide2, topStateSide2); 
	                    		}
	                    	}
	        			}
        			}
            	}
            }
        }   
    }
    
    //--------------------------------------------------------------------------------------------
    
    public void grow(World worldIn, BlockPos pos, IBlockState state)
    {
        /*int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
    	
    	if (i < this.getMaxAge())
    	{
            worldIn.setBlockState(pos, this.withAge(i), 2);
    	}
    	else
    	{
    		if (state.getValue(FACING) == EnumFacing.NORTH || state.getValue(FACING) == EnumFacing.SOUTH) {
            	if (worldIn.getBlockState(pos.up()).getBlock() == Blocks.AIR && worldIn.getBlockState(pos.up().east()).getBlock() == Blocks.AIR && worldIn.getBlockState(pos.up().west()).getBlock() == Blocks.AIR)
            	{
            		worldIn.setBlockState(pos.up(), ((BlockCropVigneTop) ModBlocks.vigne_crop_top).withAgeAndFace(0, this.getFace(worldIn.getBlockState(pos))));
            		worldIn.setBlockState(pos.up().east(), ((BlockCropVigneTop) ModBlocks.vigne_crop_top).withAgeAndFace(0, this.getFace(worldIn.getBlockState(pos))));
            		worldIn.setBlockState(pos.up().west(), ((BlockCropVigneTop) ModBlocks.vigne_crop_top).withAgeAndFace(0, this.getFace(worldIn.getBlockState(pos))));
            	}

        		int x = ((BlockCropVigneTop)worldIn.getBlockState(pos.up()).getBlock()).getAge(worldIn.getBlockState(pos.up()));
            	
            	if (x < ((BlockCropVigneTop)worldIn.getBlockState(pos.up()).getBlock()).getMaxAge() && worldIn.getBlockState(pos.up()).getBlock() == ModBlocks.vigne_crop_top && worldIn.getBlockState(pos.up().east()).getBlock() == ModBlocks.vigne_crop_top && worldIn.getBlockState(pos.up().west()).getBlock() == ModBlocks.vigne_crop_top)
            	{            		
            		IBlockState vigneTopState = worldIn.getBlockState(pos.up());
            		IBlockState vigneTopStateSide1 = worldIn.getBlockState(pos.up().east());
            		IBlockState vigneTopStateSide2 = worldIn.getBlockState(pos.up().west());
            		BlockCropVigneTop vigneTopBlock = (BlockCropVigneTop) vigneTopState.getBlock();
            		BlockCropVigneTop vigneTopBlockSide1 = (BlockCropVigneTop) vigneTopStateSide1.getBlock();
            		BlockCropVigneTop vigneTopBlockSide2 = (BlockCropVigneTop) vigneTopStateSide2.getBlock();
            		int vigneTopAge = vigneTopBlock.getAge(vigneTopState);
            		int vigneTopAgeSide1 = vigneTopBlockSide1.getAge(vigneTopStateSide1);
            		int vigneTopAgeSide2 = vigneTopBlockSide2.getAge(vigneTopStateSide2);
            		if (vigneTopAge < vigneTopBlock.getMaxAge() && vigneTopAgeSide1 < vigneTopBlockSide1.getMaxAge() && vigneTopAgeSide2 < vigneTopBlockSide2.getMaxAge())
            		{
            			int newAge = x + 1;
            			if (newAge > vigneTopBlock.getMaxAge()) {
            				newAge = vigneTopBlock.getMaxAge();
            			}
            			if (newAge > vigneTopBlockSide1.getMaxAge()) {
            				newAge = vigneTopBlockSide1.getMaxAge();
            			}
            			if (newAge > vigneTopBlockSide2.getMaxAge()) {
            				newAge = vigneTopBlockSide2.getMaxAge();
            			}
            	        worldIn.setBlockState(pos.up(), vigneTopBlock.withAge(newAge), 2);
            	        worldIn.setBlockState(pos.up().east(), vigneTopBlockSide1.withAge(newAge), 2);
            	        worldIn.setBlockState(pos.up().west(), vigneTopBlockSide2.withAge(newAge), 2);
            		}
            	}
    		} else if (state.getValue(FACING) == EnumFacing.EAST || state.getValue(FACING) == EnumFacing.WEST) {
    			if (worldIn.getBlockState(pos.up()).getBlock() == Blocks.AIR && worldIn.getBlockState(pos.up().north()).getBlock() == Blocks.AIR && worldIn.getBlockState(pos.up().south()).getBlock() == Blocks.AIR)
            	{
            		worldIn.setBlockState(pos.up(), ((BlockCropVigneTop) ModBlocks.vigne_crop_top).withAgeAndFace(0, this.getFace(worldIn.getBlockState(pos))));
            		worldIn.setBlockState(pos.up().south(), ((BlockCropVigneTop) ModBlocks.vigne_crop_top).withAgeAndFace(0, this.getFace(worldIn.getBlockState(pos))));
            		worldIn.setBlockState(pos.up().north(), ((BlockCropVigneTop) ModBlocks.vigne_crop_top).withAgeAndFace(0, this.getFace(worldIn.getBlockState(pos))));
            	}

        		int x = ((BlockCropVigneTop)worldIn.getBlockState(pos.up()).getBlock()).getAge(worldIn.getBlockState(pos.up()));
    			
            	if (x < ((BlockCropVigneTop)worldIn.getBlockState(pos.up()).getBlock()).getMaxAge() && worldIn.getBlockState(pos.up()).getBlock() == ModBlocks.vigne_crop_top && worldIn.getBlockState(pos.up().north()).getBlock() == ModBlocks.vigne_crop_top && worldIn.getBlockState(pos.up().south()).getBlock() == ModBlocks.vigne_crop_top)
            	{            		
            		IBlockState vigneTopState = worldIn.getBlockState(pos.up());
            		IBlockState vigneTopStateSide1 = worldIn.getBlockState(pos.up().north());
            		IBlockState vigneTopStateSide2 = worldIn.getBlockState(pos.up().south());
            		BlockCropVigneTop vigneTopBlock = (BlockCropVigneTop) vigneTopState.getBlock();
            		BlockCropVigneTop vigneTopBlockSide1 = (BlockCropVigneTop) vigneTopStateSide1.getBlock();
            		BlockCropVigneTop vigneTopBlockSide2 = (BlockCropVigneTop) vigneTopStateSide2.getBlock();
            		int vigneTopAge = vigneTopBlock.getAge(vigneTopState);
            		int vigneTopAgeSide1 = vigneTopBlockSide1.getAge(vigneTopStateSide1);
            		int vigneTopAgeSide2 = vigneTopBlockSide2.getAge(vigneTopStateSide2);
            		if (vigneTopAge < vigneTopBlock.getMaxAge() && vigneTopAgeSide1 < vigneTopBlockSide1.getMaxAge() && vigneTopAgeSide2 < vigneTopBlockSide2.getMaxAge())
            		{
            			int newAge = x + 1;
            			
            			if (newAge > vigneTopBlock.getMaxAge()) {
            				newAge = vigneTopBlock.getMaxAge();
            			}
            			if (newAge > vigneTopBlockSide1.getMaxAge()) {
            				newAge = vigneTopBlockSide1.getMaxAge();
            			}
            			if (newAge > vigneTopBlockSide2.getMaxAge()) {
            				newAge = vigneTopBlockSide2.getMaxAge();
            			}
            	        worldIn.setBlockState(pos.up(), vigneTopBlock.withAge(newAge), 2);
            	        worldIn.setBlockState(pos.up().north(), vigneTopBlockSide1.withAge(newAge), 2);
            	        worldIn.setBlockState(pos.up().south(), vigneTopBlockSide2.withAge(newAge), 2);
            		}
            	}
    		}
    	}*/
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
        return (worldIn.getLight(pos) >= 8 || worldIn.canSeeSky(pos)) && soil.getBlock() == Blocks.GRASS;
    }
        
    protected Item getSeed()
    {
        return ModItems.raisin_seed;
    }
    
    protected Item getCrop()
    {
        return ModItems.raisin;
    }
    
    public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune) 
    {
       
    }
    
    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
    	super.onBlockDestroyedByPlayer(worldIn, pos, state);
    	
    	if (worldIn.getBlockState(pos.up()).getBlock() == ModBlocks.vigne_crop_top) {
        	worldIn.setBlockToAir(pos.up());
    	}
    	if (worldIn.getBlockState(pos.up().east()).getBlock() == ModBlocks.vigne_crop_top) {
        	worldIn.setBlockToAir(pos.up().east());
    	}
    	if (worldIn.getBlockState(pos.up().west()).getBlock() == ModBlocks.vigne_crop_top) {
        	worldIn.setBlockToAir(pos.up().west());
    	}
    	if (worldIn.getBlockState(pos.up().south()).getBlock() == ModBlocks.vigne_crop_top) {
        	worldIn.setBlockToAir(pos.up().south());
    	}
    	if (worldIn.getBlockState(pos.up().north()).getBlock() == ModBlocks.vigne_crop_top) {
        	worldIn.setBlockToAir(pos.up().north());
    	}
    	
    	if (!worldIn.isRemote) {
        	worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this.getSeed(), 1)));
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
    	if (state.getValue(FACING) == EnumFacing.NORTH || state.getValue(FACING) == EnumFacing.SOUTH) {

        	IBlockState upState1 = worldIn.getBlockState(pos.up().east());
        	IBlockState upState2 = worldIn.getBlockState(pos.up().west());
        	return this.getAge(state) <= this.getMaxAge() - 1  ? true : upState.getBlock() == Blocks.AIR ? true : (upState.getBlock() == ModBlocks.vigne_crop_top && !((BlockCropVigneTop) upState.getBlock()).isMaxAge(upState) || 
        			upState1.getBlock() == ModBlocks.vigne_crop_top && !((BlockCropVigneTop) upState1.getBlock()).isMaxAge(upState1) || upState2.getBlock() == ModBlocks.vigne_crop_top && !((BlockCropVigneTop) upState2.getBlock()).isMaxAge(upState2));
    	} else if (state.getValue(FACING) == EnumFacing.EAST || state.getValue(FACING) == EnumFacing.WEST) {

        	IBlockState upState1 = worldIn.getBlockState(pos.up().south());
        	IBlockState upState2 = worldIn.getBlockState(pos.up().north());
        	return this.getAge(state) <= this.getMaxAge() - 1  ? true : upState.getBlock() == Blocks.AIR ? true : (upState.getBlock() == ModBlocks.vigne_crop_top && !((BlockCropVigneTop) upState.getBlock()).isMaxAge(upState) || 
        			upState1.getBlock() == ModBlocks.vigne_crop_top && !((BlockCropVigneTop) upState1.getBlock()).isMaxAge(upState1) || upState2.getBlock() == ModBlocks.vigne_crop_top && !((BlockCropVigneTop) upState2.getBlock()).isMaxAge(upState2));
    	}
    	return false;
    }

    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        this.grow(worldIn, pos, state);
    }
    
    public IBlockState getStateFromMeta(int meta)
    {
    	if (meta >= 7) {
            return this.withAgeAndFace(meta - 7, EnumFacing.EAST);
    	}
        return this.withAgeAndFace(meta, EnumFacing.NORTH);
    }

    public int getMetaFromState(IBlockState state)
    {
    	int face = 0;
    	if (state.getValue(FACING) == EnumFacing.EAST || state.getValue(FACING) == EnumFacing.WEST) {
    		face = 7;
    	}
        return this.getAge(state) + face;
    }
    
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VIGNE_AGE, FACING});
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
}