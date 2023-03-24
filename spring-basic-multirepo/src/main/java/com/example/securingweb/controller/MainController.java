package com.example.securingweb.controller;

import com.example.securingweb.WebSecurityConfig;
import com.example.securingweb.h2.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

  @Autowired
  private final DatabaseUserDetailsService databaseUserDetails;

  @Autowired
  private final WebSecurityConfig webSecurityConfig;

//  @Autowired
//  private final JdbcUserDetailsManager detailsManager;

  public MainController(UserAccountRepository userAccountRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, DatabaseUserDetailsService authenticationProvider, WebSecurityConfig webSecurityConfig) {
    this.userAccountRepository = userAccountRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
    this.databaseUserDetails = authenticationProvider;
    this.webSecurityConfig = webSecurityConfig;
//    this.detailsManager = detailsManager;
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
  @PreAuthorize("hasRole('USER')")
  @RequestMapping(value = "/user" , method = {RequestMethod.GET, RequestMethod.POST})
  public String user() {
    return "user.html";
  }

  // Login form
  @RequestMapping(value = "/home" , method = {RequestMethod.GET, RequestMethod.POST})
  public String home(Model model, SecurityContextHolder contextHolder) {
    Authentication authentication = contextHolder.getContext().getAuthentication();
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();

    Gson gson = new GsonBuilder()
            .serializeNulls()
            .create();

    model.addAttribute("jsonText", gson.toJson(userDetails));

    return "home.html";
  }

  @RequestMapping(value = "/listUsers" , method = {RequestMethod.GET, RequestMethod.POST})
  @PreAuthorize("hasRole('ADMIN') || hasRole('SUP_ADMIN')")
  public String listUsers(Model model) {

//    webSecurityConfig.securityFilterChain().getFilters().;
    String sql = "SELECT * FROM `Employees`";
/*

    List<Map<String, Object>> users = detailsManager.getJdbcTemplate().queryForList( sql );
//Call userdetailservice for each user get details/granted authorities. + extended data is a plus
    if (users != null && users.size() >0) {
      System.out.println("Users In Group size " + users.size());
      Gson gson = new GsonBuilder()
              .serializeNulls()
              .create();

      System.out.println("Users In Group " + gson.toJson(users));
    }
*/

    List<User> userList = userAccountRepository.findAll();
    for(User user : userList){
      UserDetails details = databaseUserDetails.loadUserByUsername(user.getUsername());
      System.out.println (details.getAuthorities());
    }

    model.addAttribute("users",userAccountRepository.findAll());

    return "listUsers.html";
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