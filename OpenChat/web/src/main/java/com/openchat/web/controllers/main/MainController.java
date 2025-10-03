package com.openchat.web.controllers.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class MainController {
    @GetMapping("/main")
    public String mainPage() {
        return "main"; // resolves to templates/main.html
    }

    // REPLACE TO CHAT CONTROLLER!
    @GetMapping("/chat/{id}")
    public String chatPage(@PathVariable String id) {
        return "chat"; // resolves to templates/chat.html
    }
}
