package com.binarytenshi.fundamentals.core;

import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedHashMap;

import org.lwjgl.util.Color;

/**
 * Represents the molecules in the world. <br>
 * > Constructed out of elements <br>
 * > Can be decomposed through various methods <br>
 * 
 * @author BinaryTENSHi
 */
public enum Molecule implements IContent {
    WATER("Water", new Color(0, 0, 255, 170), new SimpleEntry(Element.H, 2), new SimpleEntry(Element.O, 1));

    public static Molecule[] values = values();

    public static Molecule getById(String content) {
        for (Molecule m : values) {
            if (m.id == content) {
                return m;
            }
        }

        return null;
    }

    private String id;
    private String name;
    private Color color;
    private Formula formula;

    private final LinkedHashMap<Element, Integer> elements = new LinkedHashMap<Element, Integer>();

    /**
     * Represents a molecule (binding of elements)
     * 
     * @param name
     *            name of the molecule
     * @param elements
     *            entries of elements and their count
     */
    Molecule(String name, Color color, SimpleEntry<Element, Integer>... elements) {
        this.name = name;
        this.color = color;
        id = name.toLowerCase();
        formula = new Formula(elements);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String getFormula() {
        return formula.getFormula();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean hasFormula() {
        return true;
    }
}
