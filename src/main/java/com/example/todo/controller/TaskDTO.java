package com.example.todo.controller;

import com.example.todo.service.TaskEntity;

import java.util.List;

public record TaskDTO(
        long id,
        String title,
        boolean isCompleted
) {
    public static List<TaskDTO> toDTO(List<TaskEntity> entityList) {
        return entityList.stream()
                .map(TaskDTO::from)
                .toList();
    }

    public static TaskDTO from(TaskEntity entity) {
        return new TaskDTO(
                entity.id(),
                entity.title(),
                entity.isCompleted()
        );
    }
}
