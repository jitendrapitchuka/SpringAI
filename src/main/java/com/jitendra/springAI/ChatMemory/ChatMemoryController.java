package com.jitendra.springAI.ChatMemory;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatMemoryController {

 
    private ChatClient chatClient;

    public ChatMemoryController(ChatClient.Builder builder,ChatMemory chatMemory){
        this.chatClient=builder.defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build()).build();
    }

    
    @GetMapping("/ChatMemory")
    public String chatMemory(@RequestParam String message){
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
                
    }

}
