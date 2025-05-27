package com.backend.api.task.api_task.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;


import com.backend.api.task.api_task.dto.taskdto.TaskRequestDTO;
import com.backend.api.task.api_task.dto.taskdto.TaskResponseDTO;
import com.backend.api.task.api_task.exception.ResourceNotFoundException;
import com.backend.api.task.api_task.model.Task;
import com.backend.api.task.api_task.model.User;
import com.backend.api.task.api_task.repository.TaskRepository;
import com.backend.api.task.api_task.repository.UserRepository;
import com.backend.api.task.api_task.service.contract.TaskService;

public class TaskServiceImpl implements TaskService {
    private ModelMapper modelMapper;
    private TaskRepository taskRepository;
    private UserRepository userRepository; 
    public TaskServiceImpl (TaskRepository taskRepository, ModelMapper modelMapper, UserRepository userRepository){
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }
    @Override
    public TaskResponseDTO findbyid(Long id) {
        Task task = taskRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Task", "id", id));
        
        return modelMapper.map(task, TaskResponseDTO.class);
    }

    @Override
    public List<TaskResponseDTO> findAll(Long id) {
        User userTask = userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        List<Task> taskList = userTask.getTaskList();
        return taskList.stream()
        .map(task -> modelMapper.map(task, TaskResponseDTO.class))
        .collect(Collectors.toList());
    }

    @Override
    public void isCompleted(Long id) {
        Task task= taskRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Task","id", id));
        if(!task.isCompleted()){
            task.setCompleted(true);
        taskRepository.save(task);
        }
        
    }

    @Override
    public TaskResponseDTO save(TaskRequestDTO taskRequestDTO) {
        Task taskToSave = modelMapper.map(taskRequestDTO, Task.class);
        Task savedTask = taskRepository.save(taskToSave);
        return modelMapper.map(savedTask, TaskResponseDTO.class);
    }

}
   

