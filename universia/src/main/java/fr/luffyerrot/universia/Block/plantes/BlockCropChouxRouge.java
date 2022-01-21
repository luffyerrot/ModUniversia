package fr.luffyerrot.universia.Block.plantes;

import fr.luffyerrot.universia.init.ModItems;
import net.minecraft.block.BlockCrops;
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
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCropChouxRouge extends BlockCrops {

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 5);
    private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0625 * 5, 0.0D, 0.0625 * 5, 0.0625 * 11, 0.0625 * 5, 0.0625 * 11), new AxisAlignedBB(0.0625 * 5, 0.0D, 0.0625 * 5, 0.0625 * 11, 0.0625 * 6, 0.0625 * 11), new AxisAlignedBB(0.0625 * 3, 0.0D, 0.0625 * 3, 0.0625 * 13, 0.0625 * 7, 0.0625 * 13), new AxisAlignedBB(0.0625 * 3, 0.0D, 0.0625 * 3, 0.0625 * 13, 0.0625 * 8, 0.0625 * 13), new AxisAlignedBB(0.0625 * 2, 0.0D, 0.0625 * 2, 0.0625 * 14, 0.0625 * 9, 0.0625 * 14), new AxisAlignedBB(0.0625 * 2, 0.0D, 0.0625 * 2, 0.0625 * 14, 0.0625 * 10, 0.0625 * 14)};

    public BlockCropChouxRouge(String name){
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return CROPS_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
    }

    @Override
    protected PropertyInteger getAgeProperty()
    {
        return AGE;
    }

    @Override
    protected Item getSeed(){

        return ModItems.choux_rouge_seed;
    }

    @Override
    protected Item getCrop(){

        return ModItems.feuille_choux_rouge;
    } 
    
    protected Item getCrop2(){

        return ModItems.coeur_choux_rouge;
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {

        int age = getAge(state);
        if (age >= getMaxAge())
        {
            drops.add(new ItemStack(this.getSeed(), 1, 0));
            drops.add(new ItemStack(this.getCrop(), 1, 0));
            drops.add(new ItemStack(this.getCrop2(), 1, 0));
        }
    }

    @Override
    protected boolean canSustainBush(IBlockState state) {
        return state.getBlock() == Blocks.FARMLAND;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (!worldIn.isRemote){
            if (this.isMaxAge(state)){
                worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this.getCrop(), 2)));
                worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this.getCrop2(), 1)));
                worldIn.setBlockState(pos, this.withAge(0));
                return true;
            }
        }
        return false;
    }

    @Override
    public int getMaxAge()
    {
        return 5;
    }
    
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {AGE});
    }
}