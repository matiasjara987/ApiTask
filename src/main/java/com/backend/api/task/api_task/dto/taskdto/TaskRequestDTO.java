package com.backend.api.task.api_task.dto.taskdto;

import lombok.*;

@Getter @Setter
public class TaskRequestDTO {
    private String title;
    private String description;
    private boolean isCompleted;
}
