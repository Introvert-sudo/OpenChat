package com.openchat.db.model;

import lombok.Getter;

@Getter
public abstract class Entity {
    private long id;
    private String nickname;

    public Entity(long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
}
