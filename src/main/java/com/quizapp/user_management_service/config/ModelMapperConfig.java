package com.quizapp.user_management_service.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    private static final Logger logger = LoggerFactory.getLogger(ModelMapperConfig.class);

    @Bean
    public ModelMapper modelMapper() {
        logger.info("Initializing ModelMapper bean");
        ModelMapper modelMapper = new ModelMapper();
        
        // Customize ModelMapper to use strict matching strategies
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        logger.info("ModelMapper configured with STRICT matching strategy");
        
        // Add custom mappings if needed
        // modelMapper.typeMap(SourceClass.class, DestinationClass.class)
        //     .addMappings(mapper -> mapper.map(SourceClass::getSourceField, DestinationClass::setDestinationField));

        return modelMapper;
    }
}
