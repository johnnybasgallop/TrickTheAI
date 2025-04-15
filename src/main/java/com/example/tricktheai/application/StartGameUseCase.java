package com.example.tricktheai.application;

import com.example.tricktheai.domain.model.GameSession;
import com.example.tricktheai.infrastructure.mapper.GameSessionMapper;
import com.example.tricktheai.infrastructure.persistence.GameSessionJpaEntity;
import com.example.tricktheai.infrastructure.persistence.GameSessionRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public class StartGameUseCase {

    private final GameSessionRepository repository;

    public StartGameUseCase(GameSessionRepository repository){
        this.repository = repository;
    }

    public UUID startNewGame(){
        GameSession newSession = GameSession.builder()
                .trustLevel(5)
                .paranoiaLevel(0)
                .active(true)
                .startedAt(LocalDateTime.now())
                .build();

        GameSessionJpaEntity entity = GameSessionMapper.toEntity(newSession);
        GameSessionJpaEntity saved = repository.save(entity);

        return saved.getId();
    }
}
