package com.backend.api.task.api_task.dto.userdto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String userName;
    private String email;
    
}
