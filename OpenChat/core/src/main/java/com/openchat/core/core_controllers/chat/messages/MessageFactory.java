package com.openchat.core.core_controllers.chat.messages;

import com.openchat.db.dto.Message;
import com.openchat.db.model.Entity;

public interface MessageFactory {
    Message createMessage(long chatId, long messageId, String text, Entity sender);
}