package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        if (key == null) {
            throw new ElementNotFoundException("Element not found");
        }
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[]{}, null);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
