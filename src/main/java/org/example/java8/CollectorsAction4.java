package org.example.java8;

import java.util.Optional;
import java.util.stream.Collectors;

import static org.example.java8.CollectorsAction.menu;

public class CollectorsAction4 {


    public static void main(String[] args) {
        testSummingDouble();
        testSummingLong();
        testSummingInt();
    }


    private static void testSummingDouble() {
        System.out.println("testSummingDouble");
        Optional.of(menu.stream().collect(Collectors.summingDouble(Dish::getCalories))).ifPresent(System.out::println);

        Optional.of(menu.stream().map(Dish::getCalories).mapToInt(Integer::intValue).sum()).ifPresent(System.out::println);

    }

    private static void testSummingLong() {
        System.out.println("testSummingLong");
        Optional.of(menu.stream().collect(Collectors.summingLong(Dish::getCalories))).ifPresent(System.out::println);

    }

    private static void testSummingInt() {
        System.out.println("testSummingInt");
        Optional.of(menu.stream().collect(Collectors.summingInt(Dish::getCalories))).ifPresent(System.out::println);

    }


}
