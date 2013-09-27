package com.binarytenshi.fundamentals.blocks;

import com.binarytenshi.fundamentals.Fundamentals;
import com.binarytenshi.fundamentals.lib.Reference;
import com.binarytenshi.fundamentals.lib.Strings;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

/**
 * Basic block which acts as a super class for all fundamentals blocks. <br>
 * Will later extend IC2 EnergySink to accept and use EU.
 * 
 * @author BinaryTENSHi
 */
public class FundamentalsBlock extends Block {

    public FundamentalsBlock(int id, Material material) {
        super(id, material);
        setCreativeTab(Fundamentals.creativeTab);
        setUnlocalizedName(Strings.RESOURCE_PREFIX + "NOT_SET");
    }

    @Override
    public void registerIcons(IconRegister register) {
        this.blockIcon = register.registerIcon(Strings.RESOURCE_PREFIX + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(":") + 1));
    }

}
