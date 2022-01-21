package fr.luffyerrot.universia.init;

import fr.luffyerrot.universia.Block.BlockBois;
import fr.luffyerrot.universia.Block.BlockBox;
import fr.luffyerrot.universia.Block.BlockCTM;
import fr.luffyerrot.universia.Block.BlockGlassU;
import fr.luffyerrot.universia.Block.BlockInfrarouge;
import fr.luffyerrot.universia.Block.BlockLampe;
import fr.luffyerrot.universia.Block.BlockPlanche;
import fr.luffyerrot.universia.Block.BlockPoudre;
import fr.luffyerrot.universia.Block.deco.BlockDeco;
import fr.luffyerrot.universia.Block.deco.BlockRamp;
import fr.luffyerrot.universia.Block.deco.SlabDecoDouble;
import fr.luffyerrot.universia.Block.deco.SlabDecoHalf;
import fr.luffyerrot.universia.Block.deco.StairDeco;
import fr.luffyerrot.universia.Block.deco.WallDeco;
import fr.luffyerrot.universia.Block.liquides.BlockFluidB6;
import fr.luffyerrot.universia.Block.liquides.BlockFluidEncre;
import fr.luffyerrot.universia.Block.liquides.BlockFluidEssence;
import fr.luffyerrot.universia.Block.liquides.BlockFluidFluoroantimonique;
import fr.luffyerrot.universia.Block.machines.BlockAssemblageArme;
import fr.luffyerrot.universia.Block.machines.BlockAssemblageMunition;
import fr.luffyerrot.universia.Block.machines.BlockCentrifugeuse;
import fr.luffyerrot.universia.Block.machines.BlockDrill;
import fr.luffyerrot.universia.Block.machines.BlockElec;
import fr.luffyerrot.universia.Block.machines.BlockImprimante;
import fr.luffyerrot.universia.Block.machines.BlockSechoir;
import fr.luffyerrot.universia.Block.machines.BlockTableAssemblage;
import fr.luffyerrot.universia.Block.machines.BlockTableChimie;
import fr.luffyerrot.universia.Block.machines.BlockTami;
import fr.luffyerrot.universia.Block.machines.BlockTamiPlein;
import fr.luffyerrot.universia.Block.ores.BlockMinerais;
import fr.luffyerrot.universia.Block.ores.BlockOres;
import fr.luffyerrot.universia.Block.plantes.BlockCropBulbe;
import fr.luffyerrot.universia.Block.plantes.BlockCropChouxRouge;
import fr.luffyerrot.universia.Block.plantes.BlockCropCoca;
import fr.luffyerrot.universia.Block.plantes.BlockCropFraise;
import fr.luffyerrot.universia.Block.plantes.BlockCropMaisBottom;
import fr.luffyerrot.universia.Block.plantes.BlockCropMaisTop;
import fr.luffyerrot.universia.Block.plantes.BlockCropOignons;
import fr.luffyerrot.universia.Block.plantes.BlockCropOignonsRouge;
import fr.luffyerrot.universia.Block.plantes.BlockCropPoireaux;
import fr.luffyerrot.universia.Block.plantes.BlockCropSalade;
import fr.luffyerrot.universia.Block.plantes.BlockCropTomateBottom;
import fr.luffyerrot.universia.Block.plantes.BlockCropTomateTop;
import fr.luffyerrot.universia.Block.plantes.BlockCropVigneBottom;
import fr.luffyerrot.universia.Block.plantes.BlockCropVigneTop;
import fr.luffyerrot.universia.Block.plantes.BlockCropWeed;
import fr.luffyerrot.universia.Block.plantes.BlockPommier;
import fr.luffyerrot.universia.Block.routes.*;
import fr.luffyerrot.universia.Handlers.TileEntityHandler;
import fr.luffyerrot.universia.universiaMod;
import fr.luffyerrot.universia.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ModBlocks {

    //Blocks route
    public static Block goudron, goudron_centre_b, goudron_cote_b, goudron_cote_centre_plein_b, goudron_cote_diag_d_b, goudron_cote_diag_g_b,
            goudron_cote_g_plein_b, goudron_cote_g_plein_bis_b, goudron_double_cote_centre_plein_b, goudron_double_diag_coin_b, goudron_semi_diag_c_b,
            goudron_double_h_semi_diag_coin_b, goudron_double_semi_diag_coin_b, goudron_entier_semi_diag_coin_b, goudron_fleche_b, goudron_fleche_d_b,
            goudron_fleche_g_b, goudron_passage_p_b, goudron_passage_p_ext_b, goudron_semi_diag_b, goudron_semi_diag_coin_b, goudron_semi_diag_d_b, goudron_o_p_b,
            goudron_semi_diag_g_b, goudron_s_t_b, goudron_stop_b_d_b, goudron_stop_b_g_b, goudron_stop_b_m_b, goudron_t_o_b, goudron_triple_diag_coin_b,
            goudron_triple_semi_diag_coin_b, goudron_centre_double_b, goudron_centre_triple_b, goudron_ext_b, goudron_int_b, goudron_centre_quadruple_b, goudron_centre_cote_b;

    //Blocks entier route
    public static Block blockgoudron, blockgoudron_centre_b, blockgoudron_cote_b, blockgoudron_cote_centre_plein_b, blockgoudron_cote_diag_d_b, blockgoudron_cote_diag_g_b,
            blockgoudron_cote_g_plein_b, blockgoudron_cote_g_plein_bis_b, blockgoudron_double_cote_centre_plein_b, blockgoudron_double_diag_coin_b, blockgoudron_semi_diag_c_b,
            blockgoudron_double_h_semi_diag_coin_b, blockgoudron_double_semi_diag_coin_b, blockgoudron_entier_semi_diag_coin_b, blockgoudron_fleche_b, blockgoudron_fleche_d_b,
            blockgoudron_fleche_g_b, blockgoudron_passage_p_b, blockgoudron_passage_p_ext_b, blockgoudron_semi_diag_b, blockgoudron_semi_diag_coin_b, blockgoudron_semi_diag_d_b, blockgoudron_o_p_b,
            blockgoudron_semi_diag_g_b, blockgoudron_s_t_b, blockgoudron_stop_b_d_b, blockgoudron_stop_b_g_b, blockgoudron_stop_b_m_b, blockgoudron_t_o_b, blockgoudron_triple_diag_coin_b,
            blockgoudron_triple_semi_diag_coin_b, blockgoudron_centre_double_b, blockgoudron_centre_triple_b, blockgoudron_ext_b, blockgoudron_int_b, blockgoudron_centre_quadruple_b, blockgoudron_centre_cote_b;

    //Blocks slab route
    public static Block slabgoudron, slabgoudron_centre_b, slabgoudron_cote_b, slabgoudron_cote_centre_plein_b, slabgoudron_cote_diag_d_b, slabgoudron_cote_diag_g_b,
            slabgoudron_cote_g_plein_b, slabgoudron_cote_g_plein_bis_b, slabgoudron_double_cote_centre_plein_b, slabgoudron_double_diag_coin_b, slabgoudron_semi_diag_c_b,
            slabgoudron_double_h_semi_diag_coin_b, slabgoudron_double_semi_diag_coin_b, slabgoudron_entier_semi_diag_coin_b, slabgoudron_fleche_b, slabgoudron_fleche_d_b,
            slabgoudron_fleche_g_b, slabgoudron_passage_p_b, slabgoudron_passage_p_ext_b, slabgoudron_semi_diag_b, slabgoudron_semi_diag_coin_b, slabgoudron_semi_diag_d_b, slabgoudron_o_p_b,
            slabgoudron_semi_diag_g_b, slabgoudron_s_t_b, slabgoudron_stop_b_d_b, slabgoudron_stop_b_g_b, slabgoudron_stop_b_m_b, slabgoudron_t_o_b, slabgoudron_triple_diag_coin_b,
            slabgoudron_triple_semi_diag_coin_b, slabgoudron_centre_double_b, slabgoudron_centre_triple_b, slabgoudron_ext_b, slabgoudron_int_b, slabgoudron_centre_quadruple_b, slabgoudron_centre_cote_b;

  //Blocks route travaux
    public static Block goudron_centre_bj, goudron_cote_bj, goudron_cote_centre_plein_bj, goudron_cote_diag_d_bj, goudron_cote_diag_g_bj,
            goudron_cote_g_plein_bj, goudron_cote_g_plein_bis_bj, goudron_double_cote_centre_plein_bj, goudron_double_diag_coin_bj, goudron_semi_diag_c_bj,
            goudron_double_h_semi_diag_coin_bj, goudron_double_semi_diag_coin_bj, goudron_entier_semi_diag_coin_bj, goudron_fleche_bj, goudron_fleche_d_bj,
            goudron_fleche_g_bj, goudron_passage_p_bj, goudron_passage_p_ext_bj, goudron_semi_diag_bj, goudron_semi_diag_coin_bj, goudron_semi_diag_d_bj, goudron_o_p_bj,
            goudron_semi_diag_g_bj, goudron_s_t_bj, goudron_stop_b_d_bj, goudron_stop_b_g_bj, goudron_stop_b_m_bj, goudron_t_o_bj, goudron_triple_diag_coin_bj,
            goudron_triple_semi_diag_coin_bj, goudron_centre_double_bj, goudron_centre_triple_bj, goudron_ext_bj, goudron_int_bj, goudron_centre_quadruple_bj, goudron_centre_cote_bj;

    //Blocks entier route travaux
    public static Block blockgoudron_centre_bj, blockgoudron_cote_bj, blockgoudron_cote_centre_plein_bj, blockgoudron_cote_diag_d_bj, blockgoudron_cote_diag_g_bj,
            blockgoudron_cote_g_plein_bj, blockgoudron_cote_g_plein_bis_bj, blockgoudron_double_cote_centre_plein_bj, blockgoudron_double_diag_coin_bj, blockgoudron_semi_diag_c_bj,
            blockgoudron_double_h_semi_diag_coin_bj, blockgoudron_double_semi_diag_coin_bj, blockgoudron_entier_semi_diag_coin_bj, blockgoudron_fleche_bj, blockgoudron_fleche_d_bj,
            blockgoudron_fleche_g_bj, blockgoudron_passage_p_bj, blockgoudron_passage_p_ext_bj, blockgoudron_semi_diag_bj, blockgoudron_semi_diag_coin_bj, blockgoudron_semi_diag_d_bj, blockgoudron_o_p_bj,
            blockgoudron_semi_diag_g_bj, blockgoudron_s_t_bj, blockgoudron_stop_b_d_bj, blockgoudron_stop_b_g_bj, blockgoudron_stop_b_m_bj, blockgoudron_t_o_bj, blockgoudron_triple_diag_coin_bj,
            blockgoudron_triple_semi_diag_coin_bj, blockgoudron_centre_double_bj, blockgoudron_centre_triple_bj, blockgoudron_ext_bj, blockgoudron_int_bj, blockgoudron_centre_quadruple_bj, blockgoudron_centre_cote_bj;

    //Blocks slab route travaux
    public static Block slabgoudron_centre_bj, slabgoudron_cote_bj, slabgoudron_cote_centre_plein_bj, slabgoudron_cote_diag_d_bj, slabgoudron_cote_diag_g_bj,
            slabgoudron_cote_g_plein_bj, slabgoudron_cote_g_plein_bis_bj, slabgoudron_double_cote_centre_plein_bj, slabgoudron_double_diag_coin_bj, slabgoudron_semi_diag_c_bj,
            slabgoudron_double_h_semi_diag_coin_bj, slabgoudron_double_semi_diag_coin_bj, slabgoudron_entier_semi_diag_coin_bj, slabgoudron_fleche_bj, slabgoudron_fleche_d_bj,
            slabgoudron_fleche_g_bj, slabgoudron_passage_p_bj, slabgoudron_passage_p_ext_bj, slabgoudron_semi_diag_bj, slabgoudron_semi_diag_coin_bj, slabgoudron_semi_diag_d_bj, slabgoudron_o_p_bj,
            slabgoudron_semi_diag_g_bj, slabgoudron_s_t_bj, slabgoudron_stop_b_d_bj, slabgoudron_stop_b_g_bj, slabgoudron_stop_b_m_bj, slabgoudron_t_o_bj, slabgoudron_triple_diag_coin_bj,
            slabgoudron_triple_semi_diag_coin_bj, slabgoudron_centre_double_bj, slabgoudron_centre_triple_bj, slabgoudron_ext_bj, slabgoudron_int_bj, slabgoudron_centre_quadruple_bj, slabgoudron_centre_cote_bj;
    
    //Blocks
    public static Block opaque_noire, flint_stone, lampe, egout, infrarouge, poudre_vierge, poudre_weed, poudre_coca, poudre_bulbe, block_poudre_fer, block_poudre_or,
    block_poudre_or_bleu, block_poudre_or_rouge, block_poudre_or_noire, ardoise;
    
    //Box
    public static Block drog_box, drog_box_weed, drog_box_coca, drog_box_bulbe;
    
    //Bloque déco
    public static Block full_stone_slab, gold_stonebrick, iron_stonebrick, topaz_stonebrick, amethyst_stonebrick, kunzite_stonebrick, saphir_stonebrick, rubis_stonebrick,
    or_bleu_stonebrick, or_rouge_stonebrick, or_noire_stonebrick, gold_planks, iron_planks, topaz_planks, amethyst_planks, kunzite_planks, saphir_planks, rubis_planks,
    or_bleu_planks, or_rouge_planks, or_noire_planks, gold_stonebrick_stairs, iron_stonebrick_stairs, topaz_stonebrick_stairs, amethyst_stonebrick_stairs, kunzite_stonebrick_stairs, saphir_stonebrick_stairs, 
    rubis_stonebrick_stairs, or_bleu_stonebrick_stairs, or_rouge_stonebrick_stairs, or_noire_stonebrick_stairs, gold_planks_stairs, iron_planks_stairs, topaz_planks_stairs, amethyst_planks_stairs, 
    kunzite_planks_stairs, saphir_planks_stairs, rubis_planks_stairs, or_bleu_planks_stairs, or_rouge_planks_stairs, or_noire_planks_stairs, gold_stonebrick_wall, iron_stonebrick_wall, topaz_stonebrick_wall, 
    amethyst_stonebrick_wall, kunzite_stonebrick_wall, saphir_stonebrick_wall, rubis_stonebrick_wall, or_bleu_stonebrick_wall, or_rouge_stonebrick_wall, or_noire_stonebrick_wall, gold_planks_wall, iron_planks_wall, 
    topaz_planks_wall, amethyst_planks_wall, kunzite_planks_wall, saphir_planks_wall, rubis_planks_wall, or_bleu_planks_wall, or_rouge_planks_wall, or_noire_planks_wall, gold_stonebrick_slab, iron_stonebrick_slab, topaz_stonebrick_slab, 
    amethyst_stonebrick_slab, kunzite_stonebrick_slab, saphir_stonebrick_slab, rubis_stonebrick_slab, or_bleu_stonebrick_slab, or_rouge_stonebrick_slab, or_noire_stonebrick_slab, gold_planks_slab, iron_planks_slab, topaz_planks_slab, 
    amethyst_planks_slab, kunzite_planks_slab, saphir_planks_slab, rubis_planks_slab, or_bleu_planks_slab, or_rouge_planks_slab, or_noire_planks_slab, gold_stonebrick_double_slab, iron_stonebrick_double_slab, topaz_stonebrick_double_slab, 
    amethyst_stonebrick_double_slab, kunzite_stonebrick_double_slab, saphir_stonebrick_double_slab, rubis_stonebrick_double_slab, or_bleu_stonebrick_double_slab, or_rouge_stonebrick_double_slab, or_noire_stonebrick_double_slab, gold_planks_double_slab, iron_planks_double_slab, topaz_planks_double_slab, 
    amethyst_planks_double_slab, kunzite_planks_double_slab, saphir_planks_double_slab, rubis_planks_double_slab, or_bleu_planks_double_slab, or_rouge_planks_double_slab, or_noire_planks_double_slab;

    //Panneaux triangle
    public static Block bar, panneau_danger0, panneau_danger1, panneau_danger2, panneau_danger3, panneau_danger4, panneau_danger5, panneau_danger6,
            panneau_danger7, panneau_danger8, panneau_danger9, panneau_danger10, panneau_danger11, panneau_danger12, panneau_danger13, panneau_danger14,
            panneau_danger15, panneau_danger16, panneau_danger17;

    //Panneaux carre
    public static Block panneau_carre0, panneau_carre1;

    //Panneaux rond
    public static Block panneau_rond0, panneau_rond1, panneau_rond2, panneau_rond3, panneau_rond4, panneau_rond5;

    //Panneaux autre
    public static Block panneau_stop, panneau_tri_inv, panneau_carre_inv0, panneau_carre_inv1, panonceau0, grand_panonceau0;

    //Ramp
    public static Block ramp;
    
    //Machines
    public static Block table_assemblage, centrifugeuse, sechoir, generateur, conteneurenergie, assemblage_arme, assemblage_munition, imprimante, table_chimie, drill, tami_vide,
    tami_sand, tami_gravel, tami_dirt, tami_cobble, tami_redsand, tami_soulsand, tami_goldpowder, tami_ironpowder, tami_blackgoldpowder, tami_redgoldpowder, tami_bluegoldpowder;

    //Plante
    public static Block weed_crop, bulbe_crop, bois_farm, fraise_crop, pommier, coca_crop, mais_crop_top, mais_crop_bottom, tomate_crop_top, tomate_crop_bottom, 
    salade_crop, choux_rouge_crop, poireaux_crop, oignons_crop, oignons_rouge_crop, vigne_crop_top, vigne_crop_bottom;

    //Liquid
    public static Block b6, encre, fluoroantimonique, encre_magenta, encre_jaune, encre_cyan, essence;

    //Vitres
    public static Block glass_blanc, glass_noire, acid;

    //Cuisine
    public static Block planche, planche_tomate, planche_mais, planche_poireau, planche_salade, planche_choux_rouge, planche_oignon, planche_oignon_rouge, 
    planche_beef, planche_chicken, planche_coad, planche_mutton, planche_pork, planche_rabbit, planche_salmon, planche_bread;

    //Minerais
    public static Block ore_torbenite, saphir_ore, saphir_block, rubis_ore, rubis_block, amethyst_ore, amethyst_block, topaz_ore, topaz_block, 
    kunzite_ore, kunzite_block, or_bleu_block, or_rouge_block, or_noire_block;

    //texture liee
    public static Block crepi_BR, crepi_BRU, crepi, futur_br, futur_bru, futur, quarpi_br, quarpi_bru, quarpi, oak_br, oak_bru, big_oak_br, big_oak_bru,
            spruce_br, spruce_bru, jungle_br, jungle_bru, birch_br, birch_bru, acacia_br, acacia_bru, glass;

    public static void init(){

    	ramp = new BlockRamp("ramp", Material.ROCK);
    	
    	planche = new BlockPlanche("planche");
    	planche_tomate = new BlockPlanche("planche_tomate");
    	planche_mais = new BlockPlanche("planche_mais");
    	planche_poireau = new BlockPlanche("planche_poireau");
    	planche_salade = new BlockPlanche("planche_salade");
    	planche_choux_rouge = new BlockPlanche("planche_choux_rouge");
    	planche_oignon = new BlockPlanche("planche_oignon");
    	planche_oignon_rouge = new BlockPlanche("planche_oignon_rouge");
    	planche_beef = new BlockPlanche("planche_beef");
    	planche_chicken = new BlockPlanche("planche_chicken");
    	planche_coad = new BlockPlanche("planche_coad");
    	planche_mutton = new BlockPlanche("planche_mutton");
    	planche_pork = new BlockPlanche("planche_pork");
    	planche_rabbit = new BlockPlanche("planche_rabbit");
    	planche_salmon = new BlockPlanche("planche_salmon");
    	planche_bread = new BlockPlanche("planche_bread");
    	
    	full_stone_slab = new BlockDeco("full_stone_slab", Material.ROCK);
    	gold_stonebrick = new BlockDeco("gold_stonebrick", Material.ROCK);
    	iron_stonebrick = new BlockDeco("iron_stonebrick", Material.ROCK);
    	topaz_stonebrick = new BlockDeco("topaz_stonebrick", Material.ROCK);
    	amethyst_stonebrick = new BlockDeco("amethyst_stonebrick", Material.ROCK);
    	kunzite_stonebrick = new BlockDeco("kunzite_stonebrick", Material.ROCK);
    	saphir_stonebrick = new BlockDeco("saphir_stonebrick", Material.ROCK);
    	rubis_stonebrick = new BlockDeco("rubis_stonebrick", Material.ROCK);
    	or_bleu_stonebrick = new BlockDeco("or_bleu_stonebrick", Material.ROCK);
    	or_rouge_stonebrick = new BlockDeco("or_rouge_stonebrick", Material.ROCK);
    	or_noire_stonebrick = new BlockDeco("or_noire_stonebrick", Material.ROCK);
    	gold_planks = new BlockDeco("gold_planks", Material.WOOD);
    	iron_planks = new BlockDeco("iron_planks", Material.WOOD);
    	topaz_planks = new BlockDeco("topaz_planks", Material.WOOD);
    	amethyst_planks = new BlockDeco("amethyst_planks", Material.WOOD);
    	kunzite_planks = new BlockDeco("kunzite_planks", Material.WOOD);
    	saphir_planks = new BlockDeco("saphir_planks", Material.WOOD);
    	rubis_planks = new BlockDeco("rubis_planks", Material.WOOD);
    	or_bleu_planks = new BlockDeco("or_bleu_planks", Material.WOOD);
    	or_rouge_planks = new BlockDeco("or_rouge_planks", Material.WOOD);
    	or_noire_planks = new BlockDeco("or_noire_planks", Material.WOOD);

    	gold_stonebrick_stairs = new StairDeco("gold_stonebrick_stairs", gold_stonebrick.getDefaultState());
    	iron_stonebrick_stairs = new StairDeco("iron_stonebrick_stairs", iron_stonebrick.getDefaultState());
    	topaz_stonebrick_stairs = new StairDeco("topaz_stonebrick_stairs", topaz_stonebrick.getDefaultState());
    	amethyst_stonebrick_stairs = new StairDeco("amethyst_stonebrick_stairs", amethyst_stonebrick.getDefaultState());
    	kunzite_stonebrick_stairs = new StairDeco("kunzite_stonebrick_stairs", kunzite_stonebrick.getDefaultState());
    	saphir_stonebrick_stairs = new StairDeco("saphir_stonebrick_stairs", saphir_stonebrick.getDefaultState());
    	rubis_stonebrick_stairs = new StairDeco("rubis_stonebrick_stairs", rubis_stonebrick.getDefaultState());
    	or_bleu_stonebrick_stairs = new StairDeco("or_bleu_stonebrick_stairs", or_bleu_stonebrick.getDefaultState());
    	or_rouge_stonebrick_stairs = new StairDeco("or_rouge_stonebrick_stairs", or_rouge_stonebrick.getDefaultState());
    	or_noire_stonebrick_stairs = new StairDeco("or_noire_stonebrick_stairs", or_noire_stonebrick.getDefaultState());
    	gold_planks_stairs = new StairDeco("gold_planks_stairs", gold_planks.getDefaultState());
    	iron_planks_stairs = new StairDeco("iron_planks_stairs", iron_planks.getDefaultState());
    	topaz_planks_stairs = new StairDeco("topaz_planks_stairs", topaz_planks.getDefaultState());
    	amethyst_planks_stairs = new StairDeco("amethyst_planks_stairs", amethyst_planks.getDefaultState());
    	kunzite_planks_stairs = new StairDeco("kunzite_planks_stairs", kunzite_planks.getDefaultState());
    	saphir_planks_stairs = new StairDeco("saphir_planks_stairs", saphir_planks.getDefaultState());
    	rubis_planks_stairs = new StairDeco("rubis_planks_stairs", rubis_planks.getDefaultState());
    	or_bleu_planks_stairs = new StairDeco("or_bleu_planks_stairs", or_bleu_planks.getDefaultState());
    	or_rouge_planks_stairs = new StairDeco("or_rouge_planks_stairs", or_rouge_planks.getDefaultState());
    	or_noire_planks_stairs = new StairDeco("or_noire_planks_stairs", or_noire_planks.getDefaultState());
    	
    	gold_stonebrick_wall = new WallDeco("gold_stonebrick_wall", Material.ROCK, SoundType.STONE);
    	iron_stonebrick_wall = new WallDeco("iron_stonebrick_wall", Material.ROCK, SoundType.STONE);
    	topaz_stonebrick_wall = new WallDeco("topaz_stonebrick_wall", Material.ROCK, SoundType.STONE);
    	amethyst_stonebrick_wall = new WallDeco("amethyst_stonebrick_wall", Material.ROCK, SoundType.STONE);
    	kunzite_stonebrick_wall = new WallDeco("kunzite_stonebrick_wall", Material.ROCK, SoundType.STONE);
    	saphir_stonebrick_wall = new WallDeco("saphir_stonebrick_wall", Material.ROCK, SoundType.STONE);
    	rubis_stonebrick_wall = new WallDeco("rubis_stonebrick_wall", Material.ROCK, SoundType.STONE);
    	or_bleu_stonebrick_wall = new WallDeco("or_bleu_stonebrick_wall", Material.ROCK, SoundType.STONE);
    	or_rouge_stonebrick_wall = new WallDeco("or_rouge_stonebrick_wall", Material.ROCK, SoundType.STONE);
    	or_noire_stonebrick_wall = new WallDeco("or_noire_stonebrick_wall", Material.ROCK, SoundType.STONE);
    	gold_planks_wall = new WallDeco("gold_planks_wall", Material.WOOD, SoundType.WOOD);
    	iron_planks_wall = new WallDeco("iron_planks_wall", Material.WOOD, SoundType.WOOD);
    	topaz_planks_wall = new WallDeco("topaz_planks_wall", Material.WOOD, SoundType.WOOD);
    	amethyst_planks_wall = new WallDeco("amethyst_planks_wall", Material.WOOD, SoundType.WOOD);
    	kunzite_planks_wall = new WallDeco("kunzite_planks_wall", Material.WOOD, SoundType.WOOD);
    	saphir_planks_wall = new WallDeco("saphir_planks_wall", Material.WOOD, SoundType.WOOD);
    	rubis_planks_wall = new WallDeco("rubis_planks_wall", Material.WOOD, SoundType.WOOD);
    	or_bleu_planks_wall = new WallDeco("or_bleu_planks_wall", Material.WOOD, SoundType.WOOD);
    	or_rouge_planks_wall = new WallDeco("or_rouge_planks_wall", Material.WOOD, SoundType.WOOD);
    	or_noire_planks_wall = new WallDeco("or_noire_planks_wall", Material.WOOD, SoundType.WOOD);

    	gold_stonebrick_slab = new SlabDecoHalf("gold_stonebrick_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.gold_stonebrick_slab);
    	iron_stonebrick_slab = new SlabDecoHalf("iron_stonebrick_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.iron_stonebrick_slab);
    	topaz_stonebrick_slab = new SlabDecoHalf("topaz_stonebrick_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.topaz_stonebrick_slab);
    	amethyst_stonebrick_slab = new SlabDecoHalf("amethyst_stonebrick_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.amethyst_stonebrick_slab);
    	kunzite_stonebrick_slab = new SlabDecoHalf("kunzite_stonebrick_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.kunzite_stonebrick_slab);
    	saphir_stonebrick_slab = new SlabDecoHalf("saphir_stonebrick_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.saphir_stonebrick_slab);
    	rubis_stonebrick_slab = new SlabDecoHalf("rubis_stonebrick_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.rubis_stonebrick_slab);
    	or_bleu_stonebrick_slab = new SlabDecoHalf("or_bleu_stonebrick_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.or_bleu_stonebrick_slab);
    	or_rouge_stonebrick_slab = new SlabDecoHalf("or_rouge_stonebrick_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.or_rouge_stonebrick_slab);
    	or_noire_stonebrick_slab = new SlabDecoHalf("or_noire_stonebrick_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.or_noire_stonebrick_slab);
    	gold_planks_slab = new SlabDecoHalf("gold_planks_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.gold_planks_slab);
    	iron_planks_slab = new SlabDecoHalf("iron_planks_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.iron_planks_slab);
    	topaz_planks_slab = new SlabDecoHalf("topaz_planks_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.topaz_planks_slab);
    	amethyst_planks_slab = new SlabDecoHalf("amethyst_planks_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.amethyst_planks_slab);
    	kunzite_planks_slab = new SlabDecoHalf("kunzite_planks_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.kunzite_planks_slab);
    	saphir_planks_slab = new SlabDecoHalf("saphir_planks_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.saphir_planks_slab);
    	rubis_planks_slab = new SlabDecoHalf("rubis_planks_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.rubis_planks_slab);
    	or_bleu_planks_slab = new SlabDecoHalf("or_bleu_planks_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.or_bleu_planks_slab);
    	or_rouge_planks_slab = new SlabDecoHalf("or_rouge_planks_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.or_rouge_planks_slab);
    	or_noire_planks_slab = new SlabDecoHalf("or_noire_planks_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.or_noire_planks_slab);

    	gold_stonebrick_double_slab = new SlabDecoDouble("gold_stonebrick_double_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.gold_stonebrick_slab);
    	iron_stonebrick_double_slab = new SlabDecoDouble("iron_stonebrick_double_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.iron_stonebrick_slab);
    	topaz_stonebrick_double_slab = new SlabDecoDouble("topaz_stonebrick_double_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.topaz_stonebrick_slab);
    	amethyst_stonebrick_double_slab = new SlabDecoDouble("amethyst_stonebrick_double_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.amethyst_stonebrick_slab);
    	kunzite_stonebrick_double_slab = new SlabDecoDouble("kunzite_stonebrick_double_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.kunzite_stonebrick_slab);
    	saphir_stonebrick_double_slab = new SlabDecoDouble("saphir_stonebrick_double_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.saphir_stonebrick_slab);
    	rubis_stonebrick_double_slab = new SlabDecoDouble("rubis_stonebrick_double_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.rubis_stonebrick_slab);
    	or_bleu_stonebrick_double_slab = new SlabDecoDouble("or_bleu_stonebrick_double_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.or_bleu_stonebrick_slab);
    	or_rouge_stonebrick_double_slab = new SlabDecoDouble("or_rouge_stonebrick_double_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.or_rouge_stonebrick_slab);
    	or_noire_stonebrick_double_slab = new SlabDecoDouble("or_noire_stonebrick_double_slab", Material.ROCK, SoundType.STONE, (BlockSlab)ModBlocks.or_noire_stonebrick_slab);
    	gold_planks_double_slab = new SlabDecoDouble("gold_planks_double_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.gold_planks_slab);
    	iron_planks_double_slab = new SlabDecoDouble("iron_planks_double_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.iron_planks_slab);
    	topaz_planks_double_slab = new SlabDecoDouble("topaz_planks_double_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.topaz_planks_slab);
    	amethyst_planks_double_slab = new SlabDecoDouble("amethyst_planks_double_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.amethyst_planks_slab);
    	kunzite_planks_double_slab = new SlabDecoDouble("kunzite_planks_double_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.kunzite_planks_slab);
    	saphir_planks_double_slab = new SlabDecoDouble("saphir_planks_double_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.saphir_planks_slab);
    	rubis_planks_double_slab = new SlabDecoDouble("rubis_planks_double_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.rubis_planks_slab);
    	or_bleu_planks_double_slab = new SlabDecoDouble("or_bleu_planks_double_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.or_bleu_planks_slab);
    	or_rouge_planks_double_slab = new SlabDecoDouble("or_rouge_planks_double_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.or_rouge_planks_slab);
    	or_noire_planks_double_slab = new SlabDecoDouble("or_noire_planks_double_slab", Material.WOOD, SoundType.WOOD, (BlockSlab)ModBlocks.or_noire_planks_slab);
    	
    	//--------------------------------------------------------------------------------------
    	
    	table_assemblage = new BlockTableAssemblage("table_assemblage");
    	centrifugeuse = new BlockCentrifugeuse("centrifugeuse");
    	sechoir = new BlockSechoir("sechoir");
    	generateur = new BlockElec("generateur");
    	conteneurenergie = new BlockElec("conteneurenergie");
    	assemblage_arme = new BlockAssemblageArme("assemblage_arme");
    	assemblage_munition = new BlockAssemblageMunition("assemblage_munition");
    	imprimante = new BlockImprimante("imprimante");
    	table_chimie = new BlockTableChimie("table_chimie");
    	drill = new BlockDrill("drill");
    	tami_vide = new BlockTami("tami_vide");
    	tami_sand = new BlockTamiPlein("tami_sand", new ItemStack(Blocks.SAND, 1, 0));
    	tami_gravel = new BlockTamiPlein("tami_gravel", new ItemStack(Blocks.GRAVEL)); 
    	tami_dirt = new BlockTamiPlein("tami_dirt", new ItemStack(Blocks.DIRT));
    	tami_cobble = new BlockTamiPlein("tami_cobble", new ItemStack(Blocks.COBBLESTONE));
    	tami_redsand = new BlockTamiPlein("tami_redsand", new ItemStack(Blocks.SAND, 1, 1));
    	tami_soulsand = new BlockTamiPlein("tami_soulsand", new ItemStack(Blocks.SOUL_SAND));
    	tami_goldpowder = new BlockTamiPlein("tami_goldpowder", new ItemStack(ModBlocks.block_poudre_or));
    	tami_ironpowder = new BlockTamiPlein("tami_ironpowder", new ItemStack(ModBlocks.block_poudre_fer));
    	tami_blackgoldpowder = new BlockTamiPlein("tami_blackgoldpowder", new ItemStack(ModBlocks.block_poudre_or_noire));
    	tami_redgoldpowder = new BlockTamiPlein("tami_redgoldpowder", new ItemStack(ModBlocks.block_poudre_or_rouge));
    	tami_bluegoldpowder = new BlockTamiPlein("tami_bluegoldpowder", new ItemStack(ModBlocks.block_poudre_or_bleu));
    	
    	drog_box = new BlockBox("drog_box").setCreativeTab(universiaMod.creativeTabDrogs);
    	drog_box_weed = new BlockBox("drog_box_weed").setCreativeTab(universiaMod.creativeTabDrogs);
    	drog_box_coca = new BlockBox("drog_box_coca").setCreativeTab(universiaMod.creativeTabDrogs);
    	drog_box_bulbe = new BlockBox("drog_box_bulbe").setCreativeTab(universiaMod.creativeTabDrogs);

        egout = new BlockEgout("egout");

        bois_farm = new BlockBois(Material.WOOD, "bois");
        pommier = new BlockPommier(Material.LEAVES, "pommier");

        crepi_BR = new BlockCTM(Material.ROCK, "crepi_BR", "PIOCHE");
        crepi_BRU = new BlockCTM(Material.ROCK, "crepi_BRU", "PIOCHE");
        crepi = new BlockCTM(Material.ROCK, "crepi", "PIOCHE");

        futur_br = new BlockCTM(Material.IRON, "futur_br", "PIOCHE");
        futur_bru = new BlockCTM(Material.IRON, "futur_bru", "PIOCHE");
        futur = new BlockCTM(Material.IRON, "futur", "PIOCHE");

        quarpi_br = new BlockCTM(Material.ROCK, "quarpi_br", "PIOCHE");
        quarpi_bru = new BlockCTM(Material.ROCK, "quarpi_bru", "PIOCHE");
        quarpi = new BlockCTM(Material.ROCK, "quarpi", "PIOCHE");

        oak_br = new BlockCTM(Material.ROCK, "oak_br", "HACHE");
        oak_bru = new BlockCTM(Material.ROCK, "oak_bru", "HACHE");
        big_oak_br = new BlockCTM(Material.ROCK, "big_oak_br", "HACHE");
        big_oak_bru = new BlockCTM(Material.ROCK, "big_oak_bru", "HACHE");
        spruce_br = new BlockCTM(Material.ROCK, "spruce_br", "HACHE");
        spruce_bru = new BlockCTM(Material.ROCK, "spruce_bru", "HACHE");
        jungle_br = new BlockCTM(Material.ROCK, "jungle_br", "HACHE");
        jungle_bru = new BlockCTM(Material.ROCK, "jungle_bru", "HACHE");
        birch_br = new BlockCTM(Material.ROCK, "birch_br", "HACHE");
        birch_bru = new BlockCTM(Material.ROCK, "birch_bru", "HACHE");
        acacia_br = new BlockCTM(Material.ROCK, "acacia_br", "HACHE");
        acacia_bru = new BlockCTM(Material.ROCK, "acacia_bru", "HACHE");

        glass = new BlockGlassU(false).setUnlocalizedName("glass").setRegistryName("glass").setCreativeTab(universiaMod.creativeTabDeco);
        glass_blanc = new BlockGlassU(false).setUnlocalizedName("glass_blanc").setRegistryName("glass_blanc").setCreativeTab(universiaMod.creativeTabDeco);
        glass_noire = new BlockGlassU(false).setUnlocalizedName("glass_noire").setRegistryName("glass_noire").setCreativeTab(universiaMod.creativeTabDeco);
        acid = new BlockGlassU(false).setUnlocalizedName("acid").setRegistryName("acid").setCreativeTab(universiaMod.creativeTab);

        opaque_noire = new Block(Material.ROCK).setRegistryName("opaque_noire").setUnlocalizedName("opaque_noire").setCreativeTab(universiaMod.creativeTabDeco);
        ardoise = new Block(Material.ROCK).setRegistryName("ardoise").setUnlocalizedName("ardoise").setCreativeTab(universiaMod.creativeTabDeco);
        poudre_vierge = new BlockPoudre("poudre_vierge");
        poudre_weed = new BlockPoudre("poudre_weed");
        poudre_coca = new BlockPoudre("poudre_coca");
        poudre_bulbe = new BlockPoudre("poudre_bulbe");
        block_poudre_or = new BlockPoudre("block_poudre_or");
        block_poudre_fer = new BlockPoudre("block_poudre_fer");
        block_poudre_or_bleu = new BlockPoudre("block_poudre_or_bleu");
        block_poudre_or_rouge = new BlockPoudre("block_poudre_or_rouge");
        block_poudre_or_noire = new BlockPoudre("block_poudre_or_noire");

        lampe = new BlockLampe("lampe");
        infrarouge = new BlockInfrarouge("infrarouge");

        goudron = new BlockRoute("goudron");
        goudron_centre_cote_b = new BlockRoute("goudron_centre_cote_b");
        goudron_cote_b = new BlockRoute("goudron_cote_b");
        goudron_cote_centre_plein_b = new BlockRoute("goudron_cote_centre_plein_b");
        goudron_cote_diag_d_b = new BlockRoute("goudron_cote_diag_d_b");
        goudron_centre_b = new BlockRoute("goudron_centre_b");
        goudron_cote_diag_g_b = new BlockRoute("goudron_cote_diag_g_b");
        goudron_cote_g_plein_b = new BlockRoute("goudron_cote_g_plein_b");
        goudron_cote_g_plein_bis_b = new BlockRoute("goudron_cote_g_plein_bis_b");
        goudron_double_cote_centre_plein_b = new BlockRoute("goudron_double_cote_centre_plein_b");
        goudron_double_diag_coin_b = new BlockRoute("goudron_double_diag_coin_b");
        goudron_semi_diag_c_b = new BlockRoute("goudron_semi_diag_c_b");
        goudron_double_h_semi_diag_coin_b = new BlockRoute("goudron_double_h_semi_diag_coin_b");
        goudron_double_semi_diag_coin_b = new BlockRoute("goudron_double_semi_diag_coin_b");
        goudron_entier_semi_diag_coin_b = new BlockRoute("goudron_entier_semi_diag_coin_b");
        goudron_fleche_b = new BlockRoute("goudron_fleche_b");
        goudron_fleche_d_b = new BlockRoute("goudron_fleche_d_b");
        goudron_fleche_g_b = new BlockRoute("goudron_fleche_g_b");
        goudron_passage_p_b = new BlockRoute("goudron_passage_p_b");
        goudron_passage_p_ext_b = new BlockRoute("goudron_passage_p_ext_b");
        goudron_semi_diag_b = new BlockRoute("goudron_semi_diag_b");
        goudron_semi_diag_coin_b = new BlockRoute("goudron_semi_diag_coin_b");
        goudron_semi_diag_d_b = new BlockRoute("goudron_semi_diag_d_b");
        goudron_o_p_b = new BlockRoute("goudron_o_p_b");
        goudron_semi_diag_g_b = new BlockRoute("goudron_semi_diag_g_b");
        goudron_s_t_b = new BlockRoute("goudron_s_t_b");
        goudron_stop_b_d_b = new BlockRoute("goudron_stop_b_d_b");
        goudron_stop_b_g_b = new BlockRoute("goudron_stop_b_g_b");
        goudron_stop_b_m_b = new BlockRoute("goudron_stop_b_m_b");
        goudron_t_o_b = new BlockRoute("goudron_t_o_b");
        goudron_triple_diag_coin_b = new BlockRoute("goudron_triple_diag_coin_b");
        goudron_triple_semi_diag_coin_b = new BlockRoute("goudron_triple_semi_diag_coin_b");
        goudron_centre_double_b = new BlockRoute("goudron_centre_double_b");
        goudron_centre_triple_b = new BlockRoute("goudron_centre_triple_b");
        goudron_ext_b = new BlockRoute("goudron_ext_b");
        goudron_int_b = new BlockRoute("goudron_int_b");
        goudron_centre_quadruple_b = new BlockRoute("goudron_centre_quadruple_b");

        blockgoudron = new BlockEntierRoute("blockgoudron");
        blockgoudron_centre_cote_b = new BlockEntierRoute("blockgoudron_centre_cote_b");
        blockgoudron_cote_b = new BlockEntierRoute("blockgoudron_cote_b");
        blockgoudron_cote_centre_plein_b = new BlockEntierRoute("blockgoudron_cote_centre_plein_b");
        blockgoudron_cote_diag_d_b = new BlockEntierRoute("blockgoudron_cote_diag_d_b");
        blockgoudron_centre_b = new BlockEntierRoute("blockgoudron_centre_b");
        blockgoudron_cote_diag_g_b = new BlockEntierRoute("blockgoudron_cote_diag_g_b");
        blockgoudron_cote_g_plein_b = new BlockEntierRoute("blockgoudron_cote_g_plein_b");
        blockgoudron_cote_g_plein_bis_b = new BlockEntierRoute("blockgoudron_cote_g_plein_bis_b");
        blockgoudron_double_cote_centre_plein_b = new BlockEntierRoute("blockgoudron_double_cote_centre_plein_b");
        blockgoudron_double_diag_coin_b = new BlockEntierRoute("blockgoudron_double_diag_coin_b");
        blockgoudron_semi_diag_c_b = new BlockEntierRoute("blockgoudron_semi_diag_c_b");
        blockgoudron_double_h_semi_diag_coin_b = new BlockEntierRoute("blockgoudron_double_h_semi_diag_coin_b");
        blockgoudron_double_semi_diag_coin_b = new BlockEntierRoute("blockgoudron_double_semi_diag_coin_b");
        blockgoudron_entier_semi_diag_coin_b = new BlockEntierRoute("blockgoudron_entier_semi_diag_coin_b");
        blockgoudron_fleche_b = new BlockEntierRoute("blockgoudron_fleche_b");
        blockgoudron_fleche_d_b = new BlockEntierRoute("blockgoudron_fleche_d_b");
        blockgoudron_fleche_g_b = new BlockEntierRoute("blockgoudron_fleche_g_b");
        blockgoudron_passage_p_b = new BlockEntierRoute("blockgoudron_passage_p_b");
        blockgoudron_passage_p_ext_b = new BlockEntierRoute("blockgoudron_passage_p_ext_b");
        blockgoudron_semi_diag_b = new BlockEntierRoute("blockgoudron_semi_diag_b");
        blockgoudron_semi_diag_coin_b = new BlockEntierRoute("blockgoudron_semi_diag_coin_b");
        blockgoudron_semi_diag_d_b = new BlockEntierRoute("blockgoudron_semi_diag_d_b");
        blockgoudron_o_p_b = new BlockEntierRoute("blockgoudron_o_p_b");
        blockgoudron_semi_diag_g_b = new BlockEntierRoute("blockgoudron_semi_diag_g_b");
        blockgoudron_s_t_b = new BlockEntierRoute("blockgoudron_s_t_b");
        blockgoudron_stop_b_d_b = new BlockEntierRoute("blockgoudron_stop_b_d_b");
        blockgoudron_stop_b_g_b = new BlockEntierRoute("blockgoudron_stop_b_g_b");
        blockgoudron_stop_b_m_b = new BlockEntierRoute("blockgoudron_stop_b_m_b");
        blockgoudron_t_o_b = new BlockEntierRoute("blockgoudron_t_o_b");
        blockgoudron_triple_diag_coin_b = new BlockEntierRoute("blockgoudron_triple_diag_coin_b");
        blockgoudron_triple_semi_diag_coin_b = new BlockEntierRoute("blockgoudron_triple_semi_diag_coin_b");
        blockgoudron_centre_double_b = new BlockEntierRoute("blockgoudron_centre_double_b");
        blockgoudron_centre_triple_b = new BlockEntierRoute("blockgoudron_centre_triple_b");
        blockgoudron_ext_b = new BlockEntierRoute("blockgoudron_ext_b");
        blockgoudron_int_b = new BlockEntierRoute("blockgoudron_int_b");
        blockgoudron_centre_quadruple_b = new BlockEntierRoute("blockgoudron_centre_quadruple_b");

        slabgoudron = new BlockSlabRoute("slabgoudron");
        slabgoudron_centre_cote_b = new BlockSlabRoute("slabgoudron_centre_cote_b");
        slabgoudron_cote_b = new BlockSlabRoute("slabgoudron_cote_b");
        slabgoudron_cote_centre_plein_b = new BlockSlabRoute("slabgoudron_cote_centre_plein_b");
        slabgoudron_cote_diag_d_b = new BlockSlabRoute("slabgoudron_cote_diag_d_b");
        slabgoudron_centre_b = new BlockSlabRoute("slabgoudron_centre_b");
        slabgoudron_cote_diag_g_b = new BlockSlabRoute("slabgoudron_cote_diag_g_b");
        slabgoudron_cote_g_plein_b = new BlockSlabRoute("slabgoudron_cote_g_plein_b");
        slabgoudron_cote_g_plein_bis_b = new BlockSlabRoute("slabgoudron_cote_g_plein_bis_b");
        slabgoudron_double_cote_centre_plein_b = new BlockSlabRoute("slabgoudron_double_cote_centre_plein_b");
        slabgoudron_double_diag_coin_b = new BlockSlabRoute("slabgoudron_double_diag_coin_b");
        slabgoudron_semi_diag_c_b = new BlockSlabRoute("slabgoudron_semi_diag_c_b");
        slabgoudron_double_h_semi_diag_coin_b = new BlockSlabRoute("slabgoudron_double_h_semi_diag_coin_b");
        slabgoudron_double_semi_diag_coin_b = new BlockSlabRoute("slabgoudron_double_semi_diag_coin_b");
        slabgoudron_entier_semi_diag_coin_b = new BlockSlabRoute("slabgoudron_entier_semi_diag_coin_b");
        slabgoudron_fleche_b = new BlockSlabRoute("slabgoudron_fleche_b");
        slabgoudron_fleche_d_b = new BlockSlabRoute("slabgoudron_fleche_d_b");
        slabgoudron_fleche_g_b = new BlockSlabRoute("slabgoudron_fleche_g_b");
        slabgoudron_passage_p_b = new BlockSlabRoute("slabgoudron_passage_p_b");
        slabgoudron_passage_p_ext_b = new BlockSlabRoute("slabgoudron_passage_p_ext_b");
        slabgoudron_semi_diag_b = new BlockSlabRoute("slabgoudron_semi_diag_b");
        slabgoudron_semi_diag_coin_b = new BlockSlabRoute("slabgoudron_semi_diag_coin_b");
        slabgoudron_semi_diag_d_b = new BlockSlabRoute("slabgoudron_semi_diag_d_b");
        slabgoudron_o_p_b = new BlockSlabRoute("slabgoudron_o_p_b");
        slabgoudron_semi_diag_g_b = new BlockSlabRoute("slabgoudron_semi_diag_g_b");
        slabgoudron_s_t_b = new BlockSlabRoute("slabgoudron_s_t_b");
        slabgoudron_stop_b_d_b = new BlockSlabRoute("slabgoudron_stop_b_d_b");
        slabgoudron_stop_b_g_b = new BlockSlabRoute("slabgoudron_stop_b_g_b");
        slabgoudron_stop_b_m_b = new BlockSlabRoute("slabgoudron_stop_b_m_b");
        slabgoudron_t_o_b = new BlockSlabRoute("slabgoudron_t_o_b");
        slabgoudron_triple_diag_coin_b = new BlockSlabRoute("slabgoudron_triple_diag_coin_b");
        slabgoudron_triple_semi_diag_coin_b = new BlockSlabRoute("slabgoudron_triple_semi_diag_coin_b");
        slabgoudron_centre_double_b = new BlockSlabRoute("slabgoudron_centre_double_b");
        slabgoudron_centre_triple_b = new BlockSlabRoute("slabgoudron_centre_triple_b");
        slabgoudron_ext_b = new BlockSlabRoute("slabgoudron_ext_b");
        slabgoudron_int_b = new BlockSlabRoute("slabgoudron_int_b");
        slabgoudron_centre_quadruple_b = new BlockSlabRoute("slabgoudron_centre_quadruple_b");

        //---------------------------------------------------------------------------------------------------------------
        
        goudron_centre_cote_bj = new BlockRoute("goudron_centre_cote_bj");
        goudron_cote_bj = new BlockRoute("goudron_cote_bj");
        goudron_cote_centre_plein_bj = new BlockRoute("goudron_cote_centre_plein_bj");
        goudron_cote_diag_d_bj = new BlockRoute("goudron_cote_diag_d_bj");
        goudron_centre_bj = new BlockRoute("goudron_centre_bj");
        goudron_cote_diag_g_bj = new BlockRoute("goudron_cote_diag_g_bj");
        goudron_cote_g_plein_bj = new BlockRoute("goudron_cote_g_plein_bj");
        goudron_cote_g_plein_bis_bj = new BlockRoute("goudron_cote_g_plein_bis_bj");
        goudron_double_cote_centre_plein_bj = new BlockRoute("goudron_double_cote_centre_plein_bj");
        goudron_double_diag_coin_bj = new BlockRoute("goudron_double_diag_coin_bj");
        goudron_semi_diag_c_bj = new BlockRoute("goudron_semi_diag_c_bj");
        goudron_double_h_semi_diag_coin_bj = new BlockRoute("goudron_double_h_semi_diag_coin_bj");
        goudron_double_semi_diag_coin_bj = new BlockRoute("goudron_double_semi_diag_coin_bj");
        goudron_entier_semi_diag_coin_bj = new BlockRoute("goudron_entier_semi_diag_coin_bj");
        goudron_fleche_bj = new BlockRoute("goudron_fleche_bj");
        goudron_fleche_d_bj = new BlockRoute("goudron_fleche_d_bj");
        goudron_fleche_g_bj = new BlockRoute("goudron_fleche_g_bj");
        goudron_passage_p_bj = new BlockRoute("goudron_passage_p_bj");
        goudron_passage_p_ext_bj = new BlockRoute("goudron_passage_p_ext_bj");
        goudron_semi_diag_bj = new BlockRoute("goudron_semi_diag_bj");
        goudron_semi_diag_coin_bj = new BlockRoute("goudron_semi_diag_coin_bj");
        goudron_semi_diag_d_bj = new BlockRoute("goudron_semi_diag_d_bj");
        goudron_o_p_bj = new BlockRoute("goudron_o_p_bj");
        goudron_semi_diag_g_bj = new BlockRoute("goudron_semi_diag_g_bj");
        goudron_s_t_bj = new BlockRoute("goudron_s_t_bj");
        goudron_stop_b_d_bj = new BlockRoute("goudron_stop_b_d_bj");
        goudron_stop_b_g_bj = new BlockRoute("goudron_stop_b_g_bj");
        goudron_stop_b_m_bj = new BlockRoute("goudron_stop_b_m_bj");
        goudron_t_o_bj = new BlockRoute("goudron_t_o_bj");
        goudron_triple_diag_coin_bj = new BlockRoute("goudron_triple_diag_coin_bj");
        goudron_triple_semi_diag_coin_bj = new BlockRoute("goudron_triple_semi_diag_coin_bj");
        goudron_centre_double_bj = new BlockRoute("goudron_centre_double_bj");
        goudron_centre_triple_bj = new BlockRoute("goudron_centre_triple_bj");
        goudron_ext_bj = new BlockRoute("goudron_ext_bj");
        goudron_int_bj = new BlockRoute("goudron_int_bj");
        goudron_centre_quadruple_bj = new BlockRoute("goudron_centre_quadruple_bj");

        blockgoudron_centre_cote_bj = new BlockEntierRoute("blockgoudron_centre_cote_bj");
        blockgoudron_cote_bj = new BlockEntierRoute("blockgoudron_cote_bj");
        blockgoudron_cote_centre_plein_bj = new BlockEntierRoute("blockgoudron_cote_centre_plein_bj");
        blockgoudron_cote_diag_d_bj = new BlockEntierRoute("blockgoudron_cote_diag_d_bj");
        blockgoudron_centre_bj = new BlockEntierRoute("blockgoudron_centre_bj");
        blockgoudron_cote_diag_g_bj = new BlockEntierRoute("blockgoudron_cote_diag_g_bj");
        blockgoudron_cote_g_plein_bj = new BlockEntierRoute("blockgoudron_cote_g_plein_bj");
        blockgoudron_cote_g_plein_bis_bj = new BlockEntierRoute("blockgoudron_cote_g_plein_bis_bj");
        blockgoudron_double_cote_centre_plein_bj = new BlockEntierRoute("blockgoudron_double_cote_centre_plein_bj");
        blockgoudron_double_diag_coin_bj = new BlockEntierRoute("blockgoudron_double_diag_coin_bj");
        blockgoudron_semi_diag_c_bj = new BlockEntierRoute("blockgoudron_semi_diag_c_bj");
        blockgoudron_double_h_semi_diag_coin_bj = new BlockEntierRoute("blockgoudron_double_h_semi_diag_coin_bj");
        blockgoudron_double_semi_diag_coin_bj = new BlockEntierRoute("blockgoudron_double_semi_diag_coin_bj");
        blockgoudron_entier_semi_diag_coin_bj = new BlockEntierRoute("blockgoudron_entier_semi_diag_coin_bj");
        blockgoudron_fleche_bj = new BlockEntierRoute("blockgoudron_fleche_bj");
        blockgoudron_fleche_d_bj = new BlockEntierRoute("blockgoudron_fleche_d_bj");
        blockgoudron_fleche_g_bj = new BlockEntierRoute("blockgoudron_fleche_g_bj");
        blockgoudron_passage_p_bj = new BlockEntierRoute("blockgoudron_passage_p_bj");
        blockgoudron_passage_p_ext_bj = new BlockEntierRoute("blockgoudron_passage_p_ext_bj");
        blockgoudron_semi_diag_bj = new BlockEntierRoute("blockgoudron_semi_diag_bj");
        blockgoudron_semi_diag_coin_bj = new BlockEntierRoute("blockgoudron_semi_diag_coin_bj");
        blockgoudron_semi_diag_d_bj = new BlockEntierRoute("blockgoudron_semi_diag_d_bj");
        blockgoudron_o_p_bj = new BlockEntierRoute("blockgoudron_o_p_bj");
        blockgoudron_semi_diag_g_bj = new BlockEntierRoute("blockgoudron_semi_diag_g_bj");
        blockgoudron_s_t_bj = new BlockEntierRoute("blockgoudron_s_t_bj");
        blockgoudron_stop_b_d_bj = new BlockEntierRoute("blockgoudron_stop_b_d_bj");
        blockgoudron_stop_b_g_bj = new BlockEntierRoute("blockgoudron_stop_b_g_bj");
        blockgoudron_stop_b_m_bj = new BlockEntierRoute("blockgoudron_stop_b_m_bj");
        blockgoudron_t_o_bj = new BlockEntierRoute("blockgoudron_t_o_bj");
        blockgoudron_triple_diag_coin_bj = new BlockEntierRoute("blockgoudron_triple_diag_coin_bj");
        blockgoudron_triple_semi_diag_coin_bj = new BlockEntierRoute("blockgoudron_triple_semi_diag_coin_bj");
        blockgoudron_centre_double_bj = new BlockEntierRoute("blockgoudron_centre_double_bj");
        blockgoudron_centre_triple_bj = new BlockEntierRoute("blockgoudron_centre_triple_bj");
        blockgoudron_ext_bj = new BlockEntierRoute("blockgoudron_ext_bj");
        blockgoudron_int_bj = new BlockEntierRoute("blockgoudron_int_bj");
        blockgoudron_centre_quadruple_bj = new BlockEntierRoute("blockgoudron_centre_quadruple_bj");

        slabgoudron_centre_cote_bj = new BlockSlabRoute("slabgoudron_centre_cote_bj");
        slabgoudron_cote_bj = new BlockSlabRoute("slabgoudron_cote_bj");
        slabgoudron_cote_centre_plein_bj = new BlockSlabRoute("slabgoudron_cote_centre_plein_bj");
        slabgoudron_cote_diag_d_bj = new BlockSlabRoute("slabgoudron_cote_diag_d_bj");
        slabgoudron_centre_bj = new BlockSlabRoute("slabgoudron_centre_bj");
        slabgoudron_cote_diag_g_bj = new BlockSlabRoute("slabgoudron_cote_diag_g_bj");
        slabgoudron_cote_g_plein_bj = new BlockSlabRoute("slabgoudron_cote_g_plein_bj");
        slabgoudron_cote_g_plein_bis_bj = new BlockSlabRoute("slabgoudron_cote_g_plein_bis_bj");
        slabgoudron_double_cote_centre_plein_bj = new BlockSlabRoute("slabgoudron_double_cote_centre_plein_bj");
        slabgoudron_double_diag_coin_bj = new BlockSlabRoute("slabgoudron_double_diag_coin_bj");
        slabgoudron_semi_diag_c_bj = new BlockSlabRoute("slabgoudron_semi_diag_c_bj");
        slabgoudron_double_h_semi_diag_coin_bj = new BlockSlabRoute("slabgoudron_double_h_semi_diag_coin_bj");
        slabgoudron_double_semi_diag_coin_bj = new BlockSlabRoute("slabgoudron_double_semi_diag_coin_bj");
        slabgoudron_entier_semi_diag_coin_bj = new BlockSlabRoute("slabgoudron_entier_semi_diag_coin_bj");
        slabgoudron_fleche_bj = new BlockSlabRoute("slabgoudron_fleche_bj");
        slabgoudron_fleche_d_bj = new BlockSlabRoute("slabgoudron_fleche_d_bj");
        slabgoudron_fleche_g_bj = new BlockSlabRoute("slabgoudron_fleche_g_bj");
        slabgoudron_passage_p_bj = new BlockSlabRoute("slabgoudron_passage_p_bj");
        slabgoudron_passage_p_ext_bj = new BlockSlabRoute("slabgoudron_passage_p_ext_bj");
        slabgoudron_semi_diag_bj = new BlockSlabRoute("slabgoudron_semi_diag_bj");
        slabgoudron_semi_diag_coin_bj = new BlockSlabRoute("slabgoudron_semi_diag_coin_bj");
        slabgoudron_semi_diag_d_bj = new BlockSlabRoute("slabgoudron_semi_diag_d_bj");
        slabgoudron_o_p_bj = new BlockSlabRoute("slabgoudron_o_p_bj");
        slabgoudron_semi_diag_g_bj = new BlockSlabRoute("slabgoudron_semi_diag_g_bj");
        slabgoudron_s_t_bj = new BlockSlabRoute("slabgoudron_s_t_bj");
        slabgoudron_stop_b_d_bj = new BlockSlabRoute("slabgoudron_stop_b_d_bj");
        slabgoudron_stop_b_g_bj = new BlockSlabRoute("slabgoudron_stop_b_g_bj");
        slabgoudron_stop_b_m_bj = new BlockSlabRoute("slabgoudron_stop_b_m_bj");
        slabgoudron_t_o_bj = new BlockSlabRoute("slabgoudron_t_o_bj");
        slabgoudron_triple_diag_coin_bj = new BlockSlabRoute("slabgoudron_triple_diag_coin_bj");
        slabgoudron_triple_semi_diag_coin_bj = new BlockSlabRoute("slabgoudron_triple_semi_diag_coin_bj");
        slabgoudron_centre_double_bj = new BlockSlabRoute("slabgoudron_centre_double_bj");
        slabgoudron_centre_triple_bj = new BlockSlabRoute("slabgoudron_centre_triple_bj");
        slabgoudron_ext_bj = new BlockSlabRoute("slabgoudron_ext_bj");
        slabgoudron_int_bj = new BlockSlabRoute("slabgoudron_int_bj");
        slabgoudron_centre_quadruple_bj = new BlockSlabRoute("slabgoudron_centre_quadruple_bj");

        //---------------------------------------------------------------------------------------------------------------
        
        weed_crop = new BlockCropWeed();
        bulbe_crop = new BlockCropBulbe();
        fraise_crop = new BlockCropFraise();
        poireaux_crop = new BlockCropPoireaux("poireaux_crop");
        oignons_crop = new BlockCropOignons("oignons_crop");
        oignons_rouge_crop = new BlockCropOignonsRouge("oignons_rouge_crop");
        salade_crop = new BlockCropSalade("salade_crop");
        choux_rouge_crop = new BlockCropChouxRouge("choux_rouge_crop");
        coca_crop = new BlockCropCoca();
        mais_crop_bottom = new BlockCropMaisBottom("mais_crop_bottom");
        mais_crop_top = new BlockCropMaisTop("mais_crop_top");
        vigne_crop_bottom = new BlockCropVigneBottom("vigne_crop_bottom");
        vigne_crop_top = new BlockCropVigneTop("vigne_crop_top");
        tomate_crop_bottom = new BlockCropTomateBottom("tomate_crop_bottom");
        tomate_crop_top = new BlockCropTomateTop("tomate_crop_top");

        b6 = new BlockFluidB6("b6", ModFluids.b6, Material.WATER).setCreativeTab(universiaMod.creativeTab);
        essence = new BlockFluidEssence("essence", ModFluids.essence, Material.WATER).setCreativeTab(universiaMod.creativeTab);
        encre = new BlockFluidEncre("encre", ModFluids.encre, Material.WATER).setCreativeTab(universiaMod.creativeTab);
        encre_magenta = new BlockFluidEncre("encre_magenta", ModFluids.encre_magenta, Material.WATER).setCreativeTab(universiaMod.creativeTab);
        encre_jaune = new BlockFluidEncre("encre_jaune", ModFluids.encre_jaune, Material.WATER).setCreativeTab(universiaMod.creativeTab);
        encre_cyan = new BlockFluidEncre("encre_cyan", ModFluids.encre_cyan, Material.WATER).setCreativeTab(universiaMod.creativeTab);
        fluoroantimonique = new BlockFluidFluoroantimonique("fluoroantimonique", ModFluids.fluoroantimonique, Material.WATER).setCreativeTab(universiaMod.creativeTab);
        
        ore_torbenite = new BlockOres(MapColor.STONE).setUnlocalizedName("ore_torbenite").setRegistryName("ore_torbenite").setCreativeTab(universiaMod.creativeTab);
        saphir_ore = new BlockOres(MapColor.STONE).setUnlocalizedName("saphir_ore").setRegistryName("saphir_ore").setCreativeTab(universiaMod.creativeTab);
        rubis_ore = new BlockOres(MapColor.STONE).setUnlocalizedName("rubis_ore").setRegistryName("rubis_ore").setCreativeTab(universiaMod.creativeTab);
        amethyst_ore = new BlockOres(MapColor.STONE).setUnlocalizedName("amethyst_ore").setRegistryName("amethyst_ore").setCreativeTab(universiaMod.creativeTab);
        topaz_ore = new BlockOres(MapColor.STONE).setUnlocalizedName("topaz_ore").setRegistryName("topaz_ore").setCreativeTab(universiaMod.creativeTab);
        kunzite_ore = new BlockOres(MapColor.STONE).setUnlocalizedName("kunzite_ore").setRegistryName("kunzite_ore").setCreativeTab(universiaMod.creativeTab);
        
        saphir_block = new BlockMinerais("saphir_block");
        rubis_block = new BlockMinerais("rubis_block");
        amethyst_block = new BlockMinerais("amethyst_block");
        topaz_block = new BlockMinerais("topaz_block");
        kunzite_block = new BlockMinerais("kunzite_block");
        or_bleu_block = new BlockMinerais("or_bleu_block");
        or_noire_block = new BlockMinerais("or_noire_block");
        or_rouge_block = new BlockMinerais("or_rouge_block");
        
        flint_stone = new Block(Material.ROCK).setUnlocalizedName("flint_stone").setRegistryName("flint_stone").setCreativeTab(universiaMod.creativeTab);

        bar = new BlockBar("bar");

        panneau_carre_inv0 = new BlockPanneauDanger("panneau_carre_inv0");
        panneau_carre_inv1 = new BlockPanneauDanger("panneau_carre_inv1");
        panneau_stop = new BlockPanneauDanger("panneau_stop");
        panneau_tri_inv = new BlockPanneauDanger("panneau_tri_inv");

        panneau_danger0 = new BlockPanneauDanger("panneau_danger0");
        panneau_danger1 = new BlockPanneauDanger("panneau_danger1");
        panneau_danger2 = new BlockPanneauDanger("panneau_danger2");
        panneau_danger3 = new BlockPanneauDanger("panneau_danger3");
        panneau_danger4 = new BlockPanneauDanger("panneau_danger4");
        panneau_danger5 = new BlockPanneauDanger("panneau_danger5");
        panneau_danger6 = new BlockPanneauDanger("panneau_danger6");
        panneau_danger7 = new BlockPanneauDanger("panneau_danger7");
        panneau_danger8 = new BlockPanneauDanger("panneau_danger8");
        panneau_danger9 = new BlockPanneauDanger("panneau_danger9");
        panneau_danger10 = new BlockPanneauDanger("panneau_danger10");
        panneau_danger11 = new BlockPanneauDanger("panneau_danger11");
        panneau_danger12 = new BlockPanneauDanger("panneau_danger12");
        panneau_danger13 = new BlockPanneauDanger("panneau_danger13");
        panneau_danger14 = new BlockPanneauDanger("panneau_danger14");
        panneau_danger15 = new BlockPanneauDanger("panneau_danger15");
        panneau_danger16 = new BlockPanneauDanger("panneau_danger16");
        panneau_danger17 = new BlockPanneauDanger("panneau_danger17");

        panneau_carre0 = new BlockPanneauDanger("panneau_carre0");
        panneau_carre1 = new BlockPanneauDanger("panneau_carre1");

        panneau_rond0 = new BlockPanneauDanger("panneau_rond0");
        panneau_rond1 = new BlockPanneauDanger("panneau_rond1");
        panneau_rond2 = new BlockPanneauDanger("panneau_rond2");
        panneau_rond3 = new BlockPanneauDanger("panneau_rond3");
        panneau_rond4 = new BlockPanneauDanger("panneau_rond4");
        panneau_rond5 = new BlockPanneauDanger("panneau_rond5");

        panonceau0 = new BlockPanneauDanger("panonceau0");
        grand_panonceau0 = new BlockPanneauDanger("grand_panonceau0");
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event){

        TileEntityHandler.registerTileEntities();

        event.getRegistry().registerAll(goudron, goudron_centre_b, goudron_cote_b, goudron_cote_centre_plein_b, goudron_cote_diag_d_b, goudron_cote_diag_g_b,
                goudron_cote_g_plein_b, goudron_cote_g_plein_bis_b, goudron_double_cote_centre_plein_b, goudron_double_diag_coin_b, goudron_semi_diag_c_b,
                goudron_double_h_semi_diag_coin_b, goudron_double_semi_diag_coin_b, goudron_entier_semi_diag_coin_b, goudron_fleche_b, goudron_fleche_d_b,
                goudron_fleche_g_b, goudron_passage_p_b, goudron_semi_diag_b, goudron_semi_diag_coin_b, goudron_semi_diag_d_b, goudron_o_p_b,
                goudron_semi_diag_g_b, goudron_s_t_b, goudron_stop_b_d_b, goudron_stop_b_g_b, goudron_stop_b_m_b, goudron_t_o_b, goudron_triple_diag_coin_b,
                goudron_triple_semi_diag_coin_b, goudron_centre_double_b, goudron_centre_triple_b, goudron_ext_b, goudron_int_b, goudron_centre_quadruple_b, egout,
                opaque_noire, ardoise, poudre_vierge, poudre_weed, poudre_coca, poudre_bulbe, weed_crop, glass_blanc, glass_noire, acid, ore_torbenite, flint_stone, bulbe_crop, crepi_BR,
                crepi_BRU, crepi, futur_br, futur_bru, futur, quarpi_br, quarpi_bru, quarpi, oak_br, oak_bru, big_oak_br, big_oak_bru, spruce_br, spruce_bru,
                acacia_br, acacia_bru, birch_br, birch_bru, jungle_br, jungle_bru, bar, panneau_danger0, panneau_danger1, panneau_danger2, panneau_danger3,
                panneau_danger4, panneau_danger5, panneau_danger6, panneau_danger7, panneau_danger8, panneau_danger9, panneau_danger10, panneau_danger11,
                panneau_danger12, panneau_danger13, panneau_danger14, panneau_danger15, panneau_danger16, panneau_danger17, panneau_carre0, panneau_carre1,
                panneau_carre_inv0, panneau_carre_inv1, panneau_stop, panneau_tri_inv, panneau_rond0, glass, panonceau0, grand_panonceau0, goudron_centre_cote_b,
                panneau_rond1, panneau_rond2, panneau_rond3, panneau_rond4, panneau_rond5, lampe, bois_farm, fraise_crop, poireaux_crop, oignons_crop, oignons_rouge_crop, salade_crop, choux_rouge_crop, pommier, blockgoudron,
                blockgoudron_centre_b, blockgoudron_cote_b, blockgoudron_cote_centre_plein_b, blockgoudron_cote_diag_d_b, blockgoudron_cote_diag_g_b,
                blockgoudron_cote_g_plein_b, blockgoudron_cote_g_plein_bis_b, blockgoudron_double_cote_centre_plein_b, blockgoudron_double_diag_coin_b, blockgoudron_semi_diag_c_b,
                blockgoudron_double_h_semi_diag_coin_b, blockgoudron_double_semi_diag_coin_b, blockgoudron_entier_semi_diag_coin_b, blockgoudron_fleche_b, blockgoudron_fleche_d_b,
                blockgoudron_fleche_g_b, blockgoudron_passage_p_b, blockgoudron_semi_diag_b, blockgoudron_semi_diag_coin_b, blockgoudron_semi_diag_d_b, blockgoudron_o_p_b,
                blockgoudron_semi_diag_g_b, blockgoudron_s_t_b, blockgoudron_stop_b_d_b, blockgoudron_stop_b_g_b, blockgoudron_stop_b_m_b, blockgoudron_t_o_b, blockgoudron_triple_diag_coin_b,
                blockgoudron_triple_semi_diag_coin_b, blockgoudron_centre_double_b, blockgoudron_centre_triple_b, blockgoudron_ext_b, blockgoudron_int_b, blockgoudron_centre_quadruple_b,
                blockgoudron_centre_cote_b, slabgoudron, slabgoudron_centre_b, slabgoudron_cote_b, slabgoudron_cote_centre_plein_b, slabgoudron_cote_diag_d_b, slabgoudron_cote_diag_g_b,
                slabgoudron_cote_g_plein_b, slabgoudron_cote_g_plein_bis_b, slabgoudron_double_cote_centre_plein_b, slabgoudron_double_diag_coin_b, slabgoudron_semi_diag_c_b,
                slabgoudron_double_h_semi_diag_coin_b, slabgoudron_double_semi_diag_coin_b, slabgoudron_entier_semi_diag_coin_b, slabgoudron_fleche_b, slabgoudron_fleche_d_b,
                slabgoudron_fleche_g_b, slabgoudron_passage_p_b, slabgoudron_semi_diag_b, slabgoudron_semi_diag_coin_b, slabgoudron_semi_diag_d_b, slabgoudron_o_p_b,
                slabgoudron_semi_diag_g_b, slabgoudron_s_t_b, slabgoudron_stop_b_d_b, slabgoudron_stop_b_g_b, slabgoudron_stop_b_m_b, slabgoudron_t_o_b, slabgoudron_triple_diag_coin_b,
                slabgoudron_triple_semi_diag_coin_b, slabgoudron_centre_double_b, slabgoudron_centre_triple_b, slabgoudron_ext_b, slabgoudron_int_b, slabgoudron_centre_quadruple_b, 
                slabgoudron_centre_cote_b, goudron_centre_bj, goudron_cote_bj, goudron_cote_centre_plein_bj, goudron_cote_diag_d_bj, goudron_cote_diag_g_bj,
                goudron_cote_g_plein_bj, goudron_cote_g_plein_bis_bj, goudron_double_cote_centre_plein_bj, goudron_double_diag_coin_bj, goudron_semi_diag_c_bj,
                goudron_double_h_semi_diag_coin_bj, goudron_double_semi_diag_coin_bj, goudron_entier_semi_diag_coin_bj, goudron_fleche_bj, goudron_fleche_d_bj,
                goudron_fleche_g_bj, goudron_passage_p_bj, goudron_semi_diag_bj, goudron_semi_diag_coin_bj, goudron_semi_diag_d_bj, goudron_o_p_bj,
                goudron_semi_diag_g_bj, goudron_s_t_bj, goudron_stop_b_d_bj, goudron_stop_b_g_bj, goudron_stop_b_m_bj, goudron_t_o_bj, goudron_triple_diag_coin_bj,
                goudron_triple_semi_diag_coin_bj, goudron_centre_double_bj, goudron_centre_triple_bj, goudron_ext_bj, goudron_int_bj, goudron_centre_quadruple_bj,
                blockgoudron_centre_bj, blockgoudron_cote_bj, blockgoudron_cote_centre_plein_bj, blockgoudron_cote_diag_d_bj, blockgoudron_cote_diag_g_bj,
                blockgoudron_cote_g_plein_bj, blockgoudron_cote_g_plein_bis_bj, blockgoudron_double_cote_centre_plein_bj, blockgoudron_double_diag_coin_bj, blockgoudron_semi_diag_c_bj,
                blockgoudron_double_h_semi_diag_coin_bj, blockgoudron_double_semi_diag_coin_bj, blockgoudron_entier_semi_diag_coin_bj, blockgoudron_fleche_bj, blockgoudron_fleche_d_bj,
                blockgoudron_fleche_g_bj, blockgoudron_passage_p_bj, blockgoudron_semi_diag_bj, blockgoudron_semi_diag_coin_bj, blockgoudron_semi_diag_d_bj, blockgoudron_o_p_bj,
                blockgoudron_semi_diag_g_bj, blockgoudron_s_t_bj, blockgoudron_stop_b_d_bj, blockgoudron_stop_b_g_bj, blockgoudron_stop_b_m_bj, blockgoudron_t_o_bj, blockgoudron_triple_diag_coin_bj,
                blockgoudron_triple_semi_diag_coin_bj, blockgoudron_centre_double_bj, blockgoudron_centre_triple_bj, blockgoudron_ext_bj, blockgoudron_int_bj, blockgoudron_centre_quadruple_bj,
                blockgoudron_centre_cote_bj, slabgoudron_centre_bj, slabgoudron_cote_bj, slabgoudron_cote_centre_plein_bj, slabgoudron_cote_diag_d_bj, slabgoudron_cote_diag_g_bj,
                slabgoudron_cote_g_plein_bj, slabgoudron_cote_g_plein_bis_bj, slabgoudron_double_cote_centre_plein_bj, slabgoudron_double_diag_coin_bj, slabgoudron_semi_diag_c_bj,
                slabgoudron_double_h_semi_diag_coin_bj, slabgoudron_double_semi_diag_coin_bj, slabgoudron_entier_semi_diag_coin_bj, slabgoudron_fleche_bj, slabgoudron_fleche_d_bj,
                slabgoudron_fleche_g_bj, slabgoudron_passage_p_bj, slabgoudron_semi_diag_bj, slabgoudron_semi_diag_coin_bj, slabgoudron_semi_diag_d_bj, slabgoudron_o_p_bj,
                slabgoudron_semi_diag_g_bj, slabgoudron_s_t_bj, slabgoudron_stop_b_d_bj, slabgoudron_stop_b_g_bj, slabgoudron_stop_b_m_bj, slabgoudron_t_o_bj, slabgoudron_triple_diag_coin_bj,
                slabgoudron_triple_semi_diag_coin_bj, slabgoudron_centre_double_bj, slabgoudron_centre_triple_bj, slabgoudron_ext_bj, slabgoudron_int_bj, slabgoudron_centre_quadruple_bj,
                slabgoudron_centre_cote_bj, goudron_passage_p_ext_b, blockgoudron_passage_p_ext_b, slabgoudron_passage_p_ext_b, goudron_passage_p_ext_bj, blockgoudron_passage_p_ext_bj, 
                slabgoudron_passage_p_ext_bj, infrarouge, table_assemblage, centrifugeuse, coca_crop, mais_crop_bottom, mais_crop_top, vigne_crop_bottom, vigne_crop_top, tomate_crop_bottom, tomate_crop_top, drog_box, drog_box_weed, drog_box_coca, drog_box_bulbe, sechoir, generateur, conteneurenergie, 
                assemblage_arme, assemblage_munition, b6, essence, encre, encre_magenta, encre_cyan, encre_jaune, imprimante, fluoroantimonique, block_poudre_fer, block_poudre_or, block_poudre_or_bleu, 
                block_poudre_or_rouge, block_poudre_or_noire, table_chimie, saphir_ore, rubis_ore, amethyst_ore, topaz_ore, kunzite_ore, saphir_block, rubis_block, amethyst_block, topaz_block, 
                kunzite_block, or_bleu_block, or_rouge_block, or_noire_block, full_stone_slab, gold_stonebrick, iron_stonebrick, topaz_stonebrick, amethyst_stonebrick, kunzite_stonebrick, saphir_stonebrick, rubis_stonebrick,
                or_bleu_stonebrick, or_rouge_stonebrick, or_noire_stonebrick, gold_planks, iron_planks, topaz_planks, amethyst_planks, kunzite_planks, saphir_planks, rubis_planks,
                or_bleu_planks, or_rouge_planks, or_noire_planks, drill, tami_vide, tami_sand, tami_dirt, tami_cobble, tami_redsand, tami_soulsand, tami_goldpowder, tami_ironpowder, tami_blackgoldpowder, tami_redgoldpowder, tami_bluegoldpowder, 
                tami_gravel, gold_stonebrick_stairs, iron_stonebrick_stairs, topaz_stonebrick_stairs, amethyst_stonebrick_stairs, kunzite_stonebrick_stairs, saphir_stonebrick_stairs, rubis_stonebrick_stairs,
                or_bleu_stonebrick_stairs, or_rouge_stonebrick_stairs, or_noire_stonebrick_stairs, gold_planks_stairs, iron_planks_stairs, topaz_planks_stairs, amethyst_planks_stairs, kunzite_planks_stairs, saphir_planks_stairs, rubis_planks_stairs,
                or_bleu_planks_stairs, or_rouge_planks_stairs, or_noire_planks_stairs, gold_stonebrick_wall, iron_stonebrick_wall, topaz_stonebrick_wall, amethyst_stonebrick_wall, kunzite_stonebrick_wall, saphir_stonebrick_wall, rubis_stonebrick_wall,
                or_bleu_stonebrick_wall, or_rouge_stonebrick_wall, or_noire_stonebrick_wall, gold_planks_wall, iron_planks_wall, topaz_planks_wall, amethyst_planks_wall, kunzite_planks_wall, saphir_planks_wall, rubis_planks_wall,
                or_bleu_planks_wall, or_rouge_planks_wall, or_noire_planks_wall, gold_stonebrick_slab, iron_stonebrick_slab, topaz_stonebrick_slab, amethyst_stonebrick_slab, kunzite_stonebrick_slab, saphir_stonebrick_slab, rubis_stonebrick_slab,
                or_bleu_stonebrick_slab, or_rouge_stonebrick_slab, or_noire_stonebrick_slab, gold_planks_slab, iron_planks_slab, topaz_planks_slab, amethyst_planks_slab, kunzite_planks_slab, saphir_planks_slab, rubis_planks_slab,
                or_bleu_planks_slab, or_rouge_planks_slab, or_noire_planks_slab, gold_stonebrick_double_slab, iron_stonebrick_double_slab, topaz_stonebrick_double_slab, amethyst_stonebrick_double_slab, kunzite_stonebrick_double_slab, saphir_stonebrick_double_slab, rubis_stonebrick_double_slab,
                or_bleu_stonebrick_double_slab, or_rouge_stonebrick_double_slab, or_noire_stonebrick_double_slab, gold_planks_double_slab, iron_planks_double_slab, topaz_planks_double_slab, amethyst_planks_double_slab, kunzite_planks_double_slab, saphir_planks_double_slab, rubis_planks_double_slab,
                or_bleu_planks_double_slab, or_rouge_planks_double_slab, or_noire_planks_double_slab, planche, planche_tomate, planche_mais, planche_poireau, planche_salade, planche_choux_rouge, planche_oignon, planche_oignon_rouge, 
                planche_beef, planche_chicken, planche_coad, planche_mutton, planche_pork, planche_rabbit, planche_salmon, planche_bread, ramp);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        
        event.getRegistry().registerAll(new ItemBlock(full_stone_slab).setRegistryName(full_stone_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(gold_stonebrick).setRegistryName(gold_stonebrick.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(iron_stonebrick).setRegistryName(iron_stonebrick.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(topaz_stonebrick).setRegistryName(topaz_stonebrick.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(amethyst_stonebrick).setRegistryName(amethyst_stonebrick.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(kunzite_stonebrick).setRegistryName(kunzite_stonebrick.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(saphir_stonebrick).setRegistryName(saphir_stonebrick.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(rubis_stonebrick).setRegistryName(rubis_stonebrick.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_bleu_stonebrick).setRegistryName(or_bleu_stonebrick.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_rouge_stonebrick).setRegistryName(or_rouge_stonebrick.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_noire_stonebrick).setRegistryName(or_noire_stonebrick.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(gold_planks).setRegistryName(gold_planks.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(iron_planks).setRegistryName(iron_planks.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(topaz_planks).setRegistryName(topaz_planks.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(amethyst_planks).setRegistryName(amethyst_planks.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(kunzite_planks).setRegistryName(kunzite_planks.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(saphir_planks).setRegistryName(saphir_planks.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(rubis_planks).setRegistryName(rubis_planks.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_bleu_planks).setRegistryName(or_bleu_planks.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_rouge_planks).setRegistryName(or_rouge_planks.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_noire_planks).setRegistryName(or_noire_planks.getRegistryName()));

        event.getRegistry().registerAll(new ItemBlock(gold_stonebrick_stairs).setRegistryName(gold_stonebrick_stairs.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(iron_stonebrick_stairs).setRegistryName(iron_stonebrick_stairs.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(topaz_stonebrick_stairs).setRegistryName(topaz_stonebrick_stairs.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(amethyst_stonebrick_stairs).setRegistryName(amethyst_stonebrick_stairs.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(kunzite_stonebrick_stairs).setRegistryName(kunzite_stonebrick_stairs.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(saphir_stonebrick_stairs).setRegistryName(saphir_stonebrick_stairs.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(rubis_stonebrick_stairs).setRegistryName(rubis_stonebrick_stairs.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_bleu_stonebrick_stairs).setRegistryName(or_bleu_stonebrick_stairs.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_rouge_stonebrick_stairs).setRegistryName(or_rouge_stonebrick_stairs.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_noire_stonebrick_stairs).setRegistryName(or_noire_stonebrick_stairs.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(gold_planks_stairs).setRegistryName(gold_planks_stairs.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(iron_planks_stairs).setRegistryName(iron_planks_stairs.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(topaz_planks_stairs).setRegistryName(topaz_planks_stairs.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(amethyst_planks_stairs).setRegistryName(amethyst_planks_stairs.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(kunzite_planks_stairs).setRegistryName(kunzite_planks_stairs.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(saphir_planks_stairs).setRegistryName(saphir_planks_stairs.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(rubis_planks_stairs).setRegistryName(rubis_planks_stairs.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_bleu_planks_stairs).setRegistryName(or_bleu_planks_stairs.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_rouge_planks_stairs).setRegistryName(or_rouge_planks_stairs.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_noire_planks_stairs).setRegistryName(or_noire_planks_stairs.getRegistryName()));
        
        event.getRegistry().registerAll(new ItemBlock(gold_stonebrick_wall).setRegistryName(gold_stonebrick_wall.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(iron_stonebrick_wall).setRegistryName(iron_stonebrick_wall.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(topaz_stonebrick_wall).setRegistryName(topaz_stonebrick_wall.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(amethyst_stonebrick_wall).setRegistryName(amethyst_stonebrick_wall.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(kunzite_stonebrick_wall).setRegistryName(kunzite_stonebrick_wall.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(saphir_stonebrick_wall).setRegistryName(saphir_stonebrick_wall.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(rubis_stonebrick_wall).setRegistryName(rubis_stonebrick_wall.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_bleu_stonebrick_wall).setRegistryName(or_bleu_stonebrick_wall.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_rouge_stonebrick_wall).setRegistryName(or_rouge_stonebrick_wall.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_noire_stonebrick_wall).setRegistryName(or_noire_stonebrick_wall.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(gold_planks_wall).setRegistryName(gold_planks_wall.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(iron_planks_wall).setRegistryName(iron_planks_wall.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(topaz_planks_wall).setRegistryName(topaz_planks_wall.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(amethyst_planks_wall).setRegistryName(amethyst_planks_wall.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(kunzite_planks_wall).setRegistryName(kunzite_planks_wall.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(saphir_planks_wall).setRegistryName(saphir_planks_wall.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(rubis_planks_wall).setRegistryName(rubis_planks_wall.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_bleu_planks_wall).setRegistryName(or_bleu_planks_wall.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_rouge_planks_wall).setRegistryName(or_rouge_planks_wall.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_noire_planks_wall).setRegistryName(or_noire_planks_wall.getRegistryName()));

        event.getRegistry().registerAll(new ItemSlab((Block)gold_stonebrick_slab, (BlockSlab)gold_stonebrick_slab, (BlockSlab)gold_stonebrick_double_slab).setRegistryName(gold_stonebrick_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemSlab((Block)iron_stonebrick_slab, (BlockSlab)iron_stonebrick_slab, (BlockSlab)iron_stonebrick_double_slab).setRegistryName(iron_stonebrick_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemSlab((Block)topaz_stonebrick_slab, (BlockSlab)topaz_stonebrick_slab, (BlockSlab)topaz_stonebrick_double_slab).setRegistryName(topaz_stonebrick_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemSlab((Block)amethyst_stonebrick_slab, (BlockSlab)amethyst_stonebrick_slab, (BlockSlab)amethyst_stonebrick_double_slab).setRegistryName(amethyst_stonebrick_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemSlab((Block)kunzite_stonebrick_slab, (BlockSlab)kunzite_stonebrick_slab, (BlockSlab)kunzite_stonebrick_double_slab).setRegistryName(kunzite_stonebrick_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemSlab((Block)saphir_stonebrick_slab, (BlockSlab)saphir_stonebrick_slab, (BlockSlab)saphir_stonebrick_double_slab).setRegistryName(saphir_stonebrick_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemSlab((Block)rubis_stonebrick_slab, (BlockSlab)rubis_stonebrick_slab, (BlockSlab)rubis_stonebrick_double_slab).setRegistryName(rubis_stonebrick_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemSlab((Block)or_bleu_stonebrick_slab, (BlockSlab)or_bleu_stonebrick_slab, (BlockSlab)or_bleu_stonebrick_double_slab).setRegistryName(or_bleu_stonebrick_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemSlab((Block)or_rouge_stonebrick_slab, (BlockSlab)or_rouge_stonebrick_slab, (BlockSlab)or_rouge_stonebrick_double_slab).setRegistryName(or_rouge_stonebrick_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemSlab((Block)or_noire_stonebrick_slab, (BlockSlab)or_noire_stonebrick_slab, (BlockSlab)or_noire_stonebrick_double_slab).setRegistryName(or_noire_stonebrick_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemSlab((Block)gold_planks_slab, (BlockSlab)gold_planks_slab, (BlockSlab)gold_planks_double_slab).setRegistryName(gold_planks_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemSlab((Block)iron_planks_slab, (BlockSlab)iron_planks_slab, (BlockSlab)iron_planks_double_slab).setRegistryName(iron_planks_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemSlab((Block)topaz_planks_slab, (BlockSlab)topaz_planks_slab, (BlockSlab)topaz_planks_double_slab).setRegistryName(topaz_planks_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemSlab((Block)amethyst_planks_slab, (BlockSlab)amethyst_planks_slab, (BlockSlab)amethyst_planks_double_slab).setRegistryName(amethyst_planks_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemSlab((Block)kunzite_planks_slab, (BlockSlab)kunzite_planks_slab, (BlockSlab)kunzite_planks_double_slab).setRegistryName(kunzite_planks_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemSlab((Block)saphir_planks_slab, (BlockSlab)saphir_planks_slab, (BlockSlab)saphir_planks_double_slab).setRegistryName(saphir_planks_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemSlab((Block)rubis_planks_slab, (BlockSlab)rubis_planks_slab, (BlockSlab)rubis_planks_double_slab).setRegistryName(rubis_planks_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemSlab((Block)or_bleu_planks_slab, (BlockSlab)or_bleu_planks_slab, (BlockSlab)or_bleu_planks_double_slab).setRegistryName(or_bleu_planks_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemSlab((Block)or_rouge_planks_slab, (BlockSlab)or_rouge_planks_slab, (BlockSlab)or_rouge_planks_double_slab).setRegistryName(or_rouge_planks_slab.getRegistryName()));
        event.getRegistry().registerAll(new ItemSlab((Block)or_noire_planks_slab, (BlockSlab)or_noire_planks_slab, (BlockSlab)or_noire_planks_double_slab).setRegistryName(or_noire_planks_slab.getRegistryName()));
    	
        event.getRegistry().registerAll(new ItemBlock(table_assemblage).setRegistryName(table_assemblage.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(centrifugeuse).setRegistryName(centrifugeuse.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(sechoir).setRegistryName(sechoir.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(generateur).setRegistryName(generateur.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(conteneurenergie).setRegistryName(conteneurenergie.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(assemblage_arme).setRegistryName(assemblage_arme.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(assemblage_munition).setRegistryName(assemblage_munition.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(imprimante).setRegistryName(imprimante.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(table_chimie).setRegistryName(table_chimie.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(drill).setRegistryName(drill.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(tami_vide).setRegistryName(tami_vide.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(tami_sand).setRegistryName(tami_sand.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(tami_gravel).setRegistryName(tami_gravel.getRegistryName()).setMaxStackSize(1)); 
        event.getRegistry().registerAll(new ItemBlock(tami_dirt).setRegistryName(tami_dirt.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(tami_cobble).setRegistryName(tami_cobble.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(tami_redsand).setRegistryName(tami_redsand.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(tami_soulsand).setRegistryName(tami_soulsand.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(tami_goldpowder).setRegistryName(tami_goldpowder.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(tami_ironpowder).setRegistryName(tami_ironpowder.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(tami_blackgoldpowder).setRegistryName(tami_blackgoldpowder.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(tami_redgoldpowder).setRegistryName(tami_redgoldpowder.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(tami_bluegoldpowder).setRegistryName(tami_bluegoldpowder.getRegistryName()).setMaxStackSize(1));

        event.getRegistry().registerAll(new ItemBlock(egout).setRegistryName(egout.getRegistryName()));

        event.getRegistry().registerAll(new ItemBlock(goudron).setRegistryName(goudron.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_centre_cote_b).setRegistryName(goudron_centre_cote_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_centre_b).setRegistryName(goudron_centre_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_cote_b).setRegistryName(goudron_cote_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_cote_centre_plein_b).setRegistryName(goudron_cote_centre_plein_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_cote_diag_d_b).setRegistryName(goudron_cote_diag_d_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_cote_diag_g_b).setRegistryName(goudron_cote_diag_g_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_cote_g_plein_b).setRegistryName(goudron_cote_g_plein_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_cote_g_plein_bis_b).setRegistryName(goudron_cote_g_plein_bis_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_double_cote_centre_plein_b).setRegistryName(goudron_double_cote_centre_plein_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_double_diag_coin_b).setRegistryName(goudron_double_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_semi_diag_c_b).setRegistryName(goudron_semi_diag_c_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_double_h_semi_diag_coin_b).setRegistryName(goudron_double_h_semi_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_double_semi_diag_coin_b).setRegistryName(goudron_double_semi_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_entier_semi_diag_coin_b).setRegistryName(goudron_entier_semi_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_fleche_b).setRegistryName(goudron_fleche_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_fleche_d_b).setRegistryName(goudron_fleche_d_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_fleche_g_b).setRegistryName(goudron_fleche_g_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_passage_p_b).setRegistryName(goudron_passage_p_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_passage_p_ext_b).setRegistryName(goudron_passage_p_ext_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_semi_diag_b).setRegistryName(goudron_semi_diag_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_semi_diag_coin_b).setRegistryName(goudron_semi_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_semi_diag_d_b).setRegistryName(goudron_semi_diag_d_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_o_p_b).setRegistryName(goudron_o_p_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_semi_diag_g_b).setRegistryName(goudron_semi_diag_g_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_s_t_b).setRegistryName(goudron_s_t_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_stop_b_d_b).setRegistryName(goudron_stop_b_d_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_stop_b_g_b).setRegistryName(goudron_stop_b_g_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_stop_b_m_b).setRegistryName(goudron_stop_b_m_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_t_o_b).setRegistryName(goudron_t_o_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_triple_diag_coin_b).setRegistryName(goudron_triple_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_triple_semi_diag_coin_b).setRegistryName(goudron_triple_semi_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_centre_double_b).setRegistryName(goudron_centre_double_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_centre_triple_b).setRegistryName(goudron_centre_triple_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_ext_b).setRegistryName(goudron_ext_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_int_b).setRegistryName(goudron_int_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_centre_quadruple_b).setRegistryName(goudron_centre_quadruple_b.getRegistryName()));

        event.getRegistry().registerAll(new ItemBlock(blockgoudron).setRegistryName(blockgoudron.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_centre_cote_b).setRegistryName(blockgoudron_centre_cote_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_centre_b).setRegistryName(blockgoudron_centre_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_cote_b).setRegistryName(blockgoudron_cote_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_cote_centre_plein_b).setRegistryName(blockgoudron_cote_centre_plein_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_cote_diag_d_b).setRegistryName(blockgoudron_cote_diag_d_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_cote_diag_g_b).setRegistryName(blockgoudron_cote_diag_g_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_cote_g_plein_b).setRegistryName(blockgoudron_cote_g_plein_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_cote_g_plein_bis_b).setRegistryName(blockgoudron_cote_g_plein_bis_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_double_cote_centre_plein_b).setRegistryName(blockgoudron_double_cote_centre_plein_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_double_diag_coin_b).setRegistryName(blockgoudron_double_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_semi_diag_c_b).setRegistryName(blockgoudron_semi_diag_c_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_double_h_semi_diag_coin_b).setRegistryName(blockgoudron_double_h_semi_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_double_semi_diag_coin_b).setRegistryName(blockgoudron_double_semi_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_entier_semi_diag_coin_b).setRegistryName(blockgoudron_entier_semi_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_fleche_b).setRegistryName(blockgoudron_fleche_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_fleche_d_b).setRegistryName(blockgoudron_fleche_d_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_fleche_g_b).setRegistryName(blockgoudron_fleche_g_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_passage_p_b).setRegistryName(blockgoudron_passage_p_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_passage_p_ext_b).setRegistryName(blockgoudron_passage_p_ext_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_semi_diag_b).setRegistryName(blockgoudron_semi_diag_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_semi_diag_coin_b).setRegistryName(blockgoudron_semi_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_semi_diag_d_b).setRegistryName(blockgoudron_semi_diag_d_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_o_p_b).setRegistryName(blockgoudron_o_p_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_semi_diag_g_b).setRegistryName(blockgoudron_semi_diag_g_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_s_t_b).setRegistryName(blockgoudron_s_t_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_stop_b_d_b).setRegistryName(blockgoudron_stop_b_d_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_stop_b_g_b).setRegistryName(blockgoudron_stop_b_g_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_stop_b_m_b).setRegistryName(blockgoudron_stop_b_m_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_t_o_b).setRegistryName(blockgoudron_t_o_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_triple_diag_coin_b).setRegistryName(blockgoudron_triple_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_triple_semi_diag_coin_b).setRegistryName(blockgoudron_triple_semi_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_centre_double_b).setRegistryName(blockgoudron_centre_double_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_centre_triple_b).setRegistryName(blockgoudron_centre_triple_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_ext_b).setRegistryName(blockgoudron_ext_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_int_b).setRegistryName(blockgoudron_int_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_centre_quadruple_b).setRegistryName(blockgoudron_centre_quadruple_b.getRegistryName()));

        event.getRegistry().registerAll(new ItemBlock(slabgoudron).setRegistryName(slabgoudron.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_centre_cote_b).setRegistryName(slabgoudron_centre_cote_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_centre_b).setRegistryName(slabgoudron_centre_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_cote_b).setRegistryName(slabgoudron_cote_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_cote_centre_plein_b).setRegistryName(slabgoudron_cote_centre_plein_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_cote_diag_d_b).setRegistryName(slabgoudron_cote_diag_d_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_cote_diag_g_b).setRegistryName(slabgoudron_cote_diag_g_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_cote_g_plein_b).setRegistryName(slabgoudron_cote_g_plein_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_cote_g_plein_bis_b).setRegistryName(slabgoudron_cote_g_plein_bis_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_double_cote_centre_plein_b).setRegistryName(slabgoudron_double_cote_centre_plein_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_double_diag_coin_b).setRegistryName(slabgoudron_double_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_semi_diag_c_b).setRegistryName(slabgoudron_semi_diag_c_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_double_h_semi_diag_coin_b).setRegistryName(slabgoudron_double_h_semi_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_double_semi_diag_coin_b).setRegistryName(slabgoudron_double_semi_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_entier_semi_diag_coin_b).setRegistryName(slabgoudron_entier_semi_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_fleche_b).setRegistryName(slabgoudron_fleche_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_fleche_d_b).setRegistryName(slabgoudron_fleche_d_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_fleche_g_b).setRegistryName(slabgoudron_fleche_g_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_passage_p_b).setRegistryName(slabgoudron_passage_p_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_passage_p_ext_b).setRegistryName(slabgoudron_passage_p_ext_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_semi_diag_b).setRegistryName(slabgoudron_semi_diag_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_semi_diag_coin_b).setRegistryName(slabgoudron_semi_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_semi_diag_d_b).setRegistryName(slabgoudron_semi_diag_d_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_o_p_b).setRegistryName(slabgoudron_o_p_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_semi_diag_g_b).setRegistryName(slabgoudron_semi_diag_g_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_s_t_b).setRegistryName(slabgoudron_s_t_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_stop_b_d_b).setRegistryName(slabgoudron_stop_b_d_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_stop_b_g_b).setRegistryName(slabgoudron_stop_b_g_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_stop_b_m_b).setRegistryName(slabgoudron_stop_b_m_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_t_o_b).setRegistryName(slabgoudron_t_o_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_triple_diag_coin_b).setRegistryName(slabgoudron_triple_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_triple_semi_diag_coin_b).setRegistryName(slabgoudron_triple_semi_diag_coin_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_centre_double_b).setRegistryName(slabgoudron_centre_double_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_centre_triple_b).setRegistryName(slabgoudron_centre_triple_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_ext_b).setRegistryName(slabgoudron_ext_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_int_b).setRegistryName(slabgoudron_int_b.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_centre_quadruple_b).setRegistryName(slabgoudron_centre_quadruple_b.getRegistryName()));
        
        event.getRegistry().registerAll(new ItemBlock(goudron_centre_cote_bj).setRegistryName(goudron_centre_cote_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_centre_bj).setRegistryName(goudron_centre_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_cote_bj).setRegistryName(goudron_cote_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_cote_centre_plein_bj).setRegistryName(goudron_cote_centre_plein_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_cote_diag_d_bj).setRegistryName(goudron_cote_diag_d_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_cote_diag_g_bj).setRegistryName(goudron_cote_diag_g_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_cote_g_plein_bj).setRegistryName(goudron_cote_g_plein_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_cote_g_plein_bis_bj).setRegistryName(goudron_cote_g_plein_bis_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_double_cote_centre_plein_bj).setRegistryName(goudron_double_cote_centre_plein_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_double_diag_coin_bj).setRegistryName(goudron_double_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_semi_diag_c_bj).setRegistryName(goudron_semi_diag_c_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_double_h_semi_diag_coin_bj).setRegistryName(goudron_double_h_semi_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_double_semi_diag_coin_bj).setRegistryName(goudron_double_semi_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_entier_semi_diag_coin_bj).setRegistryName(goudron_entier_semi_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_fleche_bj).setRegistryName(goudron_fleche_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_fleche_d_bj).setRegistryName(goudron_fleche_d_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_fleche_g_bj).setRegistryName(goudron_fleche_g_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_passage_p_bj).setRegistryName(goudron_passage_p_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_passage_p_ext_bj).setRegistryName(goudron_passage_p_ext_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_semi_diag_bj).setRegistryName(goudron_semi_diag_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_semi_diag_coin_bj).setRegistryName(goudron_semi_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_semi_diag_d_bj).setRegistryName(goudron_semi_diag_d_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_o_p_bj).setRegistryName(goudron_o_p_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_semi_diag_g_bj).setRegistryName(goudron_semi_diag_g_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_s_t_bj).setRegistryName(goudron_s_t_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_stop_b_d_bj).setRegistryName(goudron_stop_b_d_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_stop_b_g_bj).setRegistryName(goudron_stop_b_g_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_stop_b_m_bj).setRegistryName(goudron_stop_b_m_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_t_o_bj).setRegistryName(goudron_t_o_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_triple_diag_coin_bj).setRegistryName(goudron_triple_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_triple_semi_diag_coin_bj).setRegistryName(goudron_triple_semi_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_centre_double_bj).setRegistryName(goudron_centre_double_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_centre_triple_bj).setRegistryName(goudron_centre_triple_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_ext_bj).setRegistryName(goudron_ext_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_int_bj).setRegistryName(goudron_int_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(goudron_centre_quadruple_bj).setRegistryName(goudron_centre_quadruple_bj.getRegistryName()));

        event.getRegistry().registerAll(new ItemBlock(blockgoudron_centre_cote_bj).setRegistryName(blockgoudron_centre_cote_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_centre_bj).setRegistryName(blockgoudron_centre_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_cote_bj).setRegistryName(blockgoudron_cote_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_cote_centre_plein_bj).setRegistryName(blockgoudron_cote_centre_plein_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_cote_diag_d_bj).setRegistryName(blockgoudron_cote_diag_d_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_cote_diag_g_bj).setRegistryName(blockgoudron_cote_diag_g_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_cote_g_plein_bj).setRegistryName(blockgoudron_cote_g_plein_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_cote_g_plein_bis_bj).setRegistryName(blockgoudron_cote_g_plein_bis_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_double_cote_centre_plein_bj).setRegistryName(blockgoudron_double_cote_centre_plein_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_double_diag_coin_bj).setRegistryName(blockgoudron_double_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_semi_diag_c_bj).setRegistryName(blockgoudron_semi_diag_c_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_double_h_semi_diag_coin_bj).setRegistryName(blockgoudron_double_h_semi_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_double_semi_diag_coin_bj).setRegistryName(blockgoudron_double_semi_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_entier_semi_diag_coin_bj).setRegistryName(blockgoudron_entier_semi_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_fleche_bj).setRegistryName(blockgoudron_fleche_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_fleche_d_bj).setRegistryName(blockgoudron_fleche_d_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_fleche_g_bj).setRegistryName(blockgoudron_fleche_g_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_passage_p_bj).setRegistryName(blockgoudron_passage_p_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_passage_p_ext_bj).setRegistryName(blockgoudron_passage_p_ext_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_semi_diag_bj).setRegistryName(blockgoudron_semi_diag_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_semi_diag_coin_bj).setRegistryName(blockgoudron_semi_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_semi_diag_d_bj).setRegistryName(blockgoudron_semi_diag_d_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_o_p_bj).setRegistryName(blockgoudron_o_p_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_semi_diag_g_bj).setRegistryName(blockgoudron_semi_diag_g_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_s_t_bj).setRegistryName(blockgoudron_s_t_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_stop_b_d_bj).setRegistryName(blockgoudron_stop_b_d_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_stop_b_g_bj).setRegistryName(blockgoudron_stop_b_g_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_stop_b_m_bj).setRegistryName(blockgoudron_stop_b_m_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_t_o_bj).setRegistryName(blockgoudron_t_o_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_triple_diag_coin_bj).setRegistryName(blockgoudron_triple_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_triple_semi_diag_coin_bj).setRegistryName(blockgoudron_triple_semi_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_centre_double_bj).setRegistryName(blockgoudron_centre_double_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_centre_triple_bj).setRegistryName(blockgoudron_centre_triple_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_ext_bj).setRegistryName(blockgoudron_ext_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_int_bj).setRegistryName(blockgoudron_int_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(blockgoudron_centre_quadruple_bj).setRegistryName(blockgoudron_centre_quadruple_bj.getRegistryName()));

        event.getRegistry().registerAll(new ItemBlock(slabgoudron_centre_cote_bj).setRegistryName(slabgoudron_centre_cote_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_centre_bj).setRegistryName(slabgoudron_centre_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_cote_bj).setRegistryName(slabgoudron_cote_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_cote_centre_plein_bj).setRegistryName(slabgoudron_cote_centre_plein_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_cote_diag_d_bj).setRegistryName(slabgoudron_cote_diag_d_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_cote_diag_g_bj).setRegistryName(slabgoudron_cote_diag_g_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_cote_g_plein_bj).setRegistryName(slabgoudron_cote_g_plein_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_cote_g_plein_bis_bj).setRegistryName(slabgoudron_cote_g_plein_bis_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_double_cote_centre_plein_bj).setRegistryName(slabgoudron_double_cote_centre_plein_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_double_diag_coin_bj).setRegistryName(slabgoudron_double_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_semi_diag_c_bj).setRegistryName(slabgoudron_semi_diag_c_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_double_h_semi_diag_coin_bj).setRegistryName(slabgoudron_double_h_semi_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_double_semi_diag_coin_bj).setRegistryName(slabgoudron_double_semi_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_entier_semi_diag_coin_bj).setRegistryName(slabgoudron_entier_semi_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_fleche_bj).setRegistryName(slabgoudron_fleche_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_fleche_d_bj).setRegistryName(slabgoudron_fleche_d_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_fleche_g_bj).setRegistryName(slabgoudron_fleche_g_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_passage_p_bj).setRegistryName(slabgoudron_passage_p_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_passage_p_ext_bj).setRegistryName(slabgoudron_passage_p_ext_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_semi_diag_bj).setRegistryName(slabgoudron_semi_diag_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_semi_diag_coin_bj).setRegistryName(slabgoudron_semi_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_semi_diag_d_bj).setRegistryName(slabgoudron_semi_diag_d_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_o_p_bj).setRegistryName(slabgoudron_o_p_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_semi_diag_g_bj).setRegistryName(slabgoudron_semi_diag_g_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_s_t_bj).setRegistryName(slabgoudron_s_t_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_stop_b_d_bj).setRegistryName(slabgoudron_stop_b_d_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_stop_b_g_bj).setRegistryName(slabgoudron_stop_b_g_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_stop_b_m_bj).setRegistryName(slabgoudron_stop_b_m_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_t_o_bj).setRegistryName(slabgoudron_t_o_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_triple_diag_coin_bj).setRegistryName(slabgoudron_triple_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_triple_semi_diag_coin_bj).setRegistryName(slabgoudron_triple_semi_diag_coin_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_centre_double_bj).setRegistryName(slabgoudron_centre_double_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_centre_triple_bj).setRegistryName(slabgoudron_centre_triple_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_ext_bj).setRegistryName(slabgoudron_ext_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_int_bj).setRegistryName(slabgoudron_int_bj.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(slabgoudron_centre_quadruple_bj).setRegistryName(slabgoudron_centre_quadruple_bj.getRegistryName()));

        event.getRegistry().registerAll(new ItemBlock(opaque_noire).setRegistryName(opaque_noire.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(ardoise).setRegistryName(ardoise.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(poudre_vierge).setRegistryName(poudre_vierge.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(poudre_weed).setRegistryName(poudre_weed.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(poudre_coca).setRegistryName(poudre_coca.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(poudre_bulbe).setRegistryName(poudre_bulbe.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(block_poudre_fer).setRegistryName(block_poudre_fer.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(block_poudre_or).setRegistryName(block_poudre_or.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(block_poudre_or_bleu).setRegistryName(block_poudre_or_bleu.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(block_poudre_or_rouge).setRegistryName(block_poudre_or_rouge.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(block_poudre_or_noire).setRegistryName(block_poudre_or_noire.getRegistryName()));
        
        event.getRegistry().registerAll(new ItemBlock(weed_crop).setRegistryName(weed_crop.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(glass_blanc).setRegistryName(glass_blanc.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(glass_noire).setRegistryName(glass_noire.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(acid).setRegistryName(acid.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(glass).setRegistryName(glass.getRegistryName()));
        
        event.getRegistry().registerAll(new ItemBlock(ore_torbenite).setRegistryName(ore_torbenite.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(saphir_ore).setRegistryName(saphir_ore.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(rubis_ore).setRegistryName(rubis_ore.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(amethyst_ore).setRegistryName(amethyst_ore.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(topaz_ore).setRegistryName(topaz_ore.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(kunzite_ore).setRegistryName(kunzite_ore.getRegistryName()));
        
        event.getRegistry().registerAll(new ItemBlock(saphir_block).setRegistryName(saphir_block.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(rubis_block).setRegistryName(rubis_block.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(topaz_block).setRegistryName(topaz_block.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(amethyst_block).setRegistryName(amethyst_block.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(kunzite_block).setRegistryName(kunzite_block.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_bleu_block).setRegistryName(or_bleu_block.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_rouge_block).setRegistryName(or_rouge_block.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(or_noire_block).setRegistryName(or_noire_block.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(flint_stone).setRegistryName(flint_stone.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(bulbe_crop).setRegistryName(bulbe_crop.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(bois_farm).setRegistryName(bois_farm.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(fraise_crop).setRegistryName(fraise_crop.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(poireaux_crop).setRegistryName(poireaux_crop.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(oignons_crop).setRegistryName(oignons_crop.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(oignons_rouge_crop).setRegistryName(oignons_rouge_crop.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(salade_crop).setRegistryName(salade_crop.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(choux_rouge_crop).setRegistryName(choux_rouge_crop.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(pommier).setRegistryName(pommier.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(coca_crop).setRegistryName(coca_crop.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(mais_crop_bottom).setRegistryName(mais_crop_bottom.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(mais_crop_top).setRegistryName(mais_crop_top.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(vigne_crop_bottom).setRegistryName(vigne_crop_bottom.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(vigne_crop_top).setRegistryName(vigne_crop_top.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(tomate_crop_bottom).setRegistryName(tomate_crop_bottom.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(tomate_crop_top).setRegistryName(tomate_crop_top.getRegistryName()));
        
        event.getRegistry().registerAll(new ItemBlock(drog_box).setRegistryName(drog_box.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(drog_box_weed).setRegistryName(drog_box_weed.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(drog_box_coca).setRegistryName(drog_box_coca.getRegistryName()).setMaxStackSize(1));
        event.getRegistry().registerAll(new ItemBlock(drog_box_bulbe).setRegistryName(drog_box_bulbe.getRegistryName()).setMaxStackSize(1));

        event.getRegistry().registerAll(new ItemBlock(crepi_BR).setRegistryName(crepi_BR.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(crepi_BRU).setRegistryName(crepi_BRU.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(crepi).setRegistryName(crepi.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(futur_br).setRegistryName(futur_br.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(futur_bru).setRegistryName(futur_bru.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(futur).setRegistryName(futur.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(quarpi_br).setRegistryName(quarpi_br.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(quarpi_bru).setRegistryName(quarpi_bru.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(quarpi).setRegistryName(quarpi.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(oak_br).setRegistryName(oak_br.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(oak_bru).setRegistryName(oak_bru.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(big_oak_br).setRegistryName(big_oak_br.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(big_oak_bru).setRegistryName(big_oak_bru.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(spruce_br).setRegistryName(spruce_br.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(spruce_bru).setRegistryName(spruce_bru.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(acacia_br).setRegistryName(acacia_br.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(acacia_bru).setRegistryName(acacia_bru.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(birch_br).setRegistryName(birch_br.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(birch_bru).setRegistryName(birch_bru.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(jungle_br).setRegistryName(jungle_br.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(jungle_bru).setRegistryName(jungle_bru.getRegistryName()));

        event.getRegistry().registerAll(new ItemBlock(bar).setRegistryName(bar.getRegistryName()));

        event.getRegistry().registerAll(new ItemBlock(panneau_stop).setRegistryName(panneau_stop.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_carre_inv0).setRegistryName(panneau_carre_inv0.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_carre_inv1).setRegistryName(panneau_carre_inv1.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_tri_inv).setRegistryName(panneau_tri_inv.getRegistryName()));

        event.getRegistry().registerAll(new ItemBlock(panneau_danger0).setRegistryName(panneau_danger0.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_danger1).setRegistryName(panneau_danger1.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_danger2).setRegistryName(panneau_danger2.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_danger3).setRegistryName(panneau_danger3.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_danger4).setRegistryName(panneau_danger4.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_danger5).setRegistryName(panneau_danger5.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_danger6).setRegistryName(panneau_danger6.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_danger7).setRegistryName(panneau_danger7.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_danger8).setRegistryName(panneau_danger8.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_danger9).setRegistryName(panneau_danger9.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_danger10).setRegistryName(panneau_danger10.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_danger11).setRegistryName(panneau_danger11.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_danger12).setRegistryName(panneau_danger12.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_danger13).setRegistryName(panneau_danger13.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_danger14).setRegistryName(panneau_danger14.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_danger15).setRegistryName(panneau_danger15.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_danger16).setRegistryName(panneau_danger16.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_danger17).setRegistryName(panneau_danger17.getRegistryName()));

        event.getRegistry().registerAll(new ItemBlock(panneau_carre0).setRegistryName(panneau_carre0.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_carre1).setRegistryName(panneau_carre1.getRegistryName()));

        event.getRegistry().registerAll(new ItemBlock(panneau_rond0).setRegistryName(panneau_rond0.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_rond1).setRegistryName(panneau_rond1.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_rond2).setRegistryName(panneau_rond2.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_rond3).setRegistryName(panneau_rond3.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_rond4).setRegistryName(panneau_rond4.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(panneau_rond5).setRegistryName(panneau_rond5.getRegistryName()));

        event.getRegistry().registerAll(new ItemBlock(panonceau0).setRegistryName(panonceau0.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(grand_panonceau0).setRegistryName(grand_panonceau0.getRegistryName()));

        event.getRegistry().registerAll(new ItemBlock(lampe).setRegistryName(lampe.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(infrarouge).setRegistryName(infrarouge.getRegistryName()));

        event.getRegistry().registerAll(new ItemBlock(planche).setRegistryName(planche.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(planche_tomate).setRegistryName(planche_tomate.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(planche_mais).setRegistryName(planche_mais.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(planche_poireau).setRegistryName(planche_poireau.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(planche_salade).setRegistryName(planche_salade.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(planche_choux_rouge).setRegistryName(planche_choux_rouge.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(planche_oignon).setRegistryName(planche_oignon.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(planche_oignon_rouge).setRegistryName(planche_oignon_rouge.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(planche_beef).setRegistryName(planche_beef.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(planche_chicken).setRegistryName(planche_chicken.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(planche_coad).setRegistryName(planche_coad.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(planche_mutton).setRegistryName(planche_mutton.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(planche_pork).setRegistryName(planche_pork.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(planche_rabbit).setRegistryName(planche_rabbit.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(planche_salmon).setRegistryName(planche_salmon.getRegistryName()));
        event.getRegistry().registerAll(new ItemBlock(planche_bread).setRegistryName(planche_bread.getRegistryName()));
        
        event.getRegistry().registerAll(new ItemBlock(ramp).setRegistryName(ramp.getRegistryName()));
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event){
    	
        registerRender(Item.getItemFromBlock(full_stone_slab));
        registerRender(Item.getItemFromBlock(gold_stonebrick));
        registerRender(Item.getItemFromBlock(iron_stonebrick));
        registerRender(Item.getItemFromBlock(topaz_stonebrick));
        registerRender(Item.getItemFromBlock(amethyst_stonebrick));
        registerRender(Item.getItemFromBlock(kunzite_stonebrick));
        registerRender(Item.getItemFromBlock(saphir_stonebrick));
        registerRender(Item.getItemFromBlock(rubis_stonebrick));
        registerRender(Item.getItemFromBlock(or_bleu_stonebrick));
        registerRender(Item.getItemFromBlock(or_rouge_stonebrick));
        registerRender(Item.getItemFromBlock(or_noire_stonebrick));
        registerRender(Item.getItemFromBlock(gold_planks));
        registerRender(Item.getItemFromBlock(iron_planks));
        registerRender(Item.getItemFromBlock(topaz_planks));
        registerRender(Item.getItemFromBlock(amethyst_planks));
        registerRender(Item.getItemFromBlock(kunzite_planks));
        registerRender(Item.getItemFromBlock(saphir_planks));
        registerRender(Item.getItemFromBlock(rubis_planks));
        registerRender(Item.getItemFromBlock(or_bleu_planks));
        registerRender(Item.getItemFromBlock(or_rouge_planks));
        registerRender(Item.getItemFromBlock(or_noire_planks));

        registerRender(Item.getItemFromBlock(gold_stonebrick_stairs));
        registerRender(Item.getItemFromBlock(iron_stonebrick_stairs));
        registerRender(Item.getItemFromBlock(topaz_stonebrick_stairs));
        registerRender(Item.getItemFromBlock(amethyst_stonebrick_stairs));
        registerRender(Item.getItemFromBlock(kunzite_stonebrick_stairs));
        registerRender(Item.getItemFromBlock(saphir_stonebrick_stairs));
        registerRender(Item.getItemFromBlock(rubis_stonebrick_stairs));
        registerRender(Item.getItemFromBlock(or_bleu_stonebrick_stairs));
        registerRender(Item.getItemFromBlock(or_rouge_stonebrick_stairs));
        registerRender(Item.getItemFromBlock(or_noire_stonebrick_stairs));
        registerRender(Item.getItemFromBlock(gold_planks_stairs));
        registerRender(Item.getItemFromBlock(iron_planks_stairs));
        registerRender(Item.getItemFromBlock(topaz_planks_stairs));
        registerRender(Item.getItemFromBlock(amethyst_planks_stairs));
        registerRender(Item.getItemFromBlock(kunzite_planks_stairs));
        registerRender(Item.getItemFromBlock(saphir_planks_stairs));
        registerRender(Item.getItemFromBlock(rubis_planks_stairs));
        registerRender(Item.getItemFromBlock(or_bleu_planks_stairs));
        registerRender(Item.getItemFromBlock(or_rouge_planks_stairs));
        registerRender(Item.getItemFromBlock(or_noire_planks_stairs));
        
        registerRender(Item.getItemFromBlock(gold_stonebrick_wall));
        registerRender(Item.getItemFromBlock(iron_stonebrick_wall));
        registerRender(Item.getItemFromBlock(topaz_stonebrick_wall));
        registerRender(Item.getItemFromBlock(amethyst_stonebrick_wall));
        registerRender(Item.getItemFromBlock(kunzite_stonebrick_wall));
        registerRender(Item.getItemFromBlock(saphir_stonebrick_wall));
        registerRender(Item.getItemFromBlock(rubis_stonebrick_wall));
        registerRender(Item.getItemFromBlock(or_bleu_stonebrick_wall));
        registerRender(Item.getItemFromBlock(or_rouge_stonebrick_wall));
        registerRender(Item.getItemFromBlock(or_noire_stonebrick_wall));
        registerRender(Item.getItemFromBlock(gold_planks_wall));
        registerRender(Item.getItemFromBlock(iron_planks_wall));
        registerRender(Item.getItemFromBlock(topaz_planks_wall));
        registerRender(Item.getItemFromBlock(amethyst_planks_wall));
        registerRender(Item.getItemFromBlock(kunzite_planks_wall));
        registerRender(Item.getItemFromBlock(saphir_planks_wall));
        registerRender(Item.getItemFromBlock(rubis_planks_wall));
        registerRender(Item.getItemFromBlock(or_bleu_planks_wall));
        registerRender(Item.getItemFromBlock(or_rouge_planks_wall));
        registerRender(Item.getItemFromBlock(or_noire_planks_wall));

        registerRender(Item.getItemFromBlock(gold_stonebrick_slab));
        registerRender(Item.getItemFromBlock(iron_stonebrick_slab));
        registerRender(Item.getItemFromBlock(topaz_stonebrick_slab));
        registerRender(Item.getItemFromBlock(amethyst_stonebrick_slab));
        registerRender(Item.getItemFromBlock(kunzite_stonebrick_slab));
        registerRender(Item.getItemFromBlock(saphir_stonebrick_slab));
        registerRender(Item.getItemFromBlock(rubis_stonebrick_slab));
        registerRender(Item.getItemFromBlock(or_bleu_stonebrick_slab));
        registerRender(Item.getItemFromBlock(or_rouge_stonebrick_slab));
        registerRender(Item.getItemFromBlock(or_noire_stonebrick_slab));
        registerRender(Item.getItemFromBlock(gold_planks_slab));
        registerRender(Item.getItemFromBlock(iron_planks_slab));
        registerRender(Item.getItemFromBlock(topaz_planks_slab));
        registerRender(Item.getItemFromBlock(amethyst_planks_slab));
        registerRender(Item.getItemFromBlock(kunzite_planks_slab));
        registerRender(Item.getItemFromBlock(saphir_planks_slab));
        registerRender(Item.getItemFromBlock(rubis_planks_slab));
        registerRender(Item.getItemFromBlock(or_bleu_planks_slab));
        registerRender(Item.getItemFromBlock(or_rouge_planks_slab));
        registerRender(Item.getItemFromBlock(or_noire_planks_slab));

        registerRender(Item.getItemFromBlock(gold_stonebrick_double_slab));
        registerRender(Item.getItemFromBlock(iron_stonebrick_double_slab));
        registerRender(Item.getItemFromBlock(topaz_stonebrick_double_slab));
        registerRender(Item.getItemFromBlock(amethyst_stonebrick_double_slab));
        registerRender(Item.getItemFromBlock(kunzite_stonebrick_double_slab));
        registerRender(Item.getItemFromBlock(saphir_stonebrick_double_slab));
        registerRender(Item.getItemFromBlock(rubis_stonebrick_double_slab));
        registerRender(Item.getItemFromBlock(or_bleu_stonebrick_double_slab));
        registerRender(Item.getItemFromBlock(or_rouge_stonebrick_double_slab));
        registerRender(Item.getItemFromBlock(or_noire_stonebrick_double_slab));
        registerRender(Item.getItemFromBlock(gold_planks_double_slab));
        registerRender(Item.getItemFromBlock(iron_planks_double_slab));
        registerRender(Item.getItemFromBlock(topaz_planks_double_slab));
        registerRender(Item.getItemFromBlock(amethyst_planks_double_slab));
        registerRender(Item.getItemFromBlock(kunzite_planks_double_slab));
        registerRender(Item.getItemFromBlock(saphir_planks_double_slab));
        registerRender(Item.getItemFromBlock(rubis_planks_double_slab));
        registerRender(Item.getItemFromBlock(or_bleu_planks_double_slab));
        registerRender(Item.getItemFromBlock(or_rouge_planks_double_slab));
        registerRender(Item.getItemFromBlock(or_noire_planks_double_slab));
        
        registerRender(Item.getItemFromBlock(table_assemblage));
        registerRender(Item.getItemFromBlock(centrifugeuse));
        registerRender(Item.getItemFromBlock(sechoir));
        registerRender(Item.getItemFromBlock(generateur));
        registerRender(Item.getItemFromBlock(conteneurenergie));
        registerRender(Item.getItemFromBlock(assemblage_arme));
        registerRender(Item.getItemFromBlock(assemblage_munition));
        registerRender(Item.getItemFromBlock(imprimante));
        registerRender(Item.getItemFromBlock(table_chimie));
        registerRender(Item.getItemFromBlock(drill));
        registerRender(Item.getItemFromBlock(tami_vide));
        registerRender(Item.getItemFromBlock(tami_sand));
        registerRender(Item.getItemFromBlock(tami_gravel));
        registerRender(Item.getItemFromBlock(tami_dirt));
        registerRender(Item.getItemFromBlock(tami_cobble));
        registerRender(Item.getItemFromBlock(tami_redsand));
        registerRender(Item.getItemFromBlock(tami_soulsand));
        registerRender(Item.getItemFromBlock(tami_goldpowder));
        registerRender(Item.getItemFromBlock(tami_ironpowder));
        registerRender(Item.getItemFromBlock(tami_blackgoldpowder));
        registerRender(Item.getItemFromBlock(tami_redgoldpowder));
        registerRender(Item.getItemFromBlock(tami_bluegoldpowder));

        registerRender(Item.getItemFromBlock(egout));

        registerRender(Item.getItemFromBlock(goudron));
        registerRender(Item.getItemFromBlock(goudron_centre_cote_b));
        registerRender(Item.getItemFromBlock(goudron_centre_b));
        registerRender(Item.getItemFromBlock(goudron_cote_b));
        registerRender(Item.getItemFromBlock(goudron_cote_centre_plein_b));
        registerRender(Item.getItemFromBlock(goudron_cote_diag_d_b));
        registerRender(Item.getItemFromBlock(goudron_cote_diag_g_b));
        registerRender(Item.getItemFromBlock(goudron_cote_g_plein_b));
        registerRender(Item.getItemFromBlock(goudron_cote_g_plein_bis_b));
        registerRender(Item.getItemFromBlock(goudron_double_cote_centre_plein_b));
        registerRender(Item.getItemFromBlock(goudron_double_diag_coin_b));
        registerRender(Item.getItemFromBlock(goudron_semi_diag_c_b));
        registerRender(Item.getItemFromBlock(goudron_double_h_semi_diag_coin_b));
        registerRender(Item.getItemFromBlock(goudron_double_semi_diag_coin_b));
        registerRender(Item.getItemFromBlock(goudron_entier_semi_diag_coin_b));
        registerRender(Item.getItemFromBlock(goudron_fleche_b));
        registerRender(Item.getItemFromBlock(goudron_fleche_d_b));
        registerRender(Item.getItemFromBlock(goudron_fleche_g_b));
        registerRender(Item.getItemFromBlock(goudron_passage_p_b));
        registerRender(Item.getItemFromBlock(goudron_passage_p_ext_b));
        registerRender(Item.getItemFromBlock(goudron_semi_diag_b));
        registerRender(Item.getItemFromBlock(goudron_semi_diag_coin_b));
        registerRender(Item.getItemFromBlock(goudron_semi_diag_d_b));
        registerRender(Item.getItemFromBlock(goudron_o_p_b));
        registerRender(Item.getItemFromBlock(goudron_semi_diag_g_b));
        registerRender(Item.getItemFromBlock(goudron_s_t_b));
        registerRender(Item.getItemFromBlock(goudron_stop_b_d_b));
        registerRender(Item.getItemFromBlock(goudron_stop_b_g_b));
        registerRender(Item.getItemFromBlock(goudron_stop_b_m_b));
        registerRender(Item.getItemFromBlock(goudron_t_o_b));
        registerRender(Item.getItemFromBlock(goudron_triple_diag_coin_b));
        registerRender(Item.getItemFromBlock(goudron_triple_semi_diag_coin_b));
        registerRender(Item.getItemFromBlock(goudron_centre_double_b));
        registerRender(Item.getItemFromBlock(goudron_centre_triple_b));
        registerRender(Item.getItemFromBlock(goudron_ext_b));
        registerRender(Item.getItemFromBlock(goudron_int_b));
        registerRender(Item.getItemFromBlock(goudron_centre_quadruple_b));

        registerRender(Item.getItemFromBlock(blockgoudron));
        registerRender(Item.getItemFromBlock(blockgoudron_centre_cote_b));
        registerRender(Item.getItemFromBlock(blockgoudron_centre_b));
        registerRender(Item.getItemFromBlock(blockgoudron_cote_b));
        registerRender(Item.getItemFromBlock(blockgoudron_cote_centre_plein_b));
        registerRender(Item.getItemFromBlock(blockgoudron_cote_diag_d_b));
        registerRender(Item.getItemFromBlock(blockgoudron_cote_diag_g_b));
        registerRender(Item.getItemFromBlock(blockgoudron_cote_g_plein_b));
        registerRender(Item.getItemFromBlock(blockgoudron_cote_g_plein_bis_b));
        registerRender(Item.getItemFromBlock(blockgoudron_double_cote_centre_plein_b));
        registerRender(Item.getItemFromBlock(blockgoudron_double_diag_coin_b));
        registerRender(Item.getItemFromBlock(blockgoudron_semi_diag_c_b));
        registerRender(Item.getItemFromBlock(blockgoudron_double_h_semi_diag_coin_b));
        registerRender(Item.getItemFromBlock(blockgoudron_double_semi_diag_coin_b));
        registerRender(Item.getItemFromBlock(blockgoudron_entier_semi_diag_coin_b));
        registerRender(Item.getItemFromBlock(blockgoudron_fleche_b));
        registerRender(Item.getItemFromBlock(blockgoudron_fleche_d_b));
        registerRender(Item.getItemFromBlock(blockgoudron_fleche_g_b));
        registerRender(Item.getItemFromBlock(blockgoudron_passage_p_b));
        registerRender(Item.getItemFromBlock(blockgoudron_passage_p_ext_b));
        registerRender(Item.getItemFromBlock(blockgoudron_semi_diag_b));
        registerRender(Item.getItemFromBlock(blockgoudron_semi_diag_coin_b));
        registerRender(Item.getItemFromBlock(blockgoudron_semi_diag_d_b));
        registerRender(Item.getItemFromBlock(blockgoudron_o_p_b));
        registerRender(Item.getItemFromBlock(blockgoudron_semi_diag_g_b));
        registerRender(Item.getItemFromBlock(blockgoudron_s_t_b));
        registerRender(Item.getItemFromBlock(blockgoudron_stop_b_d_b));
        registerRender(Item.getItemFromBlock(blockgoudron_stop_b_g_b));
        registerRender(Item.getItemFromBlock(blockgoudron_stop_b_m_b));
        registerRender(Item.getItemFromBlock(blockgoudron_t_o_b));
        registerRender(Item.getItemFromBlock(blockgoudron_triple_diag_coin_b));
        registerRender(Item.getItemFromBlock(blockgoudron_triple_semi_diag_coin_b));
        registerRender(Item.getItemFromBlock(blockgoudron_centre_double_b));
        registerRender(Item.getItemFromBlock(blockgoudron_centre_triple_b));
        registerRender(Item.getItemFromBlock(blockgoudron_ext_b));
        registerRender(Item.getItemFromBlock(blockgoudron_int_b));
        registerRender(Item.getItemFromBlock(blockgoudron_centre_quadruple_b));

        registerRender(Item.getItemFromBlock(slabgoudron));
        registerRender(Item.getItemFromBlock(slabgoudron_centre_cote_b));
        registerRender(Item.getItemFromBlock(slabgoudron_centre_b));
        registerRender(Item.getItemFromBlock(slabgoudron_cote_b));
        registerRender(Item.getItemFromBlock(slabgoudron_cote_centre_plein_b));
        registerRender(Item.getItemFromBlock(slabgoudron_cote_diag_d_b));
        registerRender(Item.getItemFromBlock(slabgoudron_cote_diag_g_b));
        registerRender(Item.getItemFromBlock(slabgoudron_cote_g_plein_b));
        registerRender(Item.getItemFromBlock(slabgoudron_cote_g_plein_bis_b));
        registerRender(Item.getItemFromBlock(slabgoudron_double_cote_centre_plein_b));
        registerRender(Item.getItemFromBlock(slabgoudron_double_diag_coin_b));
        registerRender(Item.getItemFromBlock(slabgoudron_semi_diag_c_b));
        registerRender(Item.getItemFromBlock(slabgoudron_double_h_semi_diag_coin_b));
        registerRender(Item.getItemFromBlock(slabgoudron_double_semi_diag_coin_b));
        registerRender(Item.getItemFromBlock(slabgoudron_entier_semi_diag_coin_b));
        registerRender(Item.getItemFromBlock(slabgoudron_fleche_b));
        registerRender(Item.getItemFromBlock(slabgoudron_fleche_d_b));
        registerRender(Item.getItemFromBlock(slabgoudron_fleche_g_b));
        registerRender(Item.getItemFromBlock(slabgoudron_passage_p_b));
        registerRender(Item.getItemFromBlock(slabgoudron_passage_p_ext_b));
        registerRender(Item.getItemFromBlock(slabgoudron_semi_diag_b));
        registerRender(Item.getItemFromBlock(slabgoudron_semi_diag_coin_b));
        registerRender(Item.getItemFromBlock(slabgoudron_semi_diag_d_b));
        registerRender(Item.getItemFromBlock(slabgoudron_o_p_b));
        registerRender(Item.getItemFromBlock(slabgoudron_semi_diag_g_b));
        registerRender(Item.getItemFromBlock(slabgoudron_s_t_b));
        registerRender(Item.getItemFromBlock(slabgoudron_stop_b_d_b));
        registerRender(Item.getItemFromBlock(slabgoudron_stop_b_g_b));
        registerRender(Item.getItemFromBlock(slabgoudron_stop_b_m_b));
        registerRender(Item.getItemFromBlock(slabgoudron_t_o_b));
        registerRender(Item.getItemFromBlock(slabgoudron_triple_diag_coin_b));
        registerRender(Item.getItemFromBlock(slabgoudron_triple_semi_diag_coin_b));
        registerRender(Item.getItemFromBlock(slabgoudron_centre_double_b));
        registerRender(Item.getItemFromBlock(slabgoudron_centre_triple_b));
        registerRender(Item.getItemFromBlock(slabgoudron_ext_b));
        registerRender(Item.getItemFromBlock(slabgoudron_int_b));
        registerRender(Item.getItemFromBlock(slabgoudron_centre_quadruple_b));
        
        registerRender(Item.getItemFromBlock(goudron_centre_cote_bj));
        registerRender(Item.getItemFromBlock(goudron_centre_bj));
        registerRender(Item.getItemFromBlock(goudron_cote_bj));
        registerRender(Item.getItemFromBlock(goudron_cote_centre_plein_bj));
        registerRender(Item.getItemFromBlock(goudron_cote_diag_d_bj));
        registerRender(Item.getItemFromBlock(goudron_cote_diag_g_bj));
        registerRender(Item.getItemFromBlock(goudron_cote_g_plein_bj));
        registerRender(Item.getItemFromBlock(goudron_cote_g_plein_bis_bj));
        registerRender(Item.getItemFromBlock(goudron_double_cote_centre_plein_bj));
        registerRender(Item.getItemFromBlock(goudron_double_diag_coin_bj));
        registerRender(Item.getItemFromBlock(goudron_semi_diag_c_bj));
        registerRender(Item.getItemFromBlock(goudron_double_h_semi_diag_coin_bj));
        registerRender(Item.getItemFromBlock(goudron_double_semi_diag_coin_bj));
        registerRender(Item.getItemFromBlock(goudron_entier_semi_diag_coin_bj));
        registerRender(Item.getItemFromBlock(goudron_fleche_bj));
        registerRender(Item.getItemFromBlock(goudron_fleche_d_bj));
        registerRender(Item.getItemFromBlock(goudron_fleche_g_bj));
        registerRender(Item.getItemFromBlock(goudron_passage_p_bj));
        registerRender(Item.getItemFromBlock(goudron_passage_p_ext_bj));
        registerRender(Item.getItemFromBlock(goudron_semi_diag_bj));
        registerRender(Item.getItemFromBlock(goudron_semi_diag_coin_bj));
        registerRender(Item.getItemFromBlock(goudron_semi_diag_d_bj));
        registerRender(Item.getItemFromBlock(goudron_o_p_bj));
        registerRender(Item.getItemFromBlock(goudron_semi_diag_g_bj));
        registerRender(Item.getItemFromBlock(goudron_s_t_bj));
        registerRender(Item.getItemFromBlock(goudron_stop_b_d_bj));
        registerRender(Item.getItemFromBlock(goudron_stop_b_g_bj));
        registerRender(Item.getItemFromBlock(goudron_stop_b_m_bj));
        registerRender(Item.getItemFromBlock(goudron_t_o_bj));
        registerRender(Item.getItemFromBlock(goudron_triple_diag_coin_bj));
        registerRender(Item.getItemFromBlock(goudron_triple_semi_diag_coin_bj));
        registerRender(Item.getItemFromBlock(goudron_centre_double_bj));
        registerRender(Item.getItemFromBlock(goudron_centre_triple_bj));
        registerRender(Item.getItemFromBlock(goudron_ext_bj));
        registerRender(Item.getItemFromBlock(goudron_int_bj));
        registerRender(Item.getItemFromBlock(goudron_centre_quadruple_bj));

        registerRender(Item.getItemFromBlock(blockgoudron_centre_cote_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_centre_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_cote_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_cote_centre_plein_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_cote_diag_d_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_cote_diag_g_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_cote_g_plein_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_cote_g_plein_bis_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_double_cote_centre_plein_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_double_diag_coin_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_semi_diag_c_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_double_h_semi_diag_coin_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_double_semi_diag_coin_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_entier_semi_diag_coin_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_fleche_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_fleche_d_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_fleche_g_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_passage_p_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_passage_p_ext_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_semi_diag_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_semi_diag_coin_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_semi_diag_d_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_o_p_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_semi_diag_g_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_s_t_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_stop_b_d_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_stop_b_g_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_stop_b_m_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_t_o_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_triple_diag_coin_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_triple_semi_diag_coin_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_centre_double_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_centre_triple_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_ext_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_int_bj));
        registerRender(Item.getItemFromBlock(blockgoudron_centre_quadruple_bj));

        registerRender(Item.getItemFromBlock(slabgoudron_centre_cote_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_centre_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_cote_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_cote_centre_plein_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_cote_diag_d_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_cote_diag_g_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_cote_g_plein_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_cote_g_plein_bis_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_double_cote_centre_plein_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_double_diag_coin_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_semi_diag_c_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_double_h_semi_diag_coin_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_double_semi_diag_coin_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_entier_semi_diag_coin_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_fleche_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_fleche_d_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_fleche_g_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_passage_p_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_passage_p_ext_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_semi_diag_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_semi_diag_coin_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_semi_diag_d_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_o_p_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_semi_diag_g_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_s_t_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_stop_b_d_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_stop_b_g_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_stop_b_m_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_t_o_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_triple_diag_coin_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_triple_semi_diag_coin_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_centre_double_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_centre_triple_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_ext_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_int_bj));
        registerRender(Item.getItemFromBlock(slabgoudron_centre_quadruple_bj));

        registerRender(Item.getItemFromBlock(opaque_noire));
        registerRender(Item.getItemFromBlock(ardoise));
        registerRender(Item.getItemFromBlock(poudre_vierge));
        registerRender(Item.getItemFromBlock(poudre_weed));
        registerRender(Item.getItemFromBlock(poudre_coca));
        registerRender(Item.getItemFromBlock(poudre_bulbe));
        registerRender(Item.getItemFromBlock(block_poudre_fer));
        registerRender(Item.getItemFromBlock(block_poudre_or));
        registerRender(Item.getItemFromBlock(block_poudre_or_bleu));
        registerRender(Item.getItemFromBlock(block_poudre_or_rouge));
        registerRender(Item.getItemFromBlock(block_poudre_or_noire));
        
        registerRender(Item.getItemFromBlock(weed_crop));
        registerRender(Item.getItemFromBlock(glass_blanc));
        registerRender(Item.getItemFromBlock(glass_noire));
        registerRender(Item.getItemFromBlock(acid));
        registerRender(Item.getItemFromBlock(glass));
        registerRender(Item.getItemFromBlock(ore_torbenite));
        registerRender(Item.getItemFromBlock(saphir_ore));
        registerRender(Item.getItemFromBlock(rubis_ore));
        registerRender(Item.getItemFromBlock(amethyst_ore));
        registerRender(Item.getItemFromBlock(topaz_ore));
        registerRender(Item.getItemFromBlock(kunzite_ore));
        
        registerRender(Item.getItemFromBlock(rubis_block));
        registerRender(Item.getItemFromBlock(saphir_block));
        registerRender(Item.getItemFromBlock(topaz_block));
        registerRender(Item.getItemFromBlock(kunzite_block));
        registerRender(Item.getItemFromBlock(amethyst_block));
        registerRender(Item.getItemFromBlock(or_bleu_block));
        registerRender(Item.getItemFromBlock(or_rouge_block));
        registerRender(Item.getItemFromBlock(or_noire_block));
        
        registerRender(Item.getItemFromBlock(flint_stone));
        registerRender(Item.getItemFromBlock(bulbe_crop));
        registerRender(Item.getItemFromBlock(crepi_BR));
        registerRender(Item.getItemFromBlock(crepi_BRU));
        registerRender(Item.getItemFromBlock(crepi));
        registerRender(Item.getItemFromBlock(futur_br));
        registerRender(Item.getItemFromBlock(futur_bru));
        registerRender(Item.getItemFromBlock(futur));
        registerRender(Item.getItemFromBlock(quarpi_br));
        registerRender(Item.getItemFromBlock(quarpi_bru));
        registerRender(Item.getItemFromBlock(quarpi));
        registerRender(Item.getItemFromBlock(oak_br));
        registerRender(Item.getItemFromBlock(oak_bru));
        registerRender(Item.getItemFromBlock(big_oak_br));
        registerRender(Item.getItemFromBlock(big_oak_bru));
        registerRender(Item.getItemFromBlock(spruce_br));
        registerRender(Item.getItemFromBlock(spruce_bru));
        registerRender(Item.getItemFromBlock(acacia_br));
        registerRender(Item.getItemFromBlock(acacia_bru));
        registerRender(Item.getItemFromBlock(jungle_br));
        registerRender(Item.getItemFromBlock(jungle_bru));
        registerRender(Item.getItemFromBlock(birch_br));
        registerRender(Item.getItemFromBlock(birch_bru));
        registerRender(Item.getItemFromBlock(bois_farm));
        registerRender(Item.getItemFromBlock(fraise_crop));
        registerRender(Item.getItemFromBlock(poireaux_crop));
        registerRender(Item.getItemFromBlock(oignons_crop));
        registerRender(Item.getItemFromBlock(oignons_rouge_crop));
        registerRender(Item.getItemFromBlock(salade_crop));
        registerRender(Item.getItemFromBlock(choux_rouge_crop));
        registerRender(Item.getItemFromBlock(pommier));
        registerRender(Item.getItemFromBlock(coca_crop));
        registerRender(Item.getItemFromBlock(mais_crop_bottom));
        registerRender(Item.getItemFromBlock(mais_crop_top));
        registerRender(Item.getItemFromBlock(vigne_crop_bottom));
        registerRender(Item.getItemFromBlock(vigne_crop_top));
        registerRender(Item.getItemFromBlock(tomate_crop_bottom));
        registerRender(Item.getItemFromBlock(tomate_crop_top));

        registerRender(Item.getItemFromBlock(drog_box));
        registerRender(Item.getItemFromBlock(drog_box_weed));
        registerRender(Item.getItemFromBlock(drog_box_coca));
        registerRender(Item.getItemFromBlock(drog_box_bulbe));

        registerRender(Item.getItemFromBlock(bar));

        registerRender(Item.getItemFromBlock(panneau_stop));
        registerRender(Item.getItemFromBlock(panneau_carre_inv0));
        registerRender(Item.getItemFromBlock(panneau_carre_inv1));
        registerRender(Item.getItemFromBlock(panneau_tri_inv));

        registerRender(Item.getItemFromBlock(panneau_danger0));
        registerRender(Item.getItemFromBlock(panneau_danger1));
        registerRender(Item.getItemFromBlock(panneau_danger2));
        registerRender(Item.getItemFromBlock(panneau_danger3));
        registerRender(Item.getItemFromBlock(panneau_danger4));
        registerRender(Item.getItemFromBlock(panneau_danger5));
        registerRender(Item.getItemFromBlock(panneau_danger6));
        registerRender(Item.getItemFromBlock(panneau_danger7));
        registerRender(Item.getItemFromBlock(panneau_danger8));
        registerRender(Item.getItemFromBlock(panneau_danger9));
        registerRender(Item.getItemFromBlock(panneau_danger10));
        registerRender(Item.getItemFromBlock(panneau_danger11));
        registerRender(Item.getItemFromBlock(panneau_danger12));
        registerRender(Item.getItemFromBlock(panneau_danger13));
        registerRender(Item.getItemFromBlock(panneau_danger14));
        registerRender(Item.getItemFromBlock(panneau_danger15));
        registerRender(Item.getItemFromBlock(panneau_danger16));
        registerRender(Item.getItemFromBlock(panneau_danger17));

        registerRender(Item.getItemFromBlock(panneau_carre0));
        registerRender(Item.getItemFromBlock(panneau_carre1));

        registerRender(Item.getItemFromBlock(panneau_rond0));
        registerRender(Item.getItemFromBlock(panneau_rond1));
        registerRender(Item.getItemFromBlock(panneau_rond2));
        registerRender(Item.getItemFromBlock(panneau_rond3));
        registerRender(Item.getItemFromBlock(panneau_rond4));
        registerRender(Item.getItemFromBlock(panneau_rond5));

        registerRender(Item.getItemFromBlock(panonceau0));
        registerRender(Item.getItemFromBlock(grand_panonceau0));

        registerRender(Item.getItemFromBlock(lampe));
        registerRender(Item.getItemFromBlock(infrarouge));

        registerRender(Item.getItemFromBlock(planche));
        registerRender(Item.getItemFromBlock(planche_tomate));
        registerRender(Item.getItemFromBlock(planche_mais));
        registerRender(Item.getItemFromBlock(planche_poireau));
        registerRender(Item.getItemFromBlock(planche_salade));
        registerRender(Item.getItemFromBlock(planche_choux_rouge));
        registerRender(Item.getItemFromBlock(planche_oignon));
        registerRender(Item.getItemFromBlock(planche_oignon_rouge));
        registerRender(Item.getItemFromBlock(planche_beef));
        registerRender(Item.getItemFromBlock(planche_chicken));
        registerRender(Item.getItemFromBlock(planche_coad));
        registerRender(Item.getItemFromBlock(planche_mutton));
        registerRender(Item.getItemFromBlock(planche_pork));
        registerRender(Item.getItemFromBlock(planche_rabbit));
        registerRender(Item.getItemFromBlock(planche_salmon));
        registerRender(Item.getItemFromBlock(planche_bread));
        
        registerRender(Item.getItemFromBlock(ramp));
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender(Item item){

        //b6
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(b6), new ItemMeshDefinition() {

        @Override
        public ModelResourceLocation getModelLocation(ItemStack stack) {

            return new ModelResourceLocation(Reference.MODID + ":b6","fluid");
        }
    });

        ModelLoader.setCustomStateMapper(b6, new StateMapperBase() {

        @Override
        protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

            return new ModelResourceLocation(Reference.MODID + ":b6","fluid");
        }
    });
        
      //essence
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(essence), new ItemMeshDefinition() {

        @Override
        public ModelResourceLocation getModelLocation(ItemStack stack) {

            return new ModelResourceLocation(Reference.MODID + ":essence","fluid");
        }
    });

        ModelLoader.setCustomStateMapper(essence, new StateMapperBase() {

        @Override
        protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

            return new ModelResourceLocation(Reference.MODID + ":essence","fluid");
        }
    });
        
      //fluoroantimonique
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(fluoroantimonique), new ItemMeshDefinition() {

        @Override
        public ModelResourceLocation getModelLocation(ItemStack stack) {

            return new ModelResourceLocation(Reference.MODID + ":fluoroantimonique","fluid");
        }
    });

        ModelLoader.setCustomStateMapper(fluoroantimonique, new StateMapperBase() {

        @Override
        protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

            return new ModelResourceLocation(Reference.MODID + ":fluoroantimonique","fluid");
        }
    });

	    //encre
	    ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(encre), new ItemMeshDefinition() {

        @Override
        public ModelResourceLocation getModelLocation(ItemStack stack) {

            return new ModelResourceLocation(Reference.MODID + ":encre","fluid");
        }
    });

    ModelLoader.setCustomStateMapper(encre, new StateMapperBase() {

        @Override
        protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

            return new ModelResourceLocation(Reference.MODID + ":encre","fluid");
        }
    });
    

	    //encre_magenta
	    ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(encre_magenta), new ItemMeshDefinition() {
	
	    @Override
	    public ModelResourceLocation getModelLocation(ItemStack stack) {
	
	        return new ModelResourceLocation(Reference.MODID + ":encre_magenta","fluid");
	    }
	});
	
	ModelLoader.setCustomStateMapper(encre_magenta, new StateMapperBase() {
	
	    @Override
	    protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
	
	        return new ModelResourceLocation(Reference.MODID + ":encre_magenta","fluid");
	    }
	});
	
	
		//encre_cyan
		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(encre_cyan), new ItemMeshDefinition() {
	
		@Override
		public ModelResourceLocation getModelLocation(ItemStack stack) {
		
		    return new ModelResourceLocation(Reference.MODID + ":encre_cyan","fluid");
		}
	});
	
		ModelLoader.setCustomStateMapper(encre_cyan, new StateMapperBase() {
		
		@Override
		protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
	
			return new ModelResourceLocation(Reference.MODID + ":encre_cyan","fluid");
		}	
	});
	
	
		//encre_jaune
		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(encre_jaune), new ItemMeshDefinition() {
	
		@Override
		public ModelResourceLocation getModelLocation(ItemStack stack) {
		
		    return new ModelResourceLocation(Reference.MODID + ":encre_jaune","fluid");
		}
	});
	
		ModelLoader.setCustomStateMapper(encre_jaune, new StateMapperBase() {
		
		@Override
		protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
		
		    return new ModelResourceLocation(Reference.MODID + ":encre_jaune","fluid");
		}
	});
    

        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
    
    public boolean canSustainModPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable)
    {
        IBlockState plant = plantable.getPlant(world, pos.offset(direction));

        if (plant.getBlock() == ModBlocks.bulbe_crop)
        {
            return world.getBlockState(pos) == Blocks.COBBLESTONE;
        }
        if (plant.getBlock() == ModBlocks.weed_crop || plant.getBlock() == ModBlocks.fraise_crop || plant.getBlock() == ModBlocks.coca_crop || plant.getBlock() == ModBlocks.vigne_crop_bottom)
        {
            return world.getBlockState(pos) == Blocks.GRASS;
        }
        if (plant.getBlock() == ModBlocks.mais_crop_bottom || plant.getBlock() == ModBlocks.tomate_crop_bottom || plant.getBlock() == ModBlocks.salade_crop || plant.getBlock() == ModBlocks.choux_rouge_crop || 
        		plant.getBlock() == ModBlocks.poireaux_crop || plant.getBlock() == ModBlocks.oignons_crop || plant.getBlock() == ModBlocks.oignons_rouge_crop)
        {
            return world.getBlockState(pos) == Blocks.FARMLAND;
        }

        return false;
    }
}