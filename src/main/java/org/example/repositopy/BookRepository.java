package org.example.repositopy;

import org.example.entity.Author;
import org.example.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository implements Repository<Book>{

    private final List<Book> books;

    public BookRepository() {
        books = new ArrayList<>();
    }

    @Override
    public List<Book> getEntityList() {
        return books;
    }

    @Override
    public Book addEntity(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public Book deleteEntityById(long id) {
        Book book = getById(id);
        if (book != null){
            books.remove(book);
        }
        return book;
    }

    @Override
    public Book getById(long id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Book> getByAuthor(Author author) {
        return books.stream()
                .filter(book -> book.getAuthor().getFirstName().equals(author.getFirstName()) && book.getAuthor().getLastName().equals(author.getLastName()))
                .toList();
    }
}
