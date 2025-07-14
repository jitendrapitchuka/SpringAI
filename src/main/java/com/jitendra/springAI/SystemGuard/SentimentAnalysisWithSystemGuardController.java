package com.jitendra.springAI.SystemGuard;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentimentAnalysisWithSystemGuardController {

    private ChatClient chatClient;

    //0.1d temperature means the model will be more deterministic and less creative
    //0.9d temperature means the model will be more creative and less deterministic
    public SentimentAnalysisWithSystemGuardController(ChatClient.Builder builder) {
        this.chatClient = builder.defaultOptions(VertexAiGeminiChatOptions.builder().temperature(0.1d).build()) .build();
    }

    @GetMapping("/centiment-analysis")
    public Sentiment centimentAnalysis(@RequestParam(defaultValue = "I love the new features in the latest smartphone!") String message) {
        String system =
        """
                You are a sentiment analysis assistant. Your task is to analyze the sentiment of the user's message.
                Respond with either "Positive", "Negative", or "Neutral" based on the sentiment expressed in the message.
                """;
        return chatClient.prompt()
                .system(system)
                .user(message)
                .call()
                .entity(Sentiment.class);
    }

}
