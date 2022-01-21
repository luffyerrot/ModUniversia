package fr.luffyerrot.universia.Item;

import fr.luffyerrot.universia.init.ModPotions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSmokeJoin extends ItemFood {

    public ItemSmokeJoin(int amount, boolean isWolfFood) {
        super(amount, isWolfFood);
        this.setAlwaysEdible();
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if (!worldIn.isRemote) {
            player.addPotionEffect(new PotionEffect(ModPotions.DROGUE_EFFECT, 3000, 0));
            player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 3000, 1));
        }
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }
}
