package com.GabreuDev.AteMil.Converters;

import com.GabreuDev.AteMil.Dtos.Request.CorretorDTO;
import com.GabreuDev.AteMil.Dtos.Request.RedatorDTO;
import com.GabreuDev.AteMil.Entities.Corretor;
import com.GabreuDev.AteMil.Entities.Redator;

public class RedatorConverter {
    public Redator toEntity(RedatorDTO dto){
        return Redator.builder()
                .nome(dto.nome())
                .email(dto.email())
                .build();
    }
    public RedatorDTO toDto(Redator entity){
        return RedatorDTO.builder()
                .nome(entity.getNome())
                .email(entity.getEmail())
                .build();
    }
}
