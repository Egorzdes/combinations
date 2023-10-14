//package sber_project.proj.service;
//
//import org.assertj.core.groups.Tuple;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;
//
//
//public class TestClass {
//    public static void main(String[] args) {
//
//
//        final List<String> oz_dom = Arrays.asList("2:1", "3:1");
//        final List<String> oz_gosti = Arrays.asList("1:2", "1:3");
//        final List<String> neoz_dom = Arrays.asList("1:0", "2:0");
//        final List<String> neoz_gosti = Arrays.asList("1:2", "1:3");
//        final List<String> oz_gosti2 = Arrays.asList("1:2", "1:3");
//        final List<String> oz_gosti3 = Arrays.asList("1:2", "1:3");
//        final List<String> oz_gosti4 = Arrays.asList("1:2", "1:3");
//
//
//        AtomicInteger counter = new AtomicInteger(1); // Create a counter variable
//
//        oz_dom.stream()
//                .flatMap(x -> neoz_dom.stream()
//                        .flatMap(y -> neoz_gosti.stream()
//                                .flatMap(z -> oz_gosti.stream()
//                                        .flatMap(w -> oz_gosti2.stream()
//                                                .flatMap(u -> oz_gosti3.stream()
//                                                        .flatMap(s -> oz_gosti4.stream()
//                                                                .map(v -> counter.getAndIncrement() + ": " + Tuple.tuple(x, y, z, w, u, s, v)))))))) // Add oz_gosti3 to the stream
//                .forEach(System.out::println);
//
//    }
//}