// RoleDAO.java
package com.quizapp.user_management_service.dao;

import com.quizapp.user_management_service.entity.RoleEntity;

public interface RoleDAO {
    RoleEntity findRoleByName(String name);
    RoleEntity saveRole(RoleEntity role);
}


