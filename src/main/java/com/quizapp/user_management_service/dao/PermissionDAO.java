// PermissionDAO.java
package com.quizapp.user_management_service.dao;

import com.quizapp.user_management_service.entity.PermissionEntity;

public interface PermissionDAO {
    PermissionEntity savePermission(PermissionEntity permission);
}