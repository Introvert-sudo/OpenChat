package com.openchat.web.dto;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Chat {
    private final long chat_id;
    private ArrayList<Message> messages;

    public Chat(long chat_id, ArrayList<Message> messages) {
        this.chat_id = chat_id;
        this.messages = messages;
    }
}
