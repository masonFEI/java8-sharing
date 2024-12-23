/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package org.example.java8;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static org.example.java8.CollectorsAction.menu;

/**
 * CollectorsAction2
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-12-23 22:07
 */
public class CollectorsAction2 {

    public static void main(String[] args) {
        testGroupingByConcurrent();
    }

    private static void testGroupingByConcurrent() {
        System.out.println("testGroupingByConcurrent");
        ConcurrentMap<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }


}