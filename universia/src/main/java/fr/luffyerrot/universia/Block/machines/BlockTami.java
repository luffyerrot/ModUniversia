package fr.luffyerrot.universia.Block.machines;

import fr.luffyerrot.universia.universiaMod;
import fr.luffyerrot.universia.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTami extends Block {
	
    public BlockTami(String name)
    {
        super(Material.WOOD);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(universiaMod.creativeTab);
        setHarvestLevel("axe", 1);
        setHardness(8F);
        setResistance(3F);
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
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (!worldIn.isRemote){
        	if (playerIn.getHeldItemMainhand().getItem() == Item.getItemFromBlock(Blocks.SAND)) {
        		if (playerIn.getHeldItemMainhand().getMetadata() == 0) {
            		worldIn.setBlockState(pos, ((BlockTamiPlein) ModBlocks.tami_sand).withNiveaux(Integer.valueOf(0)));
        		} else if (playerIn.getHeldItemMainhand().getMetadata() == 1) {
            		worldIn.setBlockState(pos, ((BlockTamiPlein) ModBlocks.tami_redsand).withNiveaux(Integer.valueOf(0)));
        		}
        	} else if (playerIn.getHeldItemMainhand().getItem() == Item.getItemFromBlock(Blocks.GRAVEL)) {
        		worldIn.setBlockState(pos, ((BlockTamiPlein) ModBlocks.tami_gravel).withNiveaux(Integer.valueOf(0)));
        	} else if (playerIn.getHeldItemMainhand().getItem() == Item.getItemFromBlock(Blocks.DIRT)) {
        		worldIn.setBlockState(pos, ((BlockTamiPlein) ModBlocks.tami_dirt).withNiveaux(Integer.valueOf(0)));
        	} else if (playerIn.getHeldItemMainhand().getItem() == Item.getItemFromBlock(Blocks.COBBLESTONE)) {
        		worldIn.setBlockState(pos, ((BlockTamiPlein) ModBlocks.tami_cobble).withNiveaux(Integer.valueOf(0)));
        	} else if (playerIn.getHeldItemMainhand().getItem() == Item.getItemFromBlock(Blocks.SOUL_SAND)) {
        		worldIn.setBlockState(pos, ((BlockTamiPlein) ModBlocks.tami_soulsand).withNiveaux(Integer.valueOf(0)));
        	} else if (playerIn.getHeldItemMainhand().getItem() == Item.getItemFromBlock(ModBlocks.block_poudre_fer)) {
        		worldIn.setBlockState(pos, ((BlockTamiPlein) ModBlocks.tami_ironpowder).withNiveaux(Integer.valueOf(0)));
        	} else if (playerIn.getHeldItemMainhand().getItem() == Item.getItemFromBlock(ModBlocks.block_poudre_or)) {
        		worldIn.setBlockState(pos, ((BlockTamiPlein) ModBlocks.tami_goldpowder).withNiveaux(Integer.valueOf(0)));
        	} else if (playerIn.getHeldItemMainhand().getItem() == Item.getItemFromBlock(ModBlocks.block_poudre_or_noire)) {
        		worldIn.setBlockState(pos, ((BlockTamiPlein) ModBlocks.tami_blackgoldpowder).withNiveaux(Integer.valueOf(0)));
        	} else if (playerIn.getHeldItemMainhand().getItem() == Item.getItemFromBlock(ModBlocks.block_poudre_or_rouge)) {
        		worldIn.setBlockState(pos, ((BlockTamiPlein) ModBlocks.tami_redgoldpowder).withNiveaux(Integer.valueOf(0)));
        	} else if (playerIn.getHeldItemMainhand().getItem() == Item.getItemFromBlock(ModBlocks.block_poudre_or_bleu)) {
        		worldIn.setBlockState(pos, ((BlockTamiPlein) ModBlocks.tami_bluegoldpowder).withNiveaux(Integer.valueOf(0)));
        	} else {
        		return true;
        	}
        	
        	if (!playerIn.isCreative()) {
        		playerIn.getHeldItemMainhand().shrink(1);
        	}
            return true;
        }
        return true;
    }
}