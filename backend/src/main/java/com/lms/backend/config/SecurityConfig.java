package com.lms.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // ✅ هذا هو الشكل الحديث لتعطيل CSRF
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll() // اسمح للطلبات الخاصة بـ /api بدون توثيق
                .anyRequest().authenticated() // باقي الطلبات تحتاج مصادقة
            );
        return http.build();
    }
}
