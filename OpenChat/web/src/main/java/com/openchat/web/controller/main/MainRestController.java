package com.openchat.web.controller.main;

import com.openchat.db.dto.BotDTO;
import com.openchat.db.dto.SelectBotRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MainRestController {
    @GetMapping("/bots")
    public List<BotDTO> MainPage() {


        return List.of(
                new BotDTO(1, "Code Helper", 1, "helps debug and explain code", List.of("coding", "java", "debug")),
                new BotDTO(2, "Travel Buddy", 2, "plans trips and itineraries", List.of("travel", "flights", "hotel")),
                new BotDTO(3, "Fitness Coach", 3, "workouts and nutrition", List.of("fitness", "diet", "routine")),
                new BotDTO(4, "Story Teller", 4, "ideas and plots", List.of("creative", "writing", "plot"))
        );
    }

    @PostMapping("/select-bot")
    public Map<String, Object> selectBot(@RequestBody SelectBotRequest request) {
        return Map.of(
                "status", "ok",
                "botId", request.botId,
                "nextUrl", "/chat/" + request.botId
        );
    }

    @GetMapping("/recent")
    public List<Map<String, Object>> recentChats() {
        return List.of(
                Map.of("id", "1", "name", "Code Helper", "last", "2m ago"),
                Map.of("id", "2", "name", "Travel Buddy", "last", "yesterday"),
                Map.of("id", "3", "name", "Fitness Coach", "last", "3 days ago")
        );
    }
}
