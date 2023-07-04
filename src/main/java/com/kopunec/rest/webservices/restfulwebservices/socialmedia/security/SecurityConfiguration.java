package com.kopunec.rest.webservices.restfulwebservices.socialmedia.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 1. All requests must be authenticated
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        // 2. If a request is unauthorized, send an authentication challenge
        http.httpBasic(Customizer.withDefaults());

        // 3. Disable CSRF
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
