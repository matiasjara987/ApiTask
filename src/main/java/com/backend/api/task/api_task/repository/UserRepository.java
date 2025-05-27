package com.backend.api.task.api_task.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.backend.api.task.api_task.model.User;
import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Long>{
    
@Query("SELECT u FROM User u WHERE u.email = :email")
    public Optional<User> findByEmail(@Param("email")String email);
    
}
