package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        while (index + 1 < products.length) {
            products[index] = products[index + 1];
            index++;
        }
        products[products.length - 1] = null;
        return products;
    }
}
