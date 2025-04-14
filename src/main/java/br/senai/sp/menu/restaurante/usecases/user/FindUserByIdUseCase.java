package br.senai.sp.menu.restaurante.usecases.user;

import br.senai.sp.menu.restaurante.dtos.user.output.UserDetailedOutputDTO;
import br.senai.sp.menu.restaurante.entities.Users;
import br.senai.sp.menu.restaurante.errors.exceptions.EntityNotFoundException;
import br.senai.sp.menu.restaurante.mappers.users.UserMapper;
import br.senai.sp.menu.restaurante.repositories.user.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class FindUserByIdUseCase {

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;

    public UserDetailedOutputDTO execute(Long id) {
        var user = this.usersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Users.class,
                        Map.of("id", id))
                );

        return this.userMapper.toUserDetailedOutputDTO(user);
    }
}
