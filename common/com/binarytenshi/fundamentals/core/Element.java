package com.binarytenshi.fundamentals.core;

/**
 * Represents the Elements in the world
 * 
 * @author BinaryTENSHi
 */
public enum Element {
    NOTHING("Nothing", 0, 0, 0, 0),
    H("Hydrogen", 1, 0, 14, 20),
    O("Oxygen", 8, 8, 54, 90),
    FE("Iron", 26, 30, 1808, 3032);

    public static Element[] values = values();

    private String name;
    private int protons;
    private int neutrons;
    private int electrons;
    private int mass;

    private int meltingPoint;
    private int boilingPoint;

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
    Element(String name, int protons, int neutrons, int meltingPoint, int boilingPoint) {
        this.name = name;
        this.protons = protons;
        this.neutrons = neutrons;
        this.electrons = protons;
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;

        this.mass = protons + neutrons;
    }

    public String getName() {
        return name;
    }
}
