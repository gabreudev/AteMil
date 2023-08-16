package com.GabreuDev.AteMil.Services;

import com.GabreuDev.AteMil.Entities.Corretor;
import com.GabreuDev.AteMil.Repositories.CorretorRepository;
import org.springframework.stereotype.Service;

@Service
public class CorretorService {

    private CorretorRepository corretorRepository;

    public Corretor cadastrar(Corretor corretor){
        corretorRepository.save(corretor);
        return corretor;
    }
}
