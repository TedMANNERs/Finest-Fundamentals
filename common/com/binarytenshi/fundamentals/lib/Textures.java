package com.binarytenshi.fundamentals.lib;

import net.minecraft.util.ResourceLocation;

/**
 * Contains paths to all textures
 * 
 * @author BinaryTENSHi
 */
public class Textures {
    // Base file paths
    public static final String MODEL_SHEET_LOCATION = "textures/models/";
    public static final String ARMOR_SHEET_LOCATION = "textures/armor/";
    public static final String GUI_SHEET_LOCATION = "textures/gui/";
    public static final String EFFECTS_LOCATION = "textures/effects/";

    public static final ResourceLocation DISTILLERY_MODEL = new ResourceLocation(Reference.MOD_ID, MODEL_SHEET_LOCATION + BlockInfo.DISTILLERY_UNLOCALIZED_NAME + ".png");

}
