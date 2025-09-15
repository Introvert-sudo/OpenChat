package com.openchat.web.controller.main;


import com.openchat.web.dto.BotDTO;
import com.openchat.web.dto.SelectBotRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MainRestController {
    @GetMapping("/bots")
    public List<BotDTO> MainPage() {
        return List.of(
                new BotDTO("0", "Makima", "Public Safety Leader", "just mommy", List.of("Public Safety Leader", "Mommy"))
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
}
