package com.binarytenshi.fundamentals.blocks;

import com.binarytenshi.fundamentals.lib.BlockInfo;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Class for instantiating and storing all fundamentals blocks.
 * 
 * @author BinaryTENSHi
 *
 */
public class ModBlocks {

    public static Block decomposer;

    public static void init() {
        decomposer = new BlockDecomposer(BlockInfo.DECOMPOSER_ID, Material.iron);

        GameRegistry.registerBlock(decomposer, BlockInfo.DECOMPOSER_UNLOCALIZED_NAME);
    }
}
