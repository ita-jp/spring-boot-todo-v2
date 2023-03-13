package com.example.todo.repository;

import com.example.todo.service.TaskEntity;

import java.util.List;

public record TaskRecord(
        long id,
        String title,
        boolean isCompleted) {

    public TaskEntity toEntity() {
        return new TaskEntity(
                id,
                title,
                isCompleted
        );
    }

    public static List<TaskEntity> toEntity(List<TaskRecord> recordList) {
        return recordList.stream()
                .map(TaskRecord::toEntity)
                .toList();
    }
}
