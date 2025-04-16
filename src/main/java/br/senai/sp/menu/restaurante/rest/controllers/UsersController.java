package br.senai.sp.menu.restaurante.rest.controllers;

import br.senai.sp.menu.restaurante.dtos.user.input.CreateUserInputDTO;
import br.senai.sp.menu.restaurante.dtos.user.output.UserDetailedOutputDTO;
import br.senai.sp.menu.restaurante.rest.specs.UserControllerSpecs;
import br.senai.sp.menu.restaurante.usecases.user.CreateUserUseCase;
import br.senai.sp.menu.restaurante.usecases.user.FindUserByIdUseCase;
import br.senai.sp.menu.restaurante.usecases.user.ListUsersUseCase;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController implements UserControllerSpecs {

    private final CreateUserUseCase createUserUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final ListUsersUseCase listUsersUseCase;


    @GetMapping
    public List<UserDetailedOutputDTO> findAll() {
        return listUsersUseCase.execute();
    }

    @GetMapping("/{id}")
    public UserDetailedOutputDTO findById(@PathVariable UUID id) {
        return findUserByIdUseCase.find(id);
    }

    @PostMapping
    public void create(@RequestBody @Valid CreateUserInputDTO input) {
        createUserUseCase.execute(input);
}

}



