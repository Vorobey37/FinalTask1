package org.example.repositopy;

import org.example.entity.Author;
import org.example.entity.Entity;

import java.util.List;

public interface Repository<T extends Entity> {

    List<T> getEntityList();
    T addEntity(T entity);
    T deleteEntityById(long id);
    T getById(long id);
    List<T> getByAuthor(Author author);
}
