package com.GabreuDev.AteMil.Services;
import com.GabreuDev.AteMil.Converters.CorrecaoConverter;
import com.GabreuDev.AteMil.Converters.RedatorConverter;
import com.GabreuDev.AteMil.Dtos.Request.NovaRedacaoDTO;
import com.GabreuDev.AteMil.Dtos.Request.RedatorDTO;
import com.GabreuDev.AteMil.Repositories.RedatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class RedatorService {

    private final RedatorConverter redatorConverter;
    private final CorrecaoConverter correcaoConverter;
    private final RedatorRepository redatorRepository;

    private final CorrecaoService correcaoService;

    public RedatorDTO cadastrar(RedatorDTO redator){
        try {
            redatorRepository.save(redatorConverter.toEntity(redator));
        }catch (Exception e){
            throw new RuntimeException(format("erro ao cadastrar o redator "+ e));
        }
        return redator;
    }

    public void postar(Long id, NovaRedacaoDTO redacao){
        correcaoService.postarRedacao(id, correcaoConverter.novaRedacaoToEntity(redacao));
    }

}
