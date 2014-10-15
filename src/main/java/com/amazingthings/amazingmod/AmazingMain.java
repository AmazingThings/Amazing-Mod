package com.amazingthings.amazingmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.amazingthings.amazingmod.block.ElectricFurnace;
import com.amazingthings.amazingmod.gui.GuiHandler;
import com.amazingthings.amazingmod.item.SpeedUpgrade;
import com.amazingthings.amazingmod.proxy.CommonProxy;
import com.amazingthings.amazingmod.tileentity.TileEntityElectricFurnace;



import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = AmazingMain.modid,version=AmazingMain.version,name="Amazing Mod")
public class AmazingMain {
	
	/**
	 * @author MathMods
	 * @author Kristav
	 * 
	*/

	public static final String version = "1.0.1";
	public static final String modid = "amazingmod";
	
	@Instance(modid)
	public static AmazingMain instance;
	
	@SidedProxy(serverSide="com.amazingthings.amazingmod.proxy.CommonProxy",
			clientSide="com.amazingthings.amazingmod.proxy.ClientProxy")
	public static CommonProxy proxy;
	
	public static CreativeTabs tabAmazing = new CreativeTabs("tabAmazing") {

		@Override
		public Item getTabIconItem() {
			return Items.diamond;
		}
		
	};
	public static Item SpeedUpgrade;
	
	public static Block ElectricFurnace;
	public static Block ElectricFurnaceOn;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		ElectricFurnace = new ElectricFurnace(false, Material.iron).setCreativeTab(tabAmazing);
		ElectricFurnaceOn = new ElectricFurnace(true, Material.iron);
		SpeedUpgrade = new SpeedUpgrade();
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent e){
		
		GameRegistry.registerBlock(ElectricFurnace, "electricfurnace");
		GameRegistry.registerBlock(ElectricFurnaceOn, "electricfurnaceon");
		
		GameRegistry.registerItem(SpeedUpgrade, "upgradeSpeed");
		
		Recipes.registerCraftingRecipes();
		GameRegistry.registerTileEntity(TileEntityElectricFurnace.class, "tileEntityElectricFurnace");
		proxy.registerRenderers();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this.instance, new GuiHandler());
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		
	}
	
}
