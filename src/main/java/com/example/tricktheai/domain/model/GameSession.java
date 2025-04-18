package com.example.tricktheai.domain.model;

import com.example.tricktheai.shared.GameMode;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameSession {
    private UUID id;
    private int trustLevel;
    private int paranoiaLevel;
    private boolean active;
    private LocalDateTime startedAt;
    private GameMode difficulty;
}
