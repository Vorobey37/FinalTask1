package org.example.entity;

import java.util.UUID;

public abstract class Entity {

    protected static long inventoryNumber;
    protected long id;
    private String name;
    private Author author;

    public Entity(String name, Author author) {
        this.name = name;
        this.author = author;
        inventoryNumber++;
        id = inventoryNumber;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                '}';
    }
}
