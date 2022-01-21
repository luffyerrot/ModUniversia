package fr.luffyerrot.universia.Block.liquides;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import javax.annotation.Nonnull;

public class BlockFluidB6 extends BlockFluidClassic {

    public BlockFluidB6(String name, Fluid fluid, Material material) {

        super(fluid, material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setDensity(10);
        setLightOpacity(2);
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        entityIn.attackEntityFrom(DamageSource.MAGIC, 1.0F);
        super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
    }

    @Override
    public boolean isOpaqueCube(@Nonnull IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(@Nonnull IBlockState state) {
        return false;
    }
}
