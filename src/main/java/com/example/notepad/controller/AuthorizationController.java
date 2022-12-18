package com.example.notepad.controller;

import com.example.notepad.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthorizationController {

    private final UserService userService;

    @GetMapping("/")
    public String loginPage() {
        return "auth";
    }

    @PostMapping("/auth/login")
    public String auth(String name, String pass){
        if (userService.validateUser(name, pass)) {
            return "accessgranted";
        } else { return "accessdenied"; }
    }
}
