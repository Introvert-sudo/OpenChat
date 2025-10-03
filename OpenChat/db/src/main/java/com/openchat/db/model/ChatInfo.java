package com.openchat.db.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatInfo {
    public long id;
    public String creation_date;
    public int totalMessages;

    public ChatInfo(long id, String creation_date, int totalMessages) {
        this.id = id;
        this.creation_date = creation_date;
        this.totalMessages = totalMessages;
    }
}
