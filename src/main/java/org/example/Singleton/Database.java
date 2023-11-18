package org.example.Singleton;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class Database {
    private static Database instance;
    private static final String url = Dotenv.load().get("url");
    private static final String user = Dotenv.load().get("user");
    private static final String password = Dotenv.load().get("password");
    public int value = 1;
    static Connection connection;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            Statement st = connection.createStatement();
            st.executeUpdate("create database if not exists test;");

            st.executeUpdate("create table if not exists test.books (id int primary key, title text not null, descr text);");
            st.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Database() {}

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
            instance = null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Connection closed...");
        }
    }
}
