package com.example.todo.repository;

import com.example.todo.service.TaskEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TaskRepository {

    @Select("SELECT id, summary, description, status FROM tasks")
    List<TaskRecord> select();

    @Insert("INSERT INTO tasks (summary, description, status) VALUES (#{task.summary}, #{task.description}, #{task.status})")
    void insert(@Param("task") TaskEntity taskRecord);

    @Select("SELECT id, summary, description, status FROM tasks WHERE id = #{id}")
    Optional<TaskRecord> selectById(@Param("id") long id);

    @Delete("DELETE FROM tasks WHERE id = #{id}")
    void deleteById(@Param("id") long id);
}
