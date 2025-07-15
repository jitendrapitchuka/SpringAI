package com.jitendra.springAI.multiModal.ImageOrContent;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageDetectionController {

    @Autowired
    private  ChatClient chatClient;

    @Value("classpath:static/image.jpg")
    private Resource imageResource;

    @GetMapping("/image-detection")
    public String detectImage(){
        return chatClient.prompt()
                .user(u->u.text("Can you explain the content of this image and can you guess the location by looking at the temple behind?")
                .media(MimeTypeUtils.IMAGE_JPEG, imageResource))
                .call()
                .content();
    }


}
