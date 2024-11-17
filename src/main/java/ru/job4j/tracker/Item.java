package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public Item() {
    }

    public Item(String name) {
        this.id = 11;
        this.name = "Ivan";
    }

    public Item(int id, String name) {
        this.id = 12;
        this.name = "Marya";
    }
}