package fr.luffyerrot.universia.Recipes;

import fr.luffyerrot.universia.init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class TableAssemblageRecipes {

    private static final Map <ItemStack[], ItemStack>recipes = new Hashtable<>();
    static {

        addRecipe(ModItems.weed, ModItems.fiol_b6, Items.WHEAT, ModItems.weed_synthetique);
        addRecipe(ModItems.bulbe, ModItems.fiol_b6, Items.CARROT, ModItems.bulbe_synthetique);
        addRecipe(ModItems.coca_leave, ModItems.fiol_b6, Items.POTATO, ModItems.coca_synthetique);
        addRecipe(Items.IRON_INGOT, ModItems.fiol_fluoroantimonique, Items.GOLD_INGOT, ModItems.or_bleu);
        addRecipe(ModItems.or_bleu, ModItems.fiol_b6, ModItems.shard_torbenite, ModItems.poudre_or_bleu);
        addRecipe(Items.REDSTONE, ModItems.fiol_fluoroantimonique, Items.GOLD_INGOT, ModItems.or_rouge);
        addRecipe(ModItems.or_rouge, ModItems.fiol_b6, ModItems.shard_torbenite, ModItems.poudre_or_rouge);
        addRecipe(Items.COAL, ModItems.fiol_fluoroantimonique, Items.GOLD_INGOT, ModItems.or_noire);
        addRecipe(ModItems.or_noire, ModItems.fiol_encre, ModItems.shard_torbenite, ModItems.poudre_or_noire);
    }

    private static void addRecipe(Item ingredient1, Item ingredient2, Item ingredient3, Item resultat1) {
        addRecipe(new ItemStack(ingredient1), new ItemStack(ingredient2), new ItemStack(ingredient3), new ItemStack(resultat1));
    }

    private static void addRecipe(ItemStack ingredient1, ItemStack ingredient2, ItemStack ingredient3, ItemStack resultat1) {
        recipes.put(new ItemStack[]{ingredient1, ingredient2, ingredient3}, resultat1);
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
