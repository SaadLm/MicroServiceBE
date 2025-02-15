package com.example.task_service.controllers;


import com.example.task_service.entities.Task;
import com.example.task_service.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/projet/{projetId}")
    public List<Task> getTasksByProjet(@PathVariable Long projetId) {
        return taskRepository.findByProjetId(projetId);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }
}
