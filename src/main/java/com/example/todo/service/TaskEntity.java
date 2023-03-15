package com.example.todo.service;

public record TaskEntity(
        Long id,
        String title,
        TaskStatus status
) {
}
