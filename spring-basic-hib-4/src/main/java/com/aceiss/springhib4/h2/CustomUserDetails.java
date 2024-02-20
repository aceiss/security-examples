package com.aceiss.springhib4.h2;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private final User userAccount;


    public CustomUserDetails(User userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String getUsername() {
        return userAccount.getUsername();
    }

    @Override
    public String getPassword() {
        return userAccount.getPassword();
    }

    public String getFirstName() {
        return userAccount.getFirstName();
    }

    public String getLastName() {
        return userAccount.getLastName();
    }

    public String getAddress() {
        return userAccount.getAddress();
    }


    public String getEmail() {
        return userAccount.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userAccount.isEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userAccount.isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userAccount.isEnabled();
    }

    @Override
    public boolean isEnabled() {
        return userAccount.isEnabled();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for(Role role : userAccount.getUserRoles() )
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRole()));

        return authorities;
    }
}
