package com.amazingthings.amazingmod.gui;

import com.amazingthings.amazingmod.AmazingMain;
import com.amazingthings.amazingmod.container.ContainerElectricFurnace;
import com.amazingthings.amazingmod.tileentity.TileEntityElectricFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler{

	public GuiHandler() {
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {

		TileEntity entity = world.getTileEntity(x, y, z);

		if(entity != null) {
			switch(ID) {
			case 77:
				if(entity instanceof TileEntityElectricFurnace) {
					return new ContainerElectricFurnace();
				}
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if(entity != null) {
			switch(ID) {
			case 77:
				if(entity instanceof TileEntityElectricFurnace) {
					return new GuiElectricFurnace(player.inventory, (TileEntityElectricFurnace) entity);
				}
			}
		}
		return null;
	}
}
