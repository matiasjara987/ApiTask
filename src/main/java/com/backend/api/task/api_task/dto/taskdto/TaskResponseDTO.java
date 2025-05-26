package com.backend.api.task.api_task.dto.taskdto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TaskResponseDTO {
 
    private String title;
    private String description;
    private boolean isCompleted;
}
