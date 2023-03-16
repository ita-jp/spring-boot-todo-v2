package com.example.todo.controller.tasks;

import com.example.todo.service.tasks.TaskEntity;
import com.example.todo.service.tasks.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskForm(
        @NotBlank
        String summary,
        String description,
        @NotNull
        String status
) {
    public static TaskForm toForm(TaskEntity taskEntity) {
        return new TaskForm(
                taskEntity.summary(),
                taskEntity.description(),
                taskEntity.status().name()
        );
    }

    public TaskEntity toEntity(long id) {
        return new TaskEntity(id, summary, description, TaskStatus.valueOf(status));
    }
}
