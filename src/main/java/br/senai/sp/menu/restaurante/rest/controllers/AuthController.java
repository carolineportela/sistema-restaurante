package br.senai.sp.menu.restaurante.rest.controllers;

import br.senai.sp.menu.restaurante.dtos.auth.input.LoginInputDTO;
import br.senai.sp.menu.restaurante.dtos.auth.output.LoginOutputDTO;
import br.senai.sp.menu.restaurante.rest.specs.AuthControllerSpecs;
import br.senai.sp.menu.restaurante.usecases.auth.LoginUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController implements AuthControllerSpecs {

    private final LoginUseCase loginUseCase;

    @Override
    @PostMapping("/login")
    public LoginOutputDTO login(@RequestBody @Valid LoginInputDTO loginInput) {
        return loginUseCase.execute(loginInput);
    }
}
