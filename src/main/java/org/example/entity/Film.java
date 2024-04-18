package org.example.entity;

public class Film extends Entity{

    private final double durationTime;

    public Film(String name, Author author, double durationTime) {
        super(name, author);
        this.durationTime = durationTime;

    }

    @Override
    public String toString() {
        return "Film={id=" + super.id + " " + super.getName() + " " + super.getAuthor() + " " +
                "durationTime=" + durationTime + "}";

    }

}
