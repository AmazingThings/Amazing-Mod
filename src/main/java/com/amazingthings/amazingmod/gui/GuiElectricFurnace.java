package com.amazingthings.amazingmod.gui;

import com.amazingthings.amazingmod.container.ContainerElectricFurnace;
import com.amazingthings.amazingmod.tileentity.TileEntityElectricFurnace;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiElectricFurnace extends GuiContainer{

	public static final ResourceLocation texture = new ResourceLocation("amazingmod/textures/gui/elfurnace.png");
	
	public TileEntityElectricFurnace eFurnace;
	
	public GuiElectricFurnace(InventoryPlayer playerInv, TileEntityElectricFurnace entity) {
		super(new ContainerElectricFurnace());
		
		this.eFurnace = entity;
		this.ySize = 176;
		this.xSize = 166;
	}

	protected void drawGuiContainerForegroundLayer(int i, int j) {
		String name = this.eFurnace.isInventoryNameLocalized() ? this.eFurnace.getInventoryName() : I18n.format(this.eFurnace.getInventoryName());
		
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
	}
	
	public void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		
	}
}
