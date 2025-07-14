package com.jitendra.springAI.StructuredOutput;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StructuredOutputController {

    @Autowired
    private ChatClient chatClient;


    @GetMapping("/StructuredOutput")
    public HolidayList structuredOutput(@RequestParam(defaultValue = "South India")String destination){

        return chatClient.prompt().user(u->
        {
            u.text("i am planning a holiday to {destination}, can you suggest me a plan for 7 days?");
            u.param("destination", destination);
        })  .call()
            .entity(HolidayList.class);
        
    }
}
