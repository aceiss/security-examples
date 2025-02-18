package com.example.securingweb.h2;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails  {

    private final User userAccount;


    public CustomUserDetails(User userAccount) {
        this.userAccount = userAccount;
    }

    public String getUsername() {
        return userAccount.getUsername();
    }

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

    public boolean isAccountNonExpired() {
        return userAccount.isEnabled();
    }

    public boolean isAccountNonLocked() {
        return userAccount.isEnabled();
    }

    public boolean isCredentialsNonExpired() {
        return userAccount.isEnabled();
    }

    public boolean isEnabled() {
        return userAccount.isEnabled();
    }

    public Collection<? extends Role> getAuthorities() {
        List<Role> authorities = new ArrayList<>();

        for(Role role : userAccount.getUserRoles() )
            authorities.add(role);

        return authorities;
    }
}
