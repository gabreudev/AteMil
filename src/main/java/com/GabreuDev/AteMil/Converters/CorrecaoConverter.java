package com.GabreuDev.AteMil.Converters;

import com.GabreuDev.AteMil.Dtos.Request.NovaRedacaoDTO;
import com.GabreuDev.AteMil.Dtos.Response.CorrecaoDTO;
import com.GabreuDev.AteMil.Entities.Correcao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CorrecaoConverter {
    public Correcao toEntity(CorrecaoDTO dto){

        return Correcao.builder()
                .id(dto.id())
                .redacao(dto.redacao())
                .build();
    }
    public CorrecaoDTO toDto(Correcao entity){
        return CorrecaoDTO.builder()
                .id(entity.getId())
                .comentario(entity.getComentario())
                .redacao(entity.getRedacao())
                .build();
    }
    public Correcao novaRedacaoToEntity(NovaRedacaoDTO dto){

        return Correcao.builder()
                .redacao(dto.redacao())
                .build();
    }
    public List<CorrecaoDTO> toListDto(List<Correcao> entityList){
        return entityList.stream().map(this::toDto).toList();
    }
}
