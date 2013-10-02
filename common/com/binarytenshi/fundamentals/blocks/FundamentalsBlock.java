package com.binarytenshi.fundamentals.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.binarytenshi.fundamentals.Fundamentals;
import com.binarytenshi.fundamentals.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Basic block which acts as a super class for all fundamentals blocks. <br>
 * Will later extend IC2 EnergySink to accept and use EU.
 * 
 * @author BinaryTENSHi
 */
public abstract class FundamentalsBlock extends BlockContainer {

    public FundamentalsBlock(int id, Material material) {
        super(id, material);
        setCreativeTab(Fundamentals.creativeTab);
        setUnlocalizedName(Strings.RESOURCE_PREFIX + "NOT_SET");
    }

    public abstract void addStacksDroppedOnBlockBreak(TileEntity tileEntity, ArrayList<ItemStack> itemStacks);

    @Override
    public void breakBlock(World world, int x, int y, int z, int blockId, int meta) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        Random r = new Random();

        if (tileEntity != null) {
            ArrayList<ItemStack> droppedStacks = new ArrayList<ItemStack>();
            addStacksDroppedOnBlockBreak(tileEntity, droppedStacks);

            for (ItemStack itemstack : droppedStacks) {
                float randomX = r.nextFloat() * 0.8F + 0.1F;
                float randomY = r.nextFloat() * 0.8F + 0.1F;
                float randomZ = r.nextFloat() * 0.8F + 0.1F;

                while (itemstack.stackSize > 0) {
                    int randomInt = r.nextInt(21) + 10;

                    if (randomInt > itemstack.stackSize) {
                        randomInt = itemstack.stackSize;
                    }

                    itemstack.stackSize -= randomInt;
                    new EntityItem(world, x + randomX, y + randomY, z + randomZ, new ItemStack(itemstack.itemID, randomInt, itemstack.getItemDamage()));
                }
            }

            super.breakBlock(world, x, y, z, blockId, meta);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return null;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister register) {
        this.blockIcon = register.registerIcon(Strings.RESOURCE_PREFIX + getUnlocalizedName().substring(getUnlocalizedName().indexOf(":") + 1));
    }
}
