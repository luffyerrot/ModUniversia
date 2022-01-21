package fr.luffyerrot.universia.init;

import fr.luffyerrot.universia.Item.*;
import fr.luffyerrot.universia.universiaMod;
import fr.luffyerrot.universia.utils.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ModItems {

    public static Item weed, weed_seed, piece1, piece2, billet5, billet10, billet20, billet50, billet100, billet200, billet500, billet50_faux,
            billet100_faux,pile, batterie, papier_impression, fiol_encre, fiol_encre_magenta, fiol_encre_cyan, fiol_encre_jaune, fiol_b6, fiol_fluoroantimonique, weed_synthetique, bulbe_synthetique,
            fiol, bulbe, bulbe_seed, cigarette, join, ecorce, plaque_bois, fraise, fraise_seed, poireaux, poireaux_seed, oignons, oignons_seed, oignons_rouge, oignons_rouge_seed, tomate, tomate_seed, coca_seed, 
            coca_leave, coca_bay, mais, mais_seed, feuille_salade, coeur_salade, salade_seed, feuille_choux_rouge, coeur_choux_rouge, choux_rouge_seed, sachet_poudre, papier_plastique, fiol_bulbe_synthetique, fiol_weed_synthetique, fiol_coca_synthetique, coca_synthetique,
            or_bleu, poudre_or_bleu, or_rouge, poudre_or_rouge, or_noire, poudre_or_noire, poudre_or, poudre_fer, fiol_fer, fiol_or, fiol_or_bleu, fiol_or_rouge,
            fiol_or_noire, portable1, raisin_seed, raisin;

    //soins
    public static Item medkit, seringue, bandage, morphine, doliprane, vitamine;
    
    //guns
    public static Item canon_court, canon_long, canon_double, corp, crosse, poigne, balle;
    
    //packets
    public static Item weed_packet, coca_packet, bulbe_packet;
    
    //cuisine
    public static Item couteau, rondelle_tomate, rondelle_mais, rondelle_oignons, rondelle_oignons_rouge, rondelle_poireaux, tranche_choux_rouge, 
    tranche_salade, tranche_pain;
    
    //minerais
    public static Item fragment_torbenite, shard_torbenite, topaz, poudre_topaz, amethyst, poudre_amethyst, rubis, poudre_rubis, saphir, poudre_saphir, 
    kunzite, poudre_kunzite, fragment_amethyst, fragment_charbon, fragment_cobble, fragment_gravier, fragment_kunzite, fragment_lapis, 
    fragment_obsidienne, fragment_redstone, fragment_rubis, fragment_saphir, fragment_topaz;
    
    //alcool
    public static Item biere1, biere2, biere3, biere4, bierevide, champagne, cointreau, martiniblanc, martinibleu, martinijaune, 
    martininoire, martinirouge, martinivert, pastis, porto, rose, tequilagold, tequilasilver, vinblanc, vinrouge;
    
    //outils
    public static Item wood_faucille, stone_faucille, iron_faucille, gold_faucille, diamond_faucille, torbenite_faucille, torbenite_axe,
    torbenite_pickaxe, torbenite_hoe, torbenite_shovel, torbenite_sword, diamond_nugget, taser;
    
    //organes
    public static Item coeur, coeur_argent, coeur_or, coeur_diamand, foie, foie_gras, foie_argent, foie_or, foie_diamand, yeux_diamand, yeux_bleu, yeux_rouge, yeux_vert, yeux_argent, yeux_or,
    langue, langue_gele, langue_moisie, cerveaux, cerveaux_moisie, reins, reins_moisie, poudre_coeur, poudre_cerveaux, poudre_foie, poudre_reins, poudre_langue;
    
    //Materials
    public static ToolMaterial MATERIAL_TORBENITE = EnumHelper.addToolMaterial("material_torbenite", 4, 2142, 10.0F, 3.5F, 16);
    
    private static Item[] items;

    public static void init(){
    	
    	canon_court = new ItemGuns("canon_court");
    	canon_long = new ItemGuns("canon_long");
    	canon_double = new ItemGuns("canon_double");
    	corp = new ItemGuns("corp");
    	crosse = new ItemGuns("crosse");
    	poigne = new ItemGuns("poigne");
    	
    	wood_faucille = new ItemFaucille("wood_faucille", Item.ToolMaterial.WOOD);
    	stone_faucille = new ItemFaucille("stone_faucille", Item.ToolMaterial.STONE);
    	iron_faucille = new ItemFaucille("iron_faucille", Item.ToolMaterial.IRON);
    	gold_faucille = new ItemFaucille("gold_faucille", Item.ToolMaterial.GOLD);
    	diamond_faucille = new ItemFaucille("diamond_faucille", Item.ToolMaterial.DIAMOND);
    	torbenite_faucille = new ItemFaucille("torbenite_faucille", ModItems.MATERIAL_TORBENITE);

    	torbenite_sword = new ItemSwordMod("torbenite_sword", ModItems.MATERIAL_TORBENITE);
    	torbenite_pickaxe = new ItemPickaxeMod("torbenite_pickaxe", ModItems.MATERIAL_TORBENITE);
    	torbenite_axe = new ItemAxeMod("torbenite_axe", ModItems.MATERIAL_TORBENITE);
    	torbenite_shovel = new ItemShovelMod("torbenite_shovel", ModItems.MATERIAL_TORBENITE);
    	torbenite_hoe = new ItemHoeMod("torbenite_hoe", ModItems.MATERIAL_TORBENITE);
    	
    	diamond_nugget = new Item().setUnlocalizedName("diamond_nugget").setRegistryName("diamond_nugget").setCreativeTab(universiaMod.creativeTab);
    	portable1 = new ItemPortable("portable1");

        medkit = new ItemSoin("medkit", 0, 0.0f, false, 20, 1, "Heal : 10 coeur", null);
        seringue = new ItemSoin("seringue", 0, 0.0f, false, 12, 4, "Heal : 6 coeur", null);
        bandage = new ItemSoinWithDura("bandage", 0, 0.0f, false, 4, 1, 3, "Heal : 2 coeur", null);
        doliprane = new ItemSoinWithDuraAndBonus("doliprane", 0, 0.0f, false, 1, 1, 19, "Heal : 0.5 coeur", null, new PotionEffect(MobEffects.SLOWNESS, 200, 0));
        morphine = new ItemSoinWithBonus("morphine", 0, 0.0f, false, 4, 8, "Heal : 2 coeur", "2 coeur bonus", new PotionEffect(MobEffects.ABSORPTION, 1800, 0));
        vitamine = new ItemSoinWithBonus("vitamine", 0, 0.0f, false, 2, 16, "Heal : 1 coeur", "bonus de vitesse", new PotionEffect(MobEffects.SPEED, 1800, 0));

        bierevide = new ItemBouteille("bierevide");
        taser = new ItemTaser("taser").setMaxStackSize(1);
        balle = new Item().setUnlocalizedName("balle").setRegistryName("balle");
        biere1 = new ItemAlcoolWithDuraAndBonus("biere1", 0, 0.0f, false, 0, 1, 4, new PotionEffect(MobEffects.NAUSEA, 2400, 0));
        biere2 = new ItemAlcoolWithDuraAndBonus("biere2", 0, 0.0f, false, 0, 1, 4, new PotionEffect(MobEffects.NAUSEA, 2400, 0));
        biere3 = new ItemAlcoolWithDuraAndBonus("biere3", 0, 0.0f, false, 0, 1, 4, new PotionEffect(MobEffects.NAUSEA, 2400, 0));
        biere4 = new ItemAlcoolWithDuraAndBonus("biere4", 0, 0.0f, false, 0, 1, 4, new PotionEffect(MobEffects.NAUSEA, 2400, 0));
        champagne = new ItemAlcoolWithDuraAndBonus("champagne", 0, 0.0f, false, 0, 1, 4, new PotionEffect(MobEffects.NAUSEA, 2400, 0));
        cointreau = new ItemAlcoolWithDuraAndBonus("cointreau", 0, 0.0f, false, 0, 1, 4, new PotionEffect(MobEffects.NAUSEA, 2400, 1));
        martiniblanc = new ItemAlcoolWithDuraAndBonus("martiniblanc", 0, 0.0f, false, 0, 1, 4, new PotionEffect(MobEffects.NAUSEA, 2400, 1));
        martinibleu = new ItemAlcoolWithDuraAndBonus("martinibleu", 0, 0.0f, false, 0, 1, 4, new PotionEffect(MobEffects.NAUSEA, 2400, 1));
        martinijaune = new ItemAlcoolWithDuraAndBonus("martinijaune", 0, 0.0f, false, 0, 1, 4, new PotionEffect(MobEffects.NAUSEA, 2400, 1));
        martininoire = new ItemAlcoolWithDuraAndBonus("martininoire", 0, 0.0f, false, 0, 1, 4, new PotionEffect(MobEffects.NAUSEA, 2400, 1));
        martinirouge = new ItemAlcoolWithDuraAndBonus("martinirouge", 0, 0.0f, false, 0, 1, 4, new PotionEffect(MobEffects.NAUSEA, 2400, 1));
        martinivert = new ItemAlcoolWithDuraAndBonus("martinivert", 0, 0.0f, false, 0, 1, 4, new PotionEffect(MobEffects.NAUSEA, 2400, 1));
        pastis = new ItemAlcoolWithDuraAndBonus("pastis", 0, 0.0f, false, 0, 1, 4, new PotionEffect(MobEffects.NAUSEA, 2400, 0));
        porto = new ItemAlcoolWithDuraAndBonus("porto", 0, 0.0f, false, 0, 1, 4, new PotionEffect(MobEffects.NAUSEA, 2400, 1));
        rose = new ItemAlcoolWithDuraAndBonus("rose", 0, 0.0f, false, 0, 1, 4, new PotionEffect(MobEffects.NAUSEA, 2400, 0));
        tequilagold = new ItemAlcoolWithDuraAndBonus("tequilagold", 0, 0.0f, false, 0, 1, 4, new PotionEffect(MobEffects.NAUSEA, 2400, 2));
        tequilasilver = new ItemAlcoolWithDuraAndBonus("tequilasilver", 0, 0.0f, false, 0, 1, 4, new PotionEffect(MobEffects.NAUSEA, 2400, 2));
        vinblanc = new ItemAlcoolWithDuraAndBonus("vinblanc", 0, 0.0f, false, 0, 1, 4, new PotionEffect(MobEffects.NAUSEA, 2400, 1));
        vinrouge = new ItemAlcoolWithDuraAndBonus("vinrouge", 0, 0.0f, false, 0, 1, 4, new PotionEffect(MobEffects.NAUSEA, 2400, 1));
        
        topaz = new Item().setUnlocalizedName("topaz").setRegistryName("topaz").setCreativeTab(universiaMod.creativeTab);
        poudre_topaz = new Item().setUnlocalizedName("poudre_topaz").setRegistryName("poudre_topaz").setCreativeTab(universiaMod.creativeTab);
        amethyst = new Item().setUnlocalizedName("amethyst").setRegistryName("amethyst").setCreativeTab(universiaMod.creativeTab);
        poudre_amethyst = new Item().setUnlocalizedName("poudre_amethyst").setRegistryName("poudre_amethyst").setCreativeTab(universiaMod.creativeTab);
        rubis = new Item().setUnlocalizedName("rubis").setRegistryName("rubis").setCreativeTab(universiaMod.creativeTab);
        poudre_rubis = new Item().setUnlocalizedName("poudre_rubis").setRegistryName("poudre_rubis").setCreativeTab(universiaMod.creativeTab);
        saphir = new Item().setUnlocalizedName("saphir").setRegistryName("saphir").setCreativeTab(universiaMod.creativeTab);
        poudre_saphir = new Item().setUnlocalizedName("poudre_saphir").setRegistryName("poudre_saphir").setCreativeTab(universiaMod.creativeTab);
        kunzite = new Item().setUnlocalizedName("kunzite").setRegistryName("kunzite").setCreativeTab(universiaMod.creativeTab);
        poudre_kunzite = new Item().setUnlocalizedName("poudre_kunzite").setRegistryName("poudre_kunzite").setCreativeTab(universiaMod.creativeTab);
    	
        fragment_torbenite = new ItemFragment().setUnlocalizedName("fragment_torbenite").setRegistryName("fragment_torbenite").setCreativeTab(universiaMod.creativeTab);
        fragment_amethyst = new Item().setUnlocalizedName("fragment_amethyst").setRegistryName("fragment_amethyst").setCreativeTab(universiaMod.creativeTab);
        fragment_charbon = new Item().setUnlocalizedName("fragment_charbon").setRegistryName("fragment_charbon").setCreativeTab(universiaMod.creativeTab);
        fragment_cobble = new Item().setUnlocalizedName("fragment_cobble").setRegistryName("fragment_cobble").setCreativeTab(universiaMod.creativeTab);
        fragment_gravier = new Item().setUnlocalizedName("fragment_gravier").setRegistryName("fragment_gravier").setCreativeTab(universiaMod.creativeTab);
        fragment_kunzite = new Item().setUnlocalizedName("fragment_kunzite").setRegistryName("fragment_kunzite").setCreativeTab(universiaMod.creativeTab);
        fragment_lapis = new Item().setUnlocalizedName("fragment_lapis").setRegistryName("fragment_lapis").setCreativeTab(universiaMod.creativeTab);
        fragment_obsidienne = new Item().setUnlocalizedName("fragment_obsidienne").setRegistryName("fragment_obsidienne").setCreativeTab(universiaMod.creativeTab);
        fragment_redstone = new Item().setUnlocalizedName("fragment_redstone").setRegistryName("fragment_redstone").setCreativeTab(universiaMod.creativeTab);
        fragment_rubis = new Item().setUnlocalizedName("fragment_rubis").setRegistryName("fragment_rubis").setCreativeTab(universiaMod.creativeTab);
        fragment_saphir = new Item().setUnlocalizedName("fragment_saphir").setRegistryName("fragment_saphir").setCreativeTab(universiaMod.creativeTab);
        fragment_topaz = new Item().setUnlocalizedName("fragment_topaz").setRegistryName("fragment_topaz").setCreativeTab(universiaMod.creativeTab);
        
        
        shard_torbenite = new Item().setUnlocalizedName("shard_torbenite").setRegistryName("shard_torbenite").setCreativeTab(universiaMod.creativeTab);
        or_bleu = new Item().setUnlocalizedName("or_bleu").setRegistryName("or_bleu").setCreativeTab(universiaMod.creativeTab);
        poudre_or_bleu = new Item().setUnlocalizedName("poudre_or_bleu").setRegistryName("poudre_or_bleu").setCreativeTab(universiaMod.creativeTab);
        or_rouge = new Item().setUnlocalizedName("or_rouge").setRegistryName("or_rouge").setCreativeTab(universiaMod.creativeTab);
        poudre_or_rouge = new Item().setUnlocalizedName("poudre_or_rouge").setRegistryName("poudre_or_rouge").setCreativeTab(universiaMod.creativeTab);
        or_noire = new Item().setUnlocalizedName("or_noire").setRegistryName("or_noire").setCreativeTab(universiaMod.creativeTab);
        poudre_or_noire = new Item().setUnlocalizedName("poudre_or_noire").setRegistryName("poudre_or_noire").setCreativeTab(universiaMod.creativeTab);
        poudre_or = new Item().setUnlocalizedName("poudre_or").setRegistryName("poudre_or").setCreativeTab(universiaMod.creativeTab);
        poudre_fer = new Item().setUnlocalizedName("poudre_fer").setRegistryName("poudre_fer").setCreativeTab(universiaMod.creativeTab);
        fiol_or = new Item().setUnlocalizedName("fiol_or").setRegistryName("fiol_or").setCreativeTab(universiaMod.creativeTab);
        fiol_fer = new Item().setUnlocalizedName("fiol_fer").setRegistryName("fiol_fer").setCreativeTab(universiaMod.creativeTab);
        fiol_or_bleu = new Item().setUnlocalizedName("fiol_or_bleu").setRegistryName("fiol_or_bleu").setCreativeTab(universiaMod.creativeTab);
        fiol_or_rouge = new Item().setUnlocalizedName("fiol_or_rouge").setRegistryName("fiol_or_rouge").setCreativeTab(universiaMod.creativeTab);
        fiol_or_noire = new Item().setUnlocalizedName("fiol_or_noire").setRegistryName("fiol_or_noire").setCreativeTab(universiaMod.creativeTab);
        
        coeur = new Item().setUnlocalizedName("coeur").setRegistryName("coeur").setCreativeTab(universiaMod.creativeTabDrogs);
        coeur_argent = new Item().setUnlocalizedName("coeur_argent").setRegistryName("coeur_argent").setCreativeTab(universiaMod.creativeTabDrogs);
        coeur_or = new Item().setUnlocalizedName("coeur_or").setRegistryName("coeur_or").setCreativeTab(universiaMod.creativeTabDrogs);
        coeur_diamand = new Item().setUnlocalizedName("coeur_diamand").setRegistryName("coeur_diamand").setCreativeTab(universiaMod.creativeTabDrogs);
        foie = new Item().setUnlocalizedName("foie").setRegistryName("foie").setCreativeTab(universiaMod.creativeTabDrogs);
        foie_gras = new Item().setUnlocalizedName("foie_gras").setRegistryName("foie_gras").setCreativeTab(universiaMod.creativeTabDrogs);
        foie_argent = new Item().setUnlocalizedName("foie_argent").setRegistryName("foie_argent").setCreativeTab(universiaMod.creativeTabDrogs);
        foie_or = new Item().setUnlocalizedName("foie_or").setRegistryName("foie_or").setCreativeTab(universiaMod.creativeTabDrogs);
        foie_diamand = new Item().setUnlocalizedName("foie_diamand").setRegistryName("foie_diamand").setCreativeTab(universiaMod.creativeTabDrogs);
        yeux_bleu = new Item().setUnlocalizedName("yeux_bleu").setRegistryName("yeux_bleu").setCreativeTab(universiaMod.creativeTabDrogs);
        yeux_vert = new Item().setUnlocalizedName("yeux_vert").setRegistryName("yeux_vert").setCreativeTab(universiaMod.creativeTabDrogs);
        yeux_rouge = new Item().setUnlocalizedName("yeux_rouge").setRegistryName("yeux_rouge").setCreativeTab(universiaMod.creativeTabDrogs);
        yeux_or = new Item().setUnlocalizedName("yeux_or").setRegistryName("yeux_or").setCreativeTab(universiaMod.creativeTabDrogs);
        yeux_argent = new Item().setUnlocalizedName("yeux_argent").setRegistryName("yeux_argent").setCreativeTab(universiaMod.creativeTabDrogs);
        yeux_diamand = new Item().setUnlocalizedName("yeux_diamand").setRegistryName("yeux_diamand").setCreativeTab(universiaMod.creativeTabDrogs);
        langue = new Item().setUnlocalizedName("langue").setRegistryName("langue").setCreativeTab(universiaMod.creativeTabDrogs);
        langue_gele = new Item().setUnlocalizedName("langue_gele").setRegistryName("langue_gele").setCreativeTab(universiaMod.creativeTabDrogs);
        langue_moisie = new Item().setUnlocalizedName("langue_moisie").setRegistryName("langue_moisie").setCreativeTab(universiaMod.creativeTabDrogs);
        cerveaux = new Item().setUnlocalizedName("cerveaux").setRegistryName("cerveaux").setCreativeTab(universiaMod.creativeTabDrogs);
        cerveaux_moisie = new Item().setUnlocalizedName("cerveaux_moisie").setRegistryName("cerveaux_moisie").setCreativeTab(universiaMod.creativeTabDrogs);
        reins = new Item().setUnlocalizedName("reins").setRegistryName("reins").setCreativeTab(universiaMod.creativeTabDrogs);
        reins_moisie = new Item().setUnlocalizedName("reins_moisie").setRegistryName("reins_moisie").setCreativeTab(universiaMod.creativeTabDrogs);
        poudre_coeur = new Item().setUnlocalizedName("poudre_coeur").setRegistryName("poudre_coeur").setCreativeTab(universiaMod.creativeTabDrogs);
        poudre_cerveaux = new Item().setUnlocalizedName("poudre_cerveaux").setRegistryName("poudre_cerveaux").setCreativeTab(universiaMod.creativeTabDrogs);
        poudre_foie = new Item().setUnlocalizedName("poudre_foie").setRegistryName("poudre_foie").setCreativeTab(universiaMod.creativeTabDrogs);
        poudre_reins = new Item().setUnlocalizedName("poudre_reins").setRegistryName("poudre_reins").setCreativeTab(universiaMod.creativeTabDrogs);
        poudre_langue = new Item().setUnlocalizedName("poudre_langue").setRegistryName("poudre_langue").setCreativeTab(universiaMod.creativeTabDrogs);
        
        sachet_poudre = new Item().setUnlocalizedName("sachet_poudre").setRegistryName("sachet_poudre").setCreativeTab(universiaMod.creativeTab);
        papier_plastique = new Item().setUnlocalizedName("papier_plastique").setRegistryName("papier_plastique").setCreativeTab(universiaMod.creativeTab);
        
        fiol_bulbe_synthetique = new Item().setUnlocalizedName("fiol_bulbe_synthetique").setRegistryName("fiol_bulbe_synthetique").setCreativeTab(universiaMod.creativeTabDrogs);
        fiol_weed_synthetique = new Item().setUnlocalizedName("fiol_weed_synthetique").setRegistryName("fiol_weed_synthetique").setCreativeTab(universiaMod.creativeTabDrogs);
        fiol_coca_synthetique = new Item().setUnlocalizedName("fiol_coca_synthetique").setRegistryName("fiol_coca_synthetique").setCreativeTab(universiaMod.creativeTabDrogs);
        coca_synthetique = new Item().setUnlocalizedName("coca_synthetique").setRegistryName("coca_synthetique").setCreativeTab(universiaMod.creativeTabDrogs);

        weed = new Item().setRegistryName("weed").setUnlocalizedName("weed").setCreativeTab(universiaMod.creativeTabDrogs);
        weed_seed = new ItemWeedSeed().setCreativeTab(universiaMod.creativeTabDrogs);
        
        coca_leave = new Item().setRegistryName("coca_leave").setUnlocalizedName("coca_leave").setCreativeTab(universiaMod.creativeTabDrogs);
        coca_bay = new Item().setRegistryName("coca_bay").setUnlocalizedName("coca_bay").setCreativeTab(universiaMod.creativeTabDrogs);
        coca_seed = new ItemCocaSeed().setCreativeTab(universiaMod.creativeTabDrogs);

        cigarette = new ItemSmokeCigarette(0, false).setUnlocalizedName("cigarette").setRegistryName("cigarette").setCreativeTab(universiaMod.creativeTabDrogs);
        join = new ItemSmokeJoin(0, false).setUnlocalizedName("join").setRegistryName("join").setCreativeTab(universiaMod.creativeTabDrogs);

        bulbe = new Item().setRegistryName("bulbe").setUnlocalizedName("bulbe").setCreativeTab(universiaMod.creativeTabDrogs);
        bulbe_seed = new ItemBulbeSeed().setCreativeTab(universiaMod.creativeTabDrogs);

        fraise = new ItemFoodCustom("fraise", 1, 1.0f, false);
        fraise_seed = new ItemFraiseSeed().setCreativeTab(universiaMod.creativeTabFoodAndLife);
        poireaux = new ItemFoodCustom("poireaux", 1, 1.0f, false);
        poireaux_seed = new ItemPotagerSeed("poireaux_seed", ModBlocks.poireaux_crop).setCreativeTab(universiaMod.creativeTabFoodAndLife);
        oignons = new ItemFoodCustom("oignons", 1, 1.0f, false);
        oignons_seed = new ItemPotagerSeed("oignons_seed", ModBlocks.oignons_crop).setCreativeTab(universiaMod.creativeTabFoodAndLife);
        oignons_rouge = new ItemFoodCustom("oignons_rouge", 1, 1.0f, false);
        oignons_rouge_seed = new ItemPotagerSeed("oignons_rouge_seed", ModBlocks.oignons_rouge_crop).setCreativeTab(universiaMod.creativeTabFoodAndLife);
        mais = new ItemFoodCustom("mais", 3, 2.0f, false);
        mais_seed = new ItemPotagerSeed("mais_seed", ModBlocks.mais_crop_bottom).setCreativeTab(universiaMod.creativeTabFoodAndLife);
        tomate = new ItemFoodCustom("tomate", 3, 2.0f, false);
        tomate_seed = new ItemTomateSeed("tomate_seed").setCreativeTab(universiaMod.creativeTabFoodAndLife);
        feuille_salade = new ItemFoodCustom("feuille_salade", 1, 0.0f, false);
        coeur_salade = new ItemFoodCustom("coeur_salade", 4, 2.5f, false);
        salade_seed = new ItemPotagerSeed("salade_seed", ModBlocks.salade_crop).setCreativeTab(universiaMod.creativeTabFoodAndLife);
        feuille_choux_rouge = new ItemFoodCustom("feuille_choux_rouge", 1, 0.0f, false);
        coeur_choux_rouge = new ItemFoodCustom("coeur_choux_rouge", 4, 2.5f, false);
        choux_rouge_seed = new ItemPotagerSeed("choux_rouge_seed", ModBlocks.choux_rouge_crop).setCreativeTab(universiaMod.creativeTabFoodAndLife);
        raisin = new ItemFoodCustom("raisin", 3, 2.0f, false);
        raisin_seed = new ItemPotagerSeed("raisin_seed", ModBlocks.vigne_crop_bottom).setCreativeTab(universiaMod.creativeTabFoodAndLife);

        bulbe_synthetique = new Item().setRegistryName("bulbe_synthetique").setUnlocalizedName("bulbe_synthetique").setCreativeTab(universiaMod.creativeTabDrogs);
        weed_synthetique = new Item().setRegistryName("weed_synthetique").setUnlocalizedName("weed_synthetique").setCreativeTab(universiaMod.creativeTabDrogs);

        weed_packet = new Item().setRegistryName("weed_packet").setUnlocalizedName("weed_packet").setCreativeTab(universiaMod.creativeTabDrogs).setMaxStackSize(4);
        coca_packet = new Item().setRegistryName("coca_packet").setUnlocalizedName("coca_packet").setCreativeTab(universiaMod.creativeTabDrogs).setMaxStackSize(4);
        bulbe_packet = new Item().setRegistryName("bulbe_packet").setUnlocalizedName("bulbe_packet").setCreativeTab(universiaMod.creativeTabDrogs).setMaxStackSize(4);

        piece1 = new ItemArgent("piece1");
        piece2 = new ItemArgent("piece2");
        billet5 = new ItemArgent("billet5");
        billet10 = new ItemArgent("billet10");
        billet20 = new ItemArgent("billet20");
        billet50 = new ItemArgent("billet50");
        billet100 = new ItemArgent("billet100");
        billet200 = new ItemArgent("billet200");
        billet500 = new ItemArgent("billet500");
        billet50_faux = new ItemArgent("billet50_faux");
        billet100_faux = new ItemArgent("billet100_faux");

        pile = new Item().setRegistryName("pile").setUnlocalizedName("pile").setCreativeTab(universiaMod.creativeTab);
        batterie = new Item().setRegistryName("batterie").setUnlocalizedName("batterie").setCreativeTab(universiaMod.creativeTab);
        papier_impression = new Item().setRegistryName("papier_impression").setUnlocalizedName("papier_impression").setCreativeTab(universiaMod.creativeTab);
        ecorce = new Item().setRegistryName("ecorce").setUnlocalizedName("ecorce").setCreativeTab(universiaMod.creativeTab);
        plaque_bois = new Item().setRegistryName("plaque_bois").setUnlocalizedName("plaque_bois").setCreativeTab(universiaMod.creativeTab);

        fiol_encre = new Item().setRegistryName("fiol_encre").setUnlocalizedName("fiol_encre").setCreativeTab(universiaMod.creativeTab);
        fiol_encre_magenta = new Item().setRegistryName("fiol_encre_magenta").setUnlocalizedName("fiol_encre_magenta").setCreativeTab(universiaMod.creativeTab);
        fiol_encre_cyan = new Item().setRegistryName("fiol_encre_cyan").setUnlocalizedName("fiol_encre_cyan").setCreativeTab(universiaMod.creativeTab);
        fiol_encre_jaune = new Item().setRegistryName("fiol_encre_jaune").setUnlocalizedName("fiol_encre_jaune").setCreativeTab(universiaMod.creativeTab);
        fiol_b6 = new Item().setRegistryName("fiol_b6").setUnlocalizedName("fiol_b6").setCreativeTab(universiaMod.creativeTab);
        fiol_fluoroantimonique = new Item().setRegistryName("fiol_fluoroantimonique").setUnlocalizedName("fiol_fluoroantimonique").setCreativeTab(universiaMod.creativeTab);
        fiol = new ItemFiol().setRegistryName("fiol").setUnlocalizedName("fiol").setCreativeTab(universiaMod.creativeTab);
        

        couteau = new ItemCouteau("couteau").setMaxStackSize(1);
        rondelle_tomate = new Item().setRegistryName("rondelle_tomate").setUnlocalizedName("rondelle_tomate").setCreativeTab(universiaMod.creativeTabFoodAndLife);
        rondelle_mais = new Item().setRegistryName("rondelle_mais").setUnlocalizedName("rondelle_mais").setCreativeTab(universiaMod.creativeTabFoodAndLife);
        rondelle_oignons = new Item().setRegistryName("rondelle_oignons").setUnlocalizedName("rondelle_oignons").setCreativeTab(universiaMod.creativeTabFoodAndLife);
        rondelle_oignons_rouge = new Item().setRegistryName("rondelle_oignons_rouge").setUnlocalizedName("rondelle_oignons_rouge").setCreativeTab(universiaMod.creativeTabFoodAndLife);
        rondelle_poireaux = new Item().setRegistryName("rondelle_poireaux").setUnlocalizedName("rondelle_poireaux").setCreativeTab(universiaMod.creativeTabFoodAndLife);
        tranche_choux_rouge = new Item().setRegistryName("tranche_choux_rouge").setUnlocalizedName("tranche_choux_rouge").setCreativeTab(universiaMod.creativeTabFoodAndLife);
        tranche_salade = new Item().setRegistryName("tranche_salade").setUnlocalizedName("tranche_salade").setCreativeTab(universiaMod.creativeTabFoodAndLife);
        tranche_pain = new Item().setRegistryName("tranche_pain").setUnlocalizedName("tranche_pain").setCreativeTab(universiaMod.creativeTabFoodAndLife);

        //----------
        items = new Item[]{weed, weed_seed, piece1, piece2, billet5, billet10, billet20, billet50, billet100, billet200, billet500, billet50_faux, billet100_faux , pile,
                batterie, papier_impression, fiol_encre, fiol_encre_magenta, fiol_encre_cyan, fiol_encre_jaune, fiol_b6, fiol_fluoroantimonique, fiol, weed_synthetique, bulbe_synthetique,
                fragment_torbenite, fragment_amethyst, fragment_charbon, fragment_cobble, fragment_gravier, fragment_kunzite, fragment_lapis, 
                fragment_obsidienne, fragment_redstone, fragment_rubis, fragment_saphir, fragment_topaz, shard_torbenite, bulbe, bulbe_seed, cigarette, join, ecorce, plaque_bois, fraise, fraise_seed, poireaux, poireaux_seed, oignons, oignons_seed, oignons_rouge, oignons_rouge_seed, feuille_salade, coeur_salade, salade_seed, tomate, tomate_seed, medkit, 
                feuille_choux_rouge, coeur_choux_rouge, choux_rouge_seed, bandage, seringue, morphine, doliprane, vitamine, bierevide, biere1, biere2, biere3, biere4, champagne, cointreau, martiniblanc, martinibleu, martinijaune, 
                martininoire, martinirouge, martinivert, pastis, porto, rose, tequilagold, tequilasilver, vinblanc, vinrouge, wood_faucille, stone_faucille, raisin, raisin_seed, 
                iron_faucille, gold_faucille, diamond_faucille, torbenite_faucille, torbenite_sword, torbenite_pickaxe, torbenite_axe, torbenite_shovel, torbenite_hoe, coca_seed, 
                coca_leave, coca_bay, mais, mais_seed, weed_packet, coca_packet, bulbe_packet, sachet_poudre, papier_plastique, fiol_bulbe_synthetique, fiol_weed_synthetique, fiol_coca_synthetique, 
                coca_synthetique, canon_court, canon_long, canon_double, corp, poigne, crosse, coeur, coeur_or, coeur_argent, coeur_diamand, foie, foie_gras, foie_argent, foie_or, foie_diamand, yeux_bleu, yeux_rouge, yeux_vert,
                yeux_or, yeux_argent, yeux_diamand, langue, langue_gele, langue_moisie, cerveaux, cerveaux_moisie, reins, reins_moisie, poudre_coeur, poudre_cerveaux, poudre_foie, poudre_reins, poudre_langue,
                diamond_nugget, or_bleu, poudre_or_bleu, or_rouge, poudre_or_rouge, or_noire, poudre_or_noire, poudre_fer, poudre_or, fiol_or, fiol_fer, fiol_or_bleu, fiol_or_rouge, fiol_or_noire,
                topaz, poudre_topaz, amethyst, poudre_amethyst, rubis, poudre_rubis, saphir, poudre_saphir, kunzite, poudre_kunzite, taser, balle, portable1, couteau, rondelle_tomate, 
                rondelle_mais, rondelle_oignons, rondelle_oignons_rouge, rondelle_poireaux, tranche_choux_rouge, tranche_salade, tranche_pain};
    }
    
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public  static  void  registerModels(ModelRegistryEvent e){

        for (Item item : items){

            registerModel(item);
        }
    }

    private static void registerModel(Item item) {

        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)),"inventory"));
    }

    public static Item[] getItems(){

        return items;
    }
}
