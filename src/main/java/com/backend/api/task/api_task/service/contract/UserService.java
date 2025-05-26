package com.backend.api.task.api_task.service.contract;




import com.backend.api.task.api_task.dto.userdto.*;
import com.backend.api.task.api_task.model.User;

public interface UserService {
    
    public UserResponseDTO findByEmail(String email);
    public UserResponseDTO findById(Long id);
    public void deleteUser(Long id);
    UserResponseDTO save(User user);
}
