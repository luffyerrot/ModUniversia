package fr.luffyerrot.universia.Block.plantes;

import fr.luffyerrot.universia.init.ModBlocks;
import fr.luffyerrot.universia.universiaMod;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockPommier extends Block implements IGrowable {

    public static final PropertyInteger COUCHE = PropertyInteger.create("couche", 0, 2);

    public BlockPommier(Material material, String name) {
        super(material);
        this.setDefaultState(this.blockState.getBaseState().withProperty(this.getCoucheProperty(), Integer.valueOf(0)));
        this.setCreativeTab(universiaMod.creativeTab);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setTickRandomly(true);
        this.setHardness(0.2F);
        this.setLightOpacity(1);
        this.setSoundType(SoundType.PLANT);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }

    public int getMaxCouche()
    {
        return 2;
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

    protected Item getFruit()
    {
        return Items.APPLE;
    }

    protected Block getFeuille()
    {
        return ModBlocks.pommier;
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        //super.updateTick(worldIn, pos, state, rand);

        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light

        int i = this.getCouche(state);

        if (i > 0)
        {
            float f = getGrowthChance(this, worldIn, pos);

            if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(35.0f / f) + 1) == 0))
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
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return !this.isMaxCouche(state);
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return true;
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
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {

        if (state == this.blockState.getBaseState().withProperty(this.getCoucheProperty(), 0))
        {
            drops.add(new ItemStack(this.getFruit(), 1, 0));
        }else {
            drops.add(new ItemStack(this.getFeuille(), 1, 0));
        }
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
            if (state == this.blockState.getBaseState().withProperty(this.getCoucheProperty(), Integer.valueOf(0))){
                worldIn.setBlockState(pos, this.blockState.getBaseState().withProperty(this.getCoucheProperty(), Integer.valueOf(2)));
                worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.APPLE, 1)));
                return true;
            }
        }
        return false;
    }
}
