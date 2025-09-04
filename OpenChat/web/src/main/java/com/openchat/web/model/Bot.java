package com.openchat.web.model;

import lombok.Getter;

@Getter
public class Bot extends Entity {
    private final String description;
    private final String model;

    public Bot(long id, String nickname, String model, String description) {
        super(id, nickname);

        this.model = model;
        this.description = description;
    }
}
