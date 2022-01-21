package fr.luffyerrot.universia.Item;

import fr.luffyerrot.universia.Block.plantes.BlockCropVigneBottom;
import fr.luffyerrot.universia.init.ModBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemPotagerSeed extends ItemSeeds {

    private final Block crops;
	
    public ItemPotagerSeed(String name, Block block) {

        super(block, Blocks.FARMLAND);
        this.crops = block;
        setUnlocalizedName(name);
        setRegistryName(name);
    }
    
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = player.getHeldItem(hand);
        IBlockState state = worldIn.getBlockState(pos);
        if (this.crops == ModBlocks.vigne_crop_bottom) {
        	if (facing == EnumFacing.UP && state.getBlock() == Blocks.GRASS && worldIn.isAirBlock(pos.up()))
            {
        		BlockCropVigneBottom vigne = (BlockCropVigneBottom)this.crops;
                worldIn.setBlockState(pos.up(), vigne.withAgeAndFace(0, player.getAdjustedHorizontalFacing()));

                if (player instanceof EntityPlayerMP)
                {
                    CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos.up(), itemstack);
                }

                itemstack.shrink(1);
                return EnumActionResult.SUCCESS;
            }
            else
            {
                return EnumActionResult.FAIL;
            }
        } else {
        	if (facing == EnumFacing.UP && state.getBlock() == Blocks.FARMLAND && worldIn.isAirBlock(pos.up()))
            {
                worldIn.setBlockState(pos.up(), this.crops.getDefaultState());

                if (player instanceof EntityPlayerMP)
                {
                    CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos.up(), itemstack);
                }

                itemstack.shrink(1);
                return EnumActionResult.SUCCESS;
            }
            else
            {
                return EnumActionResult.FAIL;
            }
        }
    }
}
