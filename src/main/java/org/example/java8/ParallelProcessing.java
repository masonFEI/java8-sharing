package org.example.java8;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelProcessing {


    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors());
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");

        System.out.println("The best process time(normalAdd) =>" + measureSumPerformance(ParallelProcessing::normalAdd, 100000000) + " MS");
//        System.out.println("The best process time(iterateStream) =>" + measureSumPerformance(ParallelProcessing::iterateStream, 100000000) + " MS");
//        System.out.println("The best process time(parallelStream) =>" + measureSumPerformance(ParallelProcessing::parallelStream, 10000000) + " MS");
//        System.out.println("The best process time(parallelStream2) =>" + measureSumPerformance(ParallelProcessing::parallelStream2, 100000000) + " MS");
        System.out.println("The best process time(parallelStream3) =>" + measureSumPerformance(ParallelProcessing::parallelStream3, 100000000) + " MS");
    }


    private static long measureSumPerformance(Function<Long, Long> adder, long limit) {
        long fastest = Long.MAX_VALUE;
        for (long i = 0; i < 10; i++) {
            long startTimestamp = System.currentTimeMillis();
            long result = adder.apply(limit);
            long duration = System.currentTimeMillis() - startTimestamp;
//            System.out.println("The result of sum=>" + result);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }


    private static long normalAdd(long limit) {
        long result = 0;
        for (long i = 1; i <= limit; i++) {
            result += i;
        }
        return result;
    }

    private static long iterateStream(long limit) {
        return Stream.iterate(1L, i -> i + 1L).limit(limit).reduce(0L, Long::sum);
    }

    private static long parallelStream(long limit) {
        return Stream.iterate(1L, i -> i + 1L).parallel().limit(limit).reduce(0L, Long::sum);
    }

    private static long parallelStream2(long limit) {
        return Stream.iterate(1L, i -> i + 1L).mapToLong(Long::longValue).parallel().limit(limit).reduce(0L, Long::sum);
    }

    private static long parallelStream3(long limit) {
        return LongStream.rangeClosed(1, limit).parallel().limit(limit).reduce(0L, Long::sum);
    }


}
