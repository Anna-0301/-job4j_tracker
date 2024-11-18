package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    private static int minus(int z) {
        return z - x;
    }

    private int divide(int b) {
        return b / x;
    }

    public int multyplay(int a) {
        return x * a;
    }

    private int sumAllOperation(int m) {
        return minus(m) + sum(m) + divide(m) + multyplay(m);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.sumAllOperation(10);
        System.out.println(result);
    }
}
