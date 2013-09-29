package com.binarytenshi.fundamentals.core.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.binarytenshi.fundamentals.client.gui.GuiChemicalTable;
import com.binarytenshi.fundamentals.inventory.ContainerChemicalTable;
import com.binarytenshi.fundamentals.lib.BlockInfo;
import com.binarytenshi.fundamentals.lib.GuiIds;
import com.binarytenshi.fundamentals.lib.Strings;
import com.binarytenshi.fundamentals.tileentity.TileEntityChemicalTable;

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
            case GuiIds.CHEMICALTABLE:
                return new GuiChemicalTable(player.inventory, (TileEntityChemicalTable) world.getBlockTileEntity(x, y, z));
        }

        return null;
    }

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        switch (id) {
            case GuiIds.CHEMICALTABLE:
                return new ContainerChemicalTable(player.inventory, (TileEntityChemicalTable) world.getBlockTileEntity(x, y, z));
        }

        return null;
    }

    public void initRenderers() {

    }

    public void initSounds() {

    }

    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityChemicalTable.class, Strings.TILEENTITY_PREFIX + BlockInfo.CHEMICALTABLE_UNLOCALIZED_NAME);
    }
}
