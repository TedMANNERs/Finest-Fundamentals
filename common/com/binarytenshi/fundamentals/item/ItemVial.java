package com.binarytenshi.fundamentals.item;

import java.util.List;

import javax.sql.PooledConnection;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.binarytenshi.fundamentals.core.Molecule;
import com.binarytenshi.fundamentals.lib.ItemInfo;
import com.binarytenshi.fundamentals.lib.Strings;

public class ItemVial extends FundamentalsItem {

    public ItemVial(int id) {
        super(id);
        setUnlocalizedName(Strings.RESOURCE_PREFIX + ItemInfo.VIAL_UNLOCALIZED_NAME);
        setMaxStackSize(64);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean bool) {
        int atomicNumber = itemStack.getItemDamage();

        list.add("Contains: " + Molecule.values[itemStack.getItemDamage()].getName());
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        MovingObjectPosition position = this.getMovingObjectPositionFromPlayer(world, player, true);

        if (position == null)
            return itemStack;

        Molecule water = Molecule.WATER;
        
        int blockId = world.getBlockId(position.blockX, position.blockY, position.blockZ);

        switch (blockId) {
        // Water
            case 8:
            case 9:
                setDamage(itemStack, Molecule.WATER.getMeta());
                break;
        }

        return itemStack;
    }

    @Override
    public void getSubItems(int id, CreativeTabs creativeTab, List list) {
        for (int i = 0; i < Molecule.values.length; i++) {
            list.add(new ItemStack(itemID, 1, i));
        }
    }
}
