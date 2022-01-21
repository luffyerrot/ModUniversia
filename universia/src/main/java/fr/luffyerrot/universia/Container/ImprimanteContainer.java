package fr.luffyerrot.universia.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ImprimanteContainer extends Container {

    private IInventory tile;
    private int	timePassed = 0;
    private int	burnTimeLeft = 0;
    private int	selection = 0;

    public ImprimanteContainer(IInventory player, IInventory tile)
    {
    	this.tile = tile;

        this.addSlotToContainer(new Slot(tile, 0, 8, 20));
        this.addSlotToContainer(new Slot(tile, 1, 8, 53));
        this.addSlotToContainer(new Slot(tile, 2, 26, 53));
        this.addSlotToContainer(new Slot(tile, 3, 44, 53));
        this.addSlotToContainer(new Slot(tile, 4, 44, 20));
        this.addSlotToContainer(new Slot(tile, 5, 79, 53));
        this.addSlotToContainer(new Slot(tile, 6, 114, 20));
        this.addSlotToContainer(new Slot(tile, 7, 143, 20));

        for(int y = 0; y < 3; y++)
        {
            for(int x = 0; x < 9; x++)
            {
                this.addSlotToContainer(new Slot(player, x + y * 9 + 9, 8 + x*18, 84 + y * 18));
            }
        }

        for(int x = 0; x < 9; x++)
        {
            this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 142));
        }
    }

    /*@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
	    ItemStack previous = ItemStack.EMPTY;
	    Slot slot = (Slot) this.inventorySlots.get(fromSlot);

	    if (slot != null && slot.getHasStack()) {
	        ItemStack current = slot.getStack();
	        previous = current.copy();

	        if (fromSlot < this.handler.getSlots()) {
	            if (!this.mergeItemStack(current, handler.getSlots(), handler.getSlots() + 36, true))
	                return ItemStack.EMPTY;
	        } else {
	        	if(current.getItem() == ModItems.fiol_encre) {
	        		if(!this.mergeItemStack(current, 1, handler.getSlots(), false))
	        			return ItemStack.EMPTY;
	        	}
	        	if(current.getItem() == ModItems.papier_impression || current.getItem() == Items.PAPER) {
		            if (!this.mergeItemStack(current, 0, handler.getSlots(), false))
		                return ItemStack.EMPTY;
		            }
	        	}

	        if (current.getCount() == 0)
	            slot.putStack(ItemStack.EMPTY);
	        else
	            slot.onSlotChanged();

	        if (current.getCount() == previous.getCount())
	            return null;
	        slot.onTake(playerIn, current);
	    }
	    return previous;
	}*/

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tile.isUsableByPlayer(player);
    }

    @Override
    public void addListener(IContainerListener listener) {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.tile);
    }
    
    public IInventory getTileEntity()
    {
        return this.tile;
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for(int i = 0; i < this.listeners.size(); ++i) {
            IContainerListener icontainerlistener = (IContainerListener) this.listeners.get(i);

            if (this.burnTimeLeft != this.tile.getField(0)) {
                icontainerlistener.sendWindowProperty(this, 0, this.tile.getField(0));
            }

            if (this.timePassed != this.tile.getField(1)) {
                icontainerlistener.sendWindowProperty(this, 1, this.tile.getField(1));
            }

            if (this.selection != this.tile.getField(2)) {
                icontainerlistener.sendWindowProperty(this, 2, this.tile.getField(3));
            }
        }

        this.burnTimeLeft = this.tile.getField(0);
        this.timePassed = this.tile.getField(1);
        this.selection = this.tile.getField(2);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data) {
        this.tile.setField(id, data);
    }

    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        return ItemStack.EMPTY;
    }
}