package com.example.tricktheai.shared;

import lombok.Builder;
import lombok.Data;

import java.net.http.HttpResponse;
import java.util.UUID;
@Data
@Builder
public class DeleteGameResponseDTO {
    private Boolean success;
}
