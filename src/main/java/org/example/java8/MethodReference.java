package org.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

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

        list.sort((a1,a2)->{return a1.getColor().compareTo(a2.getColor());});
        System.out.println(list);

        System.out.println("==========");

        list.stream().forEach(System.out::println);

        System.out.println("==========");

        int value = Integer.parseInt("123");

        Function<String,Integer> f = Integer::parseInt;
        Integer result = f.apply("123");
        System.out.println(result);



    }


    private static <T> void useConsumer(Consumer<T> consumer,T t) {
        consumer.accept(t);
        consumer.accept(t);
    }
}
