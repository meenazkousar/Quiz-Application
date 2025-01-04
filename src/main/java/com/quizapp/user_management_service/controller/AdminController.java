package com.quizapp.user_management_service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizapp.user_management_service.AdminService;
import com.quizapp.user_management_service.dto.request.RoleRequestDTO;
import com.quizapp.user_management_service.dto.response.RoleResponseDTO;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/roles")
    public ResponseEntity<RoleResponseDTO> createRole(@RequestBody RoleRequestDTO roleRequestDTO) {
        return ResponseEntity.ok(adminService.createRole(roleRequestDTO));
    }
}
