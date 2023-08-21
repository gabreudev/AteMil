package com.GabreuDev.AteMil.Services;

import com.GabreuDev.AteMil.Converters.CorrecaoConverter;
import com.GabreuDev.AteMil.Dtos.Response.CorrecaoDTO;
import com.GabreuDev.AteMil.Entities.Correcao;
import com.GabreuDev.AteMil.Entities.Redator;
import com.GabreuDev.AteMil.Entities.StatusEnum;
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
        correcaoRepository.save(redacao);
        return redacao;
    }

    public CorrecaoDTO corrigirRedacao(Long id, Correcao correcao){
        if (!correcaoRepository.existsById(id)) {
            throw new RuntimeException("id invalido");
        }
        correcao.setId(id);
        correcao.setStatus(StatusEnum.CORRIGIDA);
        correcao = correcaoRepository.save(correcao);
        return correcaoConverter.toDto(correcao);
    }
    public Correcao setarRedacoes(Long id, Correcao correcao){
        Optional<Redator> optionalRedator = redatorRepository.findById(id);

        if (optionalRedator.isPresent()) {
            Redator redator = optionalRedator.get();
            correcao.setStatus(StatusEnum.NAOCORRIGIDA);
            correcaoRepository.save(correcao);
            redator.getCorrecao().add(correcao);
            redatorRepository.save(redator);
            return correcao;
        } else {
            throw new RuntimeException("id do redator não encontrado!");
        }
    }

}