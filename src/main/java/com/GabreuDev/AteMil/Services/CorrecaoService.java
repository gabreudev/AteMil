package com.GabreuDev.AteMil.Services;

import com.GabreuDev.AteMil.Converters.CorrecaoConverter;
import com.GabreuDev.AteMil.Dtos.Response.CorrecaoDTO;
import com.GabreuDev.AteMil.Entities.Correcao;
import com.GabreuDev.AteMil.Entities.Redator;
import com.GabreuDev.AteMil.Entities.StatusEnum;
import com.GabreuDev.AteMil.Handlers.BusinessException;
import com.GabreuDev.AteMil.Handlers.InvalidIdException;
import com.GabreuDev.AteMil.Handlers.SaveErrorException;
import com.GabreuDev.AteMil.Repositories.CorrecaoRepository;
import com.GabreuDev.AteMil.Repositories.RedatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CorrecaoService {
    private final CorrecaoRepository correcaoRepository;
    private final RedatorRepository redatorRepository;
    private final CorrecaoConverter correcaoConverter;


    public List<CorrecaoDTO> listarRedacoesPendentes(StatusEnum status) {
        List<Correcao> lista = correcaoRepository.findAllByStatus(StatusEnum.NAOCORRIGIDA);
        return correcaoConverter.toListDto(lista);
    }

    public Correcao postarRedacao(Long id, Correcao redacao){
        redacao = setarRedacoes(id, redacao);
        try {
            correcaoRepository.save(redacao);
            return redacao;
        }catch (Exception e){
            throw new SaveErrorException("redação");
        }

    }

    public CorrecaoDTO corrigirRedacao(Long id, Correcao correcao){
        if (!correcaoRepository.existsById(id)) {
            throw new InvalidIdException("redação");
        }
        correcao.setId(id);
        correcao.setStatus(StatusEnum.CORRIGIDA);
        correcao = correcaoRepository.save(correcao);
        return correcaoConverter.toDto(correcao);
    }
    public Correcao setarRedacoes(Long id, Correcao correcao){
        if (correcaoRepository.existsById(id)){
                Optional<Redator> optionalRedator = redatorRepository.findById(id);
                Redator redator = optionalRedator.get();
                correcao.setStatus(StatusEnum.NAOCORRIGIDA);
                correcaoRepository.save(correcao);
                redator.getCorrecao().add(correcao);
                redatorRepository.save(redator);
                return correcao;
        }else {
            throw new InvalidIdException("redação");
        }
    }

}