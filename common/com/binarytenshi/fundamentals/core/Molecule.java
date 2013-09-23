package com.binarytenshi.fundamentals.core;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;

public enum Molecule {
    NOTHING(0, "Nothing", null),
    WATER(1, "Water", new SimpleEntry(Element.H, 2), new SimpleEntry(Element.O, 1));

    public static Molecule[] values = values();

    private int meta;
    private String name;
    private HashMap<Element, Integer> elements = new HashMap<Element, Integer>();

    // TODO: find an easier way to construct molecules
    Molecule(int meta, String name, SimpleEntry<Element, Integer>... elements) {
        this.name = name;
        this.meta = meta;

        if(elements == null)
            return;
        
        for (SimpleEntry<Element, Integer> entry : elements) {
            this.elements.put(entry.getKey(), entry.getValue());
        }
    }

    public String getName() {
        return this.name;
    }

    public int getMeta() {
        return this.meta;
    }
}
