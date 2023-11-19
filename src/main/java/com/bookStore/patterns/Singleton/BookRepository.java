package com.bookStore.patterns.Singleton;

import com.bookStore.entity.Book;

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
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setDescription(rs.getString("descr"));
                book.setPrice(rs.getInt("price"));
                book.setTags(rs.getString("tags"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }

    public static void insertBook(Book book) {
        try {
            PreparedStatement statement = database.getConnection().prepareStatement(
                    "INSERT INTO bs.books(title, descr, price, tags) value (?, ?, ?, ?)"
            );
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getDescription());
            statement.setInt(3, book.getPrice());
            statement.setString(4, book.getTags());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Book getById(int id) {
        Book book = new Book();
        try {
            PreparedStatement statement = database.getConnection().prepareStatement(
                    "SELECT * FROM bs.books WHERE id=?"
            );
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setDescription(rs.getString("description"));
                book.setTags(rs.getString("tags"));
                book.setPrice(rs.getInt("price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }
}
