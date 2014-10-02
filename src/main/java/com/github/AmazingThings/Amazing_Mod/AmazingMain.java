package com.github.AmazingThings.Amazing_Mod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.github.AmazingThings.Amazing_Mod.proxy.AmazingCommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="amazingmod",version="1.0.0",name="Amazing Mod")
public class AmazingMain {

	@Instance(value="amazingmod")
	public static AmazingMain instance;
	
	@SidedProxy(serverSide="com.github.AmazingThings.Amazing_Mod.proxy.AmazingCommonProxy",
			clientSide="com.github.AmazingThings.Amazing_Mod.proxy.AmazingClientProxy")
	public static AmazingCommonProxy proxy;
	
	public static CreativeTabs tabAmazing = new CreativeTabs("tabAmazing"){

		@Override
		public Item getTabIconItem() {
			return Items.diamond;
		}
		
	};
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent e){
		proxy.registerRenderers();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		
	}
	
}
