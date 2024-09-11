package com.co.leader.admin.infraestructure.security.service;

import com.co.leader.admin.domain.service.security.SecurityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.co.leader.admin.infraestructure.security.authentication.service.details.AdminDetails;

@Slf4j
@Component
public class SecurityAdapterService implements SecurityService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String encodePassword(String pasword) {
        return passwordEncoder.encode(pasword);
    }

    @Override
    public String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication.getName();
        }

        throw new AuthenticationServiceException("An error has occurred trying to get authentication");
    }

    @Override
    public String getAdminUniqueId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            AdminDetails adminDetails = (AdminDetails) authentication.getPrincipal();
            return adminDetails.getUniqueId();
        }

        throw new AuthenticationServiceException("An error has occurred trying to get authentication");
    }
}
