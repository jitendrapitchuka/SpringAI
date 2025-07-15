package com.jitendra.springAI.Tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class WeatherTool {

    
    @Tool(name = "weather", description = "Get the current weather for a location")
    public String getWeather(@ToolParam(description = "The location to get the weather for") String location) {
        // This method would typically call a weather API to get the current weather for the specified location.
        // For demonstration purposes, we will return a mock response.
        return "The current weather in " + location + " is sunny with a temperature of 25°C.";
    }
}
