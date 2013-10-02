package com.binarytenshi.fundamentals.core.proxy;

import net.minecraftforge.client.MinecraftForgeClient;

import com.binarytenshi.fundamentals.client.render.item.ItemDistilleryRenderer;
import com.binarytenshi.fundamentals.client.render.item.VialRenderer;
import com.binarytenshi.fundamentals.client.render.tileentity.TileEntityDistilleryRenderer;
import com.binarytenshi.fundamentals.item.ModItems;
import com.binarytenshi.fundamentals.lib.BlockInfo;
import com.binarytenshi.fundamentals.lib.RenderIds;
import com.binarytenshi.fundamentals.tileentity.TileEntityChemicalTable;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * Client proxy class
 * 
 * @author BinaryTENSHi
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void initRenderers() {
        MinecraftForgeClient.registerItemRenderer(ModItems.vial.itemID, new VialRenderer());
        MinecraftForgeClient.registerItemRenderer(BlockInfo.CHEMICALTABLE_ID, new ItemDistilleryRenderer());

        RenderIds.chemicalTable = RenderingRegistry.getNextAvailableRenderId();
    }

    @Override
    public void initSounds() {

    }

    @Override
    public void registerTileEntities() {
        super.registerTileEntities();

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChemicalTable.class, new TileEntityDistilleryRenderer());
    }
}
