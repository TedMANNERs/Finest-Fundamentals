package com.binarytenshi.fundamentals.blocks;

import com.binarytenshi.fundamentals.lib.BlockInfo;
import com.binarytenshi.fundamentals.lib.Strings;

import net.minecraft.block.material.Material;

/**
 * Decompose molecules into elements. <br>
 * Currently does absolutely nothing. <br>
 * Will be replaced by various machines that decompose molecules
 * using different methods like a destiller.
 * 
 * @author BinaryTENSHi
 */
public class BlockDecomposer extends FundamentalsBlock {

    public BlockDecomposer(int id, Material material) {
        super(id, Material.iron);
        setUnlocalizedName(Strings.RESOURCE_PREFIX + BlockInfo.DECOMPOSER_UNLOCALIZED_NAME);
    }

}
