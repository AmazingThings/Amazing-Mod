package com.github.AmazingThings.Amazing_Mod.renderer;

import org.lwjgl.opengl.GL11;

import com.github.AmazingThings.Amazing_Mod.AmazingMain;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityRendererElectricFurnace extends TileEntitySpecialRenderer {

	public ResourceLocation texture = new ResourceLocation(AmazingMain.modid, "textures/tile/electricfurnace.png");
	private float pixel = 1F/16F;
	private float texturepixel = 1F/32F;
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x,
			double y, double z, float f) {
		
		GL11.glTranslated(x, y, z);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.bindTexture(texture);
		drawPipe();
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslated(-x, -y, -z);
		
	}
	
	public void drawPipe(){
		Tessellator t = Tessellator.instance;
		t.startDrawingQuads();
		{
			
			//Outside
			t.addVertexWithUV(pixel*5, 1 + pixel*0, 1-pixel*10, texturepixel*8, texturepixel*16);
			t.addVertexWithUV(pixel*5, 1 + pixel*10, 1-pixel*10, texturepixel*8, texturepixel*0);
			t.addVertexWithUV(1-pixel*5, 1 + pixel*10, 1-pixel*10, texturepixel*0, texturepixel*0);
			t.addVertexWithUV(1-pixel*5, 1 + pixel*0, 1-pixel*10, texturepixel*0, texturepixel*16);
			
			t.addVertexWithUV(1-pixel*5, 1 + pixel*0, 1-pixel*10, texturepixel*8, texturepixel*16);
			t.addVertexWithUV(1-pixel*5, 1 + pixel*10, 1-pixel*10, texturepixel*8, texturepixel*0);
			t.addVertexWithUV(1-pixel*5, 1 + pixel*10, pixel*10, texturepixel*0, texturepixel*0);
			t.addVertexWithUV(1-pixel*5, 1 + pixel*0, pixel*10, texturepixel*0, texturepixel*16);
			
			t.addVertexWithUV(1-pixel*5, 1 + pixel*0, pixel*10, texturepixel*8, texturepixel*16);
			t.addVertexWithUV(1-pixel*5, 1 + pixel*10, pixel*10, texturepixel*8, texturepixel*0);
			t.addVertexWithUV(pixel*5, 1 + pixel*10, pixel*10, texturepixel*0, texturepixel*0);
			t.addVertexWithUV(pixel*5, 1 + pixel*0, pixel*10, texturepixel*0, texturepixel*16);
			
			t.addVertexWithUV(pixel*5, 1 + pixel*0, pixel*10, texturepixel*8, texturepixel*16);
			t.addVertexWithUV(pixel*5, 1 + pixel*10, pixel*10, texturepixel*8, texturepixel*0);
			t.addVertexWithUV(pixel*5, 1 + pixel*10, 1-pixel*10, texturepixel*0, texturepixel*0);
			t.addVertexWithUV(pixel*5, 1 + pixel*0, 1-pixel*10, texturepixel*0, texturepixel*16);
			
			//Inside
			t.addVertexWithUV(1-pixel*5, 1 + pixel*0, 1-pixel*10, texturepixel*8, texturepixel*16);
			t.addVertexWithUV(1-pixel*5, 1 + pixel*10, 1-pixel*10, texturepixel*8, texturepixel*0);
			t.addVertexWithUV(pixel*5, 1 + pixel*10, 1-pixel*10, texturepixel*0, texturepixel*0);
			t.addVertexWithUV(pixel*5, 1 + pixel*0, 1-pixel*10, texturepixel*0, texturepixel*16);
			
			t.addVertexWithUV(1-pixel*5, 1 + pixel*0, pixel*10, texturepixel*8, texturepixel*16);
			t.addVertexWithUV(1-pixel*5, 1 + pixel*10, pixel*10, texturepixel*8, texturepixel*0);
			t.addVertexWithUV(1-pixel*5, 1 + pixel*10, 1-pixel*10, texturepixel*0, texturepixel*0);
			t.addVertexWithUV(1-pixel*5, 1 + pixel*0, 1-pixel*10, texturepixel*0, texturepixel*16);
			
			t.addVertexWithUV(pixel*5, 1 + pixel*0, pixel*10, texturepixel*8, texturepixel*16);
			t.addVertexWithUV(pixel*5, 1 + pixel*10, pixel*10, texturepixel*8, texturepixel*0);
			t.addVertexWithUV(1-pixel*5, 1 + pixel*10, pixel*10, texturepixel*0, texturepixel*0);
			t.addVertexWithUV(1-pixel*5, 1 + pixel*0, pixel*10, texturepixel*0, texturepixel*16);
			
			t.addVertexWithUV(pixel*5, 1 + pixel*0, 1-pixel*10, texturepixel*8, texturepixel*16);
			t.addVertexWithUV(pixel*5, 1 + pixel*10, 1-pixel*10, texturepixel*8, texturepixel*0);
			t.addVertexWithUV(pixel*5, 1 + pixel*10, pixel*10, texturepixel*0, texturepixel*0);
			t.addVertexWithUV(pixel*5, 1 + pixel*0, pixel*10, texturepixel*0, texturepixel*16);
			
			//Bottom
			t.addVertexWithUV(pixel*5, 1 + pixel*1, 1-pixel*10, texturepixel*8, texturepixel*16);
			t.addVertexWithUV(pixel*5, 1 + pixel*1, pixel*10, texturepixel*8, texturepixel*0);
			t.addVertexWithUV(1-pixel*5, 1 + pixel*1, pixel*10, texturepixel*0, texturepixel*0);
			t.addVertexWithUV(1-pixel*5, 1 + pixel*1, 1-pixel*10, texturepixel*0, texturepixel*16);
			
		}
		t.draw();
		
	}

}
