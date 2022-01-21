package fr.luffyerrot.universia.Block.deco;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class SlabDeco extends BlockSlab {
		
	Block half;
	public static final PropertyEnum<Variant> VARIANT = PropertyEnum.<Variant>create("variant", Variant.class);
	
	public SlabDeco(String name, Material material, SoundType sound, BlockSlab half) {
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.useNeighborBrightness = !this.isDouble();
		this.setSoundType(sound);
		if (material == Material.ROCK) {
	        this.setHardness(3.5F);
	        this.setResistance(4.0F);
	        this.setHarvestLevel("pickaxe", 1);
		} else {
	        this.setHardness(3.0F);
	        this.setResistance(2.5F);
    		this.setHarvestLevel("axe", 1);
		}
		
		IBlockState state = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);
		if (!this.isDouble()) state = state.withProperty(HALF, EnumBlockHalf.BOTTOM);
		
		this.half = half;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
		return Item.getItemFromBlock(half);
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(half);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);
		if (!this.isDouble()) state = state.withProperty(HALF, ((meta&8) != 0) ? EnumBlockHalf.TOP : EnumBlockHalf.BOTTOM);
		return state;
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		int meta = 0;
		if (!this.isDouble() && state.getValue(HALF) == EnumBlockHalf.TOP) meta |= 8;
		return meta;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		if (!this.isDouble()) return new BlockStateContainer(this, new IProperty[] {VARIANT, HALF});
		else return new BlockStateContainer(this, new IProperty[ ] {VARIANT});
	}
	
	@Override
	public String getUnlocalizedName(int meta) {
		return super.getUnlocalizedName();
	}
	
	@Override
	public IProperty<?> getVariantProperty() {
		return VARIANT;
	}
	
	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		return Variant.DEFAULT;
	}
	
	public static enum Variant implements IStringSerializable {
		
		DEFAULT;
		
		@Override
		public String getName() {
			return "default";
		}
	}
}
