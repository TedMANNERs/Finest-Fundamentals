package com.binarytenshi.fundamentals.core;

import org.lwjgl.util.Color;

/**
 * Represents the Elements in the world. <br>
 * > Have different melting/boiling points to separate them from molecules <br>
 * > Cannot be split further (for now)
 * 
 * @author BinaryTENSHi
 */
public enum Element implements IContent {
    H("Hydrogen", 1, 0, 14, 20, new Color(170, 0, 0, 170)),
    O("Oxygen", 8, 8, 54, 90, new Color(170, 170, 0, 170)),
    FE("Iron", 26, 30, 1808, 3023, new Color(150, 150, 150, 255));

    public static Element[] values = values();

    public static Element getById(String content) {
        for (Element e : values) {
            if (e.id == content) {
                return e;
            }
        }

        return null;
    }

    private String id;
    private String name;

    private Color color;

    /**
     * Instantiates a new Element
     * 
     * @param name
     *            name of the element
     * @param protons
     *            number of protons / electrons
     * @param neutrons
     *            number of neutrons
     * @param meltingPoint
     *            melting point in Kelvin
     * @param boilingPoint
     *            boiling point in Kelvin
     */
    Element(String name, int protons, int neutrons, int meltingPoint, int boilingPoint, Color color) {
        this.name = name;
        id = name.toLowerCase();
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String getFormula() {
        return null;
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
        return false;
    }
}
