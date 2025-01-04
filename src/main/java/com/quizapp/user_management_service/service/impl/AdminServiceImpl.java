package com.quizapp.user_management_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizapp.user_management_service.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
    private RoleDAO roleDAO;

    @Autowired
    private MapperUtil mapperUtil;

    @Override
    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO) {
        RoleEntity roleEntity = mapperUtil.convertToEntity(roleRequestDTO, RoleEntity.class);
        RoleEntity savedRole = roleDAO.save(roleEntity);
        return mapperUtil.convertToDTO(savedRole, RoleResponseDTO.class);
    }
}

