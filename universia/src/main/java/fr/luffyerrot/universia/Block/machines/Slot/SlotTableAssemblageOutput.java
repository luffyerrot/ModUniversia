package fr.luffyerrot.universia.Block.machines.Slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotTableAssemblageOutput extends Slot {

    public SlotTableAssemblageOutput(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return false;
    }

    @Override
    public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {

        this.onCrafting(stack);
        super.onTake(thePlayer, stack);
        return stack;
    }

    @Override
    public ItemStack decrStackSize(int amount) {

        if (this.getHasStack())
			Math.min(amount, this.getStack().getCount());
        return super.decrStackSize(amount);
    }
}
