package com.example.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.commons.json.JacksonObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JacksonConfigurer {

    @Bean
    ObjectMapper objectMapper() {
        return JacksonObjectMapperFactory.create();
    }
}
