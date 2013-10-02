package com.binarytenshi.fundamentals.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

import com.binarytenshi.fundamentals.tileentity.TileEntityChemicalTable;

public class ContainerChemicalTable extends Container {

    private TileEntityChemicalTable chemicalTable;

    public ContainerChemicalTable(InventoryPlayer inventory, TileEntityChemicalTable chemicalTable) {
        this.chemicalTable = chemicalTable;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return chemicalTable.isUseableByPlayer(player);
    }
}
