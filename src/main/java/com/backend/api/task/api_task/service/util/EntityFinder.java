package com.backend.api.task.api_task.service.util;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.backend.api.task.api_task.exception.ResourceNotFoundException;

@Component
public class EntityFinder {
    
    public <T, ID> T findByIdOrThrow(JpaRepository<T, ID> repository, ID id, String entityName) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(entityName, "id", id));
    }

    public <T> T findByFieldOrThrow(Optional<T> optional, String entityName, String field, Object value) {
        return optional.orElseThrow(() -> new ResourceNotFoundException(entityName, field, value));
    }
}
