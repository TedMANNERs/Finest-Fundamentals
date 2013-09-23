package com.binarytenshi.fundamentals.core;

public enum Element {
    NOTHING("Nothing", 0, 0, 0),
    H("Hydrogen", 1, 1, 1),
    O("Oxygen", 8, 8, 8);

    public static Element[] values = values();

    private String name;
    private int protons;
    private int neutrons;
    private int electrons;
    private int mass;

    Element(String name, int protons, int neutrons, int electrons) {
        this.name = name;
        this.protons = protons;
        this.neutrons = neutrons;
        this.electrons = electrons;

        this.mass = protons + neutrons;
    }

    public String getName() {
        return name;
    }
}
