package com.example.todo.controller;

public record TaskForm(
        String title,
        boolean isCompleted
) {
}
