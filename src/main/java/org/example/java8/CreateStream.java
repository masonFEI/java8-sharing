package org.example.java8;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CreateStream {


    public static void main(String[] args) {
//        createStreamFromCollection().forEach(System.out::println);
//        System.out.println("======================================");
//        createStreamFromValues().forEach(System.out::println);
//        System.out.println("======================================");
//        createStreamFromArrays().forEach(System.out::println);
//        System.out.println("======================================");
//        Stream<String> streamFromFile = createStreamFromFile();
//        System.out.println(streamFromFile);

//        createStreamFromIterator().forEach(System.out::println);

//        createStreamFromGenerate().forEach(System.out::println);


        createObjStreamFromGenerate().forEach(System.out::println);

    }


    private static Stream<String> createStreamFromCollection() {
        List<String> list = Arrays.asList("hello", "alex", "wangwenjun", "world");
        return list.stream();
    }


    private static Stream<String> createStreamFromValues() {
        return Stream.of("hello", "alex", "wangwenjun", "world");
    }


    private static Stream<String> createStreamFromArrays() {
        return Arrays.stream(new String[]{"hello", "alex", "wangwenjun", "world"});
    }


    private static Stream<String> createStreamFromFile() {

        Path path = Paths.get("F:\\code\\java\\java8-sharing\\src\\main\\java\\org\\example\\java8\\CreateStream.java");

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
            return lines;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static Stream<Integer> createStreamFromIterator() {
        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2).limit(10);
        return iterate;
    }

    private static Stream<Double> createStreamFromGenerate() {

        return Stream.generate(Math::random).limit(10);

    }

    /**
     * 定义supplier，作为Stream.generate的入参
     */
    static class ObjSupplier implements Supplier<Obj> {

        private int index = 0;

        private Random random = new Random(System.currentTimeMillis());

        @Override
        public Obj get() {
            index = random.nextInt(100);
            return new Obj(index, "Name->" + index);
        }
    }


    private static Stream<Obj> createObjStreamFromGenerate() {
        return Stream.generate(new ObjSupplier()).limit(10);
    }


    static class Obj {
        private int id;
        private String name;

        public Obj(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }


        @Override
        public String toString() {
            return "Obj{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


}
