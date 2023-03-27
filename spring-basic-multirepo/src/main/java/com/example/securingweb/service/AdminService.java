package com.example.securingweb.service;

import com.example.securingweb.dto.AdminDTO;
import com.example.securingweb.h2.User;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    /**
     * Get User details by user email id
     * @param email - registered user email id
     * @return - return user object
     */
    User getUserByEmailId(String email);

    /**
     * Get User details by user id
     * @param userId - registered user id
     * @return - return user object
     */
    AdminDTO getUserById(Integer userId, String currentUser);


    /**
     * Update existing user information
     * @param adminDTO - contains user properties
     * @param currentUserEmailId - loggedIn user email id
     */
    void updateAdmin(AdminDTO adminDTO, String currentUserEmailId);


    public boolean isUserAccountActive(String email);

    Boolean isUserAdmin(String emailId);


    AdminDTO findById(String id);


}
