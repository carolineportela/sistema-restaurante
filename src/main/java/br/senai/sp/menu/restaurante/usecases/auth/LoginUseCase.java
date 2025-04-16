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





