package com.co.leader.admin.infraestructure.security.authentication;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        System.out.println(response.getStatus());
        if(600 == response.getStatus()) {
            response.sendError(600, "User needs registration before consume API");
        }else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Unauthorized.");
        }

    }

}
