/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package org.example.java8;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.example.java8.CollectorsAction.menu;

/**
 * CollectorsAction3
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-12-28 19:42
 */
public class CollectorsAction3 {


    public static void main(String[] args) {

        testPartitionByWithPredicate();
        testPartitionByWithPredicateAndCollector();
    }


    private static void testPartitionByWithPredicate() {
        System.out.println("testPartitionByWithPredicate");
        Map<Boolean, List<Dish>> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        Optional.of(collect).ifPresent(System.out::println);

    }

    private static void testPartitionByWithPredicateAndCollector() {
        System.out.println("testPartitionByWithPredicateAndCollector");
        Map<Boolean, Double> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.averagingInt(Dish::getCalories)));
        Optional.of(collect).ifPresent(System.out::println);
    }


}