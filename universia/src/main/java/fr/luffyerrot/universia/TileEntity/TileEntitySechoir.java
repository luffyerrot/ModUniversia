package fr.luffyerrot.universia.TileEntity;

import fr.luffyerrot.universia.Recipes.SechoirRecipes;
import fr.luffyerrot.universia.init.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;

public class TileEntitySechoir extends TileEntityLockable implements ITickable {

    private NonNullList<ItemStack> stacks = NonNullList.withSize(10, ItemStack.EMPTY);
    private String customName;
    private int	timePassed = 0;
    private int	burningTimeLeft	= 0;
    private int power = 0;

    @Override
    public void update() {
        if (!world.isRemote) {
        	
        	if (checkGen()[0] > 0) {
        		if (checkGen()[0] == 1) {
        			power = 200;
        			burningTimeLeft = 150;
        			if (checkGen()[1] > 3) {
        				power = 0;
            			burningTimeLeft = 0;
        			} else if (checkGen()[1] > 2) {
            			burningTimeLeft = 50;
        			} else if (checkGen()[1] > 1) {
            			burningTimeLeft = 100;
        			}
        		} else if(checkGen()[0] == 2) {
        			power = 200;
        			burningTimeLeft = 300;
        			if (checkGen()[1] > 6) {
        				power = 0;
            			burningTimeLeft = 0;
        			} else if (checkGen()[1] > 5) {
            			burningTimeLeft = 50;
        			} else if (checkGen()[1] > 4) {
            			burningTimeLeft = 100;
        			} else if (checkGen()[1] > 3) {
            			burningTimeLeft = 150;
        			} else if (checkGen()[1] > 2) {
            			burningTimeLeft = 200;
        			} else if (checkGen()[1] > 1) {
            			burningTimeLeft = 250;
        			}
        		} else if(checkGen()[0] == 3) {
        			power = 200;
        			burningTimeLeft = 450;
        			if (checkGen()[1] > 9) {
        				power = 0;
            			burningTimeLeft = 0;
        			} else if (checkGen()[1] > 8) {
            			burningTimeLeft = 50;
        			} else if (checkGen()[1] > 7) {
            			burningTimeLeft = 100;
        			} else if (checkGen()[1] > 6) {
            			burningTimeLeft = 150;
        			} else if (checkGen()[1] > 5) {
            			burningTimeLeft = 200;
        			} else if (checkGen()[1] > 4) {
            			burningTimeLeft = 250;
        			} else if (checkGen()[1] > 3) {
            			burningTimeLeft = 300;
        			} else if (checkGen()[1] > 2) {
            			burningTimeLeft = 350;
        			} else if (checkGen()[1] > 1) {
            			burningTimeLeft = 400;
        			}
        		} else if(checkGen()[0] >= 4) {
        			power = 200;
        			burningTimeLeft = 600;
        			if (checkGen()[1] > 12) {
        				power = 0;
            			burningTimeLeft = 0;
        			} else if (checkGen()[1] > 11) {
            			burningTimeLeft = 50;
        			} else if (checkGen()[1] > 10) {
            			burningTimeLeft = 100;
        			} else if (checkGen()[1] > 9) {
            			burningTimeLeft = 150;
        			} else if (checkGen()[1] > 8) {
            			burningTimeLeft = 200;
        			} else if (checkGen()[1] > 7) {
            			burningTimeLeft = 250;
        			} else if (checkGen()[1] > 6) {
            			burningTimeLeft = 300;
        			} else if (checkGen()[1] > 5) {
            			burningTimeLeft = 350;
        			} else if (checkGen()[1] > 4) {
            			burningTimeLeft = 400;
        			} else if (checkGen()[1] > 3) {
            			burningTimeLeft = 450;
        			} else if (checkGen()[1] > 2) {
            			burningTimeLeft = 500;
        			} else if (checkGen()[1] > 1) {
            			burningTimeLeft = 550;
        			}
        		}
        	} else {
    			power = 0;
    			burningTimeLeft = 0;
    		}
    		
        	if (power >= 200) {

                if (this.isPowered() && this.canSmelt()) {
                    this.timePassed++;
                    if (timePassed >= this.getFullRecipeTime()) {
                        timePassed = 0;
                        this.smelt();
                    }
                } else {
                    timePassed = 0;
                }
                this.markDirty();
                
        		/*if (this.isBurning()) {
                    this.burningTimeLeft--;
                }

                if (!this.isBurning() && this.canSmelt() && !this.hasFuelEmpty()) {
                    this.burningTimeLeft = this.getFullBurnTime();
                    this.decrStackSize(0, 1);
                }
                if (this.isBurning() && this.canSmelt()) {
                    this.timePassed++;
                    if (timePassed >= this.getFullRecipeTime()) {
                        timePassed = 0;
                        this.smelt();
                    }
                } else {
                    timePassed = 0;
                }
                this.markDirty();*/
        	}
        }
    }
    
