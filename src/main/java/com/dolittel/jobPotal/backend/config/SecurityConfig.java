package com.dolittel.jobPotal.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. Disable CSRF (Common for REST APIs)
            .csrf(csrf -> csrf.disable())

            // 2. define who can access what
            .authorizeHttpRequests(auth -> auth
                // Allow anyone to Register or Login
                .requestMatchers("/auth/**").permitAll()
                // Allow anyone to View Jobs (GET requests)
                .requestMatchers("/api/jobs/**").permitAll()
                // Lock everything else
                .anyRequest().authenticated()
            );

        return http.build();
    }

    // 3. Create a Password Encoder (Hashes passwords so they aren't plain text)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}