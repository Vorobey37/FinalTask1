package org.example.repositopy;

import org.example.entity.Author;
import org.example.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {

    private final List<Author> authors;

    public AuthorRepository() {
        authors = new ArrayList<>();

    }

    private void startAuthorList(){
//        authors.add(new Author("Лев", "Толстой"));
//        authors.add(new Author("Федор", "Достоевский"));
//        authors.add(new Author("Александр", "Пушкин"));
//        authors.add(new Author("Валерий", "Кузенков"));
//        authors.add(new Author("Виктор", "Цой"));
//        authors.add(new Author("Евгений", "Пригожин"));
//        authors.add(new Author("Александр", "Пушкин"));
//        authors.add(new Author("Александр", "Пушкин"));
//        authors.add(new Author("Александр", "Пушкин"));
//        authors.add(new Author("Александр", "Пушкин"));
//        authors.add(new Author("Александр", "Пушкин"));
//        authors.add(new Author("Александр", "Пушкин"));
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author author) throws RuntimeException{
        int count = 0;
        for (Author element : authors){
            if (element.getFirstName().equals(author.getFirstName()) && element.getLastName().equals(author.getLastName())){
                count++;
            }
        }
        if (count == 0){
            authors.add(author);
        } else {
            throw new RuntimeException("Такой автор уже существует!");
        }
    }
}
