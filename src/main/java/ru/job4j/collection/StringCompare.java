package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int min = Math.min(left.length(), right.length());
        int result;
        for (int index = 0; index < min; index++) {
            if (left.charAt(index) != right.charAt(index)) {
                result = Character.compare(left.charAt(index), right.charAt(index));
                return result;
            }
        }
        return (left.length() == right.length()) ? 0 : Integer.compare(left.length(), right.length());
    }
}
