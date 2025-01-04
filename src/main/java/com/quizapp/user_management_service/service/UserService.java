package com.quizapp.user_management_service.service;

import java.util.List;

import com.quizapp.user_management_service.dto.request.UserRequestDTO;
import com.quizapp.user_management_service.dto.response.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(Long id);

    UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO);

    void deleteUser(Long id);
}