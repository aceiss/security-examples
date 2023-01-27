package com.example.securingweb.ldap;

import com.example.securingweb.h2.Role;
import com.example.securingweb.h2.User;
import com.example.securingweb.h2.UserAccountRepository;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;

import java.util.*;
import java.util.stream.Collectors;

public class CustomAuthoritiesPopulator implements LdapAuthoritiesPopulator {

    private final UserAccountRepository userAccountRepository;

    public CustomAuthoritiesPopulator(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations dirContextOperations, String username) {

        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
        final User user = userAccountRepository.findByUsername(username);
        if(user != null) {
            final List<Role> authorities = user.getUserRoles();
            grantedAuthorities = authorities.stream()
                    .map(roles1 -> new SimpleGrantedAuthority(roles1.getRole()))
                    .collect(Collectors.toList());
        }
        return grantedAuthorities;
    }
}
