package fr.luffyerrot.universia.Block.plantes;

import fr.luffyerrot.universia.init.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCropBulbe extends BlockCrops {

    public BlockCropBulbe(){
        setUnlocalizedName("bulbe_crop");
        setRegistryName("bulbe_crop");
    }

    @Override
    protected Item getSeed(){

        return ModItems.bulbe_seed;
    }

    @Override
    protected Item getCrop(){

        return ModItems.bulbe;
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {

        int age = getAge(state);
        if (age >= getMaxAge())
        {
            drops.add(new ItemStack(this.getSeed(), 1, 0));
            drops.add(new ItemStack(this.getCrop(), 1, 0));
        }
    }

    @Override
    protected boolean canSustainBush(IBlockState state) {
        return state.getBlock() == Blocks.COBBLESTONE;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (!worldIn.isRemote){
            if (this.isMaxAge(state)){
            	if (playerIn.getHeldItemMainhand().getItem() == ModItems.wood_faucille || playerIn.getHeldItemMainhand().getItem() == ModItems.stone_faucille ||
    					playerIn.getHeldItemMainhand().getItem() == ModItems.iron_faucille || playerIn.getHeldItemMainhand().getItem() == ModItems.gold_faucille ||
    					playerIn.getHeldItemMainhand().getItem() == ModItems.diamond_faucille || playerIn.getHeldItemMainhand().getItem() == ModItems.torbenite_faucille) {
            		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.bulbe, 1)));
                    worldIn.setBlockState(pos, this.withAge(0));
	                playerIn.getHeldItemMainhand().damageItem(1, playerIn);
                    return true;
            	}
            }
        }
        return false;
    }
}
