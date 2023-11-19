package com.bookStore.patterns.Singleton;

import com.bookStore.entity.Book;
import com.bookStore.patterns.Builder.ConcreteQueryBuilder;
import com.bookStore.patterns.Builder.QueryBuilder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    static Database database = Database.getInstance();

    public static List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        QueryBuilder queryBuilder = new ConcreteQueryBuilder();
        String query = queryBuilder.select("*").from("bs.books").build();
        try {
//            PreparedStatement statement = database.getConnection().prepareStatement("SELECT * FROM bs.books;");
            PreparedStatement statement = database.getConnection().prepareStatement(query);
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
        QueryBuilder queryBuilder = new ConcreteQueryBuilder();
        String query = queryBuilder.insert_into("bs.books(title, descr, price, tags)").value("(?, ?, ?, ?)").build();
        try {
//            PreparedStatement statement = database.getConnection().prepareStatement(
//                    "INSERT INTO bs.books(title, descr, price, tags) value (?, ?, ?, ?)"
//            );
            PreparedStatement statement = database.getConnection().prepareStatement(query);
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
        QueryBuilder queryBuilder = new ConcreteQueryBuilder();
        String query = queryBuilder.select("*").from("bs.books").where("id=?").build();
        try {
//            PreparedStatement statement = database.getConnection().prepareStatement(
//                    "SELECT * FROM bs.books WHERE id=?"
//            );
            PreparedStatement statement = database.getConnection().prepareStatement(query);
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
