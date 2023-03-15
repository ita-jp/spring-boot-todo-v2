package com.example.todo.service;

import com.example.todo.repository.TaskRecord;
import com.example.todo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<TaskEntity> findAll() {
        return TaskRecord.toEntity(taskRepository.select());
    }

    @Transactional
    public void create(TaskEntity task) {
        taskRepository.insert(task);
    }
}
