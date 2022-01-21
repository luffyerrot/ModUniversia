package fr.luffyerrot.universia.Item;

import fr.luffyerrot.universia.universiaMod;
import fr.luffyerrot.universia.Entity.EntityBalle;
import fr.luffyerrot.universia.Handlers.SoundHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemTaser extends Item {

    public ItemTaser(String name){

    	setUnlocalizedName(name);
    	setRegistryName(name);
    	setCreativeTab(universiaMod.creativeTab);
    	this.setMaxDamage(440);
    }

   @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

       ItemStack item = playerIn.getHeldItem(handIn);
       if (!item.isItemDamaged()) {
    	   Vec3d look = playerIn.getLookVec();
           EntityBalle balle = new EntityBalle(worldIn, playerIn);
           balle.setPosition(playerIn.posX + look.x * 1.5D, playerIn.posY + 1.5D + look.y * 1.5D, playerIn.posZ + look.z * 1.5D);
           balle.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 5.0F, 0.0F);
    	   if (!worldIn.isRemote) {
    		   worldIn.spawnEntity(balle);
    	   }
    	   worldIn.playSound(playerIn, playerIn.getPosition(), SoundHandler.TASER_SHOT, SoundCategory.PLAYERS, 1.0F, 1.0F);
    	   if (!playerIn.capabilities.isCreativeMode) {
 	          item.damageItem(440, playerIn);
    	   }
    	   return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
       } else {
    	   return new ActionResult<ItemStack>(EnumActionResult.PASS, item);
       }
    }
}
