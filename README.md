# Spring AI Project
A modular Spring Boot application demonstrating various AI-powered features using Spring AI.

# Features

- **Simple Chat**
  - `ChatController.java`: Provides a basic AI-powered chat interface for user interaction.

- **Async Chat**
  - `AsyncChatController.java`: Handles chat requests asynchronously, allowing non-blocking communication with the AI.

- **Chat Memory**
  - `ChatMemoryController.java`: Maintains conversation history to enable context-aware responses and improved user experience.

- **Structured Output**
  - `StructuredOutputController.java`: Generates and processes structured data outputs, such as holiday plans and lists, using AI models.
  - `HolidayList.java`, `HolidayPlan.java`: Data models for structured output features.

- **System Guard**
  - `SystemGuardController.java`: Implements system-level controls and safety checks to ensure secure and reliable AI operations.
  - `SentimentAnalysisWithSystemGuardController.java`: Includes sentiment analysis capabilities for monitoring and evaluating user input.

- **Configurable AI Beans**
  - `AIBeans.java`: Centralizes configuration for all AI components, making it easy to manage and extend AI features.

- **MultiModal Features**
  - `ImageDetectionController.java`: Detects and processes image content using AI models.
  - `ContentDetectionController.java`: Detects and processes text or content using AI models.

- **Tools Integration**
  - `@Tool` in Spring AI: The `@Tool` annotation is used to define and register custom tools that can be invoked by AI models to perform specific tasks, such as fetching data or executing business logic. This enables seamless integration of external functionalities into AI workflows.
  - `WeatherToolController.java`: Provides weather-related AI features and endpoints.
  - `WeatherTool.java`: Implements the mock logic for weather tool integration.

---

## Notes

- For reference on how to integrate with OpenAI, see: [danvega/spring-ai-workshop](https://github.com/danvega/spring-ai-workshop)
- For advanced or more features like Retrieval-Augmented Generation (RAG), refer to the official Spring AI documentation.
- This entire project is implemented using Vertex AI Gemini as the underlying model provider.
