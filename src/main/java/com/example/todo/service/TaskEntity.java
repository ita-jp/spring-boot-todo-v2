package com.example.todo.service;

public record TaskEntity(
        long id,
        String title,
        boolean isCompleted
) {
}
