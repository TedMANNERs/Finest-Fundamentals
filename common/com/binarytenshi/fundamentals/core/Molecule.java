package com.binarytenshi.fundamentals.core;

import java.util.AbstractMap.SimpleEntry;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.lwjgl.util.Color;

import com.binarytenshi.fundamentals.lib.ItemInfo;
import com.binarytenshi.fundamentals.lib.Strings;

public enum Molecule implements IContent {
    NOTHING("Nothing", new Color(0, 0, 0, 0), null),
    WATER("Water", new Color(0, 0, 255, 170), new SimpleEntry(Element.H, 2), new SimpleEntry(Element.O, 1));

    public static Molecule[] values = values();

    private String id;
    private String name;
    private Color color;
    private LinkedHashMap<Element, Integer> elements = new LinkedHashMap<Element, Integer>();

    // TODO: find an easier way to construct molecules (maybe)
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
        this.id = Strings.MOLECULE_PREFIX + name;
        this.color = color;

        if (elements == null)
            return;

        for (SimpleEntry<Element, Integer> entry : elements) {
            this.elements.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public String getName() {
        return this.name;
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

    /* This method converts a number into a half height string */
    private String convertNumber(Integer number) {
        if (number == 1)
            return "";

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

    public static Molecule getById(String content) {
        for (Molecule m : values) {
            if (m.id == content)
                return m;
        }

        return null;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public boolean hasFormula() {
        return this != Molecule.NOTHING;
    }

    @Override
    public Color getColor() {
        return this.color;
    }
}
