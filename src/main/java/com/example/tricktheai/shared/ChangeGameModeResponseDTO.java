package com.example.tricktheai.shared;

import lombok.Data;

import java.util.UUID;
@Data
public class ChangeGameModeResponseDTO {
    private UUID gameId;
    private GameMode difficulty;
}
