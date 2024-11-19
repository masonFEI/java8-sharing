package org.example.java8;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamReduce {


    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Integer result = stream.reduce(0, Integer::sum);
        System.out.println(result);
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream.reduce((a, b) -> a + b).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream.reduce((a, b) -> {
            return a > b ? a : b;
        }).ifPresent(System.out::println);
        // 等价
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream.reduce(Integer::max).ifPresent(System.out::println);


        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream.reduce((a, b) -> {
            return a > b ? b : a;
        }).ifPresent(System.out::println);
        // 等价
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream.reduce(Integer::min).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Integer reduce = stream.filter(i -> i % 2 == 0).reduce(1, (i, j) -> i * j);
        System.out.println(reduce);
    }

}
