package com.bookStore.patterns.Singleton;

import com.bookStore.patterns.Factory.AudioBook;
import com.bookStore.patterns.Factory.Book;
import com.bookStore.patterns.Factory.EBook;
import com.bookStore.patterns.Factory.RegularBook;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    static Database database = Database.getInstance();

    public static List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        try {
            PreparedStatement statement = database.getConnection().prepareStatement("SELECT * FROM bs.books;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                switch (rs.getString("type").toLowerCase()) {
                    case "a" -> bookList.add(new AudioBook(rs.getInt("id"), rs.getString("title"), rs.getString("descr"), rs.getInt("price")));
                    case "e" -> bookList.add(new EBook(rs.getInt("id"), rs.getString("title"), rs.getString("descr"), rs.getInt("price")));
                    case "r" -> bookList.add(new RegularBook(rs.getInt("id"), rs.getString("title"), rs.getString("descr"), rs.getInt("price")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }
}
