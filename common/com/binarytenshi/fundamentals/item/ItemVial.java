package com.binarytenshi.fundamentals.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.binarytenshi.fundamentals.core.ContentHelper;
import com.binarytenshi.fundamentals.core.Element;
import com.binarytenshi.fundamentals.core.IContent;
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
        setHasSubtypes(true);
        setMaxStackSize(64);
        setMaxDamage(0);
    }

    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        super.onCreated(itemStack, world, player);

        if (itemStack.stackTagCompound == null) {
            itemStack.setTagCompound(new NBTTagCompound());
        }

        itemStack.stackTagCompound.setString(Strings.NBT_CONTENT, Molecule.NOTHING.id);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean bool) {
        String contentstr = itemStack.stackTagCompound.getString(Strings.NBT_CONTENT);
        IContent content = ContentHelper.getContent(contentstr);

        list.add("Contains: " + content.getName());
        
        if (content.hasFormula())
            list.add(content.getFormula());
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
                itemStack.stackTagCompound.setString(Strings.NBT_CONTENT, Molecule.WATER.getId());
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
        for (IContent content : ContentHelper.getAllContents()) {
            ItemStack stack = new ItemStack(ModItems.vial);

            if (stack.stackTagCompound == null)
                stack.stackTagCompound = new NBTTagCompound();

            stack.stackTagCompound.setString(Strings.NBT_CONTENT, content.getId());
            list.add(stack);
        }
    }
}
