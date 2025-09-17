package com.openchat.web.controller.authorization.register;

import org.springframework.web.bind.annotation.GetMapping;


public class RegisterController {

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}