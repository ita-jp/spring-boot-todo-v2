package com.example.todo.service.tasks;

import java.util.List;

public record TaskQueryEntity(
        String summary,
        List<TaskStatus> status
) {
}
