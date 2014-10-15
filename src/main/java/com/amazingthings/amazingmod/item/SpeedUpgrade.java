package com.amazingthings.amazingmod.item;

import com.amazingthings.amazingmod.AmazingMain;

import net.minecraft.item.Item;

public class SpeedUpgrade extends Item {

	public SpeedUpgrade() {
		super();
		this.setCreativeTab(AmazingMain.tabAmazing);
		this.setTextureName("amazingmod:upgradespeed");
		this.setUnlocalizedName("upgradespeed");
	}
}
