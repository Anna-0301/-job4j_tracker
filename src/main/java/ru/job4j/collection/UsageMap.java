package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("olegivanov@yandex.ru", "Oleg Ivanov");
        map.put("irinam2002@yandex.ru", "Irina Maslova");
        map.put("irinam2002@yandex.ru", "Irina Stepanovna Maslova");
        map.put("svan1919@yandex.ru", "Lily Swan");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + ", " + value);
        }
    }
}
