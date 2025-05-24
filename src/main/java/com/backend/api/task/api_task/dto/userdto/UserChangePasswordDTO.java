package com.backend.api.task.api_task.dto.userdto;

import lombok.*;

@Getter @Setter
public class UserChangePasswordDTO {
    
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
}
