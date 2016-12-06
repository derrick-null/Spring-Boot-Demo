package com.derrick.util;

import com.derrick.controller.HelloWorld;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


import java.util.Arrays;
import java.util.List;

/**
 * Created by Dre on 2016/12/1.
 */
@SpringBootApplication
public class WebConfig extends WebMvcConfigurationSupport {

    @Bean
    public Jaxb2RootElementHttpMessageConverter customXML2HttpMessageConverter() {
        Jaxb2RootElementHttpMessageConverter xmlConverter = new Jaxb2RootElementHttpMessageConverter();
        xmlConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_XML));
        return xmlConverter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(customXML2HttpMessageConverter());
        super.addDefaultHttpMessageConverters(converters);
    }

    public static void main(String[] args) throws Exception {
        org.springframework.boot.SpringApplication.run(HelloWorld.class, args);
    }
}
