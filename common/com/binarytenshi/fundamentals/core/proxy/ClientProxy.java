package com.binarytenshi.fundamentals.core.proxy;

import net.minecraftforge.client.MinecraftForgeClient;

import com.binarytenshi.fundamentals.client.render.item.VialRenderer;
import com.binarytenshi.fundamentals.item.ModItems;
import com.binarytenshi.fundamentals.lib.RenderIds;

import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * Client proxy class
 * 
 * @author BinaryTENSHi
 */
public class ClientProxy extends CommonProxy {

    //TODO: uncomment distillery
    @Override
    public void initRenderers() {
        MinecraftForgeClient.registerItemRenderer(ModItems.vial.itemID, new VialRenderer());
        //MinecraftForgeClient.registerItemRenderer(BlockInfo.DISTILLERY_ID, new ItemDistilleryRenderer());

        RenderIds.distillery = RenderingRegistry.getNextAvailableRenderId();
    }

    @Override
    public void initSounds() {

    }

    @Override
    public void registerTileEntities() {
        super.registerTileEntities();

        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDistillery.class, new TileEntityDistilleryRenderer());
    }
}
