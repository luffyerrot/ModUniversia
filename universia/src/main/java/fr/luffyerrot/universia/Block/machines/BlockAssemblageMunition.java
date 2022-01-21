package fr.luffyerrot.universia.Block.machines;

import fr.luffyerrot.universia.TileEntity.TileEntityAssemblageMunition;
import fr.luffyerrot.universia.universiaMod;
import fr.luffyerrot.universia.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockAssemblageMunition extends Block implements ITileEntityProvider {
	
    public BlockAssemblageMunition(String name){
        super(Material.IRON);
        setSoundType(SoundType.METAL);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setHardness(3.0F);
        this.setResistance(2.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(universiaMod.creativeTab);
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return true;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return true;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    public boolean hasTileEntity() {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {

        return new TileEntityAssemblageMunition();
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity instanceof TileEntityAssemblageMunition) {
            InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityAssemblageMunition) tileentity);
        }

        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	
    	if (!worldIn.isRemote)
        {
    		playerIn.openGui(universiaMod.instance, Reference.GUI_ASSEMBLAGE_MUNITION, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
		return true;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if (stack.hasDisplayName()) {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityAssemblageMunition) {
                ((TileEntityAssemblageMunition) tileentity).setCustomName(stack.getDisplayName());
            }
        }
    }
}
