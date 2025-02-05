package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class FilteredData {
    private final List<Integer> integers = new ArrayList<>();
    private final List<Double> floats = new ArrayList<>();
    private final List<String> strings = new ArrayList<>();

    public void addInteger(int value) {
        integers.add(value);
    }

    public void addFloat(double value) {
        floats.add(value);
    }

    public void addString(String value) {
        strings.add(value);
    }

    public List<Integer> getIntegers() {
        return integers;
    }

    public List<Double> getFloats() {
        return floats;
    }

    public List<String> getStrings() {
        return strings;
    }

    @Override
    public String toString() {
        return "FilteredData{" +
                "integers=" + integers +
                ", floats=" + floats +
                ", strings=" + strings +
                '}';
    }
}