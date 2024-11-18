package org.example.java8;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamFind {


    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Optional<Integer> optional1 = stream.filter(i -> i % 2 == 0).findAny();
        System.out.println(optional1.get());


        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Optional<Integer> optional3 = stream.filter(i -> i < 10).findFirst();
        System.out.println(optional3.orElse(-1));

        int result = find(new Integer[]{1, 2, 3, 4, 5, 6, 7}, -1, i -> i < 10);
        System.out.println(result);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Optional<Integer> optional2 = stream.filter(i -> i % 2 == 0).findFirst();
        optional2.ifPresent(System.out::println);

        System.out.println(optional2.filter(i -> i == 2).get());


    }

    private static int find(Integer[] values, int defaultValue, Predicate<Integer> predicate) {
        for (Integer value : values) {
            if (predicate.test(value)) {
                return value;
            }
        }
        return defaultValue;

    }


}
