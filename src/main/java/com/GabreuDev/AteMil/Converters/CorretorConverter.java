package com.GabreuDev.AteMil.Converters;

import com.GabreuDev.AteMil.Dtos.Request.CorretorDTO;
import com.GabreuDev.AteMil.Entities.Corretor;
import org.springframework.stereotype.Component;


@Component
public class CorretorConverter {
    public Corretor toEntity(CorretorDTO dto){

        return Corretor.builder()
                .nome(dto.nome())
                .email(dto.email())
                .username(dto.username())
                .senha(dto.senha())
                .build();
    }
    public CorretorDTO toDto(Corretor entity){
        return CorretorDTO.builder()
                .nome(entity.getNome())
                .email(entity.getEmail())
                .username(entity.getUsername())
                .senha(entity.getSenha())
                .build();
    }
}
