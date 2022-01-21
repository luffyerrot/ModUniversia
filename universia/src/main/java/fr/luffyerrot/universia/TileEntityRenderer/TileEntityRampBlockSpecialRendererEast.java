package fr.luffyerrot.universia.TileEntityRenderer;

import fr.luffyerrot.universia.Model.RampBlock;
import fr.luffyerrot.universia.TileEntity.TileEntityRampBlockEast;
import fr.luffyerrot.universia.utils.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class TileEntityRampBlockSpecialRendererEast extends TileEntitySpecialRenderer<TileEntityRampBlockEast>{
	
	private static RampBlock modelBlock = new RampBlock();
	public static ResourceLocation texture = new ResourceLocation(Reference.MODID + ":textures/blocks/metal_ramp.png");
	
	public void renderTileEntityRampAt(TileEntityRampBlockEast tileEntity, double posX, double posY, double posZ, float partialTicks, int damageCount) {
		GlStateManager.pushMatrix();
	    GlStateManager.translate(posX + 0.0F, posY + 1.0F, posZ + 1.0F);
	    GlStateManager.rotate(180F, 1.0F, 0.0F, 0.0F);
	    GlStateManager.rotate(0F, 0.0F, 1.0F, 0.0F);
	    this.bindTexture(texture);
	    modelBlock.renderAll();
	    GlStateManager.popMatrix();
	}
	
	@Override
	public void render(TileEntityRampBlockEast te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		
		this.renderTileEntityRampAt(te, x, y, z, partialTicks, destroyStage);;
	}
}
