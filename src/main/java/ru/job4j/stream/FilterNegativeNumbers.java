package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, -5, -10, 8, -21, 11, 0);
        List<Integer> positive = numbers.stream()
                .filter(x -> x > 0)
                .collect(Collectors.toList());
        positive.forEach(System.out::println);
    }

}
