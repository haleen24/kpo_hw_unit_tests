package ru.hse.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Data
public class ToDoEntity {
    public ToDoEntity(int id) {
        this.id = id;
    }

    public ToDoEntity(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Id
    private final int id;

    @Setter
    private String title;

    @Setter
    private String content;
}
