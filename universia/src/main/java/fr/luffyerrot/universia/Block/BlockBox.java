package fr.luffyerrot.universia.Block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlazedTerracotta;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

import fr.luffyerrot.universia.init.ModBlocks;
import fr.luffyerrot.universia.init.ModItems;

import java.util.List;

public class BlockBox extends BlockGlazedTerracotta {

    private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0625*1, 0, 0.0625*1, 0.0625*15, 0.0625*10, 0.0625*15);

    public BlockBox(String name) {
        super(EnumDyeColor.BROWN);

        this.setSoundType(SoundType.WOOD);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setHardness(2.0f);
        this.setResistance(1.5F);
        this.setHarvestLevel("axe", 2);
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return true;
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
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	
    	if (!worldIn.isRemote)
        {
    		if (playerIn.isSneaking()) {
    			Block block = worldIn.getBlockState(pos).getBlock();
	    		if (block != ModBlocks.drog_box && worldIn.isAirBlock(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()))) {
	    			worldIn.setBlockToAir(pos);
	        		if (block == ModBlocks.drog_box_weed) {
	        			worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY() + 1, pos.getZ(), new ItemStack(ModItems.weed_packet, 4)));
	        		} else if (block == ModBlocks.drog_box_coca) {
	        			worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY() + 1, pos.getZ(), new ItemStack(ModItems.coca_packet, 4)));
	    			} else if (block == ModBlocks.drog_box_bulbe) {
	        			worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY() + 1, pos.getZ(), new ItemStack(ModItems.bulbe_packet, 4)));
	    			}
        			worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY() + 1, pos.getZ(), new ItemStack(Item.getItemFromBlock(ModBlocks.drog_box))));
	    		}
        	}
        }
		return true;
    }
}
