package com.example.securingweb.h2;

import org.springframework.stereotype.Component;

@Component
public class DatabaseUserDetailsService  {
    private final
    UserAccountRepository userAccountRepository;

    public DatabaseUserDetailsService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

     public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userAccount = userAccountRepository.findByUsername(username);
        if (userAccount == null) {
            throw new UsernameNotFoundException("User with username [" + username + "] not found in the system");
        }

//        for(Role role : userAccount.getUserRoles()){
//            System.out.println(role.getRole());
//        }

        return new CustomUserDetails(userAccount);
    }
}
