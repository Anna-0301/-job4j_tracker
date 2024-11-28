package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book detective = new Book("Butler", 303);
        Book novel = new Book("Daisy", 420);
        Book horror = new Book("Trap", 360);
        Book instructions = new Book("Clean code", 208);
        Book[] books = new Book[4];
        books[0] = detective;
        books[1] = novel;
        books[2] = horror;
        books[3] = instructions;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getTitle() + " - " + book.getPages());
        }

        System.out.println("Rearrange butler to treasure.");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getTitle() + " - " + book.getPages());
        }

        for (int index = 0; index < books.length; index++) {
            if (books[index].getTitle().equals("Clean code")) {
                System.out.println(books[index].getTitle());
            }
        }
    }
}
