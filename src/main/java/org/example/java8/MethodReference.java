package org.example.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {


    public static void main(String[] args) {
//        Consumer<String> consumer= s-> System.out.println(s);
//        useConsumer(consumer,"hello Alex");
//
//        useConsumer(s-> System.out.println(s),"hello Alex");
//
//        useConsumer(System.out::println,"hello Wangwenjun");

        List<Apple> list = Arrays.asList(new Apple("red", 123), new Apple("abc", 123), new Apple("Green", 110));

        System.out.println(list);

        list.sort((a1, a2) -> {
            return a1.getColor().compareTo(a2.getColor());
        });
        System.out.println(list);

        System.out.println("==========");

        list.stream().forEach(System.out::println);

        System.out.println("==========");

        int value = Integer.parseInt("123");

        Function<String, Integer> f = Integer::parseInt;
        Integer result = f.apply("123");
        System.out.println(result);

        System.out.println("==========");

        BiFunction<String, Integer, Character> f2 = String::charAt;
        Character c = f2.apply("hello", 2);
        System.out.println(c);

        System.out.println("==========");
        String string = new String("hello");
        Function<Integer, Character> f3 = string::charAt;
        Character c2 = f3.apply(4);
        System.out.println(c2);

        System.out.println("==========");
        Supplier<String> suppliler = String::new;
        String s = suppliler.get();
        System.out.println(s);

        System.out.println("==========");
        BiFunction<String, Long, Apple> appleBiFunction = Apple::new;
        Apple apple = appleBiFunction.apply("red", 100L);
        System.out.println(apple);

        System.out.println("==========");

        ThreeFunction<String, Long, String, ComplexApple> threeFunction = ComplexApple::new;
        ComplexApple complexApple = threeFunction.apply("Green", 123L, "Fushi");
        System.out.println(complexApple);

        System.out.println("==========");
        List<Apple> list2 = Arrays.asList(new Apple("red", 123), new Apple("abc", 123), new Apple("Green", 110));
        list2.sort(Comparator.comparing(Apple::getColor));
        System.out.println(list2);

    }


    private static <T> void useConsumer(Consumer<T> consumer, T t) {
        consumer.accept(t);
        consumer.accept(t);
    }
}
