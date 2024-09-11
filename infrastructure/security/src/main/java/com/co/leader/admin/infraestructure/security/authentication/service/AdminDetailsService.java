package com.co.leader.admin.infraestructure.security.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.co.leader.admin.infraestructure.security.authentication.service.details.AdminDetails;
import com.co.leader.admin.infraestructure.security.authentication.service.details.mapper.AdminDetailsMapper;
import com.co.leader.admin.infrastructure.repository.AdminJpaRepository;
import com.co.leader.admin.infrastructure.repository.domain.AdminEntity;

import java.util.Arrays;

public class AdminDetailsService implements UserDetailsService {

    @Autowired
    private AdminJpaRepository adminJpaRepository;

    @Autowired
    private AdminDetailsMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminEntity adminEntity = adminJpaRepository.findByUsernameEquals(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        AdminDetails adminDetails= mapper.toAdminDetails(adminEntity, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
        return adminDetails;
    }

    public void updateAdmin(String username, AdminDetails adminDetails) {
        AdminEntity adminEntity = adminJpaRepository.findByUsernameEquals(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        adminEntity.setAttempts(adminDetails.getAttempts());
        adminEntity.setAccountNonLocked(adminDetails.isAccountNonLocked());
        adminEntity.setStatus(adminDetails.getStatus());
        adminJpaRepository.save(adminEntity);
    }
}
