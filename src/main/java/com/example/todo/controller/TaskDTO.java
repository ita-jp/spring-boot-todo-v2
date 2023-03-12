package com.example.todo.controller;

public record TaskDTO(
        long id,
        String title,
        boolean isCompleted
) {}
