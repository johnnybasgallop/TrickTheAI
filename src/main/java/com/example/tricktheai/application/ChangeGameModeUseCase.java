package com.example.tricktheai.application;

import com.example.tricktheai.infrastructure.persistence.GameSessionJpaEntity;
import com.example.tricktheai.infrastructure.persistence.GameSessionRepository;
import com.example.tricktheai.shared.ChangeGameModeRequestDTO;
import com.example.tricktheai.shared.ChangeGameModeResponseDTO;
import com.example.tricktheai.shared.GameMode;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class ChangeGameModeUseCase {
    private final GameSessionRepository repository;

    public ChangeGameModeResponseDTO changeGameMode(UUID gameId, GameMode mode){
        GameSessionJpaEntity session = repository.findById(gameId)
                .orElseThrow(() -> new IllegalArgumentException("No item found"));

        session.setDifficulty(mode);
        repository.save(session);

        return ChangeGameModeResponseDTO.builder()
                .gameId(session.getId())
                .difficulty(session.getDifficulty())
                .build();
    }

}
