package br.senai.sp.menu.restaurante.rest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.senai.sp.menu.restaurante.entities.Users;
import br.senai.sp.menu.restaurante.services.UsersService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UsersController {

    private UsersService usersService;

    public UsersController(UsersService userService) {
        this.usersService = userService;
    }

    //  lisar todos
    @GetMapping
    public ResponseEntity<List<Users>> listUsers() {
        var users = usersService.listUsers();

        return ResponseEntity.ok(users);
    }

    //  buscar um usuário pelo ID
    @GetMapping("/{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable("userId") String userId) {
        Optional<Users> user = usersService.getUserById(userId);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
