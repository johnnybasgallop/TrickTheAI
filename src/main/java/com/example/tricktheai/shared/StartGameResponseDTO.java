package com.example.tricktheai.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class StartGameResponseDTO {
    private UUID gameId;
    private String message;
}
