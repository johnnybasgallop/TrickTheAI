package com.example.tricktheai.config;

import com.example.tricktheai.application.SendMessageUseCase;
import com.example.tricktheai.application.StartGameUseCase;
import com.example.tricktheai.domain.ai.AIEngine;
import com.example.tricktheai.domain.ai.AdvancedAIEngine;
import com.example.tricktheai.domain.ai.SimpleAIEngine;
import com.example.tricktheai.infrastructure.persistence.GameSessionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class UseCaseConfig {
    @Bean
    public StartGameUseCase startGameUseCase(GameSessionRepository repository){
        return new StartGameUseCase(repository);
    }

    @Bean
    public SendMessageUseCase sendMessageUseCase(GameSessionRepository repository, AIEngine engine){
        return new SendMessageUseCase(repository, engine);
    }

    @Bean
    public AIEngine aiEngine(WebClient openAiWebclient) {
        return new AdvancedAIEngine(openAiWebclient);
    }
}
