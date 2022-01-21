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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiCraftingTable  extends GuiScreen {
	
    private static final ResourceLocation background = new ResourceLocation(Reference.MODID + ":textures/gui/portable/gui_portable_crafting.png");

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
        if (!(this.page == 6)) {
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
        this.itemRender.renderItemIntoGUI(new ItemStack(Item.getItemFromBlock(Blocks.CRAFTING_TABLE)), i + 55, j + 31);
        List<ItemStack> items = new ArrayList();
        ItemStack[] itemStacks1 = null;
        switch (this.page) {
        	case 0:
        	default:
        		itemStacks1 = ajoutItemStack(
        				ModItems.papier_plastique, 0, ModItems.papier_plastique, 0, ModItems.papier_plastique, 0,
        				Items.PAPER, 0, Items.PAPER, 0, Items.PAPER, 0,
        				ModItems.papier_plastique, 0, ModItems.papier_plastique, 0, ModItems.papier_plastique, 0,
        				ModItems.papier_impression, 0
        				);
        		
        		for (int b = 0; b < itemStacks1.length; b++) {
            		items.add(itemStacks1[b]);
        		}

        		/*this.fontRenderer.FONT_HEIGHT = 8;
                this.fontRenderer.drawSplitString("Le papier d'impression est utilisé pour imprimer de faux billets.", i + 14, j + 111, 104, Color.GRAY.getRGB());
                this.fontRenderer.drawSplitString("Le papier d'impression est utilisé pour imprimer de faux billets.", i + 13, j + 110, 104, Color.BLACK.getRGB());*/
        		break;
        	case 2:
        		itemStacks1 = ajoutItemStack(
        				Items.IRON_INGOT, 0, Items.REDSTONE, 0, Items.IRON_INGOT, 0,
        				Items.IRON_INGOT, 0, Item.getItemFromBlock(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE), 0, Items.IRON_INGOT, 0,
        				Items.IRON_INGOT, 0, Items.BLAZE_POWDER, 0, Items.IRON_INGOT, 0,
        				ModItems.pile, 0
        				);
        		
        		for (int b = 0; b < itemStacks1.length; b++) {
            		items.add(itemStacks1[b]);
        		}	
        		break;
        	case 3:
        		itemStacks1 = ajoutItemStack(
        				ModItems.pile, 0, Items.REDSTONE, 0, ModItems.pile, 0,
        				Items.IRON_INGOT, 0, Items.IRON_INGOT, 0, Items.IRON_INGOT, 0,
        				ModItems.pile, 0, Items.REDSTONE, 0, ModItems.pile, 0,
        				ModItems.batterie, 0
        				);
        		
        		for (int b = 0; b < itemStacks1.length; b++) {
            		items.add(itemStacks1[b]);
        		}
        		break;
        	case 4:
        		itemStacks1 = ajoutItemStack(
        				Item.getItemFromBlock(Blocks.STAINED_GLASS), 14, Item.getItemFromBlock(Blocks.STAINED_GLASS), 14, Item.getItemFromBlock(Blocks.STAINED_GLASS), 14,
        				Item.getItemFromBlock(ModBlocks.opaque_noire), 0, Items.GLOWSTONE_DUST, 0, Item.getItemFromBlock(ModBlocks.opaque_noire), 0,
        				Item.getItemFromBlock(Blocks.STAINED_GLASS), 14, Item.getItemFromBlock(Blocks.STAINED_GLASS), 14, Item.getItemFromBlock(Blocks.STAINED_GLASS), 14,
        				Item.getItemFromBlock(ModBlocks.infrarouge), 0
        				);
        		
        		for (int b = 0; b < itemStacks1.length; b++) {
            		items.add(itemStacks1[b]);
        		}
        		break;
        	case 5:
        		itemStacks1 = ajoutItemStack(
        				Items.PAPER, 0, Items.PAPER, 0, Items.PAPER, 0,
        				Items.PAPER, 0, Item.getItemFromBlock(ModBlocks.poudre_vierge), 0, Items.PAPER, 0,
        				Items.PAPER, 0, Items.PAPER, 0, Items.PAPER, 0,
        				ModItems.sachet_poudre, 0
        				);
        		
        		for (int b = 0; b < itemStacks1.length; b++) {
            		items.add(itemStacks1[b]);
        		}
        		break;
        	case 6:
        		itemStacks1 = ajoutItemStack(
        				Item.getItemFromBlock(Blocks.PLANKS), 0, Item.getItemFromBlock(Blocks.AIR), 0, Item.getItemFromBlock(Blocks.PLANKS), 0,
        				Item.getItemFromBlock(Blocks.PLANKS), 0, Item.getItemFromBlock(Blocks.CHEST), 0, Item.getItemFromBlock(Blocks.PLANKS), 0,
        				Item.getItemFromBlock(Blocks.PLANKS), 0, Item.getItemFromBlock(Blocks.PLANKS), 0, Item.getItemFromBlock(Blocks.PLANKS), 0,
        				Item.getItemFromBlock(ModBlocks.drog_box), 0
        				);
        		
        		for (int b = 0; b < itemStacks1.length; b++) {
            		items.add(itemStacks1[b]);
        		}
        		break;
        }
        
        for (int c = 0; c < items.size(); c++) {

        	int v = c;
        	if (v < 3) {

        		this.itemRender.renderItemIntoGUI(items.get(c), i + 24 + (v * 17), j + 55);
        	} else if (v < 6) {

        		this.itemRender.renderItemIntoGUI(items.get(c), i + 24 + ((v - 3) * 17), j + 72);
        	} else if (v < 9) {

        		this.itemRender.renderItemIntoGUI(items.get(c), i + 24 + ((v - 6) * 17), j + 89);
        	} else {

        		this.itemRender.renderItemIntoGUI(items.get(c), i + 82, j + 72);
        	}
        }

        RenderHelper.enableGUIStandardItemLighting();
    	GlStateManager.popMatrix();
    }
    
    public ItemStack[] ajoutItemStack(
    		Item i1, int meta1, Item i2, int meta2, Item i3, int meta3, 
    		Item i4, int meta4, Item i5, int meta5, Item i6, int meta6, 
    		Item i7, int meta7, Item i8, int meta8, Item i9, int meta9, 
    		Item i10, int meta10) {
    	
    	ItemStack[] itemStacks = {
    			new ItemStack(i1, 1, meta1), new ItemStack(i2, 1, meta2), new ItemStack(i3, 1, meta3), 
    			new ItemStack(i4, 1, meta4), new ItemStack(i5, 1, meta5), new ItemStack(i6, 1, meta6), 
    			new ItemStack(i7, 1, meta7), new ItemStack(i8, 1, meta8), new ItemStack(i9, 1, meta9), 
    			new ItemStack(i10, 1, meta10)};
    	return itemStacks;
    }
}
