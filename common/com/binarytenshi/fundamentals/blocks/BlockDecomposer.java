package com.binarytenshi.fundamentals.blocks;

import com.binarytenshi.fundamentals.lib.BlockInfo;
import com.binarytenshi.fundamentals.lib.Strings;

import net.minecraft.block.material.Material;

/**
 * Decompose molecules into elements
 * 
 * @author BinaryTENSHi
 */
public class BlockDecomposer extends FundamentalsBlock {

    public BlockDecomposer(int id, Material material) {
        super(id, Material.iron);
        setUnlocalizedName(Strings.RESOURCE_PREFIX + BlockInfo.DECOMPOSER_UNLOCALIZED_NAME);
    }

}
