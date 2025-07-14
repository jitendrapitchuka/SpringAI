package com.jitendra.springAI.SimpleChat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    @Qualifier("GeminiChatClient")
    private ChatClient chatClient;


    @GetMapping("/SimpleChat")
    public String simpleChat(@RequestParam(defaultValue = "Tell me a joke") String message) {
        return chatClient.prompt().user(message).call().content();
    }


     @GetMapping("/jokes")
    public String jokes(@RequestParam String topic) {
        return chatClient.prompt()
        .user(u->u.text("tell me a joke about {topic}").param("topic", topic))
        .call().content();
    }

    /* provides the entire response from the AI model instead of just the content like the above endpoints */
     @GetMapping("/chatWithEntireResponse")
    public ChatResponse chatWithEntireResponse(@RequestParam(defaultValue = "Tell me a some intersting fact") String message) {
        return chatClient
        .prompt()
        .user(message)
        .call()
        .chatResponse();
    }

}
