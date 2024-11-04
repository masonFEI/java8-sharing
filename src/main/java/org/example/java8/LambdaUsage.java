package org.example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public class LambdaUsage {


    @FunctionalInterface
    public interface Adder {
        int add(int a, int b);
    }

    public interface SmartAdder extends Adder {

        int add(long a, long b);
    }


    public interface DoNoting {

    }


    private static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate) {

        List<Apple> result = new ArrayList<>();
        for (Apple apple : source) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    private static List<Apple> filterByWeight(List<Apple> source, LongPredicate predicate) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : source) {
            if (predicate.test(apple.getWeight())) {
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterByBiPredicate(List<Apple> source, BiPredicate<String, Long> predicate) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : source) {
            if (predicate.test(apple.getColor(), apple.getWeight())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {

//        Runnable r1 = () -> System.out.println("Hello World");
//
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello World");
//            }
//        };
//        process(r1);
//        process(r2);
//        process(() -> System.out.println("Hello World"));

        List<Apple> list = Arrays.asList(new Apple("green", 120), new Apple("red", 160));
//        List<Apple> greenList = filter(list, apple -> apple.getColor().equals("green"));
//        System.out.println(greenList);

//        List<Apple> apples = filterByWeight(list, w -> w > 100);
//        System.out.println(apples);

        List<Apple> apples1 = filterByBiPredicate(list, (s, w) -> s.equals("green") && w > 100);
        System.out.println(apples1);

    }


    private static void process(Runnable r) {

        r.run();
    }

}
