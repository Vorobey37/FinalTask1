package org.example;

import org.example.controller.LibraryController;
import org.example.repositopy.AuthorRepository;
import org.example.repositopy.BookRepository;
import org.example.repositopy.FilmRepository;
import org.example.repositopy.LetterRepository;
import org.example.service.BookService;
import org.example.service.FilmService;
import org.example.service.LetterService;

public class LibraryApp {
    public static void main(String[] args) {

        AuthorRepository authorRepository = new AuthorRepository();
        BookRepository bookRepository = new BookRepository();
        LetterRepository letterRepository = new LetterRepository();
        FilmRepository filmRepository = new FilmRepository();

        BookService bookService = new BookService(authorRepository, bookRepository);
        LetterService letterService = new LetterService(authorRepository, letterRepository);
        FilmService filmService = new FilmService(authorRepository, filmRepository);

        LibraryController libraryController = new LibraryController(bookService, filmService, letterService);

        try{
            libraryController.addBook("После бала", "Лев", "Толстой");
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        System.out.println(libraryController.getAllEntities());
        System.out.println(libraryController.getAllAuthors());
        System.out.println(libraryController.getBooksByAuthor("Лев", "Толстой"));

    }

}