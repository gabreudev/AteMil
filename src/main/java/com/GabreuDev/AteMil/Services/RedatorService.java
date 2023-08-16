package com.GabreuDev.AteMil.Services;

import com.GabreuDev.AteMil.Entities.Correcao;
import com.GabreuDev.AteMil.Entities.Redator;
import com.GabreuDev.AteMil.Repositories.RedatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedatorService {

    @Autowired
    private RedatorRepository redatorRepository;

    @Autowired
    private CorrecaoService correcaoService;

    public Redator cadastrar(Redator redator){
        redatorRepository.save(redator);
        return redator;
    }

    public void postar(Long id, Correcao redacao){
        correcaoService.postarRedacao(id, redacao);

    }
}
