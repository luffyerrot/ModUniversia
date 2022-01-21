package fr.luffyerrot.universia.Container;

import fr.luffyerrot.universia.Block.machines.Slot.SlotTableAssemblageOutput;
import fr.luffyerrot.universia.TileEntity.TileEntityCentrifugeuse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CentrifugeuseContainer extends Container {

    private TileEntityCentrifugeuse tile;
    private int	timePassed = 0;
    private int	burnTimeLeft = 0;

    public CentrifugeuseContainer(InventoryPlayer playerInventory, TileEntityCentrifugeuse tile) {
        this.tile = tile;


        //this.addSlotToContainer(new SlotTableAssemblageSingleItem(tile, 0, 8, 60, ModItems.batterie));

        this.addSlotToContainer(new Slot(tile, 1, 36, 7));

        this.addSlotToContainer(new Slot(tile, 2, 59, 19));
        
        this.addSlotToContainer(new Slot(tile, 3, 59, 51));
        
        this.addSlotToContainer(new Slot(tile, 4, 87, 12));
        
        this.addSlotToContainer(new Slot(tile, 5, 87, 58));
        
        this.addSlotToContainer(new Slot(tile, 6, 87, 35));
        
            
        this.addSlotToContainer(new SlotTableAssemblageOutput(tile, 7, 36, 35));
        this.addSlotToContainer(new SlotTableAssemblageOutput(tile, 8, 121, 22));
        this.addSlotToContainer(new SlotTableAssemblageOutput(tile, 9, 147, 22));
        this.addSlotToContainer(new SlotTableAssemblageOutput(tile, 10, 121, 48));
        this.addSlotToContainer(new SlotTableAssemblageOutput(tile, 11, 147, 48));

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
