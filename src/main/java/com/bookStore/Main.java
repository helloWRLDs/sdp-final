package com.bookStore;

import com.bookStore.patterns.Builder.ConcreteQueryBuilder;
import com.bookStore.patterns.Builder.QueryBuilder;
import com.bookStore.patterns.Singleton.Database;

public class Main {
    public static void main(String[] args) {
        // Use the QueryBuilder to construct a SQL query
        QueryBuilder queryBuilder = new ConcreteQueryBuilder();

        String query  =  queryBuilder.insert_into("bs.books(title, descr, price, tags)").value("(?, ?, ?, ?)").build();
        System.out.println(query);


        // You can create a new query with the same builder


    }
}
