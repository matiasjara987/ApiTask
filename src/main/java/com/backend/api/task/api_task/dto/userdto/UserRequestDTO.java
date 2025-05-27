package com.backend.api.task.api_task.dto.userdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
@AllArgsConstructor
public class UserRequestDTO {
 private String userName;
 private String email; 
 private String password; 
 private Long creationTime;
 private boolean isActive; 
}
