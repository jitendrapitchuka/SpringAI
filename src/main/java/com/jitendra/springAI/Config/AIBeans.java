package com.jitendra.springAI.Config;

import org.springframework.ai.chat.client.ChatClient;

import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIBeans {

    // @Bean
    // public ChatClient OpenAiChatClient(OpenAiChatModel chatModel) {
    //     return ChatClient.create(chatModel);
    // }

    @Bean
    public ChatClient GeminiChatClient(VertexAiGeminiChatModel chatModel) {
        return ChatClient.create(chatModel);
    }

}
