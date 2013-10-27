package com.binarytenshi.fundamentals.client.render.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import com.binarytenshi.fundamentals.client.model.ModelDistillery;
import com.binarytenshi.fundamentals.lib.Textures;
import com.binarytenshi.fundamentals.tileentity.TileEntityDistillery;

import cpw.mods.fml.client.FMLClientHandler;

/**
 * Renderer for the distillery tile entity
 * 
 * @author BinaryTENSHi
 */
public class TileEntityDistilleryRenderer extends TileEntitySpecialRenderer {

    private final ModelDistillery modelDistillery = new ModelDistillery();

    @Override
    public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float tick) {
        if (entity instanceof TileEntityDistillery) {
            TileEntityDistillery distillery = (TileEntityDistillery) entity;

            GL11.glPushMatrix();
            GL11.glDisable(GL11.GL_LIGHTING);

            // Scale, Translate, Rotate
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float) x + 0.0F, (float) y + 0.0F, (float) z + 1.0F);

            // Bind texture
            FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.DISTILLERY_MODEL);

            // Render
            modelDistillery.render();

            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glPopMatrix();
        }
    }
}
