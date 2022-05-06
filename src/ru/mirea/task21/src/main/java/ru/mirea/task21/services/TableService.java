package ru.mirea.task21.services;

import java.util.List;

public interface TableService<T> {
    void createEntity(T t);

    List<T> readAllEntity();

    boolean deleteAllEntity();

}
