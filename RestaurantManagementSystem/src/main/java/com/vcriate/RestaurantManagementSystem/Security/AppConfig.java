package com.vcriate.RestaurantManagementSystem.Security;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class AppConfig {
	
	@Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.sessionManagement(se -> se.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .cors(cors -> cors.configurationSource(new org.springframework.web.cors.CorsConfigurationSource() {
                @Override
                public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                    CorsConfiguration configuration = new CorsConfiguration();
                    configuration.setAllowedOriginPatterns(Collections.singletonList("*"));
                    configuration.setAllowedMethods(Collections.singletonList("*"));
                    configuration.setAllowCredentials(true);
                    configuration.setAllowedHeaders(Collections.singletonList("*"));
                    configuration.setExposedHeaders(Arrays.asList("Authorization"));
                    return configuration;
                }
            }))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.POST, "/admin/register").permitAll()
                .requestMatchers("/swagger-ui*/**", "/v3/api-docs/**").permitAll()
                .requestMatchers("/api/menu-items/**").hasAnyRole("ADMIN", "STAFF")
                .requestMatchers("/api/orders/**").hasAnyRole("ADMIN", "STAFF", "CUSTOMER")
                .requestMatchers("/api/reservations/**").hasAnyRole("ADMIN", "CUSTOMER")
                .requestMatchers("/api/customers/**").hasRole("ADMIN")
                .requestMatchers("/api/staff/**").hasRole("ADMIN")
                .anyRequest().authenticated())
            .csrf(csrf -> csrf.disable())
            .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint())
            .and()
            .oauth2Login(oauth2 -> oauth2.userInfoEndpoint().userService(customOAuth2UserService))
            .addFilterAfter(jwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
            //.addFilterBefore(jwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationStartPoint jwtAuthenticationEntryPoint() {
        return new JwtAuthenticationStartPoint();
    }

    @Bean
    public JwtTokenGeneratorFilter jwtTokenGeneratorFilter() {
        return new JwtTokenGeneratorFilter();
    }

    @Bean
    public JwtTokenValidatorFilter jwtTokenValidatorFilter() {
        return new JwtTokenValidatorFilter();
    }
}
