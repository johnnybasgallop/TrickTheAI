package com.example.tricktheai.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DifficultyParams {
    private int requiredTrust;
    private int RequiredParanoia;
}
