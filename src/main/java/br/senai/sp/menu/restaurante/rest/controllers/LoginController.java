package br.senai.sp.menu.restaurante.rest.controllers;

import br.senai.sp.menu.restaurante.security.service.JwtService;
import br.senai.sp.menu.restaurante.entities.Users;
import br.senai.sp.menu.restaurante.repositories.user.UsersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/v1/auth")
public class LoginController {

    private final JwtService jwtService;
    private final UsersRepository usersRepository;

    public LoginController(JwtService jwtService, UsersRepository usersRepository) {
        this.jwtService = jwtService;
        this.usersRepository = usersRepository;
    }

    // Endpoint para login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        // Verificar se o usuário existe
        Optional<Users> userOptional = usersRepository.findByUsername(username);

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(404).body("Usuário não encontrado");
        }

        Users user = userOptional.get();

        // Validar senha (aqui, você pode usar algo como bcrypt para comparar as senhas de forma segura)
//        if (!user.getPassword().equals(password)) {
//            return ResponseEntity.status(401).body("Senha incorreta");
//        }


        if (!BCrypt.checkpw(password, user.getPassword())) {
            return ResponseEntity.status(401).body("Senha incorreta");
        }


        // Gerar o token JWT
        String token = jwtService.generateToken(username);

        return ResponseEntity.ok(token);  // Retorna o token para o cliente
    }
}
