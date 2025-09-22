package com.openchat.web.controller.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class ProfileController {

    @GetMapping("/profile")
    public String profilePage() {
        return "profile";
    }

    // Mock profile info for now; replace with real module wiring later
    @GetMapping("/api/profile")
    @ResponseBody
    public Map<String, Object> profileInfo() {
        return Map.of(
                "username", "@username",
                "memberSince", "2025",
                "about", "I am an OpenChat user who loves creating helpful role-bots for coding and creativity. Coffee-powered and always exploring new ideas."
        );
    }

    // Mock list of bots created by the user
    @GetMapping("/api/profile/bots")
    @ResponseBody
    public List<Map<String, Object>> myBots() {
        return List.of(
                Map.of(
                        "name", "Code Helper",
                        "subtitle", "Developer Assistant",
                        "tags", List.of("coding", "java", "debug")
                ),
                Map.of(
                        "name", "Story Crafter",
                        "subtitle", "Creative Writing",
                        "tags", List.of("creative", "plot", "themes")
                ),
                Map.of(
                        "name", "Travel Genie",
                        "subtitle", "Trip Planner",
                        "tags", List.of("travel", "flights", "hotel")
                )
        );
    }
}


