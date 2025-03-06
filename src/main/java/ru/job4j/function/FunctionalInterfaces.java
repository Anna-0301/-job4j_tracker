package ru.job4j.function;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biConsumer = (key, value) -> map.put(key, value);
        for (int i = 0; i < list.size(); i++) {
            biConsumer.accept(i + 1, list.get(i));
        }
        BiPredicate<Integer, String> biPredicate = (key, value) -> (key % 2 == 0) || (value.length() == 4);
        for (Integer key : map.keySet()) {
            if (biPredicate.test(key, map.get(key))) {
            System.out.println("key: " + key + " value: " + map.get(key));
            }
        }
        Supplier<List<String>> supplier = () -> new ArrayList<>(list);
        List<String> strings = supplier.get();
        Consumer<String> consumer = (string) -> System.out.println(string.toUpperCase());
        for (String string : strings) {
            consumer.accept(string);
        }
    }
}
