package com.vcriate.RestaurantManagementSystem.Security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import com.vcriate.RestaurantManagementSystem.Exception.UserException;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenValidatorFilter {
	
	 @Autowired
	    private UserDetailsServiceImpl userDetailsService;

	    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException, UserException {
	        String jwtToken = request.getHeader("Authorization");
	        String username = null;

	        if (jwtToken != null && jwtToken.startsWith("Bearer ")) {
	            jwtToken = jwtToken.substring(7);
	            try {
	                username = JwtTokenUtil.getUsernameFromToken(jwtToken);
	            } catch (IllegalArgumentException e) {
	            	System.out.println("Unable to get JWT Token");
	               
	            } catch (ExpiredJwtException e) {
	            	System.out.println("JWT Token has expired");
	                
	            }
	        } else {
	        	System.out.println("JWT Token does not begin with Bearer String");
	            
	        }

	        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

	            if (JwtTokenUtil.validateToken(jwtToken, userDetails)) {
	                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
	                        userDetails, null, userDetails.getAuthorities());
	                usernamePasswordAuthenticationToken
	                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	            }
	        }

	        chain.doFilter(request, response);
	    }
}
