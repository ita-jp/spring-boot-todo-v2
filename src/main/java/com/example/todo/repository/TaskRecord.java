package com.example.todo.repository;

import com.example.todo.service.TaskEntity;
import com.example.todo.service.TaskStatus;

import java.util.List;

public record TaskRecord(
        Long id,
        String title,
        String status
) {

    public TaskEntity toEntity() {
        return new TaskEntity(id, title, TaskStatus.valueOf(status));
    }

    public static List<TaskEntity> toEntity(List<TaskRecord> recordList) {
        return recordList.stream()
                .map(TaskRecord::toEntity)
                .toList();
    }
}
