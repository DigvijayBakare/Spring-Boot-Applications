package com.jwt.configuration;

import com.jwt.services.CustomUserDetailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class MySecurityConfiguration {
    @Autowired
    private CustomUserDetailServices userDetailServices;

    @Autowired
    private JwtAuthenticationFilter jwtFilter;

    // configuration methods
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       /* http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/token").permitAll() // Allow access to login page
                        .anyRequest().authenticated() // All other requests require authentication
                ).httpBasic() // Enable basic authentication
                .and().csrf().disable().cors().disable().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/

        http.csrf().disable() // Disable CSRF for stateless APIs
                .cors().and()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/token").permitAll() // Allow access to the token endpoint
                        .anyRequest().authenticated() // All other requests require authentication
                )
                .httpBasic(); // Enable HTTP Basic authentication
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/static/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /*@Bean
    public AuthenticationManager authenticationManagerBean()  throws Exception {
        return super.authenticationManagerBean();
    }*/

    /*@Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration)  throws Exception {
        return configuration.getAuthenticationManager();
    }*/

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailServices).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:4200"); // Allow your Angular app
        config.addAllowedMethod("*"); // Allow all HTTP methods
        config.addAllowedHeader("*"); // Allow all headers
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
