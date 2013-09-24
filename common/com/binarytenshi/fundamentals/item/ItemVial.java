package com.binarytenshi.fundamentals.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.binarytenshi.fundamentals.core.Molecule;
import com.binarytenshi.fundamentals.lib.ItemInfo;
import com.binarytenshi.fundamentals.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemVial extends FundamentalsItem {

    @SideOnly(Side.CLIENT)
    public Icon contentIcon;
    
    @SideOnly(Side.CLIENT)
    public Icon itemIcon;

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

        int blockId = world.getBlockId(position.blockX, position.blockY, position.blockZ);

        switch (blockId) {
            case 8: /* Water */
            case 9:
                // TODO: differentiate between Molecules and Elements
                setDamage(itemStack, Molecule.WATER.getMeta());
                break;
        }

        return itemStack;
    }

    @Override
    public void registerIcons(IconRegister register) {
        super.registerIcons(register);
        this.itemIcon = super.itemIcon;
        contentIcon = register.registerIcon(ItemInfo.VILE_CONTENT_TEX);
    }

    @Override
    public void getSubItems(int id, CreativeTabs creativeTab, List list) {
        for (int i = 0; i < Molecule.values.length; i++) {
            list.add(new ItemStack(itemID, 1, i));
        }
    }
}
