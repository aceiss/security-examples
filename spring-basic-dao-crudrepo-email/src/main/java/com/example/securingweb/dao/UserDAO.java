package com.example.securingweb.dao;

import com.example.securingweb.h2.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserDAO extends CrudRepository<User, Integer> {

    /**
     * Find user by email
     * Used for login.
     *
     * @param email
     * @return
     */
    public User findByEmail(String email);

}
