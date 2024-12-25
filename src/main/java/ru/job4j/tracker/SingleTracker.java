package ru.job4j.tracker;

public class SingleTracker {

    private static SingleTracker instance;

    private Tracker tracker = new Tracker();

    private SingleTracker() { }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public int indexOf(int id) {
        return tracker.indexOf(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public void delete(int id) {
            tracker.delete(id);
    }
}
