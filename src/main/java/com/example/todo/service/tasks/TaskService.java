package com.example.todo.service.tasks;

import com.example.todo.repository.tasks.TaskRepository;
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
        return taskRepository.select();
    }

    @Transactional
    public void create(TaskEntity task) {
        taskRepository.insert(task);
    }

    public Optional<TaskEntity> findById(Long id) {
        return taskRepository.selectById(id);
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
