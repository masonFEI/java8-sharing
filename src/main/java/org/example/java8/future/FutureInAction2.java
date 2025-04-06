package org.example.java8.future;

import java.util.concurrent.*;

public class FutureInAction2 {


    public static void main(String[] args) {


        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> future = executor.submit(() -> {
            try {
                Thread.sleep(10000);
                return "I am finished";
            } catch (InterruptedException e) {
                return "I am error";
            }
        });

        while(!future.isDone()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        String value = null;
        try {
            value = future.get(10, TimeUnit.MICROSECONDS);
            System.out.println(value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }


        executor.shutdownNow();


    }

}
