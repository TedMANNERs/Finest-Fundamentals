package com.binarytenshi.fundamentals;

import java.util.logging.Logger;

import net.minecraft.creativetab.CreativeTabs;
import codechicken.nei.forge.GuiContainerManager;

import com.binarytenshi.fundamentals.config.ConfigHandler;
import com.binarytenshi.fundamentals.core.Element;
import com.binarytenshi.fundamentals.core.Molecule;
import com.binarytenshi.fundamentals.core.handler.FormulaTooltipHandler;
import com.binarytenshi.fundamentals.core.helper.ContentHelper;
import com.binarytenshi.fundamentals.core.helper.FormulaHelper;
import com.binarytenshi.fundamentals.core.proxy.CommonProxy;
import com.binarytenshi.fundamentals.item.ModItems;
import com.binarytenshi.fundamentals.lib.Reference;
import com.binarytenshi.fundamentals.lib.Strings;
import com.binarytenshi.fundamentals.network.PacketHandler;
import com.binarytenshi.fundamentals.recipe.FundamentalsRecipies;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLFingerprintViolationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

/**
 * Main mod class for Finest-Fundamentals.
 * 
 * @author BinaryTENSHi
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = "required-after:IC2", certificateFingerprint = Reference.FINGERPRINT)
@NetworkMod(channels = Reference.CHANNEL_NAME, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class Fundamentals {
    @Instance(Reference.MOD_ID)
    public static Fundamentals instance;

    public static Logger logger = Logger.getLogger(Reference.MOD_NAME);

    public static CreativeTabs creativeTab = new CreativeTabs(Reference.MOD_ID);

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    static {
        logger.setParent(FMLLog.getLogger());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        NetworkRegistry.instance().registerGuiHandler(instance, proxy);

        ContentHelper.registerContent(Element.values);
        ContentHelper.registerContent(Molecule.values);

        FundamentalsRecipies.initRecipies();

        logger.info("I found " + Element.values.length + " elements.");
        logger.info("I found " + Molecule.values.length + " molecules.");
    }

    @EventHandler
    public void invalidFingerprint(FMLFingerprintViolationEvent event) {
        if (Reference.FINGERPRINT.equals("@FINGERPRINT@")) {
            logger.warning(Strings.NO_FINGERPRINT_MESSAGE);
        } else {
            logger.severe(Strings.INVALID_FINGERPRINT_MESSAGE);
        }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        GuiContainerManager.tooltipHandlers.add(new FormulaTooltipHandler());

        FormulaHelper.registerIC2Items();
        FormulaHelper.generateFormulas();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigHandler.init(event.getSuggestedConfigurationFile());

        ModItems.init();
        //TODO: uncomment ModBlocks
        //ModBlocks.init();

        proxy.registerTileEntities();
        proxy.initSounds();
        proxy.initRenderers();
    }
}
