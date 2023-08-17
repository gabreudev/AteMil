package com.GabreuDev.AteMil.Services;
import com.GabreuDev.AteMil.Entities.Correcao;
import com.GabreuDev.AteMil.Entities.Redator;
import com.GabreuDev.AteMil.Repositories.RedatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void setarRedacoes(Long id, Correcao correcao){
        Optional<Redator> optionalRedator = redatorRepository.findById(id);

        if (optionalRedator.isPresent()) {
            Redator redator = optionalRedator.get();
            List<Correcao> lista = redator.getCorrecao();
            lista.add(correcao);
            redator.setCorrecao(lista);
            redatorRepository.save(redator);
        } else {
            throw new RuntimeException("id do redator não encontrado!");
        }
    }


    public void postar(Long id,Long idRedator, Correcao redacao){
        Correcao correcao = correcaoService.postarRedacao(id, redacao);
    }
}
