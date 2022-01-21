package fr.luffyerrot.universia.Gui;

import fr.luffyerrot.universia.Container.TableChimieContainer;
import fr.luffyerrot.universia.TileEntity.TileEntityTableChimie;
import fr.luffyerrot.universia.utils.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiTableChimie extends GuiContainer {

    private static final ResourceLocation background = new ResourceLocation(Reference.MODID + ":textures/gui/container/gui_table_chimie.png");
    private TileEntityTableChimie tile;

    public GuiTableChimie(InventoryPlayer player, TileEntityTableChimie tile) {
        super(new TableChimieContainer(player, tile));
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
        this.drawTexturedModalRect(i - 41 , j, 0, 0, this.xSize + 81, this.ySize);
        
        if (this.tile.getField(1) > 0) {

            int liquefaction = this.tile.getField(1);
            int textureWidth1 = (int) (19f / this.tile.getFullRecipeTime1() * liquefaction);
            this.drawTexturedModalRect(i + 61, j + 39, 18, 167, textureWidth1, 10);
        }

        if (this.tile.getField(2) > 0) {
	        int gazeification = this.tile.getField(2);
	        int textureHeight1 = (int) (31f / this.tile.getFullRecipeTime2() * gazeification);
	        this.drawTexturedModalRect(i + 140, j + 20, 37, 166, 6, textureHeight1);
        }

        if (this.tile.getField(3) > 0) {
	        int pression = this.tile.getField(3);
	        int textureHeight2 = (int) (12f / this.tile.getFullRecipeTime3() * pression);
	        this.drawTexturedModalRect(i + 179, j + 28, 43, 166, 2, textureHeight2);
        }
        
        
        int nivLiquide = this.tile.getField(4); 
        int textureHeight3 = (int) (38f / this.tile.getFullNivLiquide() * nivLiquide);
        this.drawTexturedModalRect(i + 80, j + 62 - textureHeight3, 45, 204 - textureHeight3, 18, 1 + textureHeight3);

        if (this.tile.isBurning()) {
            int burningTime = this.tile.getField(0);
            int textureHeight = 0;
            if (this.tile.getFullBurnTime() != 0) {

                textureHeight = (int) (60f / this.tile.getFullBurnTime() * burningTime);
            }
            this.drawTexturedModalRect(i - 34, j + 72 - textureHeight, 0, 227 - textureHeight, 18, 1 + textureHeight);
        }
  
        this.fontRenderer.drawString(this.tile.getName(), i - 41, j - 10, 0xFFFFFF);
     }
}
