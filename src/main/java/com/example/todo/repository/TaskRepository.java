package com.example.todo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TaskRepository {

    @Select("SELECT * FROM tasks")
    List<TaskRecord> select();

    @Insert("INSERT INTO tasks (title, is_completed) VALUES (#{task.title}, #{task.isCompleted})")
    void insert(@Param("task") TaskRecord taskRecord);
}
