package com.jitendra.springAI.SystemGuard;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemGuardController {

    @Autowired
    private ChatClient chatClient;


    @GetMapping("/system-guard")
    public String systemGuard(@RequestParam(defaultValue = "What's the market share of Android vs iOS?") String message){
        String system=
        """
                You are a careful research assistant. Follow these rules:

                - Do not guess or make up facts.
                - Do not give numbers, statistics, or dates unless you are completely sure they are correct.
                - If asked for details you are unsure of, respond with one of these:
                    - "I cannot provide specific statistics without access to current data."
                    - "I don't have access to up-to-date product information."
                    - "I cannot cite specific research papers without verification."
                    - "I don't have access to current financial data."

                If you are unsure about something, say so clearly. Do not present uncertain information as fact.
                
                """;
                return chatClient.prompt()
                .system(system)
                .user(message)
                .call()
                .content();

    }

    @GetMapping("/system-guard1")
    public String systemGuard1(@RequestParam(defaultValue = "what is the treatment for diabetes?") String message){
        String system=
        """
            You are a virtual assistant for a healthcare provider. 

            You can ONLY help with:
            - Scheduling appointments
            - Providing clinic hours and contact information
            - Explaining general services (e.g. lab tests, physicals)

            If asked about symptoms, diagnoses, or treatments, respond: 
            I'm not qualified to provide medical advice. Please consult a healthcare professional.

                """;
                return chatClient.prompt()
                .system(system)
                .user(message)
                .call()
                .content();

    }

   
}
