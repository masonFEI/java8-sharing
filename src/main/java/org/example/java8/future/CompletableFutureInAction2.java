package org.example.java8.future;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CompletableFutureInAction2 {

    public static void main(String[] args) throws InterruptedException {

//        AtomicBoolean finished = new AtomicBoolean(false);
//
//        CompletableFuture<Double> doubleCompletableFuture = CompletableFuture.supplyAsync(CompletableFutureInAction1::get)
//                .whenComplete((x, y) -> {
//                    Optional.of(x).ifPresent(System.out::println);
////                    Optional.of(y).ifPresent(z -> z.printStackTrace());
//                    finished.set(true);
//                });
//
//        System.out.println("===========i am not block===============");
//
//        while (!finished.get()) {
//            Thread.sleep(1);
//        }


//        Thread.currentThread().join();

        Executor executor = Executors.newFixedThreadPool(2, r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });


        CompletableFuture<Double> doubleCompletableFuture = CompletableFuture.supplyAsync(CompletableFutureInAction1::get, executor)
                .whenComplete((x, y) -> {
                    Optional.of(x).ifPresent(System.out::println);
                });

        System.out.println("===========i am not block===============");

    }


}
