package com.openchat.db.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Message {
    private long message_id;
    private long chat_id;
    private Entity sender;

    @Setter
    private String message_text;

    public Message(long chat_id, long message_id, String message_text, Entity sender) {
        this.chat_id = chat_id;
        this.message_id = message_id;
        this.message_text = message_text;
        this.sender = sender;
    }
}
