package com.quizapp.user_management_service.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizapp.user_management_service.dao.UserDAO;
import com.quizapp.user_management_service.dto.request.UserRequestDTO;
import com.quizapp.user_management_service.dto.response.UserResponseDTO;
import com.quizapp.user_management_service.entity.UserEntity;
import com.quizapp.user_management_service.exception.UserNotFoundException;
import com.quizapp.user_management_service.service.UserService;
import com.quizapp.user_management_service.util.MapperUtil;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private MapperUtil mapperUtil;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        UserEntity userEntity = mapperUtil.convertToEntity(userRequestDTO, UserEntity.class);
        UserEntity savedUser = userDAO.save(userEntity);
        return mapperUtil.convertToDTO(savedUser, UserResponseDTO.class);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userDAO.findAll().stream()
                .map(user -> mapperUtil.convertToDTO(user, UserResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        UserEntity userEntity = userDAO.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        return mapperUtil.convertToDTO(userEntity, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        UserEntity existingUser = userDAO.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        mapperUtil.updateEntity(userRequestDTO, existingUser);
        UserEntity updatedUser = userDAO.save(existingUser);
        return mapperUtil.convertToDTO(updatedUser, UserResponseDTO.class);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userDAO.existsById(id)) {
            throw new UserNotFoundException("User not found");
        }
        userDAO.deleteById(id);
    }
}
