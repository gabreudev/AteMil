package com.GabreuDev.AteMil.Dtos.Response;

import com.GabreuDev.AteMil.Entities.StatusEnum;
import lombok.Builder;

@Builder
public record CorrecaoDTO(Long id, String redacao, String comentario, StatusEnum status, int nota) {

}
