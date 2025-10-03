package com.openchat.ai.llm;

import com.openchat.db.dto.AiServiceConf;
import com.openchat.db.model.Bot;
import com.openchat.db.model.Chat;
import com.openchat.db.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AICore {
    private final PromptManager promptManager;
    public Message generateResponse(Chat chat, AiServiceConf aiServiceConf) {
        String prompt = promptManager.generatePrompt(chat, aiServiceConf);
        String response_text = generateOllamaResponse(prompt);

        Message response = new Message(0, 0, response_text,
                new Bot(0, "nickname", "model", "description"));

        return response;
    }

    private String generateOllamaResponse(String prompt) {
        return prompt; // MOCK
    }
}
