package fr.luffyerrot.universia.Handlers;

import fr.luffyerrot.universia.Container.AssemblageArmeContainer;
import fr.luffyerrot.universia.Container.AssemblageMunitionContainer;
import fr.luffyerrot.universia.Container.CentrifugeuseContainer;
import fr.luffyerrot.universia.Container.DrillContainer;
import fr.luffyerrot.universia.Container.ImprimanteContainer;
import fr.luffyerrot.universia.Container.SechoirContainer;
import fr.luffyerrot.universia.Container.TableAssemblageContainer;
import fr.luffyerrot.universia.Container.TableChimieContainer;
import fr.luffyerrot.universia.Gui.GuiAssemblageArme;
import fr.luffyerrot.universia.Gui.GuiAssemblageMunition;
import fr.luffyerrot.universia.Gui.GuiCentrifugeuse;
import fr.luffyerrot.universia.Gui.GuiDrill;
import fr.luffyerrot.universia.Gui.GuiImprimante;
import fr.luffyerrot.universia.Gui.GuiSechoir;
import fr.luffyerrot.universia.Gui.GuiTableAssemblage;
import fr.luffyerrot.universia.Gui.GuiTableChimie;
import fr.luffyerrot.universia.Gui.portable.GuiPortableAccueil;
import fr.luffyerrot.universia.TileEntity.TileEntityAssemblageArme;
import fr.luffyerrot.universia.TileEntity.TileEntityAssemblageMunition;
import fr.luffyerrot.universia.TileEntity.TileEntityCentrifugeuse;
import fr.luffyerrot.universia.TileEntity.TileEntityDrill;
import fr.luffyerrot.universia.TileEntity.TileEntitySechoir;
import fr.luffyerrot.universia.TileEntity.TileEntityTableAssemblage;
import fr.luffyerrot.universia.TileEntity.TileEntityTableChimie;
import fr.luffyerrot.universia.TileEntity.TileEntityImprimante;
import fr.luffyerrot.universia.utils.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        if(ID == Reference.GUI_TABLE_ASSEMBLAGE) { 
        	return new TableAssemblageContainer(player.inventory, (TileEntityTableAssemblage)world.getTileEntity(new BlockPos(x,y,z)));
        }
        if(ID == Reference.GUI_IMPRIMANTE) { 
        	return new ImprimanteContainer(player.inventory, (TileEntityImprimante)world.getTileEntity(new BlockPos(x,y,z)));
        }
        if(ID == Reference.GUI_CENTRIFUGEUSE) {
        	return new CentrifugeuseContainer(player.inventory, (TileEntityCentrifugeuse)world.getTileEntity(new BlockPos(x,y,z)));
        }
        if(ID == Reference.GUI_SECHOIR) {
        	return new SechoirContainer(player.inventory, (TileEntitySechoir)world.getTileEntity(new BlockPos(x,y,z)));
        }
        if(ID == Reference.GUI_ASSEMBLAGE_ARME) {
        	return new AssemblageArmeContainer(player.inventory, (TileEntityAssemblageArme)world.getTileEntity(new BlockPos(x,y,z)));
        }
        if(ID == Reference.GUI_ASSEMBLAGE_MUNITION) {
        	return new AssemblageMunitionContainer(player.inventory, (TileEntityAssemblageMunition)world.getTileEntity(new BlockPos(x,y,z)));
        }
        if(ID == Reference.GUI_CHIMIE) {
        	return new TableChimieContainer(player.inventory, (TileEntityTableChimie)world.getTileEntity(new BlockPos(x,y,z)));
        }
        if(ID == Reference.GUI_DRILL) {
        	return new DrillContainer(player.inventory, (TileEntityDrill)world.getTileEntity(new BlockPos(x,y,z)));
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        if(ID == Reference.GUI_TABLE_ASSEMBLAGE) {
        	return new GuiTableAssemblage(player.inventory, (TileEntityTableAssemblage)world.getTileEntity(new BlockPos(x,y,z)));
        }
        if(ID == Reference.GUI_IMPRIMANTE) {
        	return new GuiImprimante(player.inventory, (TileEntityImprimante)world.getTileEntity(new BlockPos(x,y,z)));
        }
        if(ID == Reference.GUI_CENTRIFUGEUSE) {
        	return new GuiCentrifugeuse(player.inventory, (TileEntityCentrifugeuse)world.getTileEntity(new BlockPos(x,y,z)));
        }
        if(ID == Reference.GUI_SECHOIR) {
        	return new GuiSechoir(player.inventory, (TileEntitySechoir)world.getTileEntity(new BlockPos(x,y,z)));
        }
        if(ID == Reference.GUI_ASSEMBLAGE_ARME) {
        	return new GuiAssemblageArme(player.inventory, (TileEntityAssemblageArme)world.getTileEntity(new BlockPos(x,y,z)));
        }
        if(ID == Reference.GUI_ASSEMBLAGE_MUNITION) {
        	return new GuiAssemblageMunition(player.inventory, (TileEntityAssemblageMunition)world.getTileEntity(new BlockPos(x,y,z)));
        }
        if(ID == Reference.GUI_CHIMIE) {
        	return new GuiTableChimie(player.inventory, (TileEntityTableChimie)world.getTileEntity(new BlockPos(x,y,z)));
        }
        if(ID == Reference.GUI_DRILL) {
        	return new GuiDrill(player.inventory, (TileEntityDrill)world.getTileEntity(new BlockPos(x,y,z)));
        }
        if(ID == Reference.GUI_PORTABLE_ACCUEIL) {
        	return new GuiPortableAccueil();
        }
        return null;
    }
}
