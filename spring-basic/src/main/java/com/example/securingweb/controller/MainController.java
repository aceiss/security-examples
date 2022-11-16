package com.example.securingweb.controller;

import com.example.securingweb.h2.Role;
import com.example.securingweb.h2.RoleRepository;
import com.example.securingweb.h2.User;
import com.example.securingweb.h2.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/")
public class MainController {


  @Autowired
  private final UserAccountRepository userAccountRepository;

  @Autowired
  private final RoleRepository roleRepository;

  @Autowired
  private final PasswordEncoder passwordEncoder;

  public MainController(UserAccountRepository userAccountRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
    this.userAccountRepository = userAccountRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  // Login form
  @RequestMapping(value = "/login" , method = {RequestMethod.GET, RequestMethod.POST})
  public String login(Model model) {
    model.addAttribute("loginText", "This is the Login Page");
    return "login.html";
  }

  // Login form with error
  @RequestMapping(value = "/login-error" , method = {RequestMethod.GET, RequestMethod.POST})
  public String loginError(Model model) {
    model.addAttribute("loginError", true);
    return "login.html";
  }

  // Login form
  @RequestMapping(value = "/admin" , method = {RequestMethod.GET, RequestMethod.POST})
  @PreAuthorize("hasRole('ADMIN') || hasRole('SUP_ADMIN')")
  public String admin() {
    return "admin.html";
  }

  // Login form
  @PreAuthorize("hasRole('CATALOG_MGR') || hasRole('ADMIN')")
  @RequestMapping(value = "/catalog" , method = {RequestMethod.GET, RequestMethod.POST})
  public String catalog() {
    return "catalog.html";
  }

  // Login form
  @RequestMapping(value = "/home" , method = {RequestMethod.GET, RequestMethod.POST})
  public String home() {
    return "home.html";
  }

  @RequestMapping(value = "/register" , method = {RequestMethod.GET})
  public String register() {
    return "register.html";
  }

  @PostMapping("/register")
  public Role register(@RequestParam("username") String username, @RequestParam("password") String password,
                       @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("address") String address) {
    User userAccount = new User();
    userAccount.setFirstName(firstName);
    userAccount.setLastName(lastName);
    userAccount.setAddress(address);
    userAccount.setUsername(username);
    userAccount.setPassword(passwordEncoder.encode(password));
    userAccount.setEnabled("1");
    Role role = new Role();
    role.setUsername(username);
    role.setRole("ADMIN");
    userAccountRepository.save(userAccount);
    return roleRepository.save(role);
  }

}