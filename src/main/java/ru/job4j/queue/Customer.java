package ru.job4j.queue;

public record Customer(String name, int amount)  {
    public static Customer createCustomer(String name, int amount) {
        return new Customer(name, amount);
    }
}



