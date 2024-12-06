package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        System.out.println("item: " + item);
        LocalDateTime itemCreated = item.getCreated();
        System.out.println("Текущие дата и время до форматирования: " + itemCreated);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String itemCreatedFormat = itemCreated.format(formatter);
        System.out.println(itemCreatedFormat);
    }
}
