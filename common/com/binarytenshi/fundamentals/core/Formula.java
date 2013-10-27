package com.binarytenshi.fundamentals.core;

import java.util.AbstractMap.SimpleEntry;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents a chemical formula
 * 
 * @author BinaryTENSHi
 */
public class Formula {
    private final LinkedHashMap<Element, Integer> elements = new LinkedHashMap<Element, Integer>();

    public Formula() {
    }

    public Formula(Element... elements) {
        for (Element element : elements) {
            this.elements.put(element, 1);
        }
    }

    public Formula(SimpleEntry<Element, Integer>... elements) {
        for (SimpleEntry<Element, Integer> entry : elements) {
            this.elements.put(entry.getKey(), entry.getValue());
        }
    }

    public void combine(Formula form, int stackSize) {
        for (Map.Entry<Element, Integer> element : form.elements.entrySet()) {
            int count = element.getValue();

            if (elements.containsKey(element.getKey())) {
                count += elements.get(element.getKey());
                elements.remove(element.getKey());
            }

            elements.put(element.getKey(), Math.round((count / (float) stackSize) - .5f));
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

    public LinkedHashMap<Element, Integer> getElements() {
        return elements;
    }

    public String getFormula() {
        StringBuilder builder = new StringBuilder();
        Iterator it = elements.entrySet().iterator();

        for (Map.Entry<Element, Integer> element : elements.entrySet()) {
            builder.append(element.getKey().toString() + convertNumber(element.getValue()));
        }

        return builder.toString();
    }
}
