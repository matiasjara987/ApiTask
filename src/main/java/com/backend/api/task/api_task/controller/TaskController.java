package com.backend.api.task.api_task.controller;

import org.springframework.web.bind.annotation.*;

import com.backend.api.task.api_task.dto.taskdto.TaskResponseDTO;
import com.backend.api.task.api_task.service.contract.TaskService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/tasks")
@RequiredArgsConstructor
public class TaskController {
    
    private TaskService taskService;

    @GetMapping("/{id}")
    public TaskResponseDTO getTaskById(@PathVariable Long id){
        return taskService.findbyid(id);
    }

}
