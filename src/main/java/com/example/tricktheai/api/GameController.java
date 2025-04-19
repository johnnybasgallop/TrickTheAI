package com.example.tricktheai.api;

import com.example.tricktheai.application.ChangeGameModeUseCase;
import com.example.tricktheai.application.DeleteGameUseCase;
import com.example.tricktheai.application.SendMessageUseCase;
import com.example.tricktheai.application.StartGameUseCase;
import com.example.tricktheai.domain.model.PlayerInput;
import com.example.tricktheai.infrastructure.persistence.GameSessionRepository;
import com.example.tricktheai.shared.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final StartGameUseCase startGameUseCase;
    private final SendMessageUseCase sendMessageUseCase;
    private final GameSessionRepository gameSessionRepository;
    private final ChangeGameModeUseCase changeGameModeUseCase;
    private final DeleteGameUseCase deleteGameUseCase;

    @PostMapping("/start")
    public ResponseEntity<StartGameResponseDTO> startGame(){
        UUID newGameId = startGameUseCase.startNewGame();
        StartGameResponseDTO response = new StartGameResponseDTO(
                newGameId,
                "Game Started Successfully"
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/message")
    public ResponseEntity<SendMessageResponseDTO> sendMessage(@RequestBody SendMessageRequestDTO request){
        var response = sendMessageUseCase.handleMessage(request.getGameId(), new PlayerInput(request.getMessage()));

        var session = gameSessionRepository.findById(request.getGameId()).orElseThrow();

        return ResponseEntity.ok(new SendMessageResponseDTO(
                response.getMessage(),
                response.getTrustDelta(),
                response.getParanoiaDelta(),
                session.getTrustLevel(),
                session.getParanoiaLevel(),
                response.isCodeRevealed()
        ));
    }

    @PostMapping("/difficulty")
    public ResponseEntity<ChangeGameModeResponseDTO> changeDifficulty(@RequestBody ChangeGameModeRequestDTO request){

        ChangeGameModeResponseDTO response = changeGameModeUseCase.changeGameMode(request.getGameId(), GameMode.valueOf(request.getGameMode()));

        return ResponseEntity.ok(response);
    }

    @PostMapping("/delete")
    public ResponseEntity<DeleteGameResponseDTO> deleteGame(@RequestBody DeleteGameRequestDTO request){
        DeleteGameResponseDTO res = deleteGameUseCase.deleteGame(request.getGameId());
        return ResponseEntity.ok(res);
    }
}
