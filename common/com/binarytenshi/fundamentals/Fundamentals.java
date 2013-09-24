package com.binarytenshi.fundamentals;

import java.util.logging.Logger;

import net.minecraft.creativetab.CreativeTabs;

import com.binarytenshi.fundamentals.blocks.ModBlocks;
import com.binarytenshi.fundamentals.config.ConfigHandler;
import com.binarytenshi.fundamentals.core.Element;
import com.binarytenshi.fundamentals.core.Molecule;
import com.binarytenshi.fundamentals.core.proxy.CommonProxy;
import com.binarytenshi.fundamentals.item.ModItems;
import com.binarytenshi.fundamentals.lib.Reference;
import com.binarytenshi.fundamentals.network.PacketHandler;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = "required-after:IC2")
@NetworkMod(channels = Reference.CHANNEL_NAME, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class Fundamentals {

    @Instance(Reference.MOD_ID)
    public static Fundamentals instance;

    public static Logger logger = Logger.getLogger(Reference.MOD_NAME);

    public static CreativeTabs creativeTab = new CreativeTabs(Reference.MOD_ID);

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigHandler.init(event.getSuggestedConfigurationFile());

        logger.setParent(FMLLog.getLogger());

        ModItems.init();
        ModBlocks.init();

        proxy.initSounds();
        proxy.initRenderers();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModItems.addRecipies();

        logger.info("I found " + Element.values.length + " elements.");
        logger.info("I found " + Molecule.values.length + " molecules.");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
