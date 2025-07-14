package com.jitendra.springAI.Async;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class AsyncChatController {

    @Autowired
    @Qualifier("GeminiChatClient")
    private ChatClient chatClient;


    @GetMapping("/AsyncChat")
    public Flux<String> asyncChat(){
        return chatClient.prompt()
               .user("Iam planning to visit India, can you suggest me 5 places to visit?")
               .stream()
               .content();
    }




}
