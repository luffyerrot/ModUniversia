package fr.luffyerrot.universia.TileEntity;

import fr.luffyerrot.universia.Recipes.TableChimieRecipes;
import fr.luffyerrot.universia.init.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;

public class TileEntityTableChimie extends TileEntityLockable implements ITickable {

	private NonNullList<ItemStack> stacks = NonNullList.withSize(10, ItemStack.EMPTY);
    private String customName;
    private int	liquefaction;
    private Boolean	isLiquefaction;
    private int	gazeification;
    private Boolean	isGazeification;
    private int	pression;
    private Boolean	isPression;
    private int nivLiquide;
	private Boolean	isNivLiquide = false;
    private int	burningTimeLeft;
    private int power;
   
    @Override
    public void update() {
        if (!world.isRemote) {
        	if (this.getStackInSlot(5).getItem() == Items.WATER_BUCKET) {
        		if (this.nivLiquide <= 4) {

            		this.decrStackSize(5, 1);
                    this.setInventorySlotContents(5, new ItemStack (Items.BUCKET));
                    this.nivLiquide += 4;
                	isNivLiquide = true;
        		}
        	}

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
        		if (this.isPowered()) {
	            	if (this.canSmelt1()) {
	            		liquefaction++;
	                    if (liquefaction >= this.getFullRecipeTime1()) {
	                    	liquefaction = 0;
	                        this.smelt1();
	                    }
	                } else {
                    	liquefaction = 0;
                    }
	                    
	                if (this.canSmelt2()) {
	            		gazeification++;
	                    if (gazeification >= this.getFullRecipeTime2()) {
	                    	gazeification = 0;
	                        this.smelt2();
	                    }
	                } else {
                    	gazeification = 0;
                    }
	                    
	                if (this.canSmelt3()) {
	            		pression++;
	                    if (pression >= this.getFullRecipeTime3()) {
	                    	pression = 0;
	                        this.smelt3();
	                    }
	            	} else {
                    	pression = 0;
                    }
        		}
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
        this.liquefaction = compound.getInteger("liquefaction");
        this.gazeification = compound.getInteger("gazeification");
        this.pression = compound.getInteger("pression");
        this.nivLiquide = compound.getInteger("nivLiquide");
        this.isLiquefaction = compound.getBoolean("isliquefaction");
        this.isGazeification = compound.getBoolean("isgazeification");
        this.isPression = compound.getBoolean("ispression");
        this.isNivLiquide = compound.getBoolean("isnivLiquide");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        ItemStackHelper.saveAllItems(compound, this.stacks);

        if (this.hasCustomName()) {
            compound.setString("CustomName", this.customName);
        }

        compound.setInteger("burningTimeLeft", this.burningTimeLeft);
        compound.setInteger("liquefaction", this.liquefaction);
        compound.setInteger("gazeification", this.gazeification);
        compound.setInteger("pression", this.pression);
        compound.setInteger("nivLiquide", this.nivLiquide);
        compound.setBoolean("isliquefaction", this.isLiquefaction);
        compound.setBoolean("isgazeification", this.isGazeification);
        compound.setBoolean("ispression", this.isPression);
        compound.setBoolean("isnivLiquide", this.isNivLiquide);

        return compound;
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.isEmpty();
    }

    @Override
    public String getName() {
        return hasCustomName() ? this.customName : "Table de chimie";
    }

    public void setCustomName(String name) {
        this.customName = name;
    }

    @Override
    public int getField(int id) {
        switch (id) {
            case 0:
                return burningTimeLeft;
            case 1:
                return liquefaction;
            case 2:
                return gazeification;
            case 3:
                return pression;
            case 4:
                return nivLiquide;
        }
        return 0;
    }

    @Override
    public void setField(int id, int value) {
        switch (id) {
            case 0:
                burningTimeLeft = value;
                break;
            case 1:
            	liquefaction = value;
                break;
            case 2:
            	gazeification = value;
                break;
            case 3:
            	pression = value;
                break;
            case 4:
            	nivLiquide = value;
                break;
        }
    }

    @Override
    public int getFieldCount() {
        return 5;
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

    public ItemStack getRecipeResult1() {
        return TableChimieRecipes.getRecipeResult1(new ItemStack[] {this.getStackInSlot(0), this.getStackInSlot(1), this.getStackInSlot(2), this.getStackInSlot(3), this.getStackInSlot(4)});
    }
    
    public ItemStack getRecipeResult2() {
        return TableChimieRecipes.getRecipeResult2(new ItemStack[] {this.getStackInSlot(6)});
    }
    
    public ItemStack getRecipeResult3() {
        return TableChimieRecipes.getRecipeResult3(new ItemStack[] {this.getStackInSlot(7), this.getStackInSlot(8)});
    }

    public boolean canSmelt1() {
    	ItemStack result = this.getRecipeResult1();

        if (result != null) {

            if (this.nivLiquide < 8) {
            	isLiquefaction = true;
                return true;
            }
        }
    	isLiquefaction = false;
        return false;
    }
    
    public boolean canSmelt2() {
        ItemStack result = this.getRecipeResult2();

        if (result != null && this.nivLiquide >= 2) {

            ItemStack slot = this.getStackInSlot(7);

            if (slot.isEmpty()) {
            	isGazeification = true;
                return true;
            }

            int newStackSize = slot.getCount() + result.getCount();
            if (newStackSize <= this.getInventoryStackLimit()) {
            	isGazeification = true;
                return true;
            }
        }
    	isGazeification = false;
        return false;
    }
    
    public boolean canSmelt3() {
        ItemStack result = this.getRecipeResult3();

        if (result != null) {

            ItemStack slot = this.getStackInSlot(9);

            if (slot.isEmpty()) {
            	isPression = true;
                return true;
            }

            int newStackSize = slot.getCount() + result.getCount();
            if (newStackSize <= this.getInventoryStackLimit()) {
            	isPression = true;
                return true;
            }
        }
    	isPression = false;
        return false;
    }

    public void smelt1() {
        this.decrStackSize(0, 1);
        this.decrStackSize(1, 1);
        this.decrStackSize(2, 1);
        this.decrStackSize(3, 1);
        this.decrStackSize(4, 1);
        
        this.nivLiquide++;
    	isNivLiquide = true;
    }
    
    public void smelt2() {
        ItemStack result = this.getRecipeResult2();
        this.decrStackSize(6, 1);
        this.nivLiquide -= 2;
        ItemStack end = this.getStackInSlot(7);
        
        if (end.isEmpty()) {
            this.setInventorySlotContents(7, result.copy());
        } else {
        	end.grow(result.getCount());
        }
    }
    
    public void smelt3() {
        ItemStack result = this.getRecipeResult3();
        this.decrStackSize(7, 1);
        this.decrStackSize(8, 1);
        ItemStack end = this.getStackInSlot(9);
        
        if (end.isEmpty()) {
            this.setInventorySlotContents(9, result.copy());
        } else {
        	end.grow(result.getCount());
        }
    }
    
    public int getFullRecipeTime1() {
        return 100;//return 2100;
    }
    
    public int getFullRecipeTime2() {
    	return 100;//return 2850;
    }
    
    public int getFullRecipeTime3() {
    	return 100;//return 1600;
    }

    public int getFullBurnTime() {
        return 600;
    }

    public int getFullNivLiquide() {
        return 8;
    }
    
    public int getNivLiquide() {
        return nivLiquide;
    }
    
    public boolean isBurning() {
        return burningTimeLeft > 0;
    }
    
    public boolean isLiquefaction() {
        return isLiquefaction;
    }
    
    public boolean isGazeification() {
        return isGazeification;
    }
    
    public boolean isPression() {
        return isPression;
    }
    
    public boolean isNivLiquide() {
        return isNivLiquide;
    }
    
    public boolean isPowered() {
        return power >= 200;
    }
}