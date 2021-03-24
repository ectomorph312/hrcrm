package io.fortylines.hrcrm.entity;

import org.springframework.security.core.GrantedAuthority;


public enum Role implements GrantedAuthority {
    HR, HEADOFDEPARTMENT, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
