package com.example.securingweb.h2;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
public class User {
    @Id @Column(unique = true)
    private String username;

    @Column(nullable = false, length = 300)
    private String password;

    @Column(nullable = false, length = 300)
    private String firstName;

    @Column(nullable = false, length = 300)
    private String lastName;

    @Column(nullable = false, length = 300)
    private String address;

    @Column(nullable = false, length = 2)
    private String enabled;

    //    @OneToMany (fetch = FetchType.EAGER)
    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn(name="username")
    private List<Role> userRoles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean isEnabled() {
        if (enabled.equals("1"))
            return true;
        else
            return false;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public List<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<Role> userRoles) {
        this.userRoles = userRoles;
    }
}