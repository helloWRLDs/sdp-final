package com.bookStore.patterns.Builder;

public interface QueryBuilder {
    QueryBuilder select(String columns);
    QueryBuilder from(String table);
    QueryBuilder where(String condition);
    QueryBuilder insert_into(String into);
    QueryBuilder value(String value);
    String build();
}
