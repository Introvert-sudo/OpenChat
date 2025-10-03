package com.openchat.db.dto;

public class AiServiceConf {
    public long id;
    public int message_memory;

    public AiServiceConf(long id, int message_memory) {
        this.id = id;
        this.message_memory = message_memory;
    }
}
