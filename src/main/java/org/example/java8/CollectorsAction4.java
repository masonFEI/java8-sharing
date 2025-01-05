package org.example.java8;

import java.util.Optional;
import java.util.stream.Collectors;

import static org.example.java8.CollectorsAction.menu;

public class CollectorsAction4 {


    public static void main(String[] args) {
        testSummingDouble();
    }


    private static void testSummingDouble() {
        System.out.println("testSummingDouble");
        Optional.of(menu.stream().collect(Collectors.summingDouble(Dish::getCalories))).ifPresent(System.out::println);
    }


}
