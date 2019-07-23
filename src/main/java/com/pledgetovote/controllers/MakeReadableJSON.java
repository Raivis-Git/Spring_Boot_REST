package com.pledgetovote.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class MakeReadableJSON extends WebMvcConfigurationSupport {
    @Override
    protected  void extendMessageConverters(List<HttpMessageConverter<?>> converters){
        for ( HttpMessageConverter<?> converter : converters){
            if(converter instanceof MappingJackson2CborHttpMessageConverter){
                MappingJackson2CborHttpMessageConverter jacksonConverter = (MappingJackson2CborHttpMessageConverter)converter;
                jacksonConverter.setPrettyPrint((true));
            }
        }
    }
}
