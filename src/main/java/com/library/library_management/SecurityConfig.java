package com.library.library_management;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// thing here is often done with builder , also no fixed syntex as you can see

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // خوارزمية تشفير
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user1 = User.withUsername("user")
                .password(passwordEncoder.encode("password")) // تشفير كلمة المرور
                .roles("USER")
                .build();

        UserDetails user2 = User.withUsername("user2")
                .password(passwordEncoder.encode("password2")) // تشفير كلمة المرور
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("adminpassword")) // تشفير كلمة المرور
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1,user2,admin); // add all the users

        // if we want them from database we retrive them here too using query and database connection
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests() //{this is for authorize , means that he must know who is sign in and what is his previliges}
                .requestMatchers("/api/admin/**").hasRole("ADMIN") // these apis just for admins
                .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN") //these apis for users or admins
                .anyRequest()/*any other request*/.authenticated() /*{this is for authenticate , means that he just know who is sign in , no need to know what is his previliges}*/ /*if permitAll then the request is allowed without sign-in*/
                .and()
            .httpBasic(); //basic auth

        return http.build();
    }
}
