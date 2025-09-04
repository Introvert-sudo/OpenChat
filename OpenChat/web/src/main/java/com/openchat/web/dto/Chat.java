package com.openchat.web.dto;

import lombok.Getter;

import javax.management.Query;

@Getter
public class Chat {
    private long chat_id;
    private Query messages;
}
