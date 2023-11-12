package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.Singleton.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        String query = "SELECT * FROM test.books";
        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("title"));
        }
    }
}