package com.binarytenshi.fundamentals.core;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;

import com.binarytenshi.fundamentals.lib.ItemInfo;

public enum Molecule {
    NOTHING("Nothing", null),
    WATER("Water", new SimpleEntry(Element.H, 2), new SimpleEntry(Element.O, 1));

    public static Molecule[] values = values();

    private int meta;
    private String name;
    private HashMap<Element, Integer> elements = new HashMap<Element, Integer>();

    // TODO: find an easier way to construct molecules (maybe)
    Molecule(String name, SimpleEntry<Element, Integer>... elements) {
        this.name = name;
        this.meta = ItemInfo.MOLECULE_NEXT_META++;

        if (elements == null)
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
