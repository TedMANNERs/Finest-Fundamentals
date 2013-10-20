package com.binarytenshi.fundamentals.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.binarytenshi.fundamentals.lib.BlockInfo;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Class for instantiating and storing all fundamentals blocks.
 * 
 * @author BinaryTENSHi
 */
public class ModBlocks {

    public static Block distillery;

    public static void init() {
        distillery = new BlockDistillery(BlockInfo.DISTILLERY_ID, Material.iron);

        GameRegistry.registerBlock(distillery, BlockInfo.DISTILLERY_UNLOCALIZED_NAME);
    }
}
