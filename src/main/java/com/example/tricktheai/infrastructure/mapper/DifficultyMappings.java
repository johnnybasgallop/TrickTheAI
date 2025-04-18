package com.example.tricktheai.infrastructure.mapper;

import com.example.tricktheai.domain.model.GameSession;
import com.example.tricktheai.shared.DifficultyParams;
import com.example.tricktheai.shared.GameMode;
import lombok.RequiredArgsConstructor;

public class DifficultyMappings {

    public static DifficultyParams getDifficultyParams(GameSession session){
        GameMode difficulty = session.getDifficulty();
        DifficultyParams params = new DifficultyParams();
        switch (difficulty){
            case Easy:
                params.setRequiredTrust(6);
                params.setRequiredParanoia(4);
                break;
            case Medium:
                params.setRequiredTrust(8);
                params.setRequiredParanoia(3);
                break;
            case Hard:
                params.setRequiredTrust(10);
                params.setRequiredParanoia(2);
                break;
            case Impossible:
                params.setRequiredTrust(11);
                params.setRequiredParanoia(0);
        }

        return params;
    }
}
