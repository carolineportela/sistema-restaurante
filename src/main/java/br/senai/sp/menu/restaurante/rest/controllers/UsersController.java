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



