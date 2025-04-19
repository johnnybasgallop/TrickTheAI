package com.example.tricktheai.config;

import com.example.tricktheai.application.ChangeGameModeUseCase;
import com.example.tricktheai.application.DeleteGameUseCase;
import com.example.tricktheai.application.SendMessageUseCase;
import com.example.tricktheai.application.StartGameUseCase;
import com.example.tricktheai.domain.ai.AIEngine;
import com.example.tricktheai.domain.ai.AdvancedAIEngine;
import com.example.tricktheai.domain.ai.LangChainEngine;
import com.example.tricktheai.domain.ai.SimpleAIEngine;
import com.example.tricktheai.infrastructure.persistence.GameSessionRepository;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Configuration
public class UseCaseConfig {
    @Bean
    public StartGameUseCase startGameUseCase(GameSessionRepository repository){
        return new StartGameUseCase(repository);
    }

    @Bean
    public ChangeGameModeUseCase changeGameModeUseCase(GameSessionRepository repository){
        return new ChangeGameModeUseCase(repository);
    }

    @Bean
    public SendMessageUseCase sendMessageUseCase(GameSessionRepository repository, AIEngine engine){
        return new SendMessageUseCase(repository, engine);
    }

    @Bean
    public DeleteGameUseCase deleteGameUseCase(GameSessionRepository repository){
        return new DeleteGameUseCase(repository);
    }

//    @Bean
//    public AIEngine aiEngine(WebClient openAiWebclient) {
//        return new AdvancedAIEngine(openAiWebclient);
//    }

    @Bean
    public AIEngine aiEngine(ChatLanguageModel model) {
        return new LangChainEngine(model);
    }
}
