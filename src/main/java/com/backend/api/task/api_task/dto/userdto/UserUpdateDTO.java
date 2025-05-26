package com.backend.api.task.api_task.dto.userdto;

import lombok.*;

@Getter @Setter
public class UserUpdateDTO {
    private Long id;
    private String name;
    private String email;
}
