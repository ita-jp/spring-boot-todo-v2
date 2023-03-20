package com.example.todo.repository.tasks;

import com.example.todo.service.tasks.TaskEntity;
import com.example.todo.service.tasks.TaskQueryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TaskRepository {

    private final TaskMapper taskMapper;

public List<TaskEntity> select(TaskQueryEntity query) {
        return TaskRecord.toEntity(taskMapper.select(query.summary(), query.status()));
    }

    public void insert(TaskEntity taskEntity) {
        taskMapper.insert(taskEntity);
    }

    public Optional<TaskEntity> selectById(long taskId) {
        return taskMapper.selectById(taskId).map(TaskRecord::toEntity);
    }

    public void deleteById(long taskId) {
        taskMapper.deleteById(taskId);
    }

    public void update(TaskEntity taskEntity) {
        taskMapper.update(taskEntity);
    }
}
