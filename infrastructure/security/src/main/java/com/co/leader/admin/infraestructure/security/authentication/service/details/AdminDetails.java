package com.co.leader.admin.infraestructure.security.authentication.service.details;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class AdminDetails implements UserDetails, CredentialsContainer {

    private String name;

    private String lastName;

    @Getter(AccessLevel.NONE)
    private String username;

    @Getter(AccessLevel.NONE)
    private String password;

    private String uniqueId;

    private String email;

    @Getter(AccessLevel.NONE)
    private Collection<GrantedAuthority> authorities;

    @Getter(AccessLevel.NONE)
    private boolean accountNonExpired;

    @Getter(AccessLevel.NONE)
    private boolean accountNonLocked;

    @Getter(AccessLevel.NONE)
    private boolean credentialsNonExpired;

    @Getter(AccessLevel.NONE)
    private boolean enabled;

    private Map<String, Object> additionalInformation;

    private Integer attempts;

    private String status;

    @Override
    public void eraseCredentials() {
        this.password = null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Map<String, Object> getAdditionalInformation() {
        if (this.additionalInformation == null) {
            this.additionalInformation = new HashMap<>();
        }
        return additionalInformation;
    }

    public void setAdditionalInformation(Map<String, Object> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public void addAdditionalInformation(String key, Object data) {
        if (!getAdditionalInformation().containsKey(key)) {
            getAdditionalInformation().put(key, data);
        }
    }
}
