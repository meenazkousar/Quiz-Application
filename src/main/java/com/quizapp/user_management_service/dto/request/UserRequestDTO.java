// DTO Layer

// Request DTOs

// UserRequestDTO.java
package com.quizapp.user_management_service.dto.request;

import lombok.Data;

@Data
public class UserRequestDTO {
    private String email;
    private String password;
}

