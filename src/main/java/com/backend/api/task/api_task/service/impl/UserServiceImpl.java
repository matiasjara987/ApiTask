package com.backend.api.task.api_task.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly = true)
    @Override
    public UserResponseDTO findByEmail(String email) {
        User userFindbyEmail = userRepository.findByEmail(email)
        .orElseThrow(() -> new ResourceNotFoundException("User", "email", email));
        return modelMapper.map(userFindbyEmail, UserResponseDTO.class);
       
    }
    @Transactional(readOnly = true)
    @Override
    public UserResponseDTO findById(Long id) {
         User user = userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return modelMapper.map(user, UserResponseDTO.class);
    }
    @Transactional
    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        user.setActive(false);
        userRepository.save(user); 
}
    @Transactional
    @Override
    public UserResponseDTO save(UserRequestDTO userRequestDTO) {
        User userRequestDto = modelMapper.map(userRequestDTO, User.class);
        User savedUser = userRepository.save(userRequestDto);
        return modelMapper.map(savedUser, UserResponseDTO.class);
    }   
}
