package com.vcriate.RestaurantManagementSystem.Security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenGeneratorFilter extends UsernamePasswordAuthenticationFilter{
	
	@Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        String token = JwtTokenUtil.generateToken(authResult.getName());
        response.addHeader("Authorization", "Bearer " + token);
    }
	
}
