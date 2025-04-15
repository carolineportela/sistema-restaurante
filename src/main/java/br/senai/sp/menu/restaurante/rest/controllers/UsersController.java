package br.senai.sp.menu.restaurante.rest.controllers;

import br.senai.sp.menu.restaurante.dtos.user.input.CreateUserInputDTO;
import br.senai.sp.menu.restaurante.dtos.user.output.UserDetailedOutputDTO;
import br.senai.sp.menu.restaurante.usecases.user.CreateUserUseCase;
import br.senai.sp.menu.restaurante.usecases.user.FindUserByIdUseCase;
import br.senai.sp.menu.restaurante.usecases.user.ListUsersUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import br.senai.sp.menu.restaurante.entities.Users;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<UserDetailedOutputDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(findUserByIdUseCase.find(id));
    }


    @PostMapping()
    public ResponseEntity<Void> createUser(@RequestBody @Valid CreateUserInputDTO input) {
        createUserUseCase.execute(input);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}



