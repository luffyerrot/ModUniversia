package fr.luffyerrot.universia.Item;

import fr.luffyerrot.universia.universiaMod;
import fr.luffyerrot.universia.Entity.EntityBottle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemBouteille extends Item {

    public ItemBouteille(String name){

    	setUnlocalizedName(name);
    	setRegistryName(name);
    	setCreativeTab(universiaMod.creativeTab);
    }

   @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

       ItemStack item = playerIn.getHeldItem(handIn);
       Vec3d look = playerIn.getLookVec();
       EntityBottle bottle = new EntityBottle(worldIn, playerIn);
       bottle.setPosition(playerIn.posX + look.x * 1.5D, playerIn.posY + 1.5D + look.y * 1.5D, playerIn.posZ + look.z * 1.5D);
       bottle.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 0.5F);
	   if (!worldIn.isRemote) {
		   worldIn.spawnEntity(bottle);
	   }
	   worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.ENTITY_BOBBER_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
       
	   if (!playerIn.capabilities.isCreativeMode) {
	          item.shrink(1);
	   }
	   return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
    }
}
