package com.backend.api.task.api_task.repository;

import org.springframework.data.repository.CrudRepository;

import com.backend.api.task.api_task.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
    
}
