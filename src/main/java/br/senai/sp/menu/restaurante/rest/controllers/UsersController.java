package br.senai.sp.menu.restaurante.rest.controllers;

import br.senai.sp.menu.restaurante.dtos.user.input.CreateUserInputDTO;
import br.senai.sp.menu.restaurante.dtos.user.output.UserDetailedOutputDTO;
import br.senai.sp.menu.restaurante.usecases.user.CreateUserUseCase;
import br.senai.sp.menu.restaurante.usecases.user.FindUserByIdUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.senai.sp.menu.restaurante.entities.Users;
//import br.senai.sp.menu.restaurante.services.UsersService;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UsersController {

    private final CreateUserUseCase createUserUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;


    @GetMapping("/{id}")
    public UserDetailedOutputDTO findById(@PathVariable Long id) {
        return findUserByIdUseCase.execute(id);
    }
    @PostMapping()
    public ResponseEntity<Void> createUser(@RequestBody CreateUserInputDTO input) {
        createUserUseCase.execute(input);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}


//    private UsersService usersService;
//
//    public UsersController(UsersService userService) {
//        this.usersService = userService;
//    }
//
//    //  listar todos
//    @GetMapping
//    public ResponseEntity<List<Users>> listUsers() {
//        var users = usersService.listUsers();
//
//        return ResponseEntity.ok(users);
//    }
//
//    //  buscar um usuário pelo ID
//    @GetMapping("/{userId}")
//    public ResponseEntity<Users> getUserById(@PathVariable("userId") String userId) {
//        Optional<Users> user = usersService.getUserById(userId);
//
//        if (user.isPresent()) {
//            return ResponseEntity.ok(user.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }



