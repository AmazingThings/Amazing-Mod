package com.amazingthings.amazingmod.block;

import java.util.Random;

import javax.swing.Icon;

import com.amazingthings.amazingmod.AmazingMain;
import com.amazingthings.amazingmod.tileentity.TileEntityElectricFurnace;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ElectricFurnace extends BlockContainer {

	private final boolean isActive;
	
	public ElectricFurnace(boolean b, Material m) {
		super(m.iron);
		this.setHardness(4f);
		this.setBlockName("electricfurnace");
		this.isActive = b;
		this.setBlockTextureName("amazingmod:iron_block");

	}

	@Override
	public TileEntity createNewTileEntity(World w, int id) {
		return new TileEntityElectricFurnace();
	}

	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(!w.isRemote) {
			FMLNetworkHandler.openGui(player, AmazingMain.instance, 77, w, x, y, z);
			
		}
		return true;
	}
	@Override
	public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase elb, ItemStack is) {
		if(is.hasDisplayName()) {
			((TileEntityElectricFurnace)w.getTileEntity(x, y, z)).setGuiDisplayName(is.getDisplayName());
		}
	}
}
