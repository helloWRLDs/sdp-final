package com.bookStore;

import com.bookStore.dao.BookDAO;
import com.bookStore.patterns.Factory.Book;
import com.bookStore.patterns.Singleton.Database;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        List<Book> bookList = BookDAO.getAllBooks();
        for (Book book : bookList) {
            System.out.println(book.getTitle());
        }
    }
}
