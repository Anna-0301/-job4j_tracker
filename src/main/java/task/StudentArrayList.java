package task;

import java.util.ArrayList;
import java.util.List;

public class StudentArrayList {

    public static List<String> bubbleSorter(List<String> array) {
        String temp;
        for (int j = array.size() - 1; j > 0; j--) {
            for (int i = 0; i < array.size() - j; i++) {
                if (array.get(i).compareTo(array.get(i + 1)) > 0) {
                    temp = array.get(i);
                    array.set(i, array.get(i + 1));
                    array.set(i + 1, temp);
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Petrov");
        names.add("Ivanov");
        names.add("Stepanov");
        for (String name : names) {
            System.out.println(name);
        }
        ArrayList<String> names1 = new ArrayList<>();
        names1.addAll(names);
        System.out.println("Отсортированный список: " + bubbleSorter(names1));
        names1.remove("Stepanov");
        System.out.println("Список после удаления: " + names1);
    }
}
