package com.openchat.db.dto;

import java.util.List;

public class BotDTO {
    public long id;
    public String name;
    public long role_id;
    public String bio;
    public List<String> tags;

    public BotDTO(long id, String name, long role_id, String bio, List<String> tags) {
        this.id = id;
        this.name = name;
        this.role_id = role_id;
        this.bio = bio;
        this.tags = tags;
    }
}
