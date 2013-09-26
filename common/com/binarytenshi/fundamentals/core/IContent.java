package com.binarytenshi.fundamentals.core;

import org.lwjgl.util.Color;

/**
 * Represents an item or material that can be put inside a vial
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
