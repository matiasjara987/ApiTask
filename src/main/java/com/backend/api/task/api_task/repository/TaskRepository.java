package com.backend.api.task.api_task.repository;

import org.springframework.data.repository.CrudRepository;

import com.backend.api.task.api_task.model.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{
    
}
