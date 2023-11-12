package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.Singleton.Database;

import java.sql.SQLException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database database = Database.getInstance();
        database.add("books", 1, "fdsf", "fdsfs");
    }
}