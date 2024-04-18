package org.example.entity;

public class Letter extends Entity{

    public Letter(String name, Author author) {
        super(name, author);

    }

    @Override
    public String toString() {
        return "Letter=" + super.toString();
    }
}
