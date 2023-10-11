package com.GabreuDev.AteMil.Dtos.Request;

import lombok.Builder;

@Builder
public record LoginDTO(String senha, String username) {
}
