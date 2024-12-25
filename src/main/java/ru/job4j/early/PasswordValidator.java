package ru.job4j.early;

import java.util.Arrays;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException(
                    "Password can't be null"
            );
        }
        if (password.length() <= 8 || password.length() >= 32) {
            throw new IllegalArgumentException(
                    "Password should be length [8, 32]"
            );
        }
        boolean hasUpCase = false;
        boolean hasLowCase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        for (char symbol : password.toCharArray()) {
            if (Character.isUpperCase(symbol)) {
                throw new IllegalArgumentException(
                        "Uppercase character"
                );
            }
            if (Character.isLowerCase(symbol)) {
                throw new IllegalArgumentException(
                        "Lowercase character"
                );
            }
            if (Character.isDigit(symbol)) {
                throw new IllegalArgumentException(
                        "Number"
                );
            }
            if (!Character.isLetterOrDigit(symbol)) {
                throw new IllegalArgumentException(
                        "Special character"
                );
            }
        }
        if (!hasUpCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one uppercase letter"
            );
        }
        if (!hasLowCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one lowercase letter"
            );
        }
        if (!hasDigit) {
            throw new IllegalArgumentException(
                    "Password should contain at least one figure"
            );
        }
        if (!hasSpecial) {
            throw new IllegalArgumentException(
                    "Password should contain at least one special symbol "
            );
        }
        if (!password.matches(Arrays.toString(FORBIDDEN))) {
            throw new IllegalArgumentException(
                    "Password shouldn't contain substrings: qwerty, 12345, password, admin, user"
            );
        }
        return password;
    }
}
