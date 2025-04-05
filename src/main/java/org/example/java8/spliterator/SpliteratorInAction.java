package org.example.java8.spliterator;

import java.util.Objects;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SpliteratorInAction {

    private static final String text = "ava.util.concurrent.RejectedExecutionException: " +
            "\n" +
            "Task io.opentelemetry." +
            "\n" +
            "javaagent.bootstrap." +
            "\n" +
            "executors.ContextPropagatingRunnable@2d3e6e95 rejected " +
            "\n" +
            "from com.ly.tw.base.metrics.threadPool." +
            "\n" +
            "MetersThreadPoolExecutor@c370700[Running," +
            "\n" +
            " pool size = 100," +
            "\n" +
            " active threads = 0, " +
            "\n" +
            "queued tasks = 50, " +
            "\n" +
            "completed tasks = 17822216]";

    public static void main(String[] args) {
//        IntStream intStream = IntStream.rangeClosed(0, 10);
//        Spliterator.OfInt spliterator = intStream.spliterator();
//        Consumer<Integer> consumer = i -> System.out.println(i);
//        spliterator.forEachRemaining(consumer);

        MySpliteratorText mySpliteratorText = new MySpliteratorText(text);
        Optional.of(mySpliteratorText.stream().count()).ifPresent(System.out::println);
//        mySpliteratorText.stream().forEach(System.out::println);

//        mySpliteratorText.stream().filter(s-> !s.isEmpty()).forEach(System.out::println);
        mySpliteratorText.parallelStream().filter(s-> !s.isEmpty()).forEach(System.out::println);

        IntStream intStream = IntStream.rangeClosed(0, 100);
        intStream.parallel().filter(null).sequential().map(null).parallel().filter(Objects::nonNull).forEach(System.out::println);

    }

    static class MySpliteratorText {

        private final String[] data;

        public MySpliteratorText(String text) {
            Objects.requireNonNull(text, "The parameter can not be null");
            this.data = text.split("\n");
        }

        public Stream<String> stream() {
            return StreamSupport.stream(new MySpliterator(), false);
        }

        public Stream<String> parallelStream() {
            return StreamSupport.stream(new MySpliterator(), true);
        }


        private class MySpliterator implements Spliterator<String> {

            private int start, end;

            public MySpliterator() {
                this.start = 0;
                this.end = MySpliteratorText.this.data.length - 1;
            }

            public MySpliterator(int start, int end) {
                this.start = start;
                this.end = end;
            }

//            @Override
//            public void forEachRemaining(Consumer<? super String> action) {
//                Spliterator.super.forEachRemaining(action);
//            }
//

//
//            @Override
//            public boolean hasCharacteristics(int characteristics) {
//                return Spliterator.super.hasCharacteristics(characteristics);
//            }
//
//            @Override
//            public Comparator<? super String> getComparator() {
//                return Spliterator.super.getComparator();
//            }

            @Override
            public boolean tryAdvance(Consumer<? super String> action) {
                if (start <= end) {
                    action.accept(MySpliteratorText.this.data[start++]);
                    return true;
                }
                return false;
            }

            @Override
            public Spliterator<String> trySplit() {
                int mid = (end - start) / 2;
                if (mid <= 1) {
                    return null;
                }

                int left = start;
                int right = start + mid;
                start = start + mid + 1;
                return new MySpliterator(left, right);
            }

            @Override
            public long estimateSize() {
                return end - start;
            }

            @Override
            public long getExactSizeIfKnown() {
                return estimateSize();
            }

            @Override
            public int characteristics() {
                return IMMUTABLE | SIZED | SUBSIZED;
            }
        }

    }


}
