/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package org.example.java8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * CollectorsAction
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-12-14 22:20
 */
public class CollectorsAction {


    private final static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    public static void main(String[] args) {
//        testAveragingDouble();
//        testAveragingInt();
//        testAveragingLong();
//        testCollectingAndThen();
//        testCounting();
//        testGroupByingFunction();

//        testGroupByingFunctionAndCollector();
//        testGroupByingFunctionAndSupplierAndCollector();
        testSummarizingInt();
    }

    private static void testAveragingDouble() {
        System.out.println("testAveraging Double");

        Optional.ofNullable(menu.stream().collect(Collectors.averagingDouble(Dish::getCalories))).ifPresent(System.out::println);
    }

    private static void testAveragingInt() {
        System.out.println("test AveragingInt");

        Optional.ofNullable(menu.stream().collect(Collectors.averagingInt(Dish::getCalories))).ifPresent(System.out::println);
    }

    private static void testAveragingLong() {
        System.out.println("testAveragingLong");

        Optional.ofNullable(menu.stream().collect(Collectors.averagingLong(Dish::getCalories))).ifPresent(System.out::println);
    }

    private static void testCollectingAndThen() {
        System.out.println("test CollectingAndThen");
        Optional.ofNullable(menu.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(Dish::getCalories), a -> " the average calories is->" + a))).ifPresent(System.out::println);

//        List<Dish> list = menu.stream().filter(d -> d.getType().equals(Dish.Type.MEAT)).collect(Collectors.toList());

        List<Dish> list = menu.stream().filter(d -> d.getType().equals(Dish.Type.MEAT)).collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

        list.add(new Dish("pork", false, 100, Dish.Type.OTHER));
        System.out.println(list);
    }


    private static void testCounting() {
        System.out.println("testCounting");
        Optional.of(menu.stream().collect(Collectors.counting())).ifPresent(System.out::println);
//        menu.stream().count();

    }

    private static void testGroupByingFunction() {
        System.out.println("testGroupByingFunction");
        Optional.of(menu.stream().collect(Collectors.groupingBy(Dish::getType))).ifPresent(System.out::println);

    }

    private static void testGroupByingFunctionAndCollector() {
        System.out.println("testGroupByingFunctionAndCollector");
        Optional.of(menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()))).ifPresent(System.out::println);

    }

    private static void testGroupByingFunctionAndSupplierAndCollector() {
        System.out.println("testGroupByingFunctionAndSupplierAndCollector");
        Map<Dish.Type, Double> map = menu.stream().collect(Collectors.groupingBy(Dish::getType, TreeMap::new, Collectors.averagingInt(Dish::getCalories)));
        System.out.println(map.getClass());

    }


    private static void testSummarizingInt() {
        System.out.println("testSummarizingInt");
        IntSummaryStatistics result = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        Optional.of(result).ifPresent(System.out::println);

    }


}