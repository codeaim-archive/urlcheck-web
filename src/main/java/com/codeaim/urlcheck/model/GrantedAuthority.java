package com.codeaim.urlcheck.model;

public class GrantedAuthority implements org.springframework.security.core.GrantedAuthority
{
    private Role role;

    public GrantedAuthority(Role role)
    {
        this.role = role;
    }

    @Override
    public String getAuthority()
    {
        return role
                .getName()
                .toUpperCase()
                .replace(" ", "_");
    }
}
