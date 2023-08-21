package com.GabreuDev.AteMil.Dtos.Request;

import lombok.Builder;

@Builder
public record CorretorDTO(String nome, String email) {
}
