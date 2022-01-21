package fr.luffyerrot.universia.Handlers;

import fr.luffyerrot.universia.TileEntity.TileEntityAssemblageArme;
import fr.luffyerrot.universia.TileEntity.TileEntityAssemblageMunition;
import fr.luffyerrot.universia.TileEntity.TileEntityCentrifugeuse;
import fr.luffyerrot.universia.TileEntity.TileEntityImprimante;
import fr.luffyerrot.universia.TileEntity.TileEntitySechoir;
import fr.luffyerrot.universia.TileEntity.TileEntityTableAssemblage;
import fr.luffyerrot.universia.TileEntity.TileEntityTableChimie;
import fr.luffyerrot.universia.utils.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {

    public static void registerTileEntities(){

        GameRegistry.registerTileEntity(TileEntityImprimante.class, new ResourceLocation(Reference.MODID + ":imprimante"));
        GameRegistry.registerTileEntity(TileEntityTableAssemblage.class, new ResourceLocation(Reference.MODID + ":table_assemblage"));
        GameRegistry.registerTileEntity(TileEntityCentrifugeuse.class, new ResourceLocation(Reference.MODID + ":centrifugeuse"));
        GameRegistry.registerTileEntity(TileEntitySechoir.class, new ResourceLocation(Reference.MODID + ":sechoir"));
        GameRegistry.registerTileEntity(TileEntityAssemblageArme.class, new ResourceLocation(Reference.MODID + ":assemblage_arme"));
        GameRegistry.registerTileEntity(TileEntityAssemblageMunition.class, new ResourceLocation(Reference.MODID + ":assemblage_munition"));
        GameRegistry.registerTileEntity(TileEntityTableChimie.class, new ResourceLocation(Reference.MODID + ":table_chimie"));
    }
}
