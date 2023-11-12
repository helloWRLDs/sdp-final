package org.example.Singleton;

import com.google.protobuf.Any;
import io.github.cdimascio.dotenv.Dotenv;
import org.example.Book;

import java.sql.*;

public class Database {
    private static Database instance;
    private static final Dotenv dotenv = Dotenv.load();
    private static final String url = dotenv.get("url");
    private static final String user = dotenv.get("user");
    private static final String password = dotenv.get("password");
    private static final String databaseName = "test";
    static Connection connection = null;
    static PreparedStatement stmt = null;
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

    public void add(String tableName, Object... args) throws SQLException {
        String query = String.format("Insert into %s.%s values (", databaseName, tableName);
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Integer) {
                query += args[i];
            } else {
                query += String.format("\"%s\"", args[i]);
            }
            if (i != args.length - 1) {
                 query += ", ";
            } else {
                query += ")";
            }
        }
        stmt = connection.prepareStatement(query);
        stmt.executeUpdate();
    }

//    public String getEmployeeById(int id) throws SQLException {
//        stmt = connection.prepareStatement("select * from ems.employees where id=%d".formatted(id));
//        ResultSet rs = stmt.executeQuery();
//        String name = null;
//        while (rs.next()) {
//            name = rs.getString("first_name");
//        }
//        rs.close();
//        return name;
//    }
//
//    public void getAllEmployees() throws SQLException {
//        stmt = connection.prepareStatement("SELECT * FROM test.employees");
//        ResultSet rs = stmt.executeQuery();
//        while (rs.next()) {
//            System.out.println(rs.getString("first_name"));
//        }
//        rs.close();
//    }
//

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Connection closed...");
        }
    }
}
