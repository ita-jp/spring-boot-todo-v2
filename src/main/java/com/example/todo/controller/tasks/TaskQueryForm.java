package com.example.todo.controller.tasks;

import com.example.todo.service.tasks.TaskQueryEntity;
import com.example.todo.service.tasks.TaskStatus;

import java.util.List;
import java.util.Optional;

public record TaskQueryForm(
        String summary,
        List<String> status
) {
    public TaskQueryEntity toEntity() {
        var statusEntityList = Optional.ofNullable(status)
                .map(s -> s.stream().map(TaskStatus::valueOf).toList())
                .orElse(List.of());
        return new TaskQueryEntity(summary, statusEntityList);
    }
}
