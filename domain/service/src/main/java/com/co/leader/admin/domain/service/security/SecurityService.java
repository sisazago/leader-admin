package com.co.leader.admin.domain.service.security;

public interface SecurityService {

    String encodePassword(String pasword);

    String getUsername();

    String getAdminUniqueId();
}
