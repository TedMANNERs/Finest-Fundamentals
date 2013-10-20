package com.binarytenshi.fundamentals.core.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.binarytenshi.fundamentals.client.gui.GuiDistillery;
import com.binarytenshi.fundamentals.inventory.ContainerDistillery;
import com.binarytenshi.fundamentals.lib.BlockInfo;
import com.binarytenshi.fundamentals.lib.GuiIds;
import com.binarytenshi.fundamentals.lib.Strings;
import com.binarytenshi.fundamentals.tileentity.TileEntityDistillery;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Common (server) proxy class
 * 
 * @author BinaryTENSHi
 */
public class CommonProxy implements IGuiHandler {

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        switch (id) {
            case GuiIds.DISTILLERY:
                return new GuiDistillery(player.inventory, (TileEntityDistillery) world.getBlockTileEntity(x, y, z));
        }

        return null;
    }

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        switch (id) {
            case GuiIds.DISTILLERY:
                return new ContainerDistillery(player.inventory, (TileEntityDistillery) world.getBlockTileEntity(x, y, z));
        }

        return null;
    }

    public void initRenderers() {

    }

    public void initSounds() {

    }

    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityDistillery.class, Strings.TILEENTITY_PREFIX + BlockInfo.DISTILLERY_UNLOCALIZED_NAME);
    }
}
