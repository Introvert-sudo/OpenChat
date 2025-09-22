
package com.openchat.web.controller.chat;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openchat.web.dto.Chat;
import com.openchat.web.dto.ChatInfo;
import com.openchat.web.dto.Message;
import com.openchat.web.model.Bot;
import com.openchat.web.model.Entity;
import com.openchat.web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class ChatRestController {
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
    public List<Map<String, Object>> chatMessages(@PathVariable String id) {
        return List.of(
                Map.of("sender", Map.of("name", "You"), "text", "Hey bot, help me with a bug."),
                Map.of("sender", Map.of("name", "Code Helper"), "text", "Sure, paste the stacktrace."),
                Map.of("sender", Map.of("name", "You"), "text", "NullPointerException at line 42 in MainController.")
        );
    }


    @PostMapping("/chat/{id}/send_message")
    public Message send_message(@PathVariable String id, @RequestBody Map<String, String> body) {
        String text = body.get("message");
        Entity sender = new User(Long.parseLong(id), "You");

        Message message = new Message(0, 0, text, sender);

        System.out.println(message.getMessage_text() + " " + message.getSender().getNickname());

        return message;
    }
}
