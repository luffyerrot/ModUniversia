package fr.luffyerrot.universia.Gui;

import fr.luffyerrot.universia.Container.AssemblageArmeContainer;
import fr.luffyerrot.universia.TileEntity.TileEntityAssemblageArme;
import fr.luffyerrot.universia.utils.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiAssemblageArme extends GuiContainer {

    private static final ResourceLocation background = new ResourceLocation(Reference.MODID + ":textures/gui/container/gui_assemblage_arme.png");
    private TileEntityAssemblageArme tile;

    public GuiAssemblageArme(InventoryPlayer player, TileEntityAssemblageArme tile) {
        super(new AssemblageArmeContainer(player, tile));
        this.tile = tile;
    }
    
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

	@Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;

        this.drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(background);
        this.drawTexturedModalRect(i - 54, j, 0, 0, this.xSize + 54, this.ySize);

        int timePassed = this.tile.getField(1);
        int textureWidth = (int) (15f / this.tile.getFullRecipeTime() * timePassed);
        this.drawTexturedModalRect(i + 124, j + 33, 230, 62, textureWidth, 16);

        if (this.tile.isBurning()) {
            int burningTime = this.tile.getField(0);
            int textureHeight = 0;
            if (this.tile.getFullBurnTime() != 0) {

                textureHeight = (int) (60f / this.tile.getFullBurnTime() * burningTime);
            }
            this.drawTexturedModalRect(i + 8, j + 72 - textureHeight, 231, 61 - textureHeight, 16, 1 + textureHeight);
        }
        this.fontRenderer.drawString(this.tile.getName(), i, j - 10, 0xFFFFFF);
    }
}