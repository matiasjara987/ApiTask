package com.backend.api.task.api_task.service.impl;


import java.util.Optional;

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
    private final UserRepository userRepository;
    

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository ) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    
    }

    @Override
    public UserResponseDTO findByEmail(String email) {
        User userFindbyEmail = userRepository.findByEmail(email)
        .orElseThrow(() -> new ResourceNotFoundException("User", "email", email));
        return modelMapper.map(userFindbyEmail, UserResponseDTO.class);
       
    }

    @Override
    public UserResponseDTO findById(Long id) {
         User user = userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> deleteOptionalUser = userRepository.findById(id);
        if (deleteOptionalUser.isPresent()) {
            User deleteUser = deleteOptionalUser.get();
            deleteUser.setActive(false);
        } 
        throw new ResourceNotFoundException("User", "id", id);
    }

    @Override
    public UserResponseDTO save(User user) {
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponseDTO.class);
    }   
}
