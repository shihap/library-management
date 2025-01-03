package com.library.library_management;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // Define the class as a configuration for Spring
public class SecurityConfig {

    private final JwtFilter jwtFilter; // Inject the JwtFilter

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter; // Constructor injection for JwtFilter
    }

    @Bean // Define the Security Filter Chain bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // Disable CSRF for simplicity
            .authorizeRequests()
            .requestMatchers("/auth/login").permitAll()  // Explicitly allow access to /auth/login
            .anyRequest().authenticated()  // All other requests should be authenticated
            .and()
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class); // Add JwtFilter before UsernamePasswordAuthenticationFilter

        return http.build(); // Build the filter chain
    }
}
