package com.example.todo.controller;

import com.example.todo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    private final TaskService taskService;

    public IndexController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String index(Model model) {
        var dtoList = TaskDTO.toDTO(taskService.findAll());
        model.addAttribute("taskList", dtoList);
        return "index";
    }
}
