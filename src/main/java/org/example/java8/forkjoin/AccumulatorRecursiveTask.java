package org.example.java8.forkjoin;

import java.util.concurrent.RecursiveTask;

public class AccumulatorRecursiveTask extends RecursiveTask<Integer> {

    private final int start;

    private final int end;

    private final int[] data;

    private final int LIMIT = 3;

    public AccumulatorRecursiveTask(int start, int end, int[] data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected Integer compute() {

        if (end - start <= LIMIT) {
            int result = 0;
            for (int i = start; i < end; i++) {
                result += data[i];
            }
            return result;
        }

        int middle = (start + end) / 2;
        AccumulatorRecursiveTask left = new AccumulatorRecursiveTask(start, middle, data);
        AccumulatorRecursiveTask right = new AccumulatorRecursiveTask(middle, end, data);
        left.fork();
        Integer rightResult = right.compute();
        Integer leftResult = left.join();
        return rightResult + leftResult;
    }
}
