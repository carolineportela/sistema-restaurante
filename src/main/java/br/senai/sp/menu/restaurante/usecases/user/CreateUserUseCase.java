package br.senai.sp.menu.restaurante.usecases.user;

import br.senai.sp.menu.restaurante.dtos.user.input.CreateUserInputDTO;
import br.senai.sp.menu.restaurante.entities.Users;
import br.senai.sp.menu.restaurante.enums.UserRole;
import br.senai.sp.menu.restaurante.mappers.users.UserMapper;
import br.senai.sp.menu.restaurante.repositories.user.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public void execute(CreateUserInputDTO input) {
        Users user = userMapper.toEntity(input);
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        // garante enum válido
        user.setRole(UserRole.valueOf(input.getRole().toUpperCase()));
        usersRepository.save(user);
    }
}
