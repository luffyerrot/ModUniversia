package fr.luffyerrot.universia.Gui;

import fr.luffyerrot.universia.utils.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiXpJob extends Gui{

	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/gui_xp_bar.png");
	
	public GuiXpJob(Minecraft mc) {
		ScaledResolution scaled = new ScaledResolution(mc);
		int width = scaled.getScaledWidth();
		int height = scaled.getScaledHeight();
		
		drawCenteredString(mc.fontRenderer, "Job xp bar :", (width / 2) + 130 , height - 25, Integer.parseInt("FFAA00", 16));
		
        GlStateManager.enableBlend();
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        mc.getTextureManager().bindTexture(TEXTURES);
		drawModalRectWithCustomSizedTexture((width / 2) + 100, height - 15, 0, 0, 102, 10, 102, 20);
	}
}
