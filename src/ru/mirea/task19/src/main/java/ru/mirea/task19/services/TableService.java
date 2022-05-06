package ru.mirea.task19.services;

import java.util.List;

public interface TableService<T> {
    void createEntity(T t);

    List<T> readAllEntity();

    boolean deleteAllEntity();

}
