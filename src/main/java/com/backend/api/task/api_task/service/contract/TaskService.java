package com.backend.api.task.api_task.service.contract;

import java.util.List;

import com.backend.api.task.api_task.dto.taskdto.TaskRequestDTO;
import com.backend.api.task.api_task.dto.taskdto.TaskResponseDTO;

public interface TaskService {

    public TaskResponseDTO findbyid(Long id);
    public List<TaskResponseDTO> findAll(Long id);
    public void isCompleted(Long id);
    public TaskResponseDTO save(TaskRequestDTO taskRequestDTO);
} 
