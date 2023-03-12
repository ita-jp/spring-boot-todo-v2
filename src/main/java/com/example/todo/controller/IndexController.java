package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index(Model model) {
        var taskList = List.of(
                new TaskDTO(1L,"Spring Boot を学ぶ", true),
                new TaskDTO(2L,"Spring Security を学ぶ", false),
                new TaskDTO(3L,"IntelliJ を学ぶ", false)
        );
        model.addAttribute("taskList", taskList);
        return "index";
    }
}
