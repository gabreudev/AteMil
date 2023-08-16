package com.GabreuDev.AteMil.Services;

import com.GabreuDev.AteMil.Entities.Correcao;
import com.GabreuDev.AteMil.Repositories.CorrecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorrecaoService {

    @Autowired
    private CorrecaoRepository correcaoRepository;

    public void postarRedacao(Long id, Correcao redacao){
    correcaoRepository.save(redacao);
    }
}
