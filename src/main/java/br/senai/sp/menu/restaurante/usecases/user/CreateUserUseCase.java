package br.senai.sp.menu.restaurante.usecases.user;

import br.senai.sp.menu.restaurante.dtos.user.input.CreateUserInputDTO;
import br.senai.sp.menu.restaurante.entities.Users;
import br.senai.sp.menu.restaurante.enums.UserRole;
import br.senai.sp.menu.restaurante.errors.exceptions.DuplicatedResourceException;
import br.senai.sp.menu.restaurante.mappers.users.UserMapper;
import br.senai.sp.menu.restaurante.repositories.user.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public void execute(CreateUserInputDTO input) {

        if (usersRepository.existsByEmail(input.getEmail())) {
            throw new DuplicatedResourceException(Users.class, Map.of("email", input.getEmail()));
        }

        Users user = userMapper.toEntity(input);
        user.setIdUser(UUID.randomUUID());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setRole(UserRole.valueOf(input.getRole().toUpperCase()));

        usersRepository.save(user);
        System.out.println("Nome recebido no DTO: " + input.getName());

    }
}
