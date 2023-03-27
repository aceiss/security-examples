package com.example.registrationlogindemo.controller;

import com.example.registrationlogindemo.dto.UserDto;
import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.service.UserService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    @PreAuthorize("hasRole('USER')")
    public String home(){
        return "index.html";
    }

//    @RolesAllowed({ "ROLE_CATALOG_MGR", "ROLE_ADMIN" })
    @PreAuthorize("hasRole('CATALOG_MGR') || hasRole('ADMIN')")
    @RequestMapping(value = "/catalog" , method = {RequestMethod.GET, RequestMethod.POST})
    public String catalog() {
        return "catalog.html";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login.html";
    }

    @PreAuthorize("hasRole('ADMIN') || hasRole('SUP_ADMIN')")
    @RequestMapping(value = "/admin" , method = {RequestMethod.GET, RequestMethod.POST})
    public String admin() {
        return "admin.html";
    }

    // Login form
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/user" , method = {RequestMethod.GET, RequestMethod.POST})
    public String user() {
        return "user.html";
    }

    // handler method to handle user registration request
    @GetMapping("/register")
    @PreAuthorize("hasRole('ADMIN') || hasRole('CATALOG_MGR')")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register.html";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model){
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register.html";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/listUsers")
    @PreAuthorize("hasRole('ADMIN') || hasRole('CATALOG_MGR')")
    public String listRegisteredUsers(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "listUsers.html";
    }
}
