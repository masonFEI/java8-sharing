package org.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class CustomerCollecttorAction {


    public static void main(String[] args) {

        Collector<String, List<String>, List<String>> toListCollector = new ToListCollector<>();

        String[] arrs = {"alex", "wang", "hello", "lamdba", "colletor", "java8", "stream"};
//        List<String> collect = Arrays.stream(arrs).filter(s -> s.length() >= 5).collect(toListCollector);
        List<String> collect = Arrays.asList("alex", "wang", "hello", "lamdba", "colletor", "java8", "stream").parallelStream().filter(s -> s.length() >= 5).collect(toListCollector);
        System.out.println(collect);

    }

}
