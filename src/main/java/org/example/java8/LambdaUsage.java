package org.example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class LambdaUsage {


    @FunctionalInterface
    public interface Adder {
        int add(int a, int b);
    }

    public interface SmartAdder extends Adder {

        int add(long a, long b);
    }


    public interface DoNoting {

    }


    private static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate) {

        List<Apple> result = new ArrayList<>();
        for (Apple apple : source) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    private static List<Apple> filterByWeight(List<Apple> source, LongPredicate predicate) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : source) {
            if (predicate.test(apple.getWeight())) {
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterByBiPredicate(List<Apple> source, BiPredicate<String, Long> predicate) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : source) {
            if (predicate.test(apple.getColor(), apple.getWeight())) {
                result.add(apple);
            }
        }
        return result;
    }

    private static void simpleTestConsumer(List<Apple> source, Consumer<Apple> consumer) {

        for (Apple apple : source) {
            consumer.accept(apple);
        }
    }


    private static void simpleBiConsumer(String c, List<Apple> source, BiConsumer<Apple, String> consumer) {
        for (Apple apple : source) {
            consumer.accept(apple, c);
        }
    }

    private static String testFunction(Apple apple, Function<Apple, String> function) {
        return function.apply(apple);
    }


    private static Apple testBiFunction(String color, long weight, BiFunction<String, Long, Apple> function) {
        return function.apply(color, weight);
    }


    public static void main(String[] args) {

//        Runnable r1 = () -> System.out.println("Hello World");
//
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello World");
//            }
//        };
//        process(r1);
//        process(r2);
//        process(() -> System.out.println("Hello World"));

        List<Apple> list = Arrays.asList(new Apple("green", 120), new Apple("red", 160));
//        List<Apple> greenList = filter(list, apple -> apple.getColor().equals("green"));
//        System.out.println(greenList);

//        List<Apple> apples = filterByWeight(list, w -> w > 100);
//        System.out.println(apples);

//        List<Apple> apples1 = filterByBiPredicate(list, (s, w) -> s.equals("green") && w > 100);
//        System.out.println(apples1);


//        simpleTestConsumer(list, a -> System.out.println(a));

//        simpleBiConsumer("XXX", list, (a, s) -> System.out.println(s + a.getColor() + ":Weight=>" + a.getWeight()));


//        String result3 = testFunction(new Apple("yello", 100), Apple::toString);
//        System.out.println(result3);

//        IntFunction<Double> f = i -> i * 100.0d;
//        Double result4 = f.apply(10);
//        System.out.println(result4);

//        Apple blue = testBiFunction("blue", 130, (s, w) -> new Apple(s, w));
//        System.out.println(blue);

//        Supplier<String> s = String::new; // method inference
//        System.out.println(s.get());
//        System.out.println(s.get().getClass());

        Apple green = createApple(() -> new Apple("Green", 100));

        System.out.println(green);

    }


    private static void process(Runnable r) {

        r.run();
    }

    private static Apple createApple(Supplier<Apple> supplier) {
        return supplier.get();
    }


}
