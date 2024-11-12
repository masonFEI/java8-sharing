package org.example.java8;

import lombok.Data;

@Data
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    @Override
    public String toString() {
        return "name=" + name + ",vegetarian=" + vegetarian + ",calories=" + calories + ", type=" + type;
    }

    public enum Type {MEAT, FISH, OTHER}
}
