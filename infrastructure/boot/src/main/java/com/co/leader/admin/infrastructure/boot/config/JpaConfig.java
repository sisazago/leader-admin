package com.co.leader.admin.infrastructure.boot.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

@Configuration
@EntityScan(basePackages = {"com.co.leader.commons.repository.domain", "com.co.leader.admin.infrastructure.repository.domain"})
@EnableJpaRepositories(basePackages = {"com.co.leader.commons.repository", "com.co.leader.admin.infrastructure.repository"})
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if ((authentication instanceof UsernamePasswordAuthenticationToken) && authentication.isAuthenticated()) {
                UsernamePasswordAuthenticationToken authenticationToken = ((UsernamePasswordAuthenticationToken) authentication);
                UserDetails userDetails = (UserDetails) authenticationToken.getPrincipal();
                return Optional.of(userDetails.getUsername());
            }
            return Optional.empty();
        };
    }


}
