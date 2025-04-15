package com.example.tricktheai.config;

import com.example.tricktheai.application.StartGameUseCase;
import com.example.tricktheai.infrastructure.persistence.GameSessionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public StartGameUseCase startGameUseCase(GameSessionRepository repository){
        return new StartGameUseCase(repository);
    }
}
