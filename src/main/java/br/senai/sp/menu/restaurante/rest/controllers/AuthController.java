/**
 * Controller responsável por expor o endpoint de login.
 *
 * Recebe as credenciais do usuário via POST e, se estiverem corretas,
 * retorna um token JWT.
 */

package br.senai.sp.menu.restaurante.rest.controllers;

import br.senai.sp.menu.restaurante.dtos.auth.input.LoginInputDTO;
import br.senai.sp.menu.restaurante.dtos.auth.output.LoginOutputDTO;
import br.senai.sp.menu.restaurante.usecases.auth.LoginUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final LoginUseCase loginUseCase;

    public AuthController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    /**
     * Endpoint de login: recebe username e password e retorna um token JWT.
     *
     * Exemplo de requisição:
     * POST /v1/auth/login
     * {
     *   "username": "admin",
     *   "password": "1234"
     * }
     */

    @PostMapping("/login")
    public ResponseEntity<LoginOutputDTO> login(@RequestBody LoginInputDTO loginInput) {
        var tokenResponse = loginUseCase.execute(loginInput);
        return ResponseEntity.ok(tokenResponse);
    }
}
