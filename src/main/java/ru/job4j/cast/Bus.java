package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + ": Движется со скоростю не более 60 км.ч.");
    }
}
