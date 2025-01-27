package ru.job4j.queue;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class AppleStoreTest {
    @Test
    void whenGetLast() {
        Queue<Customer> customers = new LinkedList<>();
        customers.add(Customer.createCustomer("Petr", 1000));
        customers.add(Customer.createCustomer("Stas", 1500));
        customers.add(Customer.createCustomer("Andrey", 850));
        customers.add(Customer.createCustomer("Alexei", 900));
        customers.add(Customer.createCustomer("Iryna", 1250));
        customers.add(Customer.createCustomer("Elena", 750));
        customers.add(Customer.createCustomer("Rail", 950));
        int count = 4;
        AppleStore appleStore = new AppleStore(customers, count);
        String customer = appleStore.getLastHappyCustomer();
        assertThat(customer).isEqualTo("Alexei");
    }

    @Test
    void whenGetFirst() {
        Queue<Customer> customers = new LinkedList<>();
        customers.add(Customer.createCustomer("Petr", 1000));
        customers.add(Customer.createCustomer("Stas", 1500));
        customers.add(Customer.createCustomer("Andrey", 850));
        customers.add(Customer.createCustomer("Alexei", 900));
        customers.add(Customer.createCustomer("Iryna", 1250));
        customers.add(Customer.createCustomer("Elena", 750));
        customers.add(Customer.createCustomer("Rail", 950));
        int count = 4;
        AppleStore appleStore = new AppleStore(customers, count);
        String customer = appleStore.getFirstUpsetCustomer();
        assertThat(customer).isEqualTo("Iryna");
    }
}