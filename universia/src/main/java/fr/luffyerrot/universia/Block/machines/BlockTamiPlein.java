package fr.luffyerrot.universia.Block.machines;

import java.util.Random;

import fr.luffyerrot.universia.init.ModBlocks;
import fr.luffyerrot.universia.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTamiPlein extends Block implements IGrowable {

    public static final PropertyInteger NIVEAUX = PropertyInteger.create("niveaux", 0, 6);
    public ItemStack block;
    
    public BlockTamiPlein(String name, ItemStack block)
    {
        super(Material.WOOD);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        setHarvestLevel("axe", 1);
        setHardness(8F);
        setResistance(3F);
        this.block = block;
    }

    public int getMaxNiveaux()
    {
        return 6;
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public boolean isFullBlock(IBlockState state) {
    	return false;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state) {
    	return false;
    }
    
    protected int getNiveaux(IBlockState state)
    {
        return ((Integer)state.getValue(this.getNiveauxProperty())).intValue();
    }

    protected PropertyInteger getNiveauxProperty()
    {
        return NIVEAUX;
    }

    public IBlockState withNiveaux(int niveaux)
    {
        return this.getDefaultState().withProperty(this.getNiveauxProperty(), Integer.valueOf(niveaux));
    }

    public boolean isMaxNiveaux(IBlockState state)
    {
        return ((Integer)state.getValue(this.getNiveauxProperty())).intValue() >= this.getMaxNiveaux();
    }
    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    }

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return false;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return false;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
	}
	
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.withNiveaux(meta);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return this.getNiveaux(state);
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {NIVEAUX});
    }
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (!worldIn.isRemote){
	    	if (this.getNiveaux(state) == 0) {
	    		worldIn.setBlockState(pos, this.withNiveaux(Integer.valueOf(1)));
	    	} else if (this.getNiveaux(state) == 1) {
	    		worldIn.setBlockState(pos, this.withNiveaux(Integer.valueOf(2)));
	    	} else if (this.getNiveaux(state) == 2) {
	    		worldIn.setBlockState(pos, this.withNiveaux(Integer.valueOf(3)));
	    	} else if (this.getNiveaux(state) == 3) {
	    		worldIn.setBlockState(pos, this.withNiveaux(Integer.valueOf(4)));
	    	} else if (this.getNiveaux(state) == 4) {
	    		worldIn.setBlockState(pos, this.withNiveaux(Integer.valueOf(5)));
	    	} else if (this.getNiveaux(state) == 5) {
	    		worldIn.setBlockState(pos, this.withNiveaux(Integer.valueOf(6)));
	    	} else {
	    		worldIn.setBlockState(pos, ModBlocks.tami_vide.getDefaultState());
	    		if (this.block.getItem() == Item.getItemFromBlock(Blocks.SAND)) {
	    			if (this.block.getMetadata() == 0) {
		    			return true;
	    			} else {
		    			return true;
	    			}
	    		} else if (this.block.getItem() == Item.getItemFromBlock(Blocks.GRAVEL)) {
	    			if ((Math.random() * 100) < 80) {
			    		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ModItems.fragment_gravier)));
	    			}
	    			int choose = (int) Math.round((Math.random() * 100)) % 3;
	    			switch (choose) {
	    				case 0:
	    				default:
	    	    			if ((Math.random() * 100) < 40) {
	    			    		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ModItems.fragment_charbon)));
	    	    			}
	    					break;
	    				case 1:
	    	    			if ((Math.random() * 100) < 30) {
	    			    		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ModItems.fragment_redstone)));
	    	    			}
	    					break;
	    				case 2:
	    	    			if ((Math.random() * 100) < 30) {
	    			    		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ModItems.fragment_lapis)));
	    	    			}
	    					break;
	    			}
	    			return true;
	    		} else if (this.block.getItem() == Item.getItemFromBlock(Blocks.COBBLESTONE)) {
	    			if ((Math.random() * 100) < 80) {
			    		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ModItems.fragment_cobble)));
	    			}
	    			for (int i = 0; i < Math.round((Math.random() * 100)) % 3; i++) {
		    			int choose = (int) Math.round((Math.random() * 100)) % 6;
		    			switch (choose) {
		    				case 0:
		    				default:
		    	    			if ((Math.random() * 100) < 20) {
		    			    		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ModItems.fragment_amethyst)));
		    	    			}
		    					break;
		    				case 1:
		    	    			if ((Math.random() * 100) < 20) {
		    			    		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ModItems.fragment_rubis)));
		    	    			}
		    					break;
		    				case 2:
		    	    			if ((Math.random() * 100) < 10) {
		    			    		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ModItems.fragment_saphir)));
		    	    			}
		    					break;
		    				case 3:
		    	    			if ((Math.random() * 100) < 20) {
		    			    		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ModItems.fragment_topaz)));
		    	    			}
		    					break;
		    				case 4:
		    	    			if ((Math.random() * 100) < 20) {
		    			    		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ModItems.fragment_kunzite)));
		    	    			}
		    					break;
		    				case 5:
		    	    			if ((Math.random() * 100) < 20) {
		    			    		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ModItems.fragment_obsidienne)));
		    	    			}
		    					break;
		    			}
	    			}
	    		}
	    	}
        }
        return true;
    }

	@Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote){
            if (this.block.getItem() == Item.getItemFromBlock(Blocks.SAND)){
            	if (this.block.getMetadata() == 0) {
    	    		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(Blocks.SAND, 1, 0)));
            	} else {
    	    		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(Blocks.SAND, 1, 1)));
            	}
            } else if (this.block.getItem() == Item.getItemFromBlock(Blocks.GRAVEL)) {
	    		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(Blocks.GRAVEL)));
            } else if (this.block.getItem() == Item.getItemFromBlock(Blocks.DIRT)) {
	    		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(Blocks.DIRT)));
            } else if (this.block.getItem() == Item.getItemFromBlock(Blocks.COBBLESTONE)) {
	    		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(Blocks.COBBLESTONE)));
            }
	    	worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModBlocks.tami_vide)));
	        worldIn.destroyBlock(pos, false);
	        return;
        }
    }
}