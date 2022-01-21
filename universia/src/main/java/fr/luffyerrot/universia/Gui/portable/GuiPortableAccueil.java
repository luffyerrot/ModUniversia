package fr.luffyerrot.universia.Gui.portable;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;

import fr.luffyerrot.universia.init.ModBlocks;
import fr.luffyerrot.universia.utils.Reference;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiPortableAccueil extends GuiScreen {

    private static final ResourceLocation background = new ResourceLocation(Reference.MODID + ":textures/gui/portable/gui_portable_accueil_vierge.png");
    private static final ResourceLocation boutton = new ResourceLocation(Reference.MODID + ":textures/gui/portable/gui_portable_boutton.png");
    
    protected int xSize = 126;
    protected int ySize = 186;
    private int i;
    private int j;
    
    public GuiPortableAccueil() {
    }
    
    public void initGui()
    {
    	this.i = (this.width - this.xSize) / 2;
        this.j = (this.height - this.ySize) / 2;
        this.buttonList.add(new GuiButtonImage(-1, i + 125, j + 25, 2, 10, 132, 33, 10, background));
        this.buttonList.add(new GuiButtonImage(0, i + 55, j + 176, 16, 4, 132, 0, 4, background));

        this.buttonList.add(new GuiPortableButton(-4, -20, -20, 16, 16, 32, 0, 16, boutton, Item.getItemFromBlock(Blocks.CRAFTING_TABLE)));
        this.buttonList.add(new GuiPortableButton(1, i + 19, j + 30, 16, 16, 32, 0, 16, boutton, Item.getItemFromBlock(Blocks.CRAFTING_TABLE)));
        this.buttonList.add(new GuiPortableButton(2, i + 43, j + 30, 16, 16, 32, 0, 16, boutton, Item.getItemFromBlock(ModBlocks.imprimante)));
        this.buttonList.add(new GuiPortableButton(3, i + 67, j + 30, 16, 16, 32, 0, 16, boutton, Item.getItemFromBlock(ModBlocks.table_assemblage)));
        this.buttonList.add(new GuiPortableButton(4, i + 91, j + 30, 16, 16, 32, 0, 16, boutton, Item.getItemFromBlock(ModBlocks.table_chimie)));
        
        this.buttonList.add(new GuiPortableButton(5, i + 19, j + 54, 16, 16, 32, 0, 16, boutton, Item.getItemFromBlock(ModBlocks.centrifugeuse)));
        this.buttonList.add(new GuiPortableButton(6, i + 43, j + 54, 16, 16, 32, 0, 16, boutton, Item.getItemFromBlock(ModBlocks.drill)));
        this.buttonList.add(new GuiPortableButton(7, i + 67, j + 54, 16, 16, 32, 0, 16, boutton, Item.getItemFromBlock(ModBlocks.assemblage_arme)));
        this.buttonList.add(new GuiPortableButton(8, i + 91, j + 54, 16, 16, 32, 0, 16, boutton, Item.getItemFromBlock(ModBlocks.assemblage_munition)));
    }

    @Override
    protected void actionPerformed(GuiButton B) throws IOException {

    	if (B.id == -1) {
    		this.mc.displayGuiScreen((GuiScreen) null);
    		this.mc.setIngameFocus();
        }
    	
    	if (B.id == 0) {
    		this.mc.displayGuiScreen(new GuiPortableAccueil());
    	}
    	
    	if (B.id == 1) {
    		this.mc.displayGuiScreen(new GuiCraftingTable());
        }
    	
    	if (B.id == 2) {
    		this.mc.displayGuiScreen(new GuiImprimante());
        }

    	if (B.id == 3) {
    	}
    	
    	if (B.id == 12) {
    		try {
    			Desktop.getDesktop().browse(new URL("http://universiarp.fr").toURI());
    		} catch (Exception e) {
    			System.out.println("Erreur url : " + e.getMessage());
    		}
    	}
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

    	drawBackgroundImage();
    	super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    public void drawBackgroundImage() {
    	GlStateManager.pushMatrix();
    	GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

    	this.drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(background);
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

    	GlStateManager.popMatrix();
    }
}
