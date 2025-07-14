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
