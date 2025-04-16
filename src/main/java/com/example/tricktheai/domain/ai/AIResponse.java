package com.example.tricktheai.domain.ai;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AIResponse {
    private String message;
    private int trustDelta;
    private int paranoiaDelta;
    private boolean codeRevealed;
}
