package com.example.securingweb.h2;

import com.example.securingweb.service.AdminService;
import com.example.securingweb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseUserDetailsService implements UserDetailsService {
//    private final
//    UserAccountRepository userAccountRepository;

    private AdminService adminService;

    private RoleService roleService;

    private PermissionRepository permissionRepository;


//    public DatabaseUserDetailsService(UserAccountRepository userAccountRepository, AdminService adminService, RoleService roleService, PermissionRepository permissionRepository) {
   public DatabaseUserDetailsService(AdminService adminService, RoleService roleService, PermissionRepository permissionRepository) {
//        this.userAccountRepository = userAccountRepository;
        this.adminService = adminService;
        this.roleService = roleService;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userAccount = adminService.getUserByEmailId(username);
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