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

    public static List<Apple> findApples(List<Apple> apples, String color) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if (color.equals(apple.getColor())) {
                list.add(apple);
            }
        }

        return list;
    }


    @FunctionalInterface
    public interface AppleFilter {
        boolean filter(Apple apple);
    }

    public static List<Apple> findApples(List<Apple> apples, AppleFilter appleFilter) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if (appleFilter.filter(apple)) {
                list.add(apple);
            }
        }

        return list;
    }

    public static class GreenAnd150WeightFilter implements AppleFilter {
        @Override
        public boolean filter(Apple apple) {
            return apple.getColor().equals("green") && apple.getWeight() > 150;
        }
    }

    public static class YellowLess150WeightFilter implements AppleFilter {
        @Override
        public boolean filter(Apple apple) {
            return apple.getColor().equals("yellow") && apple.getWeight() < 150;
        }
    }

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green", 160), new Apple("red", 200), new Apple("green", 100), new Apple("yellow", 100));
//        List<Apple> greenApples = findGreenApple(list);
//        assert greenApples.size() == 2;

//        List<Apple> greenApples = findApples(list, "green");
//
//        System.out.println(greenApples);

//        List<Apple> greens = findApples(list, new GreenAnd150WeightFilter());
//        System.out.println(greens);
//        List<Apple> yellows = findApples(list, new YellowLess150WeightFilter());
//        System.out.println(yellows);
//
//        List<Apple> reds = findApples(list, new AppleFilter() {
//            @Override
//            public boolean filter(Apple apple) {
//                return "red".equals(apple.getColor());
//            }
//        });
//        System.out.println(reds);

//        List<Apple> lambdaResult = findApples(list, apple -> apple.getColor().equals("green"));
//
//        System.out.println(lambdaResult);


        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            }).start();

            new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}
