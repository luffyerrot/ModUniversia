package fr.luffyerrot.universia.Container;

import fr.luffyerrot.universia.Block.machines.Slot.SlotTableAssemblageOutput;
import fr.luffyerrot.universia.Block.machines.Slot.SlotTableAssemblageSingleItem;
import fr.luffyerrot.universia.TileEntity.TileEntityTableAssemblage;
import fr.luffyerrot.universia.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TableAssemblageContainer extends Container {

    private TileEntityTableAssemblage tile;
    private int	timePassed = 0;
    private int	burnTimeLeft = 0;

    public TableAssemblageContainer(InventoryPlayer playerInventory, TileEntityTableAssemblage tile) {
        this.tile = tile;


        this.addSlotToContainer(new Slot(tile, 0, 12, 27));

        this.addSlotToContainer(new Slot(tile, 2, 12, 7));

        this.addSlotToContainer(new Slot(tile, 1, 67, 7));
        
        this.addSlotToContainer(new SlotTableAssemblageSingleItem(tile, 3, 44, 40, ModItems.batterie));
            
        this.addSlotToContainer(new SlotTableAssemblageOutput(tile, 4, 128, 21));
        this.addSlotToContainer(new SlotTableAssemblageOutput(tile, 5, 67, 40));

        int i;
        for(i = 0; i < 3; i++) {
            for(int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 142));
        }

        for (i = 0; i < 9; i++){
            this.addSlotToContainer(new Slot(tile, i + 6, 8 + i * 18, 61));
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
