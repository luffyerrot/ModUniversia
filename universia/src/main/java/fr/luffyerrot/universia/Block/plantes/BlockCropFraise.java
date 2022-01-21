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

public class BlockCropFraise extends BlockCrops {

    public BlockCropFraise(){
        setUnlocalizedName("fraise_crop");
        setRegistryName("fraise_crop");
    }

    @Override
    protected Item getSeed(){

        return ModItems.fraise_seed;
    }

    @Override
    protected Item getCrop(){

        return ModItems.fraise;
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
        return state.getBlock() == Blocks.GRASS;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (!worldIn.isRemote){
            if (this.isMaxAge(state)){
                worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.fraise, 4)));
                worldIn.setBlockState(pos, this.withAge(0));
                return true;
            }
        }
        return false;
    }
}