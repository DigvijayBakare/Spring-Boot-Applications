package com.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(16);
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        encoders.put("bcrypt", new BCryptPasswordEncoder());

        // Create DelegatingPasswordEncoder with a default encoder
        return new DelegatingPasswordEncoder("bcrypt", encoders);
    }
    @Bean
    public UserDetailsService userDetails() {
        UserDetails normalUser = User.withUsername("user1")
                .password(passwordEncoder().encode("user1"))
                .roles("NORMAL")
                .build();

        UserDetails adminUser = User.withUsername("user2")
                .password(passwordEncoder().encode("user2"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(normalUser, adminUser);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
//                .requestMatchers("home/admin")
//                .hasRole("ADMIN")
//                .requestMatchers("home/normal")
//                .hasRole("NORMAL")
                .requestMatchers("home/public")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().formLogin();
        return httpSecurity.build();
    }
}
