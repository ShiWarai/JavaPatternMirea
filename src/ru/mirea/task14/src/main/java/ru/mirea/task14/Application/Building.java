package ru.mirea.task14.Application;

public class Building {
    private String creationDate, type;

    public Building(String creationDate, String type) {
        this.creationDate = creationDate;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Building{" +
                "creationDate='" + creationDate + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
