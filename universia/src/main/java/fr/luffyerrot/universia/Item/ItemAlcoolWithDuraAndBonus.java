package fr.luffyerrot.universia.Item;

import fr.luffyerrot.universia.universiaMod;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemAlcoolWithDuraAndBonus extends ItemFood{

	private PotionEffect effect;
	private int health;
	
	public ItemAlcoolWithDuraAndBonus(String name, int amount, float saturation, boolean isWolfFood, int health, int size, int damage, PotionEffect effect) {
		super(amount, saturation, isWolfFood);
		setAlwaysEdible();
		setMaxStackSize(size);
		this.effect = effect;
		this.health = health;
		setMaxDamage(damage);
		showDurabilityBar(new ItemStack(this));
		setCreativeTab(universiaMod.creativeTabFoodAndLife);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		if (!player.isPotionActive(MobEffects.NAUSEA)) {
			player.addPotionEffect(new PotionEffect(effect.getPotion(), effect.getDuration(), effect.getAmplifier()));
            player.setHealth(player.getHealth() + this.health);	
		}
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        if (entityLiving instanceof EntityPlayer)
        {
        	EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.getObjectUseStats(this));
        	
            if (entityplayer instanceof EntityPlayerMP)
            {
                CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP)entityplayer, stack);
            }
        }

        stack.damageItem(1, entityLiving);
        return stack;
    }
}
