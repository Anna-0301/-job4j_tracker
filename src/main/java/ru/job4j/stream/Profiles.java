package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(p -> new Address(p.getAddress().getCity(), p.getAddress().getStreet(), p.getAddress().getHome(), p.getAddress().getApartment()))
                .collect(Collectors.toList());
    }
}
