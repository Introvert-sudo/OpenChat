package com.openchat.web.dto;

import java.util.List;

public class BotDTO {
    public String id;
    public String name;
    public String role;
    public String bio;
    public List<String> tags;

    public BotDTO(String id, String name, String role, String bio, List<String> tags) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.bio = bio;
        this.tags = tags;
    }
}
