package ru.hse.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import ru.hse.entity.ToDoEntity;

public interface ToDoRepository extends CrudRepository<ToDoEntity, Integer> {
    @Query("INSERT INTO to_do_entity (title, content) VALUES(:header, :content) RETURNING to_do_entity.id")
    int insert(String header, String content);
}
