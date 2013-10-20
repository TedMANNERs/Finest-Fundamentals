package com.binarytenshi.fundamentals.client.render.item;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.binarytenshi.fundamentals.client.model.ModelDistillery;
import com.binarytenshi.fundamentals.lib.Textures;

import cpw.mods.fml.client.FMLClientHandler;

/**
 * Renderer for the distillery item
 * 
 * @author BinaryTENSHi
 */
public class ItemDistilleryRenderer implements IItemRenderer {

    private final ModelDistillery modelDistillery;

    public ItemDistilleryRenderer() {
        modelDistillery = new ModelDistillery();
    }

    @Override
    public boolean handleRenderType(ItemStack itemstack, ItemRenderType type) {
        return true;
    }

    private void renderDistillery(float x, float y, float z, float scale) {

        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);

        // Scale, Translate, Rotate
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(x, y, z);
        GL11.glRotatef(0, 0, 0, 0);

        // Bind texture
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.DISTILLERY_MODEL);

        // Render
        modelDistillery.render();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack itemstack, Object... data) {
        switch (type) {
            case ENTITY:
                renderDistillery(-0.5F, 0.0F, 0.5F, 1.0F);
                return;

            case EQUIPPED:
            case EQUIPPED_FIRST_PERSON:
                renderDistillery(0.0F, 0.0F, 1.0F, 1.0F);
                return;

            case INVENTORY:
                renderDistillery(0.0F, -0.1F, 1.0F, 1.0F);
                return;
        }
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack itemstack, ItemRendererHelper helper) {
        return true;
    }
}
