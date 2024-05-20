package ru.hse.api;

import org.springframework.web.bind.annotation.RequestBody;
import ru.hse.entity.ToDoEntity;

import java.util.Map;

public interface ToDoController {

    ToDoEntity add(@RequestBody Map<String, String> body);

    void remove(int id);

    Iterable<ToDoEntity> view();
}
