package com.binarytenshi.fundamentals.item;

import com.binarytenshi.fundamentals.Fundamentals;

import net.minecraft.block.StepSound;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FundamentalsItem extends Item {

    public FundamentalsItem(int id) {
        super(id);
        setMaxStackSize(1);
        setNoRepair();
        setCreativeTab(Fundamentals.creativeTab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register) {
        itemIcon = register.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}
