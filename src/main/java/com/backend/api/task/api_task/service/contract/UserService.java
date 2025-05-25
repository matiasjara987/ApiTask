package com.backend.api.task.api_task.service.contract;

import java.util.Optional;

import com.backend.api.task.api_task.dto.userdto.*;

public interface UserService {
    
    public void createUser(UserRequestDTO userRequestDTO);
    public Optional<UserResponseDTO> findByEmail(String email);
    public UserResponseDTO findById(Long id);
    public UserResponseDTO updateUser(UserUpdateDTO userUpdateDTO);
    public void changePassword(UserChangePasswordDTO userChangePasswordDTO);
    public void deleteUser(Long id);
}
