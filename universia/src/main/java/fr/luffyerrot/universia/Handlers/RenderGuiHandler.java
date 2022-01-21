package fr.luffyerrot.universia.Handlers;

import fr.luffyerrot.universia.init.ModBlocks;
import fr.luffyerrot.universia.init.ModPotions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderGuiHandler {

    protected final Minecraft mc = Minecraft.getMinecraft();
    //private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/effects/acid/acid.png");
	
	@SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Post event)
    {
		if (event.getType() != ElementType.EXPERIENCE) return;
		if (this.mc.playerController.gameIsSurvivalOrAdventure()) {

			//new GuiXpJob(this.mc);			
		}
    }
	
	@SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Chat event)
    {
		if (mc.player.isPotionActive(ModPotions.DROGUE_EFFECT)) {
			ScaledResolution scaledRes = new ScaledResolution(mc);

	        GlStateManager.disableAlpha();
	        GlStateManager.disableDepth();
	        GlStateManager.depthMask(false);
	        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
	        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	        this.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
	        TextureAtlasSprite textureatlassprite = this.mc.getBlockRendererDispatcher().getBlockModelShapes().getTexture(ModBlocks.acid.getDefaultState());
	        float f = textureatlassprite.getMinU();
	        float f1 = textureatlassprite.getMinV();
	        float f2 = textureatlassprite.getMaxU();
	        float f3 = textureatlassprite.getMaxV();
	        Tessellator tessellator = Tessellator.getInstance();
	        BufferBuilder bufferbuilder = tessellator.getBuffer();
	        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
	        bufferbuilder.pos(0.0D, (double)scaledRes.getScaledHeight(), -90.0D).tex((double)f, (double)f3).endVertex();
	        bufferbuilder.pos((double)scaledRes.getScaledWidth(), (double)scaledRes.getScaledHeight(), -90.0D).tex((double)f2, (double)f3).endVertex();
	        bufferbuilder.pos((double)scaledRes.getScaledWidth(), 0.0D, -90.0D).tex((double)f2, (double)f1).endVertex();
	        bufferbuilder.pos(0.0D, 0.0D, -90.0D).tex((double)f, (double)f1).endVertex();
	        tessellator.draw();
	        GlStateManager.depthMask(true);
	        GlStateManager.enableDepth();
	        GlStateManager.enableAlpha();
	        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		}
    }
}
