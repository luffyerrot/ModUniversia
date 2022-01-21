package fr.luffyerrot.universia.Block;

import fr.luffyerrot.universia.universiaMod;
import fr.luffyerrot.universia.init.ModBlocks;
import fr.luffyerrot.universia.init.ModItems;
import net.minecraft.block.BlockGlazedTerracotta;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
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
import java.util.List;

public class BlockPlanche extends BlockGlazedTerracotta {

    private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0, 0, 0, 0.0625*16, 0.0625*5, 0.0625*16);

    public BlockPlanche(String name) {
        super(EnumDyeColor.BROWN);

        this.setSoundType(SoundType.WOOD);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setHardness(1.4F);
        this.setResistance(2.0F);
        this.setHarvestLevel("axe", 0);
        this.setCreativeTab(universiaMod.creativeTabFoodAndLife);
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
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDING_BOX;
    }

    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn) {
        super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
    }
    
    public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune) 
    {
       drops.add(new ItemStack(Item.getItemFromBlock(ModBlocks.planche)));
       if (state.getBlock() == ModBlocks.planche_tomate) {
           drops.add(new ItemStack(ModItems.tomate));
       } else if (state.getBlock() == ModBlocks.planche_mais) {
           drops.add(new ItemStack(ModItems.mais));
       } else if (state.getBlock() == ModBlocks.planche_poireau) {
           drops.add(new ItemStack(ModItems.poireaux));
       } else if (state.getBlock() == ModBlocks.planche_salade) {
           drops.add(new ItemStack(ModItems.coeur_salade));
       } else if (state.getBlock() == ModBlocks.planche_choux_rouge) {
           drops.add(new ItemStack(ModItems.coeur_choux_rouge));
       } else if (state.getBlock() == ModBlocks.planche_oignon) {
           drops.add(new ItemStack(ModItems.oignons));
       } else if (state.getBlock() == ModBlocks.planche_oignon_rouge) {
           drops.add(new ItemStack(ModItems.oignons_rouge));
       } else if (state.getBlock() == ModBlocks.planche_beef) {
           drops.add(new ItemStack(Items.COOKED_BEEF));
       } else if (state.getBlock() == ModBlocks.planche_chicken) {
           drops.add(new ItemStack(Items.COOKED_CHICKEN));
       } else if (state.getBlock() == ModBlocks.planche_coad) {
           drops.add(new ItemStack(Items.COOKED_FISH));
       } else if (state.getBlock() == ModBlocks.planche_mutton) {
           drops.add(new ItemStack(Items.COOKED_MUTTON));
       } else if (state.getBlock() == ModBlocks.planche_pork) {
           drops.add(new ItemStack(Items.COOKED_PORKCHOP));
       } else if (state.getBlock() == ModBlocks.planche_rabbit) {
           drops.add(new ItemStack(Items.COOKED_RABBIT));
       } else if (state.getBlock() == ModBlocks.planche_salmon) {
           drops.add(new ItemStack(Items.COOKED_FISH, 1, 1));
       } else if (state.getBlock() == ModBlocks.planche_bread) {
           drops.add(new ItemStack(Items.BREAD));
       }
    }
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	if (!worldIn.isRemote) {
    		if (worldIn.getBlockState(pos).getBlock() == ModBlocks.planche) {
            	if (playerIn.getHeldItem(hand).getItem() == ModItems.tomate) {
                	worldIn.setBlockState(pos, ModBlocks.planche_tomate.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
            	} else if (playerIn.getHeldItem(hand).getItem() == ModItems.mais) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche_mais.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
            	} else if (playerIn.getHeldItem(hand).getItem() == ModItems.poireaux) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche_poireau.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
            	} else if (playerIn.getHeldItem(hand).getItem() == ModItems.coeur_salade) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche_salade.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
            	} else if (playerIn.getHeldItem(hand).getItem() == ModItems.coeur_choux_rouge) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche_choux_rouge.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
            	} else if (playerIn.getHeldItem(hand).getItem() == ModItems.oignons) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche_oignon.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
            	} else if (playerIn.getHeldItem(hand).getItem() == ModItems.oignons_rouge) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche_oignon_rouge.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
            	} else if (playerIn.getHeldItem(hand).getItem() == Items.COOKED_BEEF) {
                	worldIn.setBlockState(pos, ModBlocks.planche_beef.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
            	} else if (playerIn.getHeldItem(hand).getItem() == Items.COOKED_CHICKEN) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche_chicken.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
            	} else if (playerIn.getHeldItem(hand).getItem() == Items.COOKED_FISH && playerIn.getHeldItem(hand).getMetadata() == 0) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche_coad.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
            	} else if (playerIn.getHeldItem(hand).getItem() == Items.COOKED_MUTTON) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche_mutton.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
            	} else if (playerIn.getHeldItem(hand).getItem() == Items.COOKED_PORKCHOP) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche_pork.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
            	} else if (playerIn.getHeldItem(hand).getItem() == Items.COOKED_RABBIT) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche_rabbit.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
            	} else if (playerIn.getHeldItem(hand).getItem() == Items.COOKED_FISH && playerIn.getHeldItem(hand).getMetadata() == 1) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche_salmon.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
            	} else if (playerIn.getHeldItem(hand).getItem() == Items.BREAD) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche_bread.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
            	}
            	if (!playerIn.isCreative()) {
            		playerIn.getHeldItem(hand).shrink(1);
            	}
            	return true;
            	
        	} else if (worldIn.getBlockState(pos).getBlock() == ModBlocks.planche_tomate) {
        		if (playerIn.getHeldItem(hand).getItem() == ModItems.couteau) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
                	worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.rondelle_tomate, 2)));
                	playerIn.getHeldItem(hand).damageItem(1, playerIn);
                	return true;
            	}
        	} else if (worldIn.getBlockState(pos).getBlock() == ModBlocks.planche_mais) {
        		if (playerIn.getHeldItem(hand).getItem() == ModItems.couteau) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
                	worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.rondelle_mais, 2)));
                	playerIn.getHeldItem(hand).damageItem(1, playerIn);
                	return true;
            	}
        	} else if (worldIn.getBlockState(pos).getBlock() == ModBlocks.planche_poireau) {
        		if (playerIn.getHeldItem(hand).getItem() == ModItems.couteau) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
                	worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.rondelle_poireaux, 2)));
                	playerIn.getHeldItem(hand).damageItem(1, playerIn);
                	return true;
            	}
        	} else if (worldIn.getBlockState(pos).getBlock() == ModBlocks.planche_salade) {
        		if (playerIn.getHeldItem(hand).getItem() == ModItems.couteau) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
                	worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.tranche_salade, 2)));
                	playerIn.getHeldItem(hand).damageItem(1, playerIn);
                	return true;
            	}
        	} else if (worldIn.getBlockState(pos).getBlock() == ModBlocks.planche_choux_rouge) {
        		if (playerIn.getHeldItem(hand).getItem() == ModItems.couteau) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
                	worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.tranche_choux_rouge, 2)));
                	playerIn.getHeldItem(hand).damageItem(1, playerIn);
                	return true;
            	}
        	} else if (worldIn.getBlockState(pos).getBlock() == ModBlocks.planche_oignon) {
        		if (playerIn.getHeldItem(hand).getItem() == ModItems.couteau) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
                	worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.rondelle_oignons, 2)));
                	playerIn.getHeldItem(hand).damageItem(1, playerIn);
                	return true;
            	}
        	} else if (worldIn.getBlockState(pos).getBlock() == ModBlocks.planche_oignon_rouge) {
        		if (playerIn.getHeldItem(hand).getItem() == ModItems.couteau) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
                	worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.rondelle_oignons_rouge, 2)));
                	playerIn.getHeldItem(hand).damageItem(1, playerIn);
                	return true;
            	}
        	} else if (worldIn.getBlockState(pos).getBlock() == ModBlocks.planche_beef) {
        		if (playerIn.getHeldItem(hand).getItem() == ModItems.couteau) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
                	//worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.rondelle_tomate, 2)));
                	playerIn.getHeldItem(hand).damageItem(1, playerIn);
                	return true;
            	}
        	} else if (worldIn.getBlockState(pos).getBlock() == ModBlocks.planche_chicken) {
        		if (playerIn.getHeldItem(hand).getItem() == ModItems.couteau) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
                	//worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.rondelle_mais, 2)));
                	playerIn.getHeldItem(hand).damageItem(1, playerIn);
                	return true;
            	}
        	} else if (worldIn.getBlockState(pos).getBlock() == ModBlocks.planche_coad) {
        		if (playerIn.getHeldItem(hand).getItem() == ModItems.couteau) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
                	//worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.rondelle_poireau, 2)));
                	playerIn.getHeldItem(hand).damageItem(1, playerIn);
                	return true;
            	}
        	} else if (worldIn.getBlockState(pos).getBlock() == ModBlocks.planche_mutton) {
        		if (playerIn.getHeldItem(hand).getItem() == ModItems.couteau) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
                	//worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.tranche_salade, 2)));
                	playerIn.getHeldItem(hand).damageItem(1, playerIn);
                	return true;
            	}
        	} else if (worldIn.getBlockState(pos).getBlock() == ModBlocks.planche_pork) {
        		if (playerIn.getHeldItem(hand).getItem() == ModItems.couteau) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
                	//worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.tranche_choux_rouge, 2)));
                	playerIn.getHeldItem(hand).damageItem(1, playerIn);
                	return true;
            	}
        	} else if (worldIn.getBlockState(pos).getBlock() == ModBlocks.planche_rabbit) {
        		if (playerIn.getHeldItem(hand).getItem() == ModItems.couteau) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
                	//worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.rondelle_oignon, 2)));
                	playerIn.getHeldItem(hand).damageItem(1, playerIn);
                	return true;
            	}
        	} else if (worldIn.getBlockState(pos).getBlock() == ModBlocks.planche_salmon) {
        		if (playerIn.getHeldItem(hand).getItem() == ModItems.couteau) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
                	//worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.rondelle_oignon_rouge, 2)));
                	playerIn.getHeldItem(hand).damageItem(1, playerIn);
                	return true;
            	}
        	} else if (worldIn.getBlockState(pos).getBlock() == ModBlocks.planche_bread) {
        		if (playerIn.getHeldItem(hand).getItem() == ModItems.couteau) {
                	worldIn.setBlockToAir(pos);
                	worldIn.setBlockState(pos, ModBlocks.planche.getDefaultState().withProperty(FACING, (EnumFacing)state.getValue(FACING)));
                	worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.tranche_pain, 2)));
                	playerIn.getHeldItem(hand).damageItem(1, playerIn);
                	return true;
            	}
        	}
    	}
    	return false;
    }
}
