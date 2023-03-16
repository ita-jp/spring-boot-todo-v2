package com.example.todo.service;

import com.example.todo.repository.TaskRecord;
import com.example.todo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public Optional<TaskEntity> findById(Long id) {
        return taskRepository.selectById(id).map(TaskRecord::toEntity);
    }

    public void delete(long id) {
        taskRepository.deleteById(id);
    }

    @Transactional
    public void update(TaskEntity entity) {
        findById(entity.id()).orElseThrow(() -> new IllegalArgumentException("Task not found"));
        taskRepository.update(entity);
    }
}
