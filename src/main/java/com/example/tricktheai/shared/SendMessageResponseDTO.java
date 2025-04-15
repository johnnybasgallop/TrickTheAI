package com.example.tricktheai.shared;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SendMessageResponseDTO {
    private String aiMessage;
    private int trustLevel;
    private int paranoiaLevel;
    private boolean codeRevealed;
}

