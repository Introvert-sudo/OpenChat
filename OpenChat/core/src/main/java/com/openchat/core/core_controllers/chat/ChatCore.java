package com.openchat.core.core_controllers.chat;

import com.openchat.core.core_controllers.chat.messages.BotMessageFactory;
import com.openchat.core.core_controllers.chat.messages.UserMessageFactory;
import com.openchat.db.dto.Chat;
import com.openchat.db.dto.ChatInfo;
import com.openchat.db.dto.Message;
import com.openchat.db.model.Bot;
import com.openchat.db.model.Entity;
import com.openchat.db.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ChatCore {
    private final UserMessageFactory userMessageFactory;
    private final BotMessageFactory botMessageFactory;

    private Chat get_chat(long chat_id) {
        Entity bot = new Bot(0, "Makima", "model", "desc");
        Message message = new Message(0, 0, "text", bot);
        ArrayList<Message> messages = new ArrayList<>();
        messages.add(message);

        ChatInfo chatInfo = new ChatInfo(0, "2025.09.25", 1);

        Chat chat = new Chat(0, messages, chatInfo);

        return chat;
    }


    private Entity get_bot() {
        return new Bot(0, "Makima", "model", "desc");
    }


    private Entity get_user() {
        return new User(0, "Sv1fT1");
    }


    public Message on_user_message(long chat_id, String message_text) {
        Message user_message = userMessageFactory.createMessage(chat_id, 0, message_text, get_user());
        Message bot_message = botMessageFactory.createMessage(chat_id, 1, "text", get_bot());

        System.out.println("User message obj: " + user_message.toString() + "\nBot message obj: " + bot_message.toString());

        return bot_message;
    }


    public List<Message> get_messages(long chat_id) {
        Chat chat = get_chat(chat_id);
        List<Message> messages = chat.getMessages();

        return messages;
    }
}