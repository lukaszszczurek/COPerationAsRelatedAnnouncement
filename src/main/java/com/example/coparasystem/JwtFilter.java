package com.example.coparasystem;

import jakarta.servlet.*;

import java.io.IOException;

public class JwtFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter is working");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
