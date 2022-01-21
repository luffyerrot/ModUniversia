package fr.luffyerrot.universia.Gui;

import fr.luffyerrot.universia.Container.TableAssemblageContainer;
import fr.luffyerrot.universia.TileEntity.TileEntityTableAssemblage;
import fr.luffyerrot.universia.utils.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiTableAssemblage extends GuiContainer {

    private static final ResourceLocation background = new ResourceLocation(Reference.MODID + ":textures/gui/container/gui_table_assemblage.png");
    private TileEntityTableAssemblage tile;

    public GuiTableAssemblage(InventoryPlayer player, TileEntityTableAssemblage tile) {
        super(new TableAssemblageContainer(player, tile));
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
        int textureWidth = (int) (23f / 480f * timePassed);
        this.drawTexturedModalRect(i + 92, j + 26, 230, 17, textureWidth, 7);

        if (this.tile.isBurning()) {
            int burningTime = this.tile.getField(0);
            int textureHeight = (int) (11f / this.tile.getFullBurnTime() * burningTime);
            this.drawTexturedModalRect(i + 39, j + 25, 230, 0, 25, textureHeight);
        }
        this.fontRenderer.drawString(this.tile.getName(), i, j - 10, 0xFFFFFF);
    }
}
