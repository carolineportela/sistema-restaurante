/**
 * caso de uso responsável por autenticar o usuário e gerar um JWT
 *
 * etapas do processo:
 * 1. recebe os dados do usuário (email e password) via LoginInputDTO.
 * 2. autentica o usuário usando o AuthenticationManager do Spring Security.
 * 3. gera um token JWT com base no usuário autenticado.
 * 4. retorna esse token encapsulado em um LoginOutputDTO.
 */

package br.senai.sp.menu.restaurante.usecases.auth;

import br.senai.sp.menu.restaurante.dtos.auth.input.LoginInputDTO;
import br.senai.sp.menu.restaurante.dtos.auth.output.LoginOutputDTO;
import br.senai.sp.menu.restaurante.security.dto.UsersDetailsDTO;
import br.senai.sp.menu.restaurante.security.service.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUseCase {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;

    public LoginOutputDTO execute(LoginInputDTO input) {
        var authRequest = new UsernamePasswordAuthenticationToken(
                input.getEmail(), input.getPassword()
        );

        var auth = this.authenticationManager.authenticate(authRequest);

        var userDetails = (UsersDetailsDTO) auth.getPrincipal();

        var token = this.jwtTokenService.generateToken(userDetails);

        return new LoginOutputDTO(token);

    }
}





