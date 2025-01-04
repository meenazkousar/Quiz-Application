package com.quizapp.user_management_service.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrations;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@Configuration
public class OAuth2Config {

    private static final Logger logger = LoggerFactory.getLogger(OAuth2Config.class);

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        logger.info("Configuring OAuth2 client registration repository");
        
        // Example configuration for Google OAuth2
        ClientRegistration googleRegistration = ClientRegistrations
                .fromIssuerLocation("https://accounts.google.com")
                .clientId("your-google-client-id") // Replace with your actual client ID
                .clientSecret("your-google-client-secret") // Replace with your actual client secret
                .build();
        
        // Add additional client registrations if needed
        return new InMemoryClientRegistrationRepository(googleRegistration);
    }
}
