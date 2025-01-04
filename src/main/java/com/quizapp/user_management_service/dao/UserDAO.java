// DAO Layer

// UserDAO.java
package com.quizapp.user_management_service.dao;

import java.util.Optional;

import com.quizapp.user_management_service.entity.UserEntity;

public interface UserDAO {
    Optional<UserEntity> findUserByEmail(String email);
    UserEntity saveUser(UserEntity user);
}

