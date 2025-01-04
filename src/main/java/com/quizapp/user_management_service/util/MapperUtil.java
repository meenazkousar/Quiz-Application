package com.quizapp.user_management_service.util;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapperUtil {

    private static final Logger logger = LoggerFactory.getLogger(MapperUtil.class);
    private final ModelMapper modelMapper = new ModelMapper();

    public <D, T> D map(T source, Class<D> destinationType) {
        logger.info("Mapping object from {} to {}", source.getClass().getName(), destinationType.getName());
        return modelMapper.map(source, destinationType);
    }

    public ModelMapper getMapper() {
        logger.info("Returning ModelMapper instance");
        return modelMapper;
    }
}
