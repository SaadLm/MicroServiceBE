package com.example.task_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Column(name = "projet_id")
    private Long projetId;

    private Long userId;

    private boolean completed = false;




    public void setId(Long id) {this.id = id;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProjetId(Long projetId) {
        this.projetId = projetId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }



    public Long getId() {return id;}
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getProjetId() {
        return projetId;
    }

    public Long getUserId() {
        return userId;
    }

    public boolean isCompleted() {
        return completed;
    }
}
