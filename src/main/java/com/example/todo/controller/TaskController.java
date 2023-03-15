package com.example.todo.controller;

import com.example.todo.service.TaskEntity;
import com.example.todo.service.TaskService;
import com.example.todo.service.TaskStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute TaskForm form) {
        return "tasks/creationForm";
    }

    @PostMapping
    public String create(@Validated TaskForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return showCreationForm(form);
        }
        taskService.create(new TaskEntity(null, form.summary(), form.description(), TaskStatus.valueOf(form.status())));
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String showDetail(@PathVariable Long id, Model model) {
        var taskOpt = taskService.findById(id).map(TaskDTO::toDTO);
        if (taskOpt.isEmpty()) {
            return "redirect:/";
        }
        model.addAttribute("task", taskOpt.get());
        return "tasks/detail";
    }
}
