// LoginRequestDTO.java
package com.quizapp.user_management_service.dto.request;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String email;
    private String password;
}

