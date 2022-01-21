package fr.luffyerrot.universia.Recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import fr.luffyerrot.universia.init.ModBlocks;
import fr.luffyerrot.universia.init.ModItems;

public class AssemblageMunitionRecipes {

    private static final Map <ItemStack[], ItemStack>recipes = new Hashtable<>();
    static {

        addRecipe(ModItems.fiol_weed_synthetique, ModItems.fiol_weed_synthetique, ModItems.fiol_weed_synthetique, ModItems.fiol_weed_synthetique, ModItems.fiol_weed_synthetique, ModItems.fiol_weed_synthetique, ModItems.fiol_weed_synthetique, ModItems.fiol_weed_synthetique, ModItems.sachet_poudre, Item.getItemFromBlock(ModBlocks.poudre_weed));
    }

    private static void addRecipe(Item ingredient1, Item ingredient2, Item ingredient3, Item ingredient4, Item ingredient5, Item ingredient6, Item ingredient7, Item ingredient8, Item ingredient9, Item resultat1) {
        addRecipe(new ItemStack(ingredient1), new ItemStack(ingredient2), new ItemStack(ingredient3), new ItemStack(ingredient4), new ItemStack(ingredient5), new ItemStack(ingredient6), new ItemStack(ingredient7), new ItemStack(ingredient8), new ItemStack(ingredient9), new ItemStack(resultat1));
    }

    private static void addRecipe(ItemStack ingredient1, ItemStack ingredient2, ItemStack ingredient3, ItemStack ingredient4, ItemStack ingredient5, ItemStack ingredient6, ItemStack ingredient7, ItemStack ingredient8, ItemStack ingredient9, ItemStack resultat1) {
        recipes.put(new ItemStack[]{ingredient1, ingredient2, ingredient3, ingredient4, ingredient5, ingredient6, ingredient7, ingredient8, ingredient9}, resultat1);
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
