package com.amazingthings.amazingmod.container;

import com.amazingthings.amazingmod.tileentity.TileEntityElectricFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerElectricFurnace extends Container{

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		if(!player.isSneaking()) {
			return false;
		}
		return true;
	}
}
