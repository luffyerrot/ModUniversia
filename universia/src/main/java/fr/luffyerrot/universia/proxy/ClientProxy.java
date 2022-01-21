package fr.luffyerrot.universia.proxy;

import fr.luffyerrot.universia.Entity.EntityBalle;
import fr.luffyerrot.universia.Entity.EntityBottle;
import fr.luffyerrot.universia.Handlers.RenderGuiHandler;
import fr.luffyerrot.universia.TileEntity.TileEntityRampBlockEast;
import fr.luffyerrot.universia.TileEntity.TileEntityRampBlockNorth;
import fr.luffyerrot.universia.TileEntity.TileEntityRampBlockSouth;
import fr.luffyerrot.universia.TileEntity.TileEntityRampBlockWest;
import fr.luffyerrot.universia.TileEntityRenderer.TileEntityInventoryRenderHelper;
import fr.luffyerrot.universia.TileEntityRenderer.TileEntityRampBlockSpecialRendererEast;
import fr.luffyerrot.universia.TileEntityRenderer.TileEntityRampBlockSpecialRendererNorth;
import fr.luffyerrot.universia.TileEntityRenderer.TileEntityRampBlockSpecialRendererSouth;
import fr.luffyerrot.universia.TileEntityRenderer.TileEntityRampBlockSpecialRendererWest;
import fr.luffyerrot.universia.init.ModBlockColors;
import fr.luffyerrot.universia.init.ModBlocks;
import fr.luffyerrot.universia.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy{

    @Override
    public void preInit() {

        super.preInit();
    }

    @Override
    public void init() {

        super.init();
        TileEntityItemStackRenderer.instance = new TileEntityInventoryRenderHelper();
        Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(ModBlockColors.INSTANCE, ModBlocks.pommier);
    }

    @Override
    public void postInit() {

        super.postInit();
        MinecraftForge.EVENT_BUS.register(new RenderGuiHandler());
    }
    
    @SuppressWarnings("deprecation")
	@Override
    public void render() {
    	RenderingRegistry.registerEntityRenderingHandler(EntityBottle.class, new RenderSnowball<EntityBottle>(Minecraft.getMinecraft().getRenderManager(), ModItems.bierevide, Minecraft.getMinecraft().getRenderItem()));
    	RenderingRegistry.registerEntityRenderingHandler(EntityBalle.class, new RenderSnowball<EntityBalle>(Minecraft.getMinecraft().getRenderManager(), ModItems.balle, Minecraft.getMinecraft().getRenderItem()));
    	
    	GameRegistry.registerTileEntity(TileEntityRampBlockNorth.class, "tileEntityRampBlockNorth");
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRampBlockNorth.class, new TileEntityRampBlockSpecialRendererNorth());
    	GameRegistry.registerTileEntity(TileEntityRampBlockWest.class, "tileEntityRampBlockWest");
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRampBlockWest.class, new TileEntityRampBlockSpecialRendererWest());
    	GameRegistry.registerTileEntity(TileEntityRampBlockSouth.class, "tileEntityRampBlockSouth");
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRampBlockSouth.class, new TileEntityRampBlockSpecialRendererSouth());
    	GameRegistry.registerTileEntity(TileEntityRampBlockEast.class, "tileEntityRampBlockEast");
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRampBlockEast.class, new TileEntityRampBlockSpecialRendererEast());
    }
}
