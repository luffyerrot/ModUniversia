package fr.luffyerrot.universia.Item;

import fr.luffyerrot.universia.universiaMod;
import fr.luffyerrot.universia.utils.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemPortable extends Item {
	
	public ItemPortable(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(universiaMod.creativeTab);
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
		playerIn.openGui(Reference.MODID, Reference.GUI_PORTABLE_ACCUEIL, worldIn, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ());
        return new ActionResult(EnumActionResult.SUCCESS, itemstack);
    }
}

