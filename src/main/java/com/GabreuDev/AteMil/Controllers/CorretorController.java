package com.GabreuDev.AteMil.Controllers;

import com.GabreuDev.AteMil.Entities.Correcao;
import com.GabreuDev.AteMil.Entities.Corretor;
import com.GabreuDev.AteMil.Entities.Redator;
import com.GabreuDev.AteMil.Entities.StatusEnum;
import com.GabreuDev.AteMil.Services.CorretorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/corretor")
@RequiredArgsConstructor
public class CorretorController {

    private final CorretorService corretorService;

    @PostMapping()
    public ResponseEntity<Corretor> cadastrarCorretor(@RequestBody Corretor corretor) {
        Corretor novoCorretor = corretorService.cadastrar(corretor);
        return ResponseEntity.ok(novoCorretor);
    }

    @PostMapping("{id}/corrigir")
    public ResponseEntity<Correcao> corrigirRedacao(@PathVariable Long id, @RequestBody Correcao correcao) {
        Correcao correcaoCorrigida = corretorService.corrigirRedacao(id, correcao);
        return ResponseEntity.ok(correcaoCorrigida);
    }
    @GetMapping("")
    public ResponseEntity<List<Correcao>> listarRedacoesPendentes(){
        StatusEnum status = StatusEnum.NAOCORRIGIDA;
        List<Correcao> lista = corretorService.listarRedacoesPendentes(status);
        return ResponseEntity.ok(lista);
    }

}

