package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] wordsLeft = left.split("\\.");
        String[] wordsRight = right.split("\\.");
        Integer iL = 0;
        Integer iR = 0;
        try {
            iL = Integer.parseInt(wordsLeft[0]);
            iR = Integer.parseInt(wordsRight[0]);
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
        return iL.compareTo(iR);
    }
}
