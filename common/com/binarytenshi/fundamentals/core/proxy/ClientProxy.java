package com.binarytenshi.fundamentals.core.proxy;

import com.binarytenshi.fundamentals.client.render.item.VialRenderer;
import com.binarytenshi.fundamentals.item.ModItems;

import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Client proxy class
 * 
 * @author BinaryTENSHi
 *
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void initSounds() {
        
    }

    @Override
    public void initRenderers() {
        MinecraftForgeClient.registerItemRenderer(ModItems.vial.itemID, new VialRenderer());
    }
}
