package com.GabreuDev.AteMil.Controllers;
import com.GabreuDev.AteMil.Entities.Correcao;
import com.GabreuDev.AteMil.Entities.Redator;
import com.GabreuDev.AteMil.Services.RedatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RequestMapping("/redator")
@RestController
@RequiredArgsConstructor
public class RedatorController {

    private final RedatorService redatorService;

    @PostMapping("")
    public ResponseEntity<Redator> cadastrarRedator(@RequestBody Redator redator) {
        Redator novoRedator = redatorService.cadastrar(redator);
        return ResponseEntity.ok(novoRedator);
    }

    @PostMapping("{id}/postar")
    public ResponseEntity<String> postarRedacao(@PathVariable Long id, @RequestBody Correcao redacao) {
        redatorService.postar(id, redacao);
        return ResponseEntity.ok("Redação postada com sucesso.");
    }
}

