package com.GabreuDev.AteMil.Services;

import com.GabreuDev.AteMil.Entities.Correcao;
import com.GabreuDev.AteMil.Entities.StatusEnum;
import com.GabreuDev.AteMil.Repositories.CorrecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorrecaoService {

    @Autowired
    private CorrecaoRepository correcaoRepository;
    @Autowired
    private RedatorService redatorService;

    public Correcao postarRedacao(Long id, Correcao redacao){
    Correcao correcao = correcaoRepository.save(redacao);
    return correcao;
    }

    public Correcao corrigirRedacao(Long id, Correcao correcao){
        if (!correcaoRepository.existsById(id)) {
            throw new RuntimeException("id invalido");
        }
        correcao.setId(id);
        correcao.setStatus(StatusEnum.CORRIGIDA);
        correcao = correcaoRepository.save(correcao);
        redatorService.setarRedacoes(id, correcao);
        return correcao;
    }
}
