package com.example.coparasystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class COPARAsystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(COPARAsystemApplication.class, args);
    }


//    @Bean
//    // create filter registration bean
//    public FilterRegistrationBean<JwtFilter> filterRegistrationBean(){
//        FilterRegistrationBean<JwtFilter> filterRegistrationBean = new FilterRegistrationBean<>();
//        filterRegistrationBean.setFilter(new JwtFilter());
//        filterRegistrationBean.addUrlPatterns("/login/*");
//        return filterRegistrationBean;
//    }
}
