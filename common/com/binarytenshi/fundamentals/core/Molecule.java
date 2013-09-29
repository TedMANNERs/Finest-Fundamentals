package com.binarytenshi.fundamentals.core;

import java.util.AbstractMap.SimpleEntry;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.lwjgl.util.Color;

/**
 * Represents the molecules in the world. <br>
 * > Constructed out of elements <br>
 * > Can be decomposed via various methods <br>
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
        this.id = name.toLowerCase();
        this.color = color;

        if (elements == null) {
            return;
        }

        for (SimpleEntry<Element, Integer> entry : elements) {
            this.elements.put(entry.getKey(), entry.getValue());
        }
    }

    /* This method converts a number into a half height string */
    private String convertNumber(Integer number) {
        if (number == 1) {
            return "";
        }

        String val = String.valueOf(number);

        val = val.replace('0', '\u2080');
        val = val.replace('1', '\u2081');
        val = val.replace('2', '\u2082');
        val = val.replace('3', '\u2083');
        val = val.replace('4', '\u2084');
        val = val.replace('5', '\u2085');
        val = val.replace('6', '\u2086');
        val = val.replace('7', '\u2087');
        val = val.replace('8', '\u2088');
        val = val.replace('9', '\u2089');

        return val;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public String getFormula() {
        StringBuilder builder = new StringBuilder();
        Iterator it = this.elements.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Element, Integer> pair = (Map.Entry<Element, Integer>) it.next();
            builder.append(pair.getKey().toString() + convertNumber(pair.getValue()));
        }

        return builder.toString();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean hasFormula() {
        return true;
    }
}
