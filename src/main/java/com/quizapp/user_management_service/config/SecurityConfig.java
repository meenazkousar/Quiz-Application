package com.quizapp.user_management_service.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class SecurityConfig extends ResourceServerConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Override
    public void configure(HttpSecurity http) throws Exception {
        logger.info("Configuring security settings");
        http
            .authorizeRequests()
                .antMatchers("/api/public/**").permitAll() // Open access to public APIs
                .antMatchers("/api/admin/**").hasRole("ADMIN") // Restrict admin APIs to users with ADMIN role
                .antMatchers("/api/user/**").hasAnyRole("USER", "ADMIN") // Restrict user APIs to USER and ADMIN roles
                .anyRequest().authenticated() // All other endpoints require authentication
            .and()
            .csrf().disable(); // CSRF protection disabled for simplicity (ensure to enable it in production for security)
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        logger.info("Initializing PasswordEncoder bean");
        return new BCryptPasswordEncoder();
    }
}
