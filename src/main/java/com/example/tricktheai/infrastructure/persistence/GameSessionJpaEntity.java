package com.example.tricktheai.infrastructure.persistence;

import com.example.tricktheai.shared.GameMode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameSessionJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private int trustLevel;
    private int paranoiaLevel;
    private boolean active;
    private LocalDateTime startedAt;

    @Enumerated(EnumType.STRING)
    private GameMode difficulty;
}
