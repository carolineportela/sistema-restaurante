/**
 * Caso de uso responsável por autenticar o usuário e gerar um JWT.
 *
 * Etapas do processo:
 * 1. Recebe os dados do usuário (username e password) via LoginInputDTO.
 * 2. Autentica o usuário usando o AuthenticationManager do Spring Security.
 * 3. Gera um token JWT com base no usuário autenticado.
 * 4. Retorna esse token encapsulado em um LoginOutputDTO.
 */

//package br.senai.sp.menu.restaurante.usecases.auth;
//
//import br.senai.sp.menu.restaurante.dtos.auth.input.LoginInputDTO;
//import br.senai.sp.menu.restaurante.dtos.auth.output.LoginOutputDTO;
//import br.senai.sp.menu.restaurante.repositories.user.UsersRepository;
//import br.senai.sp.menu.restaurante.security.dto.UsersDetailsDTO;
//import br.senai.sp.menu.restaurante.security.service.JwtTokenService;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LoginUseCase {
//
//    private final UsersRepository usersRepository;
//    private final JwtTokenService jwtTokenService;
//
//    public LoginUseCase(UsersRepository usersRepository, JwtTokenService jwtTokenService) {
//        this.usersRepository = usersRepository;
//        this.jwtTokenService = jwtTokenService;
//    }
//
//    public LoginOutputDTO execute(LoginInputDTO loginInput) {
//
//        // Autentica o usuário (se necessário lemrar de substituir pelo AuthenticationManager)
//        Authentication authentication = new UsernamePasswordAuthenticationToken(
//                loginInput.getEmail(), loginInput.getPassword()
//        );
//
//        // Exemplo usando manualmente o repositório (não seguro em produção)
//        var user = usersRepository.findByEmail(loginInput.getEmail())
//                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
//
//        if (!user.getPassword().equals(loginInput.getPassword())) {
//            throw new RuntimeException("Senha inválida");
//        }
//
//        // Gera o token JWT
//        String token = jwtTokenService.generateToken(new UsersDetailsDTO(user));
//
//        // Retorna o DTO de saída com o token
//        return new LoginOutputDTO(token);
//    }
//
//}

package br.senai.sp.menu.restaurante.usecases.auth;

import br.senai.sp.menu.restaurante.dtos.auth.input.LoginInputDTO;
import br.senai.sp.menu.restaurante.dtos.auth.output.LoginOutputDTO;
import br.senai.sp.menu.restaurante.repositories.user.UsersRepository;
import br.senai.sp.menu.restaurante.security.dto.UsersDetailsDTO;
import br.senai.sp.menu.restaurante.security.service.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
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





