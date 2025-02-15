package com.example.task_service.repositories;

import com.example.task_service.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProjetId(Long projetId);
    List<Task> findByUserId(Long userId);
}