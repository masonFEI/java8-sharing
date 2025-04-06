package org.example.java8.future;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class CompletableFutureInAction5 {

    public static void main(String[] args) throws InterruptedException {
//        CompletableFuture.supplyAsync(() -> {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                    System.out.println(Thread.currentThread().getName() + "  is running");
//                    return 1.0d;
//                })
//                .runAfterBoth(CompletableFuture.supplyAsync(() -> {
//                    System.out.println(Thread.currentThread().getName() + "i s running");
//                    return 2.0d;
//                }), () -> System.out.println("done"));


//        CompletableFuture.supplyAsync(() -> {
//                    System.out.println("I am future 1");
//                    return CompletableFutureInAction1.get();
//                }).applyToEither(CompletableFuture.supplyAsync(() -> {
//                    System.out.println("I am future 2");
//                    return CompletableFutureInAction1.get();
//                }), v -> v * 10)
//                .thenAccept(System.out::println);


//        CompletableFuture.supplyAsync(() -> {
//            System.out.println("I am future 1");
//            return CompletableFutureInAction1.get();
//        }).acceptEither(CompletableFuture.supplyAsync(() -> {
//            System.out.println("I am future 2");
//            return CompletableFutureInAction1.get();
//        }), System.out::println);


//        CompletableFuture.supplyAsync(() -> {
//            System.out.println("I am future 1");
//            return CompletableFutureInAction1.get();
//        }).runAfterEither(CompletableFuture.supplyAsync(() -> {
//            System.out.println("I am future 2");
//            return CompletableFutureInAction1.get();
//        }), () -> System.out.println("done."));


        //        CompletableFuture
//                .allOf(collect.toArray(new CompletableFuture[collect.size()]))
//                .thenRun(() -> System.out.println("done"));

        CompletableFuture
                .anyOf(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                        .map(i -> CompletableFuture.supplyAsync(CompletableFutureInAction1::get)).toArray(CompletableFuture[]::new))
                .thenRun(() -> System.out.println("done"));


        Thread.currentThread().join();
    }


}
