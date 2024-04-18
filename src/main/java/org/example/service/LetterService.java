package org.example.service;

import org.example.entity.Author;
import org.example.entity.Letter;
import org.example.repositopy.AuthorRepository;
import org.example.repositopy.LetterRepository;

import java.util.List;

public class LetterService implements Service<Letter>{

    private final AuthorRepository authorRepository;
    private final LetterRepository letterRepository;

    public LetterService(AuthorRepository authorRepository, LetterRepository letterRepository) {
        this.authorRepository = authorRepository;
        this.letterRepository = letterRepository;
        createStartLetterList();
    }

    private void createStartLetterList() throws RuntimeException{
        addEntity(new Letter("Записки охотника", new Author("Валерий", "Кузенков")));
        addEntity(new Letter("Записки музыканта", new Author("Виктор", "Цой")));
        addEntity(new Letter("Записки бойца", new Author("Евгений", "Пригожин")));
    }

    @Override
    public List<Letter> getEntityList() {
        return letterRepository.getEntityList();
    }

    @Override
    public Letter addEntity(Letter entity) throws RuntimeException{
        letterRepository.addEntity(entity);
        authorRepository.addAuthor(entity.getAuthor());
        return entity;
    }

    @Override
    public Letter deleteEntityById(long id) {
        return letterRepository.deleteEntityById(id);
    }

    @Override
    public Letter getById(long id) {
        return letterRepository.getById(id);
    }

    @Override
    public List<Letter> getByAuthor(Author author) {
        return letterRepository.getByAuthor(author);
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
