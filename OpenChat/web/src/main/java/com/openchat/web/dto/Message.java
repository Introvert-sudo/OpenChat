package com.openchat.web.dto;

import com.openchat.web.model.Entity;
import lombok.Getter;
import lombok.Setter;

public class Message {
    private long message_id;
    private long chat_id;

    @Getter
    @Setter
    private String message_text;

    @Getter
    private Entity sender;

    public Message(long chat_id, long message_id, String message_text, Entity sender) {
        this.chat_id = chat_id;
        this.message_id = message_id;
        this.message_text = message_text;
        this.sender = sender;
    }
}
