package fr.luffyerrot.universia.Item;

import fr.luffyerrot.universia.universiaMod;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemSoinWithDuraAndBonus extends ItemSoin{

	private PotionEffect effect;
	private int health;
	
	public ItemSoinWithDuraAndBonus(String name, int amount, float saturation, boolean isWolfFood, int health, int size, int damage, String description1, String description2, PotionEffect effect) {
		super(name, amount, saturation, isWolfFood, size, health, description1, description2);
		this.effect = effect;
		this.health = health;
		this.setMaxDamage(damage);
		this.showDurabilityBar(new ItemStack(this));
		setCreativeTab(universiaMod.creativeTabFoodAndLife);
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		if (player.shouldHeal()) {
			player.addPotionEffect(new PotionEffect(effect.getPotion(), effect.getDuration(), effect.getAmplifier()));
            player.setHealth(player.getHealth() + this.health);	
		}
	}
	
	public boolean hasEffect(ItemStack stack) {
		return true;
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

        stack.damageItem(1, entityLiving);
        return stack;
    }
}
