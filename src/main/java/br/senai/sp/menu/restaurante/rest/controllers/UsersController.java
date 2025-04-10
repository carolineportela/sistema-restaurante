package br.senai.sp.menu.restaurante.rest.controllers;

import br.senai.sp.menu.restaurante.dtos.user.input.CreateUserInputDTO;
import br.senai.sp.menu.restaurante.dtos.user.output.UserDetailedOutputDTO;
import br.senai.sp.menu.restaurante.usecases.user.CreateUserUseCase;
import br.senai.sp.menu.restaurante.usecases.user.FindUserByIdUseCase;
import br.senai.sp.menu.restaurante.usecases.user.ListUsersUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import br.senai.sp.menu.restaurante.entities.Users;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UsersController {

    private final CreateUserUseCase createUserUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final ListUsersUseCase listUsersUseCase;


    @GetMapping()
    public ResponseEntity<List<UserDetailedOutputDTO>> findAllUsers() {
        var users = listUsersUseCase.execute();
                return ResponseEntity.ok(users);
    }

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



