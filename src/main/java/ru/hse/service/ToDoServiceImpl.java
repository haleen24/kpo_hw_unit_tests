package ru.hse.service;

import org.springframework.stereotype.Component;
import ru.hse.entity.ToDoEntity;
import ru.hse.repository.ToDoRepository;

@Component
public class ToDoServiceImpl implements ru.hse.api.ToDoService {
    private final ToDoRepository toDoRepository;

    ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public ToDoEntity add(String header, String content) {
        int id = toDoRepository.insert(header, content);
        var entity = new ToDoEntity(id);
        entity.setContent(content);
        entity.setTitle(header);
        return entity;
    }

    @Override
    public void remove(int id) {
        toDoRepository.deleteById(id);
    }

    @Override
    public Iterable<ToDoEntity> view() {
        return toDoRepository.findAll();
    }
}
