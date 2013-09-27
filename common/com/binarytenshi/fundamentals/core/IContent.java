package com.binarytenshi.fundamentals.core;

import org.lwjgl.util.Color;

import com.binarytenshi.fundamentals.item.ItemVial;

/**
 * Represents an item or material that can be put inside an {@link ItemVial}.
 * 
 * @author BinaryTENSHi
 *
 */
public interface IContent {
    String getId();

    String getName();

    boolean hasFormula();

    String getFormula();

    Color getColor();
}
