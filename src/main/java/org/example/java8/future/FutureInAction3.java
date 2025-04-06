package org.example.java8.future;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FutureInAction3 {


    public static void main(String[] args) {
        Future<String> future = invoke(() -> {
            try {
                Thread.sleep(10000);
                return "I am finished";
            } catch (InterruptedException e) {
                return "I am error";
            }
        });

        future.setCompletable(new Completable<String>() {
            @Override
            public void complete(String value) {
                System.out.println(value);
            }

            @Override
            public void exception(Throwable cause) {
                System.out.println("error");
                cause.printStackTrace();
            }
        });

        System.out.println("........");
        System.out.println(future.get());
        System.out.println(future.get());

    }


    private static <T> FutureInAction3.Future<T> invoke(FutureInAction3.Callable<T> callable) {
        AtomicReference<T> result = new AtomicReference<>();
        AtomicBoolean finished = new AtomicBoolean(false);
        FutureInAction3.Future<T> future = new FutureInAction3.Future<T>() {

            private Completable<T> completable;

            @Override
            public T get() {
                return result.get();
            }

            @Override
            public boolean isDone() {
                return finished.get();
            }

            @Override
            public void setCompletable(Completable<T> completable) {
                this.completable = completable;
            }

            @Override
            public Completable<T> getCompletable() {
                return completable;
            }
        };


        Thread t = new Thread(() -> {
            try {
                T value = callable.action();
                result.set(value);
                finished.set(true);
                if (future.getCompletable() != null) {
                    future.getCompletable().complete(value);
                }
            } catch (Throwable cause) {
                if (future.getCompletable() != null) {
                    future.getCompletable().exception(cause);
                }
            }
        });
        t.start();

        return future;
    }


    private interface Future<T> {
        T get();

        boolean isDone();

        void setCompletable(Completable<T> completable);

        Completable<T> getCompletable();
    }

    private interface Callable<T> {
        T action();
    }

    private interface Completable<T> {
        void complete(T value);

        void exception(Throwable cause);

    }


}
