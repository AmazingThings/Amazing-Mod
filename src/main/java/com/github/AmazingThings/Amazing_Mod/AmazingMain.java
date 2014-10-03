package com.github.AmazingThings.Amazing_Mod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.github.AmazingThings.Amazing_Mod.block.ElectricFurnace;
import com.github.AmazingThings.Amazing_Mod.proxy.AmazingCommonProxy;
import com.github.AmazingThings.Amazing_Mod.tileentity.TileEntityElectricFurnace;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="amazingmod",version="1.0.0",name="Amazing Mod")
public class AmazingMain {

	public static String modid = "amazingmod";
	
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
	
	public static Block ElectricFurnace;
	public static Block ElectricFurnaceOn;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		ElectricFurnace = new ElectricFurnace(false).setBlockName("electricfurnace").setCreativeTab(tabAmazing);
		ElectricFurnaceOn = new ElectricFurnace(true).setBlockName("electricfurnaceon").setCreativeTab(tabAmazing);
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent e){
		
		GameRegistry.registerBlock(ElectricFurnace, modid + ":electricfurnace");
		GameRegistry.registerBlock(ElectricFurnaceOn, modid + ":electricfurnaceon");
		
		GameRegistry.registerTileEntity(TileEntityElectricFurnace.class, modid + ":electricfurnace");
		
		proxy.registerRenderers();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		
	}
	
}
