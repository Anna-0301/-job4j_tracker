package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] wordsLeft = left.split("\\.");
        String[] wordsRight = right.split("\\.");
        Integer iL = Integer.parseInt(wordsLeft[0]);
        Integer iR = Integer.parseInt(wordsRight[0]);
        return iL.compareTo(iR);
    }
}
