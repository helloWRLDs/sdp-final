package org.example.Observer;

import org.example.Factory.Book;

import java.util.List;

public class Subscriber implements Observer{
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<Book> bookList) {
        System.out.printf("Hello, %s. We have updated our storage!\n[ ", this.name);
        for (Book book : bookList) {
            System.out.print(book.getTitle());
            if (bookList.indexOf(book) != bookList.size() - 1) {
                System.out.print(", ");
            } else {
                System.out.print(" ]\n");
            }
        }
    }
}
