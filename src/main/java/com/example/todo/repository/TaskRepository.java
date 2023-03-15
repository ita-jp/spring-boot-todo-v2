package com.example.todo.repository;

import com.example.todo.service.TaskEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TaskRepository {

    @Select("SELECT * FROM tasks")
    List<TaskRecord> select();

    @Insert("INSERT INTO tasks (title, status) VALUES (#{task.title}, #{task.status})")
    void insert(@Param("task") TaskEntity taskRecord);
}
