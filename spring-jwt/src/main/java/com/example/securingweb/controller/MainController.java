package com.example.securingweb.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class MainController {

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
//@Secured({"ROLE_ADMIN","ROLE_SUP_ADMIN"})
  public String admin() {
    return "admin.html";
  }

  // Login form
  @RequestMapping(value = "/catalog" , method = {RequestMethod.GET, RequestMethod.POST})
  @Secured({"ROLE_ADMIN","ROLE_CATALOG"})
  public String catalog() {
    return "catalog.html";
  }

  // Login form
  @RequestMapping(value = "/home" , method = {RequestMethod.GET, RequestMethod.POST})
  @Secured({"ROLE_USER"})
  public String home() {
    return "home.html";
  }
  

}