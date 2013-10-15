package com.binarytenshi.fundamentals.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.binarytenshi.fundamentals.lib.Strings;

/**
 * Chemical table tile entity
 * 
 * @author BinaryTENSHi
 */
public class TileEntityChemicalTable extends FundamentalsTileEntity implements IInventory {

    public TileEntityChemicalTable() {
        inventory = new ItemStack[getSizeInventory()];
    }

    @Override
    public void closeChest() {
    }

    @Override
    public ItemStack decrStackSize(int slot, int count) {
        ItemStack itemstack = inventory[slot];
        if (itemstack != null) {
            if (itemstack.stackSize <= count) {
                setInventorySlotContents(slot, null);
            } else {
                itemstack = itemstack.splitStack(count);
                onInventoryChanged();
            }
        }

        return itemstack;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public String getInvName() {
        return Strings.DISTILLERY_INVENTORY;
    }

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack itemstack = getStackInSlot(slot);
        setInventorySlotContents(slot, null);
        return itemstack;
    }

    @Override
    public boolean isInvNameLocalized() {
        return false;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
        return true;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openChest() {
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemstack) {
        inventory[slot] = itemstack;

        if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
            itemstack.stackSize = getInventoryStackLimit();
        }

        onInventoryChanged();
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
    }
}
