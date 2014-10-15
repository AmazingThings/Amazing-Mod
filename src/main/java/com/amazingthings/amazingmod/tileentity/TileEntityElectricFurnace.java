package com.amazingthings.amazingmod.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;


public class TileEntityElectricFurnace extends TileEntity implements ISidedInventory{

	private String localizedName;
	
	private static final int[] slot_top = new int[]{0};
	private static final int[] slot_buttom = new int[]{2, 1};
	private static final int[] slot_side = new int[]{1};
	
	public int speed = 150;
	public int burnTime;
	public int currentBurnTime;
	public int cookTime;
	public int power = 0;
	public String tier;
	
	private ItemStack[] slots;
	
	public void updateEntity() {
		if(this.burnTime > 0) {
			this.burnTime--;
		}
		if(!this.worldObj.isRemote) {
			if(this.burnTime == 0) {
				this.currentBurnTime = this.burnTime = getItemBurnTime(this.slots[1]);
				if(this.burnTime > 0) {
					if(this.slots[1] != null) {
						this.slots[1].stackSize--;
					}
				}
			}
		}
	}

	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		
		NBTTagList list = tag.getTagList("Items", 10);
		slots = new ItemStack[this.getSizeInventory()];
		for(int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound tagCom = list.getCompoundTagAt(i);
			byte slotIndex = tagCom.getByte("Slot");
			if(slotIndex >= 0 && slotIndex < slots.length) {
				slots[slotIndex] = ItemStack.loadItemStackFromNBT(tagCom);
			}
		}
		
		speed = tag.getInteger("speed");
		burnTime = tag.getInteger("burnTime");
		currentBurnTime = tag.getInteger("currentBurnTime");
		cookTime = tag.getInteger("cookTime");
		power = tag.getInteger("power");
		tier = tag.getString("tier");
	}
	
	public void setGuiDisplayName(String name) {
		this.localizedName = name;
	}

	public boolean isInventoryNameLocalized() {
		
		return this.localizedName != null && this.localizedName.length() > 0;
	}
	
	public String getInventoryName() {
		return this.isInventoryNameLocalized() ? this.localizedName : "Electric Furnace";
	}

	@Override
	public int getSizeInventory() {
		return this.slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory() {
		
	}
	
	public static int getItemBurnTime(ItemStack is) {
		if(is == null) {
			return 0;
		}else {
			if(is == (new ItemStack(Items.redstone))) return 100;
			if(is == (new ItemStack(Blocks.redstone_block))) return 900;

		}
		return 0;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack is) {
		if(i == 2) {
			return false;
		}
		return true;
	}


	@Override
	public int[] getAccessibleSlotsFromSide(int i) {
		return i == 0 ? slot_buttom : (i == 1 ? slot_top : slot_side);
	}

	@Override
	public boolean canInsertItem(int i, ItemStack is, int j) {
		return this.isItemValidForSlot(i, is);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack is, int j) {
		return j != 0 || i != 1;
	}
}
