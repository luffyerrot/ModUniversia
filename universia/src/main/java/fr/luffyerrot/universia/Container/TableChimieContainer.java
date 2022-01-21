package fr.luffyerrot.universia.Container;

import fr.luffyerrot.universia.Block.machines.Slot.SlotTableAssemblageOutput;
import fr.luffyerrot.universia.TileEntity.TileEntityTableChimie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TableChimieContainer extends Container {

    private TileEntityTableChimie tile;
    private int	liquefaction = 0;
    private int	gazeification = 0;
    private int	pression = 0;
    private int	nivLiquide = 0;
    private int	burnTimeLeft = 0;

    public TableChimieContainer(InventoryPlayer playerInventory, TileEntityTableChimie tile) {
        this.tile = tile;

        this.addSlotToContainer(new Slot(tile, 0, -7, 11));

        this.addSlotToContainer(new Slot(tile, 1, -7, 35));
        
        this.addSlotToContainer(new Slot(tile, 2, -7, 59));
        
        this.addSlotToContainer(new Slot(tile, 3, 26, 35));
        
        this.addSlotToContainer(new Slot(tile, 4, 44, 35));
        
        this.addSlotToContainer(new Slot(tile, 5, 81, 5));
        
        this.addSlotToContainer(new Slot(tile, 6, 115, 35));
        
        this.addSlotToContainer(new Slot(tile, 7, 152, 35));
        
        this.addSlotToContainer(new Slot(tile, 8, 172, 11));
        
        this.addSlotToContainer(new SlotTableAssemblageOutput(tile, 9, 192, 35));

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

            if (this.liquefaction != this.tile.getField(1)) {
                icontainerlistener.sendWindowProperty(this, 1, this.tile.getField(1));
            }

            if (this.gazeification != this.tile.getField(2)) {
                icontainerlistener.sendWindowProperty(this, 2, this.tile.getField(2));
            }

            if (this.pression != this.tile.getField(3)) {
                icontainerlistener.sendWindowProperty(this, 3, this.tile.getField(3));
            }
            
            if (this.nivLiquide != this.tile.getField(4)) {
                icontainerlistener.sendWindowProperty(this, 4, this.tile.getField(4));
            }
        }

        this.burnTimeLeft = this.tile.getField(0);
        this.liquefaction = this.tile.getField(1);
        this.gazeification = this.tile.getField(2);
        this.pression = this.tile.getField(3);
        this.nivLiquide = this.tile.getField(4);
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
