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

    public static Block chemicalTable;

    public static void init() {
        chemicalTable = new BlockChemicalTable(BlockInfo.CHEMICALTABLE_ID, Material.iron);

        GameRegistry.registerBlock(chemicalTable, BlockInfo.CHEMICALTABLE_UNLOCALIZED_NAME);
    }
}
