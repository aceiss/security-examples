package com.example.securingweb.h2;


import java.util.ArrayList;

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

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//
//        for(Role role : userAccount.getUserRoles() )
//            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRole()));
//
//        return authorities;
//    }
}
