package org.example.entity;

public class Author {
    private static long createId;
    private final long id;
    private final String firstName;
    private final String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        createId++;
        id = createId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName + "'}";
    }
}
