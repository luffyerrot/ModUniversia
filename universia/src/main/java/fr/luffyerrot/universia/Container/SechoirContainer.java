package fr.luffyerrot.universia.Container;

import fr.luffyerrot.universia.Block.machines.Slot.SlotTableAssemblageOutput;
import fr.luffyerrot.universia.TileEntity.TileEntitySechoir;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SechoirContainer extends Container {

    private TileEntitySechoir tile;
    private int	timePassed = 0;
    private int	burnTimeLeft = 0;

    public SechoirContainer(InventoryPlayer playerInventory, TileEntitySechoir tile) {
        this.tile = tile;

        this.addSlotToContainer(new Slot(tile, 0, 58, 11));

        this.addSlotToContainer(new Slot(tile, 1, 80, 11));
        
        this.addSlotToContainer(new Slot(tile, 2, 102, 11));
        
        this.addSlotToContainer(new Slot(tile, 3, 58, 33));
        
        this.addSlotToContainer(new Slot(tile, 4, 102, 33));
        
        this.addSlotToContainer(new Slot(tile, 5, 58, 55));
        
        this.addSlotToContainer(new Slot(tile, 6, 80, 55));
        
        this.addSlotToContainer(new Slot(tile, 7, 102, 55));
        
        this.addSlotToContainer(new Slot(tile, 8, 80, 33));
        
        this.addSlotToContainer(new SlotTableAssemblageOutput(tile, 9, 134, 33));

        int i;
        for(i = 0; i < 3; i++) {
            for(int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tile.isUsableByPlayer(player);
    }

    @Override
    public void addListener(IContainerListener listener) {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.tile);
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
        }

        this.burnTimeLeft = this.tile.getField(0);
        this.timePassed = this.tile.getField(1);
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
