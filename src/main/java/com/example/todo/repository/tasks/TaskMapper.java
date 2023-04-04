package com.example.todo.repository.tasks;

import com.example.todo.service.tasks.TaskEntity;
import com.example.todo.service.tasks.TaskStatus;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TaskMapper {
    @Select("""
    <script>
      SELECT id, summary, description, status
      FROM tasks
      <where>
        <if test='summary != null and !summary.isBlank()'>
          AND summary LIKE CONCAT('%', #{summary}, '%')
        </if>
        <if test='statusList != null and !statusList.isEmpty()'>
          AND status IN (
            <foreach item='item' index='index' collection='statusList' separator=','>
              #{item}
            </foreach>
          )
        </if>
      </where>
    </script>
    """)
    List<TaskEntity> select(@Param("summary") String summary, @Param("statusList") List<TaskStatus> status);

    @Insert("INSERT INTO tasks (summary, description, status) VALUES (#{task.summary}, #{task.description}, #{task.status})")
    void insert(@Param("task") TaskEntity taskEntity);

    @Select("SELECT id, summary, description, status FROM tasks WHERE id = #{id}")
    Optional<TaskEntity> selectById(@Param("id") long taskId);

    @Delete("DELETE FROM tasks WHERE id = #{id}")
    void deleteById(@Param("id") long taskId);

    @Update("UPDATE tasks SET summary = #{task.summary}, description = #{task.description}, status = #{task.status} WHERE id = #{task.id}")
    void update(@Param("task") TaskEntity taskEntity);
}
