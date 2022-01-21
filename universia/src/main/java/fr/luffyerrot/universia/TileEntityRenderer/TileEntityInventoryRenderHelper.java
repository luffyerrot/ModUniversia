package fr.luffyerrot.universia.TileEntityRenderer;

import fr.luffyerrot.universia.TileEntity.TileEntityRampBlockNorth;
import fr.luffyerrot.universia.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;

public class TileEntityInventoryRenderHelper extends TileEntityItemStackRenderer {

	private TileEntityRampBlockNorth tileEntityRampBlock = new TileEntityRampBlockNorth();
	 
    @Override
    public void renderByItem(ItemStack itemStack) {
        Block block = Block.getBlockFromItem(itemStack.getItem());
 
        if (block == ModBlocks.ramp) {
        	TileEntityRendererDispatcher.instance.render(this.tileEntityRampBlock, 0.0D, 0.0D, 0.0D, 0.0F);
        } else {
            super.renderByItem(itemStack);
        }
    }
}
