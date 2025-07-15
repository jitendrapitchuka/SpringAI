package com.jitendra.springAI.multiModal.ImageOrContent;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentDetectionController {

    @Autowired
    private ChatClient chatClient;

    @Value("classpath:static/chat_memory_spring.pdf")
    private Resource pdfResource;

    @GetMapping("/content-detection")
    public String detectContent() {
        return chatClient.prompt()
                .user(u -> u.text("Can you explain the content of this PDF document in 5 bullet points?")
                .media(new MimeType("application", "pdf"), pdfResource))
                .call()
                .content();
    }
}
