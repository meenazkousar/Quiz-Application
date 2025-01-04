package com.quizapp.user_management_service.service;



import com.quizapp.user_management_service.dto.request.LoginRequestDTO;
import com.quizapp.user_management_service.dto.response.LoginResponseDTO;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
}
