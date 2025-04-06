package org.example.java8.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureInAction3 {


    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(2, r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(false);
            return thread;
        });

//        CompletableFuture.supplyAsync(CompletableFutureInAction1::get, executor)
//                .thenApply(CompletableFutureInAction3::multiply)
//                .whenComplete((r, e) -> Optional.ofNullable(r).ifPresent(System.out::println));
        List<Integer> productionIDs = Arrays.asList(1, 2, 3, 4, 5);
        Stream<CompletableFuture<Double>> futureStream = productionIDs.stream().map(i -> CompletableFuture.supplyAsync(() -> queryProduction(i), executor));
        Stream<CompletableFuture<Double>> multiplyFutures = futureStream.map(future -> future.thenApply(CompletableFutureInAction3::multiply));
        List<Double> result = multiplyFutures.map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println(result);
    }

    private static double multiply(double a) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return a * 10d;
    }


    private static double queryProduction(int i) {
        return CompletableFutureInAction1.get();
    }

}
