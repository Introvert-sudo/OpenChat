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
    /*
    Chat Core
    This class created for managing chat business logic and creating dependency inversion.
     */

    private final UserMessageFactory userMessageFactory;
    private final BotMessageFactory botMessageFactory;

    // Web -> Core logic. Function for user input managing.
    public Message on_user_message(long chat_id, String message_text) {
        Message user_message = userMessageFactory.createMessage(chat_id, 0, message_text, get_user());
        Message bot_message = botMessageFactory.createMessage(chat_id, 1, "text", get_bot());

        System.out.println("User message obj: " + user_message.toString() + "\nBot message obj: " + bot_message.toString());

        return bot_message;
    }

    // Web -> Core logic. Function that transfer messages list from chat by unique chat id.
    public List<Message> get_chat_messages(long chat_id) {
        List<Message> messages = new ArrayList<>();
        try {
            messages = get_messages(chat_id);
        } catch (Exception e) {
            System.out.println(e);
        }

        return messages;
    }

    // Core -> Entity logic function. Getting bot object for main logic
    private Entity get_bot() {
        return new Bot(0, "Makima", "model", "desc");
    }

    // Core -> Entity logic function. Getting user object for main logic
    private Entity get_user() {
        return new User(0, "Sv1fT1");
    }

    // Core -> Entity logic function. Getting chat info for chat initializing
    private ChatInfo get_chatInfo() {
        return new ChatInfo(0, "2025.09.25", 1);
    }

    // Core -> Entity logic function. Getting chat by unique chat id.
    private Chat get_chat(long chat_id) {
        Entity bot = new Bot(0, "Makima", "model", "desc");
        Message message = new Message(0, 0, "text", bot);

        ArrayList<Message> messages = new ArrayList<>();
        messages.add(message);

        ChatInfo chatInfo = get_chatInfo();

        Chat chat = new Chat(0, messages, chatInfo);

        return chat;
    }

    // Getting messages from chat by unique chat id
    private List<Message> get_messages(long chat_id) {
        Chat chat = get_chat(chat_id);
        List<Message> messages = chat.getMessages();

        return messages;
    }
}