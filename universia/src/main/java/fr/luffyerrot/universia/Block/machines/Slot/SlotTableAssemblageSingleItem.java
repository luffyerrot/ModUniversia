package fr.luffyerrot.universia.Block.machines.Slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotTableAssemblageSingleItem extends Slot {

    private Item item;

    public SlotTableAssemblageSingleItem(IInventory inventoryIn, int index, int xPosition, int yPosition, Item item) {
        super(inventoryIn, index, xPosition, yPosition);
        this.item = item;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return stack.isEmpty() || stack.getItem() == item;
    }
}
