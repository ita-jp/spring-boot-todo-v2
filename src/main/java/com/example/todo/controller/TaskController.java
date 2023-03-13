package com.example.todo.controller;

import com.example.todo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/creationForm")
    public String showCreationForm() {
        return "tasks/creationForm";
    }

    @PostMapping
    public String create(TaskForm form) {
        taskService.create(form.title(), form.isCompleted());
        return "redirect:/";
    }
}
