package org.example.entity;

public class Book extends Entity {


    public Book(String name, Author author) {
        super(name, author);

    }

    @Override
    public String toString() {
        return "Book=" + super.toString();
    }
}
