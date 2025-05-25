package com.backend.api.task.api_task.service.impl;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.backend.api.task.api_task.dto.userdto.*;
import com.backend.api.task.api_task.exception.ResourceNotFoundException;
import com.backend.api.task.api_task.model.User;
import com.backend.api.task.api_task.repository.UserRepository;
import com.backend.api.task.api_task.service.contract.UserService;

@Service
public class UserServiceImpl implements UserService{

    private final ModelMapper modelMapper;
    private UserRepository userRepository;

    UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserRequestDTO userRequestDTO) {
        
    }

    @Override
    public UserResponseDTO findByEmail(String email) {
        User userFindbyEnail = userRepository.findByEmail(email)
            .orElseThrow(() -> new ResourceNotFoundException("User", "email", email));
       return modelMapper.map(userFindbyEnail, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO findById(Long id) {
         User user = userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    
        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO updateUser(UserUpdateDTO userUpdateDTO) {
        return null;
    }

    @Override
    public void changePassword(UserChangePasswordDTO userChangePasswordDTO) {
    
    }

    @Override
    public void deleteUser(Long id) {
    }
    
}
