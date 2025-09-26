package com.openchat.core.core_controllers.chat.messages;

import com.openchat.db.dto.Message;
import com.openchat.db.model.Entity;
import org.springframework.stereotype.Component;

@Component
public class UserMessageFactory implements MessageFactory {
    @Override
    public Message createMessage(long chatId, long messageId, String message_text, Entity sender) {
        Message message = new Message(chatId, messageId, message_text, sender);

        return message;
    }
}
