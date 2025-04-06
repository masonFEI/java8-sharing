package org.example.java8.future;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureInAction1 {

    private final static Random RANDOM = new Random(System.currentTimeMillis());


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CompletableFuture<Double> completableFuture = new CompletableFuture();

        Thread thread = new Thread(() -> {
            double value = get();
            completableFuture.complete(value);
        });

        System.out.println("=======no====block...");

//        Optional.ofNullable(completableFuture.get()).ifPresent(System.out::println);


        completableFuture.whenComplete((result, throwable) -> {
            Optional.ofNullable(result).ifPresent(System.out::println);
            Optional.ofNullable(throwable).ifPresent(x -> x.printStackTrace());
        });


    }

    static double get() {
        try {
            Thread.sleep(RANDOM.nextInt(10000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return RANDOM.nextDouble();
    }


}
