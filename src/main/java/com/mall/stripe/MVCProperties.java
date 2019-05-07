package com.mall.stripe;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-05-07 09:17
 **/
@Configuration
public class MVCProperties extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS");
    }

}

