package fr.luffyerrot.universia.Block;

import fr.luffyerrot.universia.init.ModItems;
import fr.luffyerrot.universia.universiaMod;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
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

import java.util.Random;

public class BlockBois extends Block implements IGrowable {

    public static final PropertyInteger COUCHE = PropertyInteger.create("couche", 0, 3);
    private static final AxisAlignedBB[] BOIS_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.0625*15D, 1.0D, 0.0625*15D), new AxisAlignedBB(0.0625*4D, 0.0D, 0.0625*4D, 0.0625*12D, 1.0D, 0.0625*12D), new AxisAlignedBB(0.0625*6D, 0.0D, 0.0625*6D, 0.0625*10D, 1.0D, 0.0625*10D)};

    public BlockBois(Material material, String name) {
        super(material);
        this.setDefaultState(this.blockState.getBaseState().withProperty(this.getCoucheProperty(), Integer.valueOf(0)));
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(universiaMod.creativeTab);
        this.setTickRandomly(true);
        this.setHardness(1.2f);
        this.setResistance(1.5F);
        this.setHarvestLevel("axe", 2);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return BOIS_AABB[((Integer)state.getValue(this.getCoucheProperty())).intValue()];
    }

    public int getMaxCouche()
    {
        return 3;
    }

    protected int getCouche(IBlockState state)
    {
        return ((Integer)state.getValue(this.getCoucheProperty())).intValue();
    }

    protected PropertyInteger getCoucheProperty()
    {
        return COUCHE;
    }

    public IBlockState withCouche(int couche)
    {
        return this.getDefaultState().withProperty(this.getCoucheProperty(), Integer.valueOf(couche));
    }

    public boolean isMaxCouche(IBlockState state)
    {
        return ((Integer)state.getValue(this.getCoucheProperty())).intValue() >= this.getMaxCouche();
    }

    protected Item getEcorse()
    {
        return ModItems.ecorce;
    }

    protected Item getBois()
    {
        return ModItems.plaque_bois;
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        super.updateTick(worldIn, pos, state, rand);

        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light

        int i = this.getCouche(state);

        if (i > 0)
        {
            float f = getGrowthChance(this, worldIn, pos);

            if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(50.0f / f) + 1) == 0))
            {
                worldIn.setBlockState(pos, this.withCouche(i - 1), 2);
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
            }
        }
    }

    @SuppressWarnings("unused")
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

                    f1 = 3.0F;

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

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {

        if (state == this.blockState.getBaseState().withProperty(this.getCoucheProperty(), 0))
        {
            drops.add(new ItemStack(Item.getItemFromBlock(Blocks.LOG), 1, 0));
        }
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
        return !this.isMaxCouche(state);
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return false;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        int i = this.getCouche(state);
        int j = this.getMaxCouche();

        if (i > j)
        {
            i = j;
        }

        worldIn.setBlockState(pos, this.withCouche(i), 2);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.withCouche(meta);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return this.getCouche(state);
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {COUCHE});
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (!worldIn.isRemote){
            if (playerIn.isCreative()){
                worldIn.destroyBlock(pos, false);
                return true;
            }
        }
        return false;
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote){
            if (state == this.blockState.getBaseState().withProperty(this.getCoucheProperty(), Integer.valueOf(0))){
                worldIn.setBlockState(pos, this.blockState.getBaseState().withProperty(this.getCoucheProperty(), Integer.valueOf(3)));
            } else if (state == this.blockState.getBaseState().withProperty(this.getCoucheProperty(), Integer.valueOf(1))){
                worldIn.setBlockState(pos, this.blockState.getBaseState().withProperty(this.getCoucheProperty(), Integer.valueOf(1)));
            } else if (state == this.blockState.getBaseState().withProperty(this.getCoucheProperty(), Integer.valueOf(2))){
                worldIn.setBlockState(pos, this.blockState.getBaseState().withProperty(this.getCoucheProperty(), Integer.valueOf(2)));
            } else if (state == this.blockState.getBaseState().withProperty(this.getCoucheProperty(), Integer.valueOf(3))){
                worldIn.setBlockState(pos, state);
            }
        }
    }
}
