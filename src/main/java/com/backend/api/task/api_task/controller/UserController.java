package com.backend.api.task.api_task.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.api.task.api_task.dto.userdto.UserRequestDTO;
import com.backend.api.task.api_task.dto.userdto.UserResponseDTO;
import com.backend.api.task.api_task.service.contract.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
 
    @GetMapping("/{id}")
    public UserResponseDTO GetUserId(@PathVariable Long id) {
        return userService.findById(id);
    } 
    @GetMapping()
    public UserResponseDTO GetUserEmail(@RequestParam String email){
        return userService.findByEmail(email);
    }
    @PostMapping()
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO UserRequestDTO) {
        UserResponseDTO response = userService.save(UserRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }    

}
