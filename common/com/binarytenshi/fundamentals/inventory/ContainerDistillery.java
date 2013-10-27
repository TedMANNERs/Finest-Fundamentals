package com.binarytenshi.fundamentals.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

import com.binarytenshi.fundamentals.tileentity.TileEntityDistillery;

/**
 * Distillery container
 * 
 * @author BinaryTENSHi
 */
public class ContainerDistillery extends Container {

    private final TileEntityDistillery distillery;

    public ContainerDistillery(InventoryPlayer inventory, TileEntityDistillery distillery) {
        this.distillery = distillery;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return distillery.isUseableByPlayer(player);
    }
}
