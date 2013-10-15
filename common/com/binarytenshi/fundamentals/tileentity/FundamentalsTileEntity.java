package com.binarytenshi.fundamentals.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * Basic tile entity which acts as a super class for all fundamentals tile
 * entities.
 * 
 * @author BinaryTENSHi
 */
public class FundamentalsTileEntity extends TileEntity {
    public ItemStack[] inventory;
}
