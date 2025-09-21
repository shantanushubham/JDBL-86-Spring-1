package org.geeksforgeeks.jdbl86.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Will explain later or in next class
                // CSRF = Cross-Site Request Forgery
//                .csrf(AbstractHttpConfigurer::disable)
                // Which API calls require authentication are written here:
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/redis/**").permitAll()
                                .anyRequest()
                                .authenticated())
                // Then we write the method of logging in
                // 1. FormLogin -> The default login page that spring gives
                .formLogin(form -> form.permitAll())
                .logout(LogoutConfigurer::permitAll);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService users(PasswordEncoder passwordEncoder) {
        UserDetails userDetails = User.withUsername("friendUser")
                .password(passwordEncoder.encode("12345"))
                .roles("FRIEND")
                .build();

        UserDetails userDetails1 = User.withUsername("familyUser")
                .password(passwordEncoder.encode("12345"))
                .roles("FAMILY")
                .build();

        return new InMemoryUserDetailsManager(userDetails, userDetails1);
    }
}
