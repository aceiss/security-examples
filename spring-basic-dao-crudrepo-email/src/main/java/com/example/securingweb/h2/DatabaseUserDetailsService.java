package com.example.securingweb.h2;

import com.example.securingweb.dao.UserDAO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseUserDetailsService implements UserDetailsService {
    private UserDAO userDAO;

    public DatabaseUserDetailsService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userAccount = userDAO.findByEmail(username);
        if (userAccount == null) {
            throw new UsernameNotFoundException("User with username [" + username + "] not found in the system");
        }
        //This is not used anywhere, just adding another repository for the Agent to deal with.
//        for(Role role : userAccount.getUserRoles()){
//            System.out.println(role.getRole());
//        }

        return new CustomUserDetails(userAccount);
    }
}