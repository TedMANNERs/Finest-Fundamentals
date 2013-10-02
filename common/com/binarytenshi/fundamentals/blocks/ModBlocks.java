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

    public static Block decomposer;

    public static void init() {
        decomposer = new BlockChemicalTable(BlockInfo.CHEMICALTABLE_ID, Material.iron);

        GameRegistry.registerBlock(decomposer, BlockInfo.CHEMICALTABLE_UNLOCALIZED_NAME);
    }
}
