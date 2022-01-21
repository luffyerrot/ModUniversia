package fr.luffyerrot.universia.TileEntity;

import javax.annotation.Nullable;

import fr.luffyerrot.universia.Handlers.SoundHandler;
import fr.luffyerrot.universia.Recipes.imprimante.ImprimanteRecipe1;
import fr.luffyerrot.universia.Recipes.imprimante.ImprimanteRecipe2;
import fr.luffyerrot.universia.init.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityImprimante extends TileEntity implements ITickable, ISidedInventory {

	private NonNullList<ItemStack> stacks = NonNullList.withSize(8, ItemStack.EMPTY);
    private String customName;
    private int	timePassed;
    private int	burningTimeLeft;
    private int selection = 1;
    private int oldSelection = 1;
    private int sound = 0;

	@Override
    public void update() {
        if (!world.isRemote) {
            
            if (!this.isBurning() && this.canSmelt() && !this.hasFuelEmpty()) {
                this.burningTimeLeft = this.getFullBurnTime();
                this.decrStackSize(5, 1);
            }
            if (this.selection != this.oldSelection) {
            	this.timePassed = 0;
            }
            this.oldSelection = this.selection;
            
            if (this.isBurning() && this.canSmelt()) {

                this.burningTimeLeft--;
                this.timePassed++;
                if (this.sound < 220) {
    				this.sound++;
    			} else {
    				world.playSound(null, this.getPos(), SoundHandler.IMPRIMANTE_ON, SoundCategory.BLOCKS, 10.0F, 1.0F);
    				this.sound = 0;
    			}
                if (timePassed >= this.getFullRecipeTime()) {
                    timePassed = 0;
                    this.smelt();
    				world.playSound(null, this.getPos(), SoundHandler.IMPRIMANTE_END, SoundCategory.BLOCKS, 10.0F, 1.0F);
	            }
            } else {
                timePassed = 0;
        	}
            this.markDirty();
        }
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
        this.selection = compound.getInteger("selection");
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
        compound.setInteger("selection", this.selection);

        return compound;
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.isEmpty();
    }

    @Override
    public String getName() {
        return hasCustomName() ? this.customName : "Imprimante";
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
            case 2:
                return this.selection;
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
            case 2:
                this.selection = value;
        }
    }

    @Override
    public int getFieldCount() {
        return 3;
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
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (index == 7 || index == 8) {
            return false;
        }
        return true;
    }

    public boolean isUsableByPlayer(EntityPlayer player) {
        return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
    }

    public boolean hasFuelEmpty() {
        return this.getStackInSlot(5).isEmpty();
    }

    public ItemStack getRecipeResult() {
    	switch (this.selection) {
    	case 1:
    	default:
            return ImprimanteRecipe1.getRecipeResult(new ItemStack[] {this.getStackInSlot(0), this.getStackInSlot(1), this.getStackInSlot(2), this.getStackInSlot(3), this.getStackInSlot(4)});
    	case 2:
            return ImprimanteRecipe2.getRecipeResult(new ItemStack[] {this.getStackInSlot(0), this.getStackInSlot(1), this.getStackInSlot(2), this.getStackInSlot(3), this.getStackInSlot(4)});
    	}
    }

    public boolean canSmelt() {
        ItemStack result = this.getRecipeResult();
        ItemStack slot6 = this.getStackInSlot(5);
        ItemStack slot7 = this.getStackInSlot(6);
        ItemStack slot8 = this.getStackInSlot(7);
        
        if (result != null) {
        	
        	if(!slot7.isEmpty()) {
            	if (!(result.getItem() == slot7.getItem())) {
                    return false;
            	}
            }

            if (slot8.getCount() > 60)
                return false;
            
            if (slot7.isEmpty())
                return true;
            
            if (slot6.getItem() == ModItems.batterie) {
                int newStackSize = slot7.getCount() + result.getCount();
                if (newStackSize <= this.getInventoryStackLimit() && newStackSize <= slot7.getMaxStackSize()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void smelt() {
        ItemStack result = this.getRecipeResult();
        ItemStack result2 = new ItemStack(ModItems.fiol, 4);
        this.decrStackSize(0, 1);
        this.decrStackSize(1, 1);
        this.decrStackSize(2, 1);
        this.decrStackSize(3, 1);
        this.decrStackSize(4, 1);
        ItemStack stack6 = this.getStackInSlot(6);
        ItemStack bottle = this.getStackInSlot(7);
        if (stack6.isEmpty()) {
            this.setInventorySlotContents(6, result.copy());
        } else {
        	stack6.grow(result.getCount());
        }
        if (bottle.isEmpty()){
            this.setInventorySlotContents(7, result2.copy());
        }else {
            bottle.grow(result2.getCount());
        }
    }
    
    public int getFullRecipeTime() {
    	return 480 ;
    }

    public int getFullBurnTime() {
        return 7180;
    }

    public boolean isBurning() {
        return burningTimeLeft > 0;
    }

    @Nullable
    public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		int metadata = getBlockMetadata();
		return new SPacketUpdateTileEntity(this.pos, metadata, nbt);
	}
    
    @Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.getNbtCompound());
	}

    public NBTTagCompound getUpdateTag()
    {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt;
    }
    
	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		this.readFromNBT(tag);
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		return false;
	}
	
	@Override
	public NBTTagCompound getTileData() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt;
	}
    
	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		// TODO Auto-generated method stub
		return false;
	}
	
    public BlockPos getPos() {
		return this.pos;
	}
    
    public int getSelection() {
		return selection;
	}

	public void setSelection(int selection) {
		this.selection = selection;
	}
}