package com.example.tricktheai.api;

import com.example.tricktheai.application.StartGameUseCase;
import com.example.tricktheai.shared.StartGameResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final StartGameUseCase startGameUseCase;

    @PostMapping("/start")
    public ResponseEntity<StartGameResponseDTO> startGame(){
        UUID newGameId = startGameUseCase.startNewGame();
        StartGameResponseDTO response = new StartGameResponseDTO(
                newGameId,
                "Game Started Successfully"
        );

        return ResponseEntity.ok(response);
    }

}
