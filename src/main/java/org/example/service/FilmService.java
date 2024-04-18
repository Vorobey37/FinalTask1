package org.example.service;

import org.example.entity.Author;

import org.example.entity.Film;
import org.example.repositopy.AuthorRepository;
import org.example.repositopy.FilmRepository;

import java.util.List;

public class FilmService implements Service<Film>{

    private final AuthorRepository authorRepository;
    private final FilmRepository filmRepository;

    public FilmService(AuthorRepository authorRepository, FilmRepository filmRepository) {
        this.authorRepository = authorRepository;
        this.filmRepository = filmRepository;
        createStartFilmList();
    }

    private void createStartFilmList() throws RuntimeException{
        addEntity(new Film("Аритмия",  new Author("Борис", "Хлебников"), 116));
        addEntity(new Film("Ледокол", new Author("Николай", "Хомерики"), 120));
        addEntity(new Film("Воздух", new Author("Алексей", "Герман"), 159));
    }
    @Override
    public List<Film> getEntityList() {
        return filmRepository.getEntityList();
    }

    @Override
    public Film addEntity(Film entity) throws RuntimeException{
        filmRepository.addEntity(entity);
        authorRepository.addAuthor(entity.getAuthor());
        return entity;
    }

    @Override
    public Film deleteEntityById(long id) {
        return filmRepository.deleteEntityById(id);
    }

    @Override
    public Film getById(long id) {
        return filmRepository.getById(id);
    }

    @Override
    public List<Film> getByAuthor(Author author) {
        return filmRepository.getByAuthor(author);
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
