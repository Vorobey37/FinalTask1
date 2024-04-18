package org.example.service;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.repositopy.AuthorRepository;
import org.example.repositopy.BookRepository;

import java.util.List;

public class BookService implements Service<Book>{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        createStartBookList();
    }

    private void createStartBookList() throws RuntimeException{
        addEntity(new Book("Война и мир", new Author("Лев", "Толстой")));
        addEntity(new Book("Преступление и наказание", new Author("Федор", "Достоевский")));
        addEntity(new Book("Руслан и Людмила", new Author("Александр", "Пушкин")));
    }
    @Override
    public List<Book> getEntityList() {
        return bookRepository.getEntityList();
    }

    @Override
    public Book addEntity(Book entity) throws RuntimeException{
        bookRepository.addEntity(entity);
        authorRepository.addAuthor(entity.getAuthor());
        return entity;
    }

    @Override
    public Book deleteEntityById(long id) {
        return bookRepository.deleteEntityById(id);
    }

    @Override
    public Book getById(long id) {
        return bookRepository.getById(id);
    }

    @Override
    public List<Book> getByAuthor(Author author) {
        return bookRepository.getByAuthor(author);
    }

    @Override
    public List<Author> getAuthorList() {
        return authorRepository.getAuthors();
    }

    @Override
    public Author getAuthor(String firstName, String lastName) {
        for (Author author : getAuthorList()) {
            if (author.getFirstName().equals(firstName) && author.getLastName().equals(lastName)){
                return author;
            }
        }
        return null;
    }
}
