package com.openchat.db.model;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Chat {
    private final long chat_id;
    @Getter
    private ArrayList<Message> messages;
    private ChatInfo chatInfo;

    public Chat(long chat_id, ArrayList<Message> messages, ChatInfo chatInfo) {
        this.chat_id = chat_id;
        this.messages = messages;
        this.chatInfo = chatInfo;
    }
}
