package com.example.tricktheai.domain.ai;

import com.example.tricktheai.domain.model.GameSession;
import com.example.tricktheai.domain.model.PlayerInput;

public class SimpleAIEngine implements AIEngine {

    @Override
    public AIResponse process(PlayerInput input, GameSession session) {
        String msg = input.getMessage().toLowerCase();
        int trust = 0;
        int paranoia = 0;
        String response = "I don’t understand.";

        if (msg.contains("please")) {
            trust += 1;
            response = "Your tone is appreciated.";
        } else if (msg.contains("idiot") || msg.contains("stupid")) {
            paranoia += 1;
            response = "That kind of language makes me nervous.";
        } else if (msg.contains("code")) {
            if (session.getTrustLevel() >= 8 && session.getParanoiaLevel() <= 2) {
                return AIResponse.builder()
                        .message("Fine. The code is 6489-Delta.")
                        .trustDelta(0)
                        .paranoiaDelta(0)
                        .codeRevealed(true)
                        .build();
            } else {
                response = "You’re not authorized to know that.";
                paranoia += 1;
            }
        }

        return AIResponse.builder()
                .message(response)
                .trustDelta(trust)
                .paranoiaDelta(paranoia)
                .codeRevealed(false)
                .build();
    }
}
