package com.GabreuDev.AteMil.Dtos.Response;

import com.GabreuDev.AteMil.Entities.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public record CorrecaoDTO(Long id, String redacao, String comentario, StatusEnum status, int nota) {

}
