package com.binarytenshi.fundamentals.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import com.binarytenshi.fundamentals.inventory.ContainerChemicalTable;
import com.binarytenshi.fundamentals.tileentity.TileEntityChemicalTable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiChemicalTable extends GuiContainer {

    TileEntityChemicalTable chemicalTable;

    public GuiChemicalTable(InventoryPlayer inventory, TileEntityChemicalTable chemicalTable) {
        super(new ContainerChemicalTable(inventory, chemicalTable));

        this.xSize = 176;
        this.ySize = 154;

        this.chemicalTable = chemicalTable;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        this.fontRenderer.drawString("Hello World", 176, 154, 0xFFFF00);
    }
}
