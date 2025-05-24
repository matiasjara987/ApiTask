package com.backend.api.task.api_task.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "tasks")
@Getter @Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean isCompleted;

    @ManyToOne
    @JoinColumn(name= "user_id", nullable = false)
    private User user;
}
