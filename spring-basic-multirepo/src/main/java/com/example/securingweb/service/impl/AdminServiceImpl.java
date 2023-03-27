package com.example.securingweb.service.impl;

import com.example.securingweb.dto.AdminDTO;
import com.example.securingweb.h2.User;
import com.example.securingweb.h2.UserAccountRepository;
import com.example.securingweb.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    private UserAccountRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    public AdminServiceImpl() {
    }

    @Override
    public User getUserByEmailId(String email) {
        User user = userRepository.findByUsername(email);
        // TODO, Here we will create a transformer to convert user object into dto
        return user;
    }

    @Override
    public AdminDTO getUserById(Integer userId, String currentUser) {

        Optional<User> user = userRepository.findById(userId);

        AdminDTO admin = new AdminDTO();
        admin.setUsername(user.get().getUsername());
        return admin;
    }

    @Override
    public void updateAdmin(AdminDTO adminDTO, String currentUserEmailId) {
        // TODO admin validation need to add
        return;
    }

    @Override
    public boolean isUserAccountActive(String email) {
        return false;
    }

    /**
     * this method is used to mapUserData user object
     *
     * @param user     - user entity
     * @param adminDTO - userDto object contains user related property
     */
    private void mapUserData(User user, AdminDTO adminDTO) {
        return;
    }



    @Override
    public Boolean isUserAdmin(String emailId) {
        return false;
    }

    @Override
    public AdminDTO findById(String id) {
        AdminDTO admin = new AdminDTO();
        admin.setEmail("emailId");
        admin.setUsername("user");
        return admin;

    }

}
