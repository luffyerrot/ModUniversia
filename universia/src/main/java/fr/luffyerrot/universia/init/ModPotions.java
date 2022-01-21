package fr.luffyerrot.universia.init;

import fr.luffyerrot.universia.Potion.CustomPotion;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModPotions {

    public static final Potion DROGUE_EFFECT = new CustomPotion("bad_trip", false, 13695385, 0, 0);

    public static final PotionType  DROGUE = new PotionType("bad_trip", new PotionEffect[] {new PotionEffect(DROGUE_EFFECT, 2400)}).setRegistryName("bad_trip");
    public static final PotionType  LONG_DROGUE = new PotionType("bad_trip", new PotionEffect[] {new PotionEffect(DROGUE_EFFECT, 4800)}).setRegistryName("long_bad_trip");

    public static void registerPotions(){

        registerPotion(DROGUE, LONG_DROGUE, DROGUE_EFFECT);

        registerPotionMixes();
    }

    public static void registerPotion(PotionType defaultPotion, PotionType longPotion, Potion effect){

        ForgeRegistries.POTIONS.register(effect);
        ForgeRegistries.POTION_TYPES.register(defaultPotion);
        ForgeRegistries.POTION_TYPES.register(longPotion);
    }

    private static void registerPotionMixes(){

        PotionHelper.addMix(DROGUE, Items.REDSTONE, LONG_DROGUE);
        PotionHelper.addMix(PotionTypes.WATER, ModItems.weed, DROGUE);
        PotionHelper.addMix(PotionTypes.WATER, ModItems.bulbe, DROGUE);
    }
}
