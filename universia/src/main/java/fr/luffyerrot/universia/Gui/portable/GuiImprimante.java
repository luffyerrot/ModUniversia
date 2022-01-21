package fr.luffyerrot.universia.Gui.portable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.luffyerrot.universia.init.ModBlocks;
import fr.luffyerrot.universia.init.ModItems;
import fr.luffyerrot.universia.utils.Reference;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiImprimante  extends GuiScreen {
	
    private static final ResourceLocation background = new ResourceLocation(Reference.MODID + ":textures/gui/portable/gui_portable_imprimante.png");

    protected int xSize = 126;
    protected int ySize = 186;
    private int i;
    private int j;
    public int page = 0;

	public void initGui()
    {
    	this.i = (this.width - this.xSize) / 2;
        this.j = (this.height - this.ySize) / 2;
        this.buttonList.add(new GuiButtonImage(-1, i + 125, j + 25, 2, 10, 132, 33, 10, background));
        this.buttonList.add(new GuiButtonImage(0, i + 55, j + 176, 16, 4, 132, 0, 4, background));
        if (!(this.page == 0)) {
            this.buttonList.add(new GuiButtonImage(1, i + 14, j + 154, 14, 6, 132, 21, 6, background));
        }
        if (!(this.page == 2)) {
            this.buttonList.add(new GuiButtonImage(2, i + 98, j + 154, 14, 6, 132, 8, 6, background));
        }
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
    		if (this.page == 2) {
    			this.page = 0;
    		} else {
        		this.page --;
    		}
    	}
    	
    	if (B.id == 2) {
    		this.page ++;
    	}
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
    
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

    	drawBackgroundImage();
    	super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void drawBackgroundImage() {
    	GlStateManager.pushMatrix();
    	GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

    	this.drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(background);
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
        RenderHelper.enableGUIStandardItemLighting();
        this.itemRender.renderItemIntoGUI(new ItemStack(Item.getItemFromBlock(ModBlocks.imprimante)), i + 55, j + 31);
        List<ItemStack> items = new ArrayList();
        ItemStack[] itemStacks1 = null;
        switch (this.page) {
        	case 0:
        	default:
        		itemStacks1 = ajoutItemStack(
        				ModItems.fiol_encre, 0, ModItems.fiol_encre_jaune, 0, ModItems.fiol_encre_cyan, 0, ModItems.fiol_encre_magenta, 0, 
        				ModItems.papier_impression, 0, ModItems.billet50_faux, 0
        				);
        		
        		for (int b = 0; b < itemStacks1.length; b++) {
            		items.add(itemStacks1[b]);
        		}
        		break;
        	case 2:
        		itemStacks1 = ajoutItemStack(
        				ModItems.fiol_encre, 0, ModItems.fiol_encre_jaune, 0, ModItems.fiol_encre_cyan, 0, ModItems.fiol_encre_magenta, 0, 
        				ModItems.papier_impression, 0, ModItems.billet100_faux, 0
        				);
        		
        		for (int b = 0; b < itemStacks1.length; b++) {
            		items.add(itemStacks1[b]);
        		}	
        		break;
        }
        
        for (int c = 0; c < items.size(); c++) {

        	int v = c;
        	if (v < 4) {
        		
        		this.itemRender.renderItemIntoGUI(items.get(c), i + 30 + (v * 17), j + 55);
        	} else if (v < 5) {

        		this.itemRender.renderItemIntoGUI(items.get(c), i + 55, j + 69);
        	} else {
        		
        		this.itemRender.renderItemIntoGUI(items.get(c), i + 55, j + 86);
        	}
        }

        RenderHelper.enableGUIStandardItemLighting();
    	GlStateManager.popMatrix();
    }
    
    public ItemStack[] ajoutItemStack(
    		Item i1, int meta1, Item i2, int meta2, Item i3, int meta3, Item i4, int meta4, 
    		Item i5, int meta5, Item i6, int meta6) {
    	
    	ItemStack[] itemStacks = {
    			new ItemStack(i1, 1, meta1), new ItemStack(i2, 1, meta2), new ItemStack(i3, 1, meta3), new ItemStack(i4, 1, meta4), 
    			new ItemStack(i5, 1, meta5), new ItemStack(i6, 1, meta6)};
    	return itemStacks;
    }
}
