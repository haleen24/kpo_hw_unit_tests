package ru.hse.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.hse.api.ToDoService;

import ru.hse.entity.ToDoEntity;
import ru.hse.repository.ToDoRepository;


import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ToDoServiceTest {
    ToDoRepository toDoRepository;
    ToDoService toDoService;

    @BeforeEach
    void setUp() {
        toDoRepository = mock(ToDoRepository.class);
        toDoService = new ToDoServiceImpl(toDoRepository);
    }

    @Test
    public void addTwoTimes() {
        ToDoEntity expected1 = new ToDoEntity(0, "header", "content");
        ToDoEntity expected2 = new ToDoEntity(1, "second header", "second content");
        when(toDoRepository.insert("header", "content")).thenReturn(0);
        when(toDoRepository.insert("second header", "second content")).thenReturn(1);
        Assertions.assertEquals(expected1, toDoService.add("header", "content"));
        Assertions.assertEquals(expected2, toDoService.add("second header", "second content"));
        verify(toDoRepository, times(1)).insert("header", "content");
        verify(toDoRepository, times(1)).insert("second header", "second content");
        verify(toDoRepository, times(0)).insert("header", "second content");
    }

    @Test
    public void removeByIdSeveralTimes() {
        int maxId = 10;
        for (int i = 0; i < maxId; ++i) {
            toDoService.remove(i);
        }
        for (int i = 0; i < maxId; ++i) {
            verify(toDoRepository, times(1)).deleteById(i);
        }
    }

    @Test
    public void viewAll() {
        ToDoEntity first = new ToDoEntity(0, "1", "make coffee");
        ToDoEntity second = new ToDoEntity(0, "2", "have a cup of coffee");
        ToDoEntity third = new ToDoEntity(0, "3", "have a bath");
        Iterable<ToDoEntity> allEntities = new ArrayList<>() {
            {
                add(first);
                add(second);
                add(third);
            }
        };
        when(toDoRepository.findAll()).thenReturn(allEntities);
        Assertions.assertEquals(allEntities, toDoService.view());
        verify(toDoRepository, times(1)).findAll();
        verifyNoMoreInteractions(toDoRepository);
    }
}

