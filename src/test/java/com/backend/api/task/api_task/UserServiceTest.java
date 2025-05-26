package com.backend.api.task.api_task;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.backend.api.task.api_task.dto.userdto.UserResponseDTO;
import com.backend.api.task.api_task.exception.ResourceNotFoundException;
import com.backend.api.task.api_task.model.User;
import com.backend.api.task.api_task.repository.UserRepository;
import com.backend.api.task.api_task.service.impl.UserServiceImpl;
import com.backend.api.task.api_task.service.util.EntityFinder;

public class UserServiceTest {
   
   @Mock
   private UserRepository userRepository;

   @Mock
   private ModelMapper modelMapper;

   @Mock 
   private EntityFinder entityFinder;


   private UserServiceImpl userService;

   @BeforeEach
   public void setup(){
        MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl(modelMapper, userRepository, entityFinder);
   }
    
   @Test
   public void testFindbyId_Success(){
    Long USER_ID = 1L;
    String USERNAME_TEST = "matías".toUpperCase();
    User userTestFindById = new User();
    userTestFindById.setId(USER_ID);
    userTestFindById.setUserName(USERNAME_TEST);
    userTestFindById.setEmail("matias@prueba.com");

    UserResponseDTO userDTO = new UserResponseDTO(USER_ID, USERNAME_TEST, "matias@prueba.com");

    when(userRepository.findById(USER_ID)).thenReturn(Optional.of(userTestFindById));
   when(modelMapper.map(userTestFindById, UserResponseDTO.class)).thenReturn(userDTO);

   UserResponseDTO result = userService.findById(USER_ID);

   assertNotNull(result);
   assertEquals(USER_ID, result.getId());
   assertEquals(USERNAME_TEST, result.getUserName());
   assertEquals("matias@prueba.com", result.getEmail());

    verify(userRepository).findById(USER_ID);
    verify(modelMapper).map(userTestFindById, UserResponseDTO.class);
}


   
   @Test
   public void testFindbyId_NotFound(){
        Long userId = 2L;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            userService.findById(userId);
        });

        assertTrue(exception.getMessage().contains("User"));
        assertTrue(exception.getMessage().contains("id"));

        verify(userRepository).findById(userId);
        verifyNoInteractions(modelMapper);
   }
}
