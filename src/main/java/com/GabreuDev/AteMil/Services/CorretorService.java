package com.GabreuDev.AteMil.Services;

import com.GabreuDev.AteMil.Converters.CorrecaoConverter;
import com.GabreuDev.AteMil.Converters.CorretorConverter;
import com.GabreuDev.AteMil.Dtos.Request.CorretorDTO;
import com.GabreuDev.AteMil.Dtos.Response.CorrecaoDTO;
import com.GabreuDev.AteMil.Entities.Correcao;
import com.GabreuDev.AteMil.Entities.Corretor;
import com.GabreuDev.AteMil.Entities.StatusEnum;
import com.GabreuDev.AteMil.Repositories.CorretorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CorretorService {
    private final CorretorRepository corretorRepository;
    private final CorrecaoConverter correcaoConverter;
    private final CorretorConverter corretorConverter;
    private final CorrecaoService correcaoService;
    public CorretorDTO cadastrar(CorretorDTO corretor){
        corretorRepository.save(corretorConverter.toEntity(corretor));
        return corretor;
    }
    public CorrecaoDTO corrigirRedacao(Long id, CorrecaoDTO correcao) {
        return correcaoService.corrigirRedacao(id, correcaoConverter.toEntity(correcao));

    }
    public List<CorrecaoDTO> listarRedacoesPendentes(StatusEnum status){
        List<CorrecaoDTO> lista = correcaoService.listarRedacoesPendentes(status.NAOCORRIGIDA);
        return lista;
    }
}