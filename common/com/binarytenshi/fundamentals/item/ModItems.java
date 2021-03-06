package com.binarytenshi.fundamentals.item;

import com.binarytenshi.fundamentals.lib.ItemInfo;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Class for instantiating and storing all fundamentals items.
 * 
 * @author BinaryTENSHi
 *
 */
public class ModItems {
    
    public static ItemVial vial;
    
    public static void init() {
        vial = new ItemVial(ItemInfo.VIAL_ID);
        
        GameRegistry.registerItem(vial, ItemInfo.VIAL_UNLOCALIZED_NAME);
    }
}
