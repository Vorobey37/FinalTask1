package org.example.service;

import org.example.entity.Author;
import org.example.entity.Entity;

import java.util.List;

public interface Service<T extends Entity> {

    List<T> getEntityList();
    T addEntity(T entity);
    T deleteEntityById(long id);
    T getById(long id);
    List<T> getByAuthor(Author author);
    List<Author> getAuthorList();
    Author getAuthor(String firstName, String lastName);
}
