package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> nameFind = name -> persons.contains(name);
        Predicate<Person> surnameFind = surname -> persons.contains(surname);
        Predicate<Person> phoneFind = phone -> persons.contains(phone);
        Predicate<Person> addressFind = address -> persons.contains(address);
        Predicate<Person> combine = nameFind.or(surnameFind).or(phoneFind).or(addressFind);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
