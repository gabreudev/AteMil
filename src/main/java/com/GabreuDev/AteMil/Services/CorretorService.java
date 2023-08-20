package com.GabreuDev.AteMil.Services;

import com.GabreuDev.AteMil.Entities.Correcao;
import com.GabreuDev.AteMil.Entities.Corretor;
import com.GabreuDev.AteMil.Repositories.CorrecaoRepository;
import com.GabreuDev.AteMil.Repositories.CorretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class CorretorService {
    @Autowired
    private CorretorRepository corretorRepository;
    @Autowired
    private CorrecaoService correcaoService;
    public Corretor cadastrar(Corretor corretor){
        corretorRepository.save(corretor);
        return corretor;
    }
    public Correcao corrigirRedacao(Long id, Correcao correcao) {
        correcaoService.corrigirRedacao(id, correcao);
        return correcao;
    }
}
