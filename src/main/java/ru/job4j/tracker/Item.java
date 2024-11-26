package ru.job4j.tracker;

import java.time.LocalDateTime;

public class Item {
    private LocalDateTime created;

    public Item() {
        this.created = LocalDateTime.now();
    }

    public LocalDateTime getCreated() {
        return this.created;
    }
}

