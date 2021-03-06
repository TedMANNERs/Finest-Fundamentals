package com.binarytenshi.fundamentals.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.binarytenshi.fundamentals.core.IContent;
import com.binarytenshi.fundamentals.core.Molecule;
import com.binarytenshi.fundamentals.core.helper.ContentHelper;
import com.binarytenshi.fundamentals.lib.ItemInfo;
import com.binarytenshi.fundamentals.lib.LanguageStrings;
import com.binarytenshi.fundamentals.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * A glass vial that can contain an {@link IContent}. <br>
 * To access that content, read stackTagCompound.getString({@link Strings}
 * .NBT_CONTENT)
 * and call {@link ContentHelper}.getContent(string) to get the appropriate
 * {@link IContent} if it's registered.
 * 
 * @author BinaryTENSHi
 */
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
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean bool) {
        if (itemStack.stackTagCompound != null) {
            IContent content = ContentHelper.getContent(itemStack.stackTagCompound.getString(Strings.NBT_CONTENT));

            list.add(StatCollector.translateToLocal(LanguageStrings.TOOLTIP_CONTAINS) + " " + content.getName());

            if (content.hasFormula()) {
                list.add(content.getFormula());
            }
        } else {
            list.add(StatCollector.translateToLocal(LanguageStrings.TOOLTIP_CONTAINS) + " " + StatCollector.translateToLocal(LanguageStrings.TOOLTIP_NOTHING));
        }
    }

    @Override
    public void getSubItems(int id, CreativeTabs creativeTab, List list) {
        list.add(new ItemStack(ModItems.vial)); // Empty vial

        for (IContent content : ContentHelper.getAllContents()) {
            ItemStack stack = new ItemStack(ModItems.vial);

            stack.stackTagCompound = new NBTTagCompound();

            stack.stackTagCompound.setString(Strings.NBT_CONTENT, content.getId());
            list.add(stack);
        }
    }

    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        super.onCreated(itemStack, world, player);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            MovingObjectPosition position = getMovingObjectPositionFromPlayer(world, player, true);

            if (position == null) {
                return itemStack;
            }

            int blockId = world.getBlockId(position.blockX, position.blockY, position.blockZ);
            ItemStack newItemStack = null;

            if (itemStack.stackTagCompound != null) {
                return itemStack;
            }

            switch (blockId) {
                case 8: /* Water */
                case 9:
                    newItemStack = itemStack.splitStack(1);
                    newItemStack.stackTagCompound = new NBTTagCompound();
                    newItemStack.stackTagCompound.setString(Strings.NBT_CONTENT, Molecule.WATER.getId());
                    break;
            }

            if (!player.inventory.addItemStackToInventory(newItemStack)) {
                player.dropPlayerItem(newItemStack);
            }
        }

        return itemStack;
    }

    @Override
    public void registerIcons(IconRegister register) {
        super.registerIcons(register);
        itemIcon = super.itemIcon;
        contentIcon = register.registerIcon(ItemInfo.VILE_CONTENT_TEX);
    }
}
