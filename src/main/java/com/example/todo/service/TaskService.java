package com.example.todo.service;

import com.example.todo.controller.TaskDTO;

import java.util.List;

public class TaskService {

    public List<TaskDTO> findAll() {
        return List.of(
                new TaskDTO(1L,"Spring Boot を学ぶ", true),
                new TaskDTO(2L,"Spring Security を学ぶ", false),
                new TaskDTO(3L,"IntelliJ を学ぶ", false)
        );
    }
}
