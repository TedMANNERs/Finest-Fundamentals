package com.binarytenshi.fundamentals.client.render.item;

import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.binarytenshi.fundamentals.core.Molecule;
import com.binarytenshi.fundamentals.item.ModItems;

public class VialRenderer implements IItemRenderer {

    @Override
    public boolean handleRenderType(ItemStack itemStack, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack itemStack, ItemRendererHelper helper) {
        switch (helper) {
            case ENTITY_BOBBING:
                return true;
            case ENTITY_ROTATION:
                return true;
        }

        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack itemStack, Object... data) {
        // TODO: differentiate between Molecules and Elements
        Molecule molecule = Molecule.values[itemStack.getItemDamage()];
        Tessellator tessellator = Tessellator.instance;

        switch (type) {
            case INVENTORY:
                setColorForMolecule(molecule);
                drawTexturedRectUV(0, 0, 0, 16, 16, ModItems.vial.contentIcon);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                drawTexturedRectUV(0, 0, 0, 16, 16, ModItems.vial.itemIcon);
                return;

            case EQUIPPED:
            case EQUIPPED_FIRST_PERSON:
                setColorForMolecule(molecule);
                ItemRenderer.renderItemIn2D(tessellator, ModItems.vial.contentIcon.getMaxU(), ModItems.vial.contentIcon.getMinV(), ModItems.vial.contentIcon.getMinU(), ModItems.vial.contentIcon.getMaxV(), 192, 48, 0.0625F);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                ItemRenderer.renderItemIn2D(tessellator, ModItems.vial.itemIcon.getMaxU(), ModItems.vial.itemIcon.getMinV(), ModItems.vial.itemIcon.getMinU(), ModItems.vial.itemIcon.getMaxV(), 192, 48, 0.0625F);
                return;

            case ENTITY:
                float scale = 0.7F;
                GL11.glPushMatrix();
                GL11.glScalef(scale, scale, scale);
                GL11.glTranslatef(-0.5F, 0, 0);
                setColorForMolecule(molecule);
                ItemRenderer.renderItemIn2D(tessellator, ModItems.vial.contentIcon.getMinU(), ModItems.vial.contentIcon.getMinV(), ModItems.vial.contentIcon.getMaxU(), ModItems.vial.contentIcon.getMaxV(), 192, 48, 0.05F);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                ItemRenderer.renderItemIn2D(tessellator, ModItems.vial.itemIcon.getMinU(), ModItems.vial.itemIcon.getMinV(), ModItems.vial.itemIcon.getMaxU(), ModItems.vial.itemIcon.getMaxV(), 192, 48, 0.05F);
                GL11.glPopMatrix();
                return;
        }
    }

    private void setColorForMolecule(Molecule molecule) {
        switch (molecule) {
            case WATER:
                GL11.glColor4f(0.0F, 0.0F, 1.0F, 1.0F);
                return;

            default:
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 0F);
                return;
        }
    }

    private void drawTexturedRectUV(int x, int y, int z, int width, int height, Icon icon) {
        Tessellator tesselator = Tessellator.instance;
        tesselator.startDrawingQuads();
        tesselator.addVertexWithUV(x, y + height, z, icon.getMinU(), icon.getMaxV());
        tesselator.addVertexWithUV(x + width, y + height, z, icon.getMaxU(), icon.getMaxV());
        tesselator.addVertexWithUV(x + width, y, z, icon.getMaxU(), icon.getMinV());
        tesselator.addVertexWithUV(x, y, z, icon.getMinU(), icon.getMinV());
        tesselator.draw();
    }
}
