package com.example.tricktheai.application;

import com.example.tricktheai.infrastructure.persistence.GameSessionJpaEntity;
import com.example.tricktheai.infrastructure.persistence.GameSessionRepository;
import com.example.tricktheai.shared.DeleteGameResponseDTO;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteGameUseCase {

    private final GameSessionRepository repository;

    public DeleteGameResponseDTO deleteGame(UUID gameId){
        GameSessionJpaEntity entity = repository.findById(gameId).orElseThrow(() -> new IllegalStateException("cant find game by id"));
        repository.delete(entity);

        return DeleteGameResponseDTO.builder().success(true).build();
    }

}
