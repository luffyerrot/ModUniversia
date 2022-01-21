package fr.luffyerrot.universia.Gui;

import java.io.IOException;

import fr.luffyerrot.universia.Container.ImprimanteContainer;
import fr.luffyerrot.universia.TileEntity.TileEntityImprimante;
import fr.luffyerrot.universia.init.ModItems;
import fr.luffyerrot.universia.network.PacketHandler;
import fr.luffyerrot.universia.network.packet.DoUpdateBlock;
import fr.luffyerrot.universia.network.packet.PacketGetImprimante;
import fr.luffyerrot.universia.utils.Reference;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiImprimante extends GuiContainer {

    private static final ResourceLocation background = new ResourceLocation(Reference.MODID + ":textures/gui/container/gui_imprimante.png");
    private final TileEntityImprimante tile;
    
    public static int selection = 1;
    private int sync = 0;
    
    public GuiImprimante(IInventory player, TileEntityImprimante tile) {
        super(new ImprimanteContainer(player, tile));
        this.tile = tile; 
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }
    
    public void initGui()
    {
        super.initGui();
        this.buttonList.add(new GuiButtonImage(1, (this.width - this.xSize) / 2 + 115, (this.height - this.ySize) / 2 + 52, 18, 18, 230, 22, 18, background));
        this.buttonList.add(new GuiButtonImage(2, (this.width - this.xSize) / 2 + 133, (this.height - this.ySize) / 2 + 52, 18, 18, 230, 59, 18, background));
    }

    @Override
    protected void actionPerformed(GuiButton B) throws IOException {

    	if (B.id == 1) {
    		PacketHandler.INSTANCE.sendToServer(new DoUpdateBlock(this.tile.getPos(), 1));
        }
    	
    	if (B.id == 2) {
    		PacketHandler.INSTANCE.sendToServer(new DoUpdateBlock(this.tile.getPos(), 2));
        }
        this.buttonList.clear();
        this.tile.markDirty();
        this.initGui();
        this.updateScreen();
    }

	@Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
    	
        this.drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(background);
        this.drawTexturedModalRect(i - 54, j, 0, 0, this.xSize + 54, this.ySize);

        if (this.tile.getField(0) > 0) {
            int burningTime = this.tile.getField(0);
            int textureHeight = (int) (12f / 7180 * burningTime);
            this.drawTexturedModalRect(i + 74, j + 38, 230, 0, 26, textureHeight);
        }
        
        if (this.tile.getField(1) > 0) {

            int timePassed = this.tile.getField(1);
            int textureWidth = (int) (11f / 480 * timePassed);
            this.drawTexturedModalRect(i + 83, j + 23, 230, 12, textureWidth, 10);
        }
        
        this.fontRenderer.drawString(this.tile.getName(), i, j - 10, 0xFFFFFF);

        sync++;
        sync %= 10;
        if (sync == 0) {
        	PacketHandler.INSTANCE.sendToServer(new PacketGetImprimante(this.tile.getPos(), this.mc.player.getAdjustedHorizontalFacing(), "fr.luffyerrot.universia.Gui.GuiImprimante", "selection"));
        }
        
        switch (selection) {
        	case 1:
        	default:
                this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(ModItems.billet50_faux), i + 160, j - 14);
                break;
        	case 2:
                this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(ModItems.billet100_faux), i + 160, j - 14);
                break;
        }
        
        this.fontRenderer.drawString("sélection : ", i + 106, j - 10, 0xFFFFFF);
    }
}
