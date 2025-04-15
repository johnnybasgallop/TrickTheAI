package com.example.tricktheai.application;

import com.example.tricktheai.domain.ai.AIEngine;
import com.example.tricktheai.domain.ai.AIResponse;
import com.example.tricktheai.domain.model.GameSession;
import com.example.tricktheai.domain.model.PlayerInput;
import com.example.tricktheai.infrastructure.mapper.GameSessionMapper;
import com.example.tricktheai.infrastructure.persistence.GameSessionJpaEntity;
import com.example.tricktheai.infrastructure.persistence.GameSessionRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class SendMessageUseCase {
    private final GameSessionRepository gameSessionRepository;
    private final AIEngine aiEngine;

    public AIResponse handleMessage(UUID gameId, PlayerInput input){
        GameSessionJpaEntity entity = gameSessionRepository.findById(gameId).orElseThrow(() -> new IllegalArgumentException("game id not found"));

        GameSession session = GameSessionMapper.toDomain(entity);

        AIResponse response = aiEngine.process(input, session);

        session.setTrustLevel(session.getTrustLevel() + response.getTrustDelta());
        session.setParanoiaLevel(session.getParanoiaLevel() + response.getParanoiaDelta());

        if(response.isCodeRevealed()){
            session.setActive(false);
        }

        gameSessionRepository.save(GameSessionMapper.toEntity(session));

        return response;

    }

}
