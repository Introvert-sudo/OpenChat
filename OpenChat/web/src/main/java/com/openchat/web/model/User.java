package com.openchat.web.model;

public class User extends Entity {
    private long user_id;

    public User(long id, String nickname) {
        super(id, nickname);
    }
}
