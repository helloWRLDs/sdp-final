package com.bookStore.patterns.Singleton;

import com.bookStore.patterns.Factory.*;

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

    public static void insertBook(Book book) {
        try {
            PreparedStatement statement = database.getConnection().prepareStatement(
                    "INSERT INTO bs.books(title, descr, type, price) value (?, ?, ?, ?)"
            );
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getDescription());
            statement.setString(3, book.getType());
            statement.setInt(4, book.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
