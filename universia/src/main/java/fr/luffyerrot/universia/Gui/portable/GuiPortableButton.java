package fr.luffyerrot.universia.Gui.portable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiPortableButton extends GuiButtonImage {

	private ItemStack item;
	private int posX, posY, tailleX, tailleY, posImageX, posImageY, hauteurY;
	private ResourceLocation loc;
	
	public GuiPortableButton(int id, int posX, int posY, int tailleX, int tailleY, int posImageX, int posImageY, int hauteurY, ResourceLocation image, Item item) {
		super(id, posX, posY, tailleX, tailleY, posImageX, posImageY, hauteurY, image);
		this.item = new ItemStack(item);
		this.loc = image;
		this.posX = posX;
		this.posY = posY;
		this.tailleX = tailleX;
		this.tailleY = tailleY;
		this.posImageX = posImageX;
		this.posImageY = posImageY;
		this.hauteurY = hauteurY;
	}

	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
		GlStateManager.pushMatrix();
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.enableDepth();
        GlStateManager.disableLighting();
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableColorMaterial();
        GlStateManager.enableLighting();
		
		FontRenderer fr = mc.fontRenderer;
		mc.getTextureManager().bindTexture(this.loc);
		boolean mouseHovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
		this.mouseDragged(mc, mouseX, mouseY);
		int j = 0;
		if (mouseHovered) {
			j += this.hauteurY;
		}
		this.drawTexturedModalRect(this.posX, this.posY, this.posImageX, this.posImageY + j, this.tailleX, this.tailleY);
		
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        
		renderItem.zLevel = 100F;
        renderItem.renderItemAndEffectIntoGUI(item, this.posX, this.posY);
        renderItem.renderItemOverlays(fr, item, this.posX, this.posY);
        renderItem.zLevel = 0.0F;
        GlStateManager.popMatrix();
        GlStateManager.enableLighting();
        RenderHelper.enableStandardItemLighting();
		
	}
}
