package com.estagio.estudos.BlinksFoodAPI.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configBean {
    @Bean
    public ModelMapper modelMapper (){
        ModelMapper modelMappers = new ModelMapper();
        return modelMappers;
    }
}
