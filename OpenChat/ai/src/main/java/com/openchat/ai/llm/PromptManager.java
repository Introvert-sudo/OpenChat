package com.openchat.ai.llm;

import com.openchat.db.dto.AiServiceConf;
import com.openchat.db.model.Chat;
import org.springframework.stereotype.Component;

@Component
public class PromptManager {
    public String generatePrompt(Chat chat, AiServiceConf aiServiceConf) {
        return "Hi?";
    }
}
