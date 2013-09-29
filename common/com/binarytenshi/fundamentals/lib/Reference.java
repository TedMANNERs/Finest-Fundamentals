package com.binarytenshi.fundamentals.lib;

/**
 * Contains various static values that are used across the whole mod.
 * 
 * @author BinaryTENSHi
 */
public class Reference {
    /* Debug Mode */
    public static final boolean DEBUG_MODE = true;

    /* General */
    public static final String MOD_ID = "fundamentals";
    public static final String MOD_NAME = "Finest Fundamentals";
    public static final String VERSION = "@VERSION@ (build @BUILD_NUMBER@)";
    public static final String FINGERPRINT = "@FINGERPRINT@";
    public static final String CHANNEL_NAME = MOD_ID;
    public static final int ITEM_ID_SHIFT = 256;

    /* Proxies */
    public static final String SERVER_PROXY_CLASS = "com.binarytenshi.fundamentals.core.proxy.CommonProxy";
    public static final String CLIENT_PROXY_CLASS = "com.binarytenshi.fundamentals.core.proxy.ClientProxy";

}
