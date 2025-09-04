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
}
