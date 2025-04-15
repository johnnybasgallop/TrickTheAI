package com.example.tricktheai.infrastructure.mapper;

import com.example.tricktheai.domain.model.GameSession;
import com.example.tricktheai.infrastructure.persistence.GameSessionJpaEntity;

public class GameSessionMapper {

    public static GameSessionJpaEntity toEntity(GameSession session){
     if (session == null) return  null;

     return GameSessionJpaEntity.builder()
             .id(session.getId())
             .trustLevel(session.getTrustLevel())
             .paranoiaLevel(session.getParanoiaLevel())
             .active(session.isActive())
             .startedAt(session.getStartedAt())
             .build();
    }

    public static GameSession toDomain(GameSession entity){
        if(entity == null) return null;

        return GameSession.builder()
                .id(entity.getId())
                .trustLevel(entity.getTrustLevel())
                .paranoiaLevel(entity.getParanoiaLevel())
                .active(entity.isActive())
                .startedAt(entity.getStartedAt())
                .build();
    }
}
