package com.jitendra.springAI.Tools;

import org.springframework.ai.chat.client.ChatClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherToolController {

    private final ChatClient chatClient;
    private final WeatherTool weatherTool;

    public WeatherToolController(ChatClient chatClient, WeatherTool weatherTool) {
        this.chatClient = chatClient;
        this.weatherTool = weatherTool;
    }


    @GetMapping("/weather")
    public String getWeather(@RequestParam(defaultValue = "India")String location) {
        return chatClient.prompt()
        .user("Get the current weather for " + location)
        .tools(weatherTool)
        .call()
        .content();
    }


}
