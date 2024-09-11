package com.co.leader.admin.infraestructure.security.authentication.provider;

import com.co.leader.admin.domain.model.support.AdminStatus;
import com.co.leader.admin.infraestructure.security.authentication.service.AdminDetailsService;
import com.co.leader.admin.infraestructure.security.authentication.service.details.AdminDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class AdminAuthenticationProvider implements AuthenticationProvider {

    @Value("${application.security.authentication.attempts}")
    private int LOGIN_ATTEMPTS;

    private final AdminDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) authentication;

        String username = (String) usernamePasswordAuthenticationToken.getPrincipal();
        String password = (String) usernamePasswordAuthenticationToken.getCredentials();

        AdminDetails userDetails = (AdminDetails) userDetailsService.loadUserByUsername(username);
        if ((userDetails != null) && passwordEncoder.matches(password, userDetails.getPassword()) && userDetails.isAccountNonLocked()) {
            userDetails.eraseCredentials();
            return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        }

        if (userDetails != null && userDetails.isAccountNonLocked()){
            try {
                if (userDetails.getAttempts() < LOGIN_ATTEMPTS) {
                    userDetails.setAttempts(userDetails.getAttempts() + 1);
                } else {
                    userDetails.setAccountNonLocked(Boolean.FALSE);
                    userDetails.setStatus(AdminStatus.BLOCKED.toString());
                }

                userDetailsService.updateAdmin(username, userDetails);
            }catch (Exception e) {
                throw new AuthenticationServiceException(String.format("An error has occurred trying to update user %s", username));
            }
        }else{
            throw new LockedException(String.format("User %s is blocked", username));
        }

        throw new BadCredentialsException(String.format("User %s credential aren't valid.", username));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
