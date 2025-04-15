package com.example.tricktheai.api;

import com.example.tricktheai.application.SendMessageUseCase;
import com.example.tricktheai.application.StartGameUseCase;
import com.example.tricktheai.domain.model.PlayerInput;
import com.example.tricktheai.shared.SendMessageRequestDTO;
import com.example.tricktheai.shared.SendMessageResponseDTO;
import com.example.tricktheai.shared.StartGameResponseDTO;
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

        return ResponseEntity.ok(new SendMessageResponseDTO(
                response.getMessage(),
                response.getTrustDelta(),
                response.getParanoiaDelta(),
                response.isCodeRevealed()
        ));
    }

}
