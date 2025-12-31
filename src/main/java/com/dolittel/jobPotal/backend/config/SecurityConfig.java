package com.dolittel.jobPotal.backend.config; // Check if your package name is correct (jobPotal vs jobPortal)

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer; // 👈 CRITICAL IMPORT
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. Disable CSRF
            .csrf(csrf -> csrf.disable())
            
            // 2. Define Rules
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/jobs/**").permitAll()
                .requestMatchers("/api/applications/**").permitAll()
                .anyRequest().authenticated()
            )
            
            // 3. Enable OAuth2 Token Validation
            // ✅ FIX: Use Customizer.withDefaults() instead of empty brackets
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));

        return http.build();
    }
}