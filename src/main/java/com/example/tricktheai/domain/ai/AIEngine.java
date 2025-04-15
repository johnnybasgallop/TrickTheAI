package com.example.tricktheai.domain.ai;

import com.example.tricktheai.domain.model.GameSession;
import com.example.tricktheai.domain.model.PlayerInput;

public interface AIEngine {
    AIResponse process(PlayerInput input, GameSession session);
}
