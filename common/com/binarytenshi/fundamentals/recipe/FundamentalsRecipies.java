package com.binarytenshi.fundamentals.recipe;

import com.binarytenshi.fundamentals.item.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class FundamentalsRecipies {

    public static void initRecipies() {
        /* Any vial to empty vial    */
        /* Probably for testing only */
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.vial), new Object[] { new ItemStack(ModItems.vial, 1, OreDictionary.WILDCARD_VALUE) });
    }
}
