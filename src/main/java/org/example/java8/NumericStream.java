package org.example.java8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStream {


    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Stream<Integer> stream1 = stream.filter(i -> i.intValue() > 3);
        Integer result = stream1.reduce(0, Integer::sum);
        System.out.println(result);
        // int(4byte/32bit)

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        // 拆箱后的int
        int sum = stream.mapToInt(i -> i.intValue()).filter(i -> i > 3).sum();
        System.out.println(sum);
//        int sum = intStream.filter(i -> i > 3).sum();

        int a = 9;
        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .boxed()
                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                .forEach(r -> System.out.println("a=" + r[0] + ",b=" + r[1] + ",c=" + r[2]));

        System.out.println("===============================");

        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                .forEach(r -> System.out.println("a=" + r[0] + ",b=" + r[1] + ",c=" + r[2]));


    }

}
