package org.example.controller;

import org.example.entity.*;
import org.example.service.BookService;
import org.example.service.FilmService;
import org.example.service.LetterService;

import java.util.ArrayList;
import java.util.List;

public class LibraryController {

    private final BookService bookService;
    private final FilmService filmService;
    private final LetterService letterService;

    public LibraryController(BookService bookService, FilmService filmService, LetterService letterService) {
        this.bookService = bookService;
        this.filmService = filmService;
        this.letterService = letterService;
    }

    private Author createAuthor(String authorFirstName, String authorLastName){
        return new Author(authorFirstName, authorLastName);
    }

    public Book addBook(String bookName, String authorFirstName, String authorLastName) throws RuntimeException{
        Author author = createAuthor(authorFirstName, authorLastName);
        Book book = new Book(bookName, author);
        return bookService.addEntity(book);
    }
    public Book deleteBookById(long bookId){
        return bookService.deleteEntityById(bookId);
    }
    public Book getBookById(long bookId){
        return bookService.getById(bookId);
    }
    public List<Book> getAllBooks(){
        return bookService.getEntityList();
    }
    public List<Book> getBooksByAuthor(String authorFirstName, String authorLastName){
        Author author = bookService.getAuthor(authorFirstName, authorLastName);
        return bookService.getByAuthor(author);
    }
    public Letter addLetter(String letterName, String authorFirstName, String authorLastName) throws RuntimeException{
        Author author = createAuthor(authorFirstName, authorLastName);
        Letter letter = new Letter(letterName, author);
        return letterService.addEntity(letter);
    }
    public Letter deleteLetterById(long letterId){
        return letterService.deleteEntityById(letterId);
    }
    public Letter getLetterById(long letterId){
        return letterService.getById(letterId);
    }
    public List<Letter> getAllLetters(){
        return letterService.getEntityList();
    }
    public List<Letter> getLettersByAuthor(String authorFirstName, String authorLastName){
        Author author = letterService.getAuthor(authorFirstName, authorLastName);
        return letterService.getByAuthor(author);
    }
    public Film addFilm(String filmName, double durationTime, String authorFirstName, String authorLastName) throws RuntimeException{
        Author author = createAuthor(authorFirstName, authorLastName);
        Film film = new Film(filmName, author, durationTime);
        return filmService.addEntity(film);
    }
    public Film deleteFilmById(long filmId){
        return filmService.deleteEntityById(filmId);
    }
    public Film getFilmById(long filmId){
        return filmService.getById(filmId);
    }
    public List<Film> getAllFilms(){
        return filmService.getEntityList();
    }
    public List<Film> getFilmsByAuthor(String authorFirstName, String authorLastName){
        Author author = filmService.getAuthor(authorFirstName, authorLastName);
        return filmService.getByAuthor(author);
    }
    public List<Entity> getAllEntities(){
        List<Entity> entities = new ArrayList<>();
        entities.addAll(getAllBooks());
        entities.addAll(getAllLetters());
        entities.addAll(getAllFilms());
        return entities;
    }
    public List<Author> getAllAuthors(){
        return bookService.getAuthorList();
    }
}
