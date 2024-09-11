package com.co.leader.admin.infrastructure.boot.config;

import com.co.leader.admin.infraestructure.security.authentication.provider.AdminAuthenticationProvider;
import com.co.leader.admin.infraestructure.security.authentication.service.AdminDetailsService;
import com.co.leader.commons.properties.CORSProperties;
import com.co.leader.commons.properties.JWTProperties;
import com.co.leader.commons.security.filter.CORSFilter;
import com.co.leader.commons.security.filter.JWTAuthenticationFilter;
import com.co.leader.commons.security.filter.JWTAuthorizationFilter;
import com.co.leader.commons.security.jwt.provider.JWTProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    @ConfigurationProperties(prefix = "application.security.jwt")
    public JWTProperties jwtProperties() {
        return new JWTProperties();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        http
                // Start with adding CORS and CSRF configurations
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                // Define which requests are allowed and which are secured
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeRequests(authorizeRequests -> {
                    try {
                        authorizeRequests
                                .requestMatchers("/login").permitAll()
                                .anyRequest()
                                .authenticated()
                                .and()
                                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                    } catch (Exception ignored) {

                    }

                })
                // Add the JWT Authentication filter before the UsernamePasswordAuthenticationFilter
                .addFilter(new JWTAuthenticationFilter(authenticationManager, jwtProvider()))
                // Add the JWT Authorization filter to check user permissions on requests
                .addFilterAfter(new JWTAuthorizationFilter(authenticationManager, jwtProvider()), UsernamePasswordAuthenticationFilter.class)
                // Handle exceptions by redirecting to a custom error page
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling.accessDeniedPage("/error/403"));

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(adminAuthenticationProvider());
        return authenticationManagerBuilder.build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AdminAuthenticationProvider adminAuthenticationProvider() {
        return new AdminAuthenticationProvider(userDetailsService(), encoder());
    }

    @Bean
    public JWTProvider jwtProvider() {
        return new JWTProvider(jwtProperties());
    }

    @Bean
    public AdminDetailsService userDetailsService() {
        return new AdminDetailsService();
    }

    @Bean
    public CORSFilter myCorsFilter() {
        return new CORSFilter(corsProperties());
    }

    @Bean
    @ConfigurationProperties(prefix = "application.security.filters.cors")
    public CORSProperties corsProperties() {
        return new CORSProperties();
    }
}
