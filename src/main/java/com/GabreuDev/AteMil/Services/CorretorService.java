package com.GabreuDev.AteMil.Services;

import com.GabreuDev.AteMil.Entities.Correcao;
import com.GabreuDev.AteMil.Entities.Corretor;
import com.GabreuDev.AteMil.Repositories.CorrecaoRepository;
import com.GabreuDev.AteMil.Repositories.CorretorRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class CorretorService {

    private CorretorRepository corretorRepository;

    private CorrecaoService correcaoService;
    public Corretor cadastrar(Corretor corretor){
        corretorRepository.save(corretor);
        return corretor;
    }
    public Correcao atualizarDados(Long id, Correcao correcao) {
        correcaoService.corrigirRedacao(id, correcao);
        return correcao;
    }
}
