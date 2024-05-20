package ru.hse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.hse.api.ToDoController;
import ru.hse.api.ToDoService;
import ru.hse.entity.ToDoEntity;

import java.util.Map;

@RestController("todo")
public class ToDoControllerImpl implements ToDoController {

    private final ToDoService toDoService;

    public ToDoControllerImpl(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @Override
    @PostMapping("add")
    public ToDoEntity add(@RequestBody Map<String, String> body) {
        try {
            return toDoService.add(body.get("title"), body.get("content"));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    @DeleteMapping("remove")
    public void remove(@RequestParam int id) {
        toDoService.remove(id);
    }

    @Override
    @GetMapping("view")
    public Iterable<ToDoEntity> view() {
        return toDoService.view();
    }
}
