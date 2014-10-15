package com.amazingthings.amazingmod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {

	public static void registerCraftingRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(AmazingMain.SpeedUpgrade), new Object[] {"XYX","YZY","XYX", 'X', Blocks.redstone_block, 'Y', Items.gold_nugget, 'Z', Items.sugar});
	}
}