    public int[] checkGen() {
    	int[] machines = {0, 0};
		for (BlockPos.MutableBlockPos blockpos$mutableblockpos : BlockPos.getAllInBoxMutable(pos.add(-3, 0, -3), pos.add(3, 3, 3)))
        {
            if (world.getBlockState(blockpos$mutableblockpos).getBlock() == ModBlocks.generateur)
            {
            	machines[0]++;
            }
            if (world.getBlockState(blockpos$mutableblockpos).getBlock() == ModBlocks.centrifugeuse || world.getBlockState(blockpos$mutableblockpos).getBlock() == ModBlocks.assemblage_arme || 
            		world.getBlockState(blockpos$mutableblockpos).getBlock() == ModBlocks.sechoir || world.getBlockState(blockpos$mutableblockpos).getBlock() == ModBlocks.assemblage_munition || 
            		world.getBlockState(blockpos$mutableblockpos).getBlock() == ModBlocks.table_chimie)
            {
            	machines[1]++;
            }
        }
		return machines;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.stacks = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.stacks);

        if (compound.hasKey("CustomName", 8)) {
            this.customName = compound.getString("CustomName");
        }
        this.burningTimeLeft = compound.getInteger("burningTimeLeft");
        this.timePassed = compound.getInteger("timePassed");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        ItemStackHelper.saveAllItems(compound, this.stacks);

        if (this.hasCustomName()) {
            compound.setString("CustomName", this.customName);
        }

        compound.setInteger("burningTimeLeft", this.burningTimeLeft);
        compound.setInteger("timePassed", this.timePassed);

        return compound;
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.isEmpty();
    }

    @Override
    public String getName() {
        return hasCustomName() ? this.customName : "Sechoir";
    }

    public void setCustomName(String name) {
        this.customName = name;
    }

    @Override
    public int getField(int id) {
        switch (id) {
            case 0:
                return this.burningTimeLeft;
            case 1:
                return this.timePassed;
        }
        return 0;
    }

    @Override
    public void setField(int id, int value) {
        switch (id) {
            case 0:
                this.burningTimeLeft = value;
                break;
            case 1:
                this.timePassed = value;
                break;
        }
    }

    @Override
    public int getFieldCount() {
        return 2;
    }

    @Override
    public int getSizeInventory() {
        return this.stacks.size();
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return this.stacks.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.stacks, index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(stacks, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        this.stacks.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack stack : this.stacks) {
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for(int i = 0; i < this.stacks.size(); i++) {
            this.stacks.set(i, ItemStack.EMPTY);
        }
    }

    @Override
    public void openInventory(EntityPlayer player) {}

    @Override
    public void closeInventory(EntityPlayer player) {}

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return null;
    }

    @Override
    public String getGuiID() {
        return null;
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (index == 10) {
            return false;
        }
        return true;
    }

    public boolean isUsableByPlayer(EntityPlayer player) {
        return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
    }

    public boolean hasFuelEmpty() {
        //return this.getStackInSlot(0).isEmpty();
    	return false;
    }

    public ItemStack getRecipeResult() {
        return SechoirRecipes.getRecipeResult(new ItemStack[] {this.getStackInSlot(0), this.getStackInSlot(1), this.getStackInSlot(2), this.getStackInSlot(3), 
        		this.getStackInSlot(4), this.getStackInSlot(5), this.getStackInSlot(6), this.getStackInSlot(7), this.getStackInSlot(8)});
    }

    public boolean canSmelt() {
        ItemStack result = this.getRecipeResult();

        if (result != null) {

            ItemStack slot = this.getStackInSlot(9);

            if (slot.isEmpty())
                return true;

            int newStackSize = slot.getCount() + result.getCount();
            if (newStackSize <= this.getInventoryStackLimit()) {
                return true;
            }
        }
        return false;
    }

    public void smelt() {
        ItemStack result = this.getRecipeResult();
        this.decrStackSize(0, 1);
        this.decrStackSize(1, 1);
        this.decrStackSize(2, 1);
        this.decrStackSize(3, 1);
        this.decrStackSize(4, 1);
        this.decrStackSize(5, 1);
        this.decrStackSize(6, 1);
        this.decrStackSize(7, 1);
        this.decrStackSize(8, 1);
        ItemStack end = this.getStackInSlot(9);
        
        if (end.isEmpty()) {
            this.setInventorySlotContents(9, result.copy());
        } else {
        	end.grow(result.getCount());
        }
    }
    public int getFullRecipeTime() {
        return 6350;
    }

    public int getFullBurnTime() {
        return 600;
    }

    public boolean isBurning() {
        return burningTimeLeft > 0;
    }
    
    public boolean isPowered() {
        return power >= 200;
    }
}