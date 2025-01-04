package com.quizapp.user_management_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizapp.user_management_service.service.AuthService;
@Service
public class AuthServiceImpl implements AuthService {
	
	 @Autowired
	    private JWTUtil jwtUtil;

	    @Autowired
	    private PasswordUtil passwordUtil;

	    @Override
	    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
	        // Mock authentication logic (replace with actual logic)
	        if (!"admin".equals(loginRequestDTO.getUsername()) ||
	                !passwordUtil.verifyPassword(loginRequestDTO.getPassword(), "hashed_password")) {
	            throw new InvalidCredentialsException("Invalid username or password");
	        }
	        String token = jwtUtil.generateToken(loginRequestDTO.getUsername());
	        return new LoginResponseDTO(token);
	    }
	    
}
