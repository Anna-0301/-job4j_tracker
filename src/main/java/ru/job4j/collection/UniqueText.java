package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {

    public boolean isEquals(String originText, String duplicateText) {
        boolean result = true;
        String[] origin = originText.split(" ");
        String[] duplicate = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String string : origin) {
            check.add(Arrays.toString(origin));
        }
        for (String string : duplicate) {
            if (check.contains(Arrays.toString(duplicate))) {
                return result;
            }
        }
        return !result;
    }
}
