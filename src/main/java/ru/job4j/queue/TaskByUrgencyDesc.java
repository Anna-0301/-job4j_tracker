package ru.job4j.queue;

import java.util.Comparator;

public class TaskByUrgencyDesc implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        if (o2.urgency() == o1.urgency()) {
            return 0;
        }
        return o1.urgency() < o2.urgency() ? 1 : -1;
    }
}
