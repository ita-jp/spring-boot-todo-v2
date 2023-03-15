package com.example.todo.controller;

import com.example.todo.service.TaskEntity;

import java.util.List;

public record TaskDTO(
        long id,
        String summary,
        String description,
        String status
) {
    public static List<TaskDTO> toDTO(List<TaskEntity> entityList) {
        return entityList.stream()
                .map(TaskDTO::toDTO)
                .toList();
    }

    public static TaskDTO toDTO(TaskEntity entity) {
        return new TaskDTO(
                entity.id(),
                entity.summary(),
                entity.description(),
                entity.status().name()
        );
    }
}
