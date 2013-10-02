package com.binarytenshi.fundamentals.client.render.item;

import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;

import com.binarytenshi.fundamentals.core.IContent;
import com.binarytenshi.fundamentals.core.helper.ContentHelper;
import com.binarytenshi.fundamentals.item.ModItems;
import com.binarytenshi.fundamentals.lib.Strings;

/**
 * Custom render for ItemVial <br>
 * Currently renders the content as a solid regardless of
 * it's melting / boiling point. <br>
 * It does however take the content color into account. <br>
 * 
 * @author BinaryTENSHi
 */
public class VialRenderer implements IItemRenderer {

    private void drawTexturedRectUV(int x, int y, int z, int width, int height, Icon icon) {
        Tessellator tesselator = Tessellator.instance;
        tesselator.startDrawingQuads();
        tesselator.addVertexWithUV(x, y + height, z, icon.getMinU(), icon.getMaxV());
        tesselator.addVertexWithUV(x + width, y + height, z, icon.getMaxU(), icon.getMaxV());
        tesselator.addVertexWithUV(x + width, y, z, icon.getMaxU(), icon.getMinV());
        tesselator.addVertexWithUV(x, y, z, icon.getMinU(), icon.getMinV());
        tesselator.draw();
    }

    @Override
    public boolean handleRenderType(ItemStack itemStack, ItemRenderType type) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack itemStack, Object... data) {
        IContent content = null;

        if (itemStack.stackTagCompound != null) {
            content = ContentHelper.getContent(itemStack.stackTagCompound.getString(Strings.NBT_CONTENT));
        }

        Tessellator tessellator = Tessellator.instance;

        switch (type) {
            case INVENTORY:
                setColor(content);
                drawTexturedRectUV(0, 0, 0, 16, 16, ModItems.vial.contentIcon);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                drawTexturedRectUV(0, 0, 0, 16, 16, ModItems.vial.itemIcon);
                return;

            case EQUIPPED:
            case EQUIPPED_FIRST_PERSON:
                setColor(content);
                ItemRenderer.renderItemIn2D(tessellator, ModItems.vial.contentIcon.getMaxU(), ModItems.vial.contentIcon.getMinV(), ModItems.vial.contentIcon.getMinU(), ModItems.vial.contentIcon.getMaxV(), 192, 48, 0.0625F);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                ItemRenderer.renderItemIn2D(tessellator, ModItems.vial.itemIcon.getMaxU(), ModItems.vial.itemIcon.getMinV(), ModItems.vial.itemIcon.getMinU(), ModItems.vial.itemIcon.getMaxV(), 192, 48, 0.0625F);
                return;

            case ENTITY:
                float scale = 0.7F;
                GL11.glPushMatrix();
                GL11.glScalef(scale, scale, scale);
                GL11.glTranslatef(-0.5F, 0, 0);
                setColor(content);
                ItemRenderer.renderItemIn2D(tessellator, ModItems.vial.contentIcon.getMinU(), ModItems.vial.contentIcon.getMinV(), ModItems.vial.contentIcon.getMaxU(), ModItems.vial.contentIcon.getMaxV(), 192, 48, 0.05F);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                ItemRenderer.renderItemIn2D(tessellator, ModItems.vial.itemIcon.getMinU(), ModItems.vial.itemIcon.getMinV(), ModItems.vial.itemIcon.getMaxU(), ModItems.vial.itemIcon.getMaxV(), 192, 48, 0.05F);
                GL11.glPopMatrix();
                return;
        }
    }

    private void setColor(IContent content) {
        Color c = new Color(0, 0, 0, 0);

        if (content != null) {
            c = content.getColor();
        }

        float r = c.getRed() / 255F;
        float g = c.getGreen() / 255F;
        float b = c.getBlue() / 255F;
        float a = c.getAlpha() / 255F;
        GL11.glColor4f(r, g, b, a);
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
}
