package com.example.Loja.de.roupas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenResponse {

    private String token;
    private Long expiresIn;
    private Boolean firstAccess;

}
