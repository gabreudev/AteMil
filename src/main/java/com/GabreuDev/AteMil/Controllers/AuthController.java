package com.GabreuDev.AteMil.Controllers;

import com.GabreuDev.AteMil.Dtos.Request.LoginDTO;
import com.GabreuDev.AteMil.Entities.Corretor;
import com.GabreuDev.AteMil.Services.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    @PostMapping("/login")
    public String Login(@RequestBody LoginDTO login){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(login.username(), login.senha());
        Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

    var username = (Corretor)authenticate.getPrincipal();


    return tokenService.gerarToken(username);

    }

}
