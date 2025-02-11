package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackerTest {
    @Test
    public void whenTestFindById() {
        Item bug = new Item("Bug");
        Tracker tracker = new Tracker();
        Item item = tracker.add(bug);
        Item result = tracker.findById(bug.getId());
        assertThat(result).isEqualTo(item);
    }

    @Test
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        List<Item> results = tracker.findAll();
        List<Item> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        assertThat(results).isEqualTo(list);
    }

    @Test
    public void whenTestFindByName() {
        Item first = new Item("First");
        Item second = new Item("Second");
        Tracker tracker = new Tracker();
        tracker.add(first);
        tracker.add(second);
        List<Item> testlist = new ArrayList<>();
        testlist.add(first);
        List<Item> results = tracker.findByName("First");
        assertThat(results).isEqualTo(testlist);
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        List<Item> testlist = new ArrayList<>();
        testlist.add(second);
        List<Item> result = tracker.findByName("Second");
        assertThat(result).isEqualTo(testlist);
    }

    @Test
    public void whenReplaceItemIsSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item(0, "Bug");
        tracker.add(item);
        Item updateItem = new Item(0, "Bug with description");
        tracker.replace(item.getId(), updateItem);
        assertThat(updateItem.getName()).isEqualTo("Bug with description");
    }

    @Test
    public void whenReplaceItemIsNotSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("Bug");
        tracker.add(item);
        Item updateItem = new Item("Bug with description");
        boolean result = tracker.replace(1000, updateItem);
        assertThat(result).isFalse();
    }

    @Test
    public void whenDeleteItemIsSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("Bug");
        tracker.add(item);
        tracker.delete(item);
        List<Item> testlist = new ArrayList<>();
        assertThat(tracker.findByName("Bug")).isEqualTo(testlist);
    }

    @Test
    public void whenDeleteItemIsNotSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("Bug");
        Item item2 = new Item("Ant");
        tracker.add(item);
        tracker.delete(item2);
        List<Item> testlist = new ArrayList<>();
        assertThat(tracker.findByName("Ant")).isEqualTo(testlist);
    }
}
