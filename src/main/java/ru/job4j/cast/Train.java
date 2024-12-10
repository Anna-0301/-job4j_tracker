package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + ": Движется со скоростью не менее 100 км.ч.");
    }
}
