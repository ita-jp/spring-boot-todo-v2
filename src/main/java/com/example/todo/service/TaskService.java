package com.example.todo.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    public List<TaskEntity> findAll() {
        return List.of(
                new TaskEntity(1L,"Spring Boot を学ぶ", true),
                new TaskEntity(2L,"Spring Security を学ぶ", false),
                new TaskEntity(3L,"IntelliJ を学ぶ", false)
        );
    }
}
