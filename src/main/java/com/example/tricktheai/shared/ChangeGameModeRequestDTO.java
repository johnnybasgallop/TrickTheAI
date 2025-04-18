package com.example.tricktheai.shared;

import lombok.Data;
import org.w3c.dom.Text;

import java.util.UUID;
@Data
public class ChangeGameModeRequestDTO {
    private UUID gameId;
    private String gameMode;
}