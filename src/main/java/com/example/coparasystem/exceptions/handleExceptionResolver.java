package com.example.coparasystem.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component("handlerExceptionResolver")
public class handleExceptionResolver implements org.springframework.web.servlet.HandlerExceptionResolver {

    handleExceptionResolver() {
        System.out.println("handleExceptionResolver constructor");
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        return null;
    }
}
