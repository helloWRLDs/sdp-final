package com.bookStore.patterns.Builder;

public class ConcreteQueryBuilder implements QueryBuilder {
    private StringBuilder query;

    public ConcreteQueryBuilder() {
        this.query = new StringBuilder();
    }

    @Override
    public QueryBuilder select(String columns) {
        query.append("SELECT ").append(columns).append(" ");
        return this;
    }

    @Override
    public QueryBuilder from(String table) {
        query.append("FROM ").append(table).append(" ");
        return this;
    }

    @Override
    public QueryBuilder where(String condition) {
        query.append("WHERE ").append(condition).append(" ");
        return this;
    }

    @Override
    public QueryBuilder insert_into(String into) {
        query.append("INSERT INTO ").append(into).append(" ");
        return this;
    }

    @Override
    public QueryBuilder value(String value) {
        query.append("VALUE ").append(value).append(" ");
        return this;
    }

    @Override
    public String build() {
        return query.toString().trim();
    }
}
