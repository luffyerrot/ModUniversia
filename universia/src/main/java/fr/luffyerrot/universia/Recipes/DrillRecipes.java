package fr.luffyerrot.universia.Recipes;

import fr.luffyerrot.universia.init.ModBlocks;
import fr.luffyerrot.universia.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class DrillRecipes {

    private static final Map <ItemStack[], ItemStack>recipes = new Hashtable<>();
    static {

        addRecipe(Item.getItemFromBlock(ModBlocks.amethyst_ore), ModItems.amethyst);
    }

    private static void addRecipe(Item ingredient1, Item resultat) {
        addRecipe(new ItemStack(ingredient1), new ItemStack(resultat));
    }

    private static void addRecipe(ItemStack ingredient1, ItemStack resultat) {
        recipes.put(new ItemStack[]{ingredient1}, resultat);
    }

    private static boolean areKeysEqual(ItemStack[] key1, ItemStack[] key2) {
        if(key1.length != key2.length) return false;

        for(int i = 0; i < key1.length; i++) {
            ItemStack s1 = key1[i];
            ItemStack s2 = key2[i];
            if(s1.isEmpty() && !s2.isEmpty()) return false;
            if(!s1.isEmpty() && s2.isEmpty()) return false;
            if(s1.getItem() != s2.getItem()) return false;
            if(s1.getItemDamage() != s2.getItemDamage()) return false;
        }
        return true;
    }

    public static ItemStack getRecipeResult(ItemStack[] ingredients) {
        Iterator<Map.Entry<ItemStack[], ItemStack>> it = recipes.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<ItemStack[], ItemStack> entry = it.next();
            if(areKeysEqual(entry.getKey(), ingredients)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
