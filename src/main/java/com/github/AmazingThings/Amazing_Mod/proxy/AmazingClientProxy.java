package com.github.AmazingThings.Amazing_Mod.proxy;

import com.github.AmazingThings.Amazing_Mod.renderer.TileEntityRendererElectricFurnace;
import com.github.AmazingThings.Amazing_Mod.tileentity.TileEntityElectricFurnace;

import cpw.mods.fml.client.registry.ClientRegistry;

public class AmazingClientProxy extends AmazingCommonProxy {

	@Override
	public void registerRenderers(){
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectricFurnace.class,
				new TileEntityRendererElectricFurnace());
		
	}
	
}
