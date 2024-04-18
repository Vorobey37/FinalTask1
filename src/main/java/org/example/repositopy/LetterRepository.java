package org.example.repositopy;

import org.example.entity.Author;
import org.example.entity.Letter;

import java.util.ArrayList;
import java.util.List;

public class LetterRepository implements Repository<Letter>{

    private final List<Letter> letters;

    public LetterRepository() {
        letters = new ArrayList<>();

    }

    @Override
    public List<Letter> getEntityList() {
        return letters;
    }

    @Override
    public Letter addEntity(Letter entity) {
        letters.add(entity);
        return entity;
    }

    @Override
    public Letter deleteEntityById(long id) {
        Letter letter = getById(id);
        if (letter != null){
            letters.remove(letter);
        }
        return letter;
    }

    @Override
    public Letter getById(long id) {
        return letters.stream()
                .filter(letter -> letter.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Letter> getByAuthor(Author author) {
        return letters.stream()
                .filter(letter -> letter.getAuthor().getFirstName().equals(author.getFirstName()) && letter.getAuthor().getLastName().equals(author.getLastName()))
                .toList();
    }
}
