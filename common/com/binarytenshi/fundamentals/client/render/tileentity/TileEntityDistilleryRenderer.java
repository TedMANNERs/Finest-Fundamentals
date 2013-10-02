package com.binarytenshi.fundamentals.client.render.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import com.binarytenshi.fundamentals.client.model.ModelChemicalTable;
import com.binarytenshi.fundamentals.lib.Textures;
import com.binarytenshi.fundamentals.tileentity.TileEntityChemicalTable;

import cpw.mods.fml.client.FMLClientHandler;

public class TileEntityDistilleryRenderer extends TileEntitySpecialRenderer {

    private final ModelChemicalTable modelDistillery = new ModelChemicalTable();

    @Override
    public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float tick) {
        if (entity instanceof TileEntityChemicalTable) {
            // TODO Use the TileAlchemyTable to determine what circle to project on the server of the table
            TileEntityChemicalTable tileAlchemyTable = (TileEntityChemicalTable) entity;

            GL11.glPushMatrix();
            GL11.glDisable(GL11.GL_LIGHTING);

            // Scale, Translate, Rotate
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float) x + 0.0F, (float) y + 0.0F, (float) z + 1.0F);

            // Bind texture
            FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.CHEMICALTABLE_MODEL);

            // Render
            this.modelDistillery.render();

            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glPopMatrix();
        }
    }
}
