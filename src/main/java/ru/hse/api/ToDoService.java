package ru.hse.api;

import ru.hse.entity.ToDoEntity;

public interface ToDoService {
    ToDoEntity add(String header, String content);

    void remove(int id);

    Iterable<ToDoEntity> view();
}
