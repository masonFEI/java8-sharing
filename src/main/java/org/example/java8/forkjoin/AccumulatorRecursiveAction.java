package org.example.java8.forkjoin;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

public class AccumulatorRecursiveAction extends RecursiveAction {

    private final int start;

    private final int end;

    private final int[] data;

    private final int LIMIT = 3;

    public AccumulatorRecursiveAction(int start, int end, int[] data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected void compute() {
        if (end - start < LIMIT) {
            for (int i = start; i < end; i++) {
                AccumulatorHelper.accumulate(data[i]);
            }
        } else {
            int middle = (start + end) / 2;
            AccumulatorRecursiveAction left = new AccumulatorRecursiveAction(start, middle, data);
            AccumulatorRecursiveAction right = new AccumulatorRecursiveAction(middle, end, data);

            left.fork();
            right.fork();

            left.join();
            right.join();
        }
    }

    static class AccumulatorHelper {
        private static final AtomicInteger result = new AtomicInteger(0);

        static void accumulate(int value) {
            result.getAndAdd(value);
        }

        public static int getResult() {
            return result.get();
        }

        static void reset() {
            result.set(0);
        }

    }
}
