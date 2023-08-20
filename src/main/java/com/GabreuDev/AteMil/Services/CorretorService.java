package com.GabreuDev.AteMil.Services;

import com.GabreuDev.AteMil.Entities.Correcao;
import com.GabreuDev.AteMil.Entities.Corretor;
import com.GabreuDev.AteMil.Repositories.CorretorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CorretorService {
    private final CorretorRepository corretorRepository;

    private final CorrecaoService correcaoService;
    public Corretor cadastrar(Corretor corretor){
        corretorRepository.save(corretor);
        return corretor;
    }
    public Correcao corrigirRedacao(Long id, Correcao correcao) {
        correcaoService.corrigirRedacao(id, correcao);
        return correcao;
    }
}
