/**
 * LY.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package org.example.java8;

import com.sun.javafx.collections.MappingChange;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * CollectorIntroduce
 *
 * @author johnny.fei
 * @version 1.0.0
 * @since 2024-12-10 21:50
 */
public class CollectorIntroduce {

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green", 160), new Apple("red", 200), new Apple("green", 100), new Apple("yellow", 100));
        List<Apple> greenList = list.stream().filter(a -> a.getColor().equals("green")).collect(Collectors.toList());
//        Optional.ofNullable(greenList).ifPresent(System.out::println);

//        Optional.ofNullable(groupByNormal(greenList)).ifPresent(System.out::println);

        Optional.ofNullable(groupByFunction(list)).ifPresent(System.out::println);

    }

    private static Map<String, List<Apple>> groupByNormal(List<Apple> apples) {
        Map<String, List<Apple>> map = new HashMap<>();
        for (Apple apple : apples) {
            List<Apple> list = map.computeIfAbsent(apple.getColor(), k -> new ArrayList<>());

            list.add(apple);
        }

        return map;
    }

    private static Map<String, List<Apple>> groupByFunction(List<Apple> apples) {
        Map<String, List<Apple>> map = new HashMap<>();
        apples.stream().forEach(apple ->
                {
                    List<Apple> colorList = Optional.ofNullable(map.get(apple.getColor())).orElseGet(() -> {
                        List<Apple> list = new ArrayList<>();
                        map.put(apple.getColor(), list);
                        return list;
                    });
                    colorList.add(apple);
                }
        );

        return map;
    }


}