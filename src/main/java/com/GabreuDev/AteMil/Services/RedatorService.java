package com.GabreuDev.AteMil.Services;
import com.GabreuDev.AteMil.Entities.Correcao;
import com.GabreuDev.AteMil.Entities.Redator;
import com.GabreuDev.AteMil.Repositories.RedatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class RedatorService {

    private final RedatorRepository redatorRepository;

    private final CorrecaoService correcaoService;

    public Redator cadastrar(Redator redator){
        try {
            redatorRepository.save(redator);
        }catch (Exception e){
            throw new RuntimeException(format("erro ao cadastrar o redator "+ e));
        }
        return redator;
    }

    public void postar(Long id, Correcao redacao){
        correcaoService.postarRedacao(id, redacao);
    }

}
