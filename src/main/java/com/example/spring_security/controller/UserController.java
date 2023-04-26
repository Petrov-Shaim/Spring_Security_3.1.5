package com.example.spring_security.controller;

import com.example.spring_security.dao.UserRepository;
import com.example.spring_security.entity.User;
import com.example.spring_security.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    UserService userService;
    private final UserRepository userRepository;


    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }


    @GetMapping()
    public String userView(Model model) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedUser = userService.findByUsername(userDetails.getUsername());
        model.addAttribute("LoggedUser", loggedUser);
        return "user";
    }
}
