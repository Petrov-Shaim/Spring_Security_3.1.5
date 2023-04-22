package com.example.spring_security.controller;

import com.example.spring_security.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.spring_security.entity.User;


@Controller
public class UserController {

    private final EmployeeService employeeService;


    @Autowired
    public UserController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/user")
    public String showInfoYourSelf(Model model) {
        User userAuth = employeeService.getAuthUser();
        model.addAttribute("user", userAuth);
        return "user";
    }

}
