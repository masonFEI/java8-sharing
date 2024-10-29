package org.example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterApple {


    public static List<Apple> findGreenApple(List<Apple> apples) {

        List<Apple> list = new ArrayList<>();

        for (Apple apple : apples) {

            if ("green".equals(apple.getColor())) {
                list.add(apple);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green", 150), new Apple("red", 200), new Apple("green", 100));
        List<Apple> greenApples = findGreenApple(list);
        assert greenApples.size() == 2;

        System.out.println(greenApples);
    }

}
