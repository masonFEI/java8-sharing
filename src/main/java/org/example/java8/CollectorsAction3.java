/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package org.example.java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
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

//        testPartitionByWithPredicate();
//        testPartitionByWithPredicateAndCollector();
        testReducingBinaryOperator();
        testReducingBinaryOperatorAndIdentity();
        testReducingBinaryOperatorAndIdentityAndFunction();
    }


    private static void testPartitionByWithPredicate() {
        System.out.println("testPartitionByWithPredicate");
        Map<Boolean, List<Dish>> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        Optional.of(collect).ifPresent(System.out::println);

    }

    private static void testPartitionByWithPredicateAndCollector() {
        System.out.println("testPartitionBy WithPredicateAndCollector");
        Map<Boolean, Double> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.averagingInt(Dish::getCalories)));
        Optional.of(collect).ifPresent(System.out::println);
    }

    private static void testReducingBinaryOperator() {
        System.out.println("testReducingBinaryOperator");
        menu.stream().collect(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingInt(Dish::getCalories)))).ifPresent(System.out::println);
    }

    private static void testReducingBinaryOperatorAndIdentity() {
        System.out.println("testReducingBinaryOperatorAndIdentity");
        Integer result = menu.stream().map(Dish::getCalories).collect(Collectors.reducing(0, (d1, d2) -> d1 + d2));
        System.out.println(result);
    }

    private static void testReducingBinaryOperatorAndIdentityAndFunction() {
        System.out.println("testReducingBinaryOperatorAndIdentityAndFunction");
        Integer result = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (d1, d2) -> d1 + d2));
        System.out.println(result);
    }

}