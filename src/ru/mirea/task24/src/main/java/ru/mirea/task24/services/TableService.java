package ru.mirea.task24.services;

import java.util.List;

public interface TableService<T> {
    void createEntity(T t);

    List<T> readAllEntity();

    boolean deleteAllEntity();

}
