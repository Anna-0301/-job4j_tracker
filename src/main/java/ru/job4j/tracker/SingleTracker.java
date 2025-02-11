package ru.job4j.tracker;

import java.util.List;

public class SingleTracker {

    private static SingleTracker instance;

    private final Tracker tracker = new Tracker();

    private SingleTracker() { }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return (Item) tracker.add(item);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public Item findById(int id) {
        return (Item) tracker.findById(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public void delete(Item item) {
            tracker.delete(item);
    }
}
