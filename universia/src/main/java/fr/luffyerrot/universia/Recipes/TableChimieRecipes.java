package fr.luffyerrot.universia.Recipes;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import fr.luffyerrot.universia.init.ModItems;

public class TableChimieRecipes {

    private static final Map <ItemStack[], ItemStack>recipes1 = new Hashtable<>();
    private static final Map <ItemStack[], ItemStack>recipes2 = new Hashtable<>();
    private static final Map <ItemStack[], ItemStack>recipes3 = new Hashtable<>();
    
    static {
    	addRecipe1(Items.APPLE, Items.APPLE, Items.APPLE, Items.APPLE, Items.APPLE, Items.WATER_BUCKET);
    	//--------------------------------------------------------------------------------------------------------------
    	addRecipe2(Items.ARROW, Items.BLAZE_POWDER);
    	//--------------------------------------------------------------------------------------------------------------
    	addRecipe3(Items.BLAZE_POWDER, Items.BEETROOT, ModItems.batterie);
    }

    private static void addRecipe1(Item ingredient1, Item ingredient2, Item ingredient3, Item ingredient4, Item ingredient5, Item resultat) {
        addRecipe1(new ItemStack(ingredient1), new ItemStack(ingredient2), new ItemStack(ingredient3), new ItemStack(ingredient4), new ItemStack(ingredient5), new ItemStack(resultat));
    }

    private static void addRecipe1(ItemStack ingredient1, ItemStack ingredient2, ItemStack ingredient3, ItemStack ingredient4, ItemStack ingredient5, ItemStack resultat) {
        recipes1.put(new ItemStack[]{ingredient1, ingredient2, ingredient3, ingredient4, ingredient5}, resultat);
    }
    
    private static void addRecipe2(Item ingredient7, Item resultat) {
        addRecipe2(new ItemStack(ingredient7), new ItemStack(resultat));
    }

    private static void addRecipe2(ItemStack ingredient7, ItemStack resultat) {
        recipes2.put(new ItemStack[]{ingredient7}, resultat);
    }
    
    private static void addRecipe3(Item ingredient8, Item ingredient9, Item resultat) {
        addRecipe3(new ItemStack(ingredient8), new ItemStack(ingredient9), new ItemStack(resultat));
    }

    private static void addRecipe3(ItemStack ingredient8, ItemStack ingredient9, ItemStack resultat1) {
        recipes3.put(new ItemStack[]{ingredient8, ingredient9}, resultat1);
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

    public static ItemStack getRecipeResult1(ItemStack[] ingredients) {
        Iterator<Map.Entry<ItemStack[], ItemStack>> it = recipes1.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<ItemStack[], ItemStack> entry = it.next();
            if(areKeysEqual(entry.getKey(), ingredients)) {
                return entry.getValue();
            }
        }
        return null;
    }
    
    public static ItemStack getRecipeResult2(ItemStack[] ingredients) {
        Iterator<Map.Entry<ItemStack[], ItemStack>> it = recipes2.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<ItemStack[], ItemStack> entry = it.next();
            if(areKeysEqual(entry.getKey(), ingredients)) {
                return entry.getValue();
            }
        }
        return null;
    }
    
    public static ItemStack getRecipeResult3(ItemStack[] ingredients) {
        Iterator<Map.Entry<ItemStack[], ItemStack>> it = recipes3.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<ItemStack[], ItemStack> entry = it.next();
            if(areKeysEqual(entry.getKey(), ingredients)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
