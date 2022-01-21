package fr.luffyerrot.universia.Item;

import java.util.List;

import javax.annotation.Nullable;

import fr.luffyerrot.universia.universiaMod;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSoin extends ItemFood{

	private int health;
	private String description1, description2;
	
	public ItemSoin(String name, int amount, float saturation, boolean isWolfFood, int health, int size, String description1, String description2) {
		super(amount, saturation, isWolfFood);
		setAlwaysEdible();
		setMaxStackSize(size);
		this.health = health;
		this.description1 = description1;
		this.description2 = description2;
		setCreativeTab(universiaMod.creativeTabFoodAndLife);
		setUnlocalizedName(name);
		setRegistryName(name);
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote) {
            player.setHealth(player.getHealth() + this.health);	
		}
	}
	
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        if (entityLiving instanceof EntityPlayer)
        {
        	EntityPlayer entityplayer = (EntityPlayer)entityLiving;
        	if (entityplayer.shouldHeal()) {
        		worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_CHICKEN_EGG, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
                this.onFoodEaten(stack, worldIn, entityplayer);
                entityplayer.addStat(StatList.getObjectUseStats(this));
        	} else {
        		return stack;
        	}
        	
	    	if (entityplayer instanceof EntityPlayerMP)
	        {
	            CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP)entityplayer, stack);
	        }
        }

        stack.shrink(1);
        return stack;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add(this.description1);
		if (this.description2 != null) {
			tooltip.add(this.description2);
		}
    }
}
