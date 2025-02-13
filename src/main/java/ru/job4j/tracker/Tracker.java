package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {

    private int ids = 1;
    private final List<Item> items = new ArrayList<>();

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public Item findById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Item indexOf(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public boolean replace(int id, Item item) {
        Item old = indexOf(id);
        if (old != null) {
            int idx = items.indexOf(old);
            items.set(idx, item);
            return true;
        }
        return false;
    }

    public void delete(Item item) {
        if (indexOf(item.getId()) != null) {
            items.remove(item);
        }
    }
}
