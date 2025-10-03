
package com.openchat.web.controllers.chat;

import com.openchat.core.core_controllers.chat.ChatCore;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openchat.db.model.Message;

import java.util.List;
import java.util.Map;



@CrossOrigin
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ChatRestController {
    private final ChatCore chatCore;

    // Mock chat info and messages
    @GetMapping("/chat/{id}")
    public Map<String, Object> chatInfo(@PathVariable String id) {
        return Map.of(
                "id", id,
                "createdAt", "2025-09-18",
                "totalMessages", 3,
                "bots", List.of(
                        Map.of("name", "Code Helper", "description", "Developer Assistant"),
                        Map.of("name", "Makima", "description", "Public Safety Leader")
                ),
                "roles", List.of(
                        Map.of("name", "assistant"),
                        Map.of("name", "reviewer"),
                        Map.of("name", "planner")
                )
        );
    }

    @GetMapping("/chat/{id}/messages")
    public List<Message> chatMessages(@PathVariable String id) {
        return chatCore.get_chat_messages(Long.parseLong(id));
    }


    @PostMapping("/chat/{id}/send_message")
    public Message send_message(@PathVariable String id, @RequestBody Map<String, String> body) {
        String message_text = body.get("message");
        long chat_id = Long.parseLong(id);

        Message answer = chatCore.on_user_message(chat_id, message_text);

        System.out.println("Answer:" + answer.toString());

        return answer;
    }
}
