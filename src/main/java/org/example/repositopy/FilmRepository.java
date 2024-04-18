package org.example.repositopy;

import org.example.entity.Author;
import org.example.entity.Film;

import java.util.ArrayList;
import java.util.List;

public class FilmRepository implements Repository<Film>{

    private final List<Film> films;

    public FilmRepository() {
        films = new ArrayList<>();
    }

    @Override
    public List<Film> getEntityList() {
        return films;
    }

    @Override
    public Film addEntity(Film entity) {
        films.add(entity);
        return entity;
    }

    @Override
    public Film deleteEntityById(long id) {
        Film film = getById(id);
        if (film != null){
            films.remove(film);
        }
        return film;
    }

    @Override
    public Film getById(long id) {
        return films.stream()
                .filter(film -> film.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Film> getByAuthor(Author author) {
        return films.stream()
                .filter(film -> film.getAuthor().getFirstName().equals(author.getFirstName()) && film.getAuthor().getLastName().equals(author.getLastName()))
                .toList();
    }
}
