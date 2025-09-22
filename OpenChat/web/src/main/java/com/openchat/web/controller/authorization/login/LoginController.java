package com.openchat.web.controller.authorization.login;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/")
    public String root() {
        return "login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam(required = false) String username,
                               @RequestParam(required = false) String email,
                               @RequestParam String password) {
        String user = (username != null && !username.isBlank()) ? username : (email != null ? email : "");

        if (("admin".equalsIgnoreCase(user) || "admin@example.com".equalsIgnoreCase(user))
                && "password".equals(password)) {
            return "redirect:/main?message=1";
        } else {
            return "redirect:/login?error=1";
        }
    }
}


