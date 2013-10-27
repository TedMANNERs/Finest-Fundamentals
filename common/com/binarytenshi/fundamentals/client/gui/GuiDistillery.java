package com.binarytenshi.fundamentals.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import com.binarytenshi.fundamentals.inventory.ContainerDistillery;
import com.binarytenshi.fundamentals.tileentity.TileEntityDistillery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Distillery user interface
 * 
 * @author BinaryTENSHi
 */
@SideOnly(Side.CLIENT)
public class GuiDistillery extends GuiContainer {

    TileEntityDistillery distillery;

    public GuiDistillery(InventoryPlayer inventory, TileEntityDistillery distillery) {
        super(new ContainerDistillery(inventory, distillery));

        xSize = 176;
        ySize = 154;

        this.distillery = distillery;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        fontRenderer.drawString("Hello World", 176, 154, 0xFFFF00);
    }
}
