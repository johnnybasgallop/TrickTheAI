package com.example.tricktheai.shared;

import lombok.Data;

import java.util.UUID;

@Data
public class SendMessageRequestDTO {
    private UUID gameId;
    private String message;
}
