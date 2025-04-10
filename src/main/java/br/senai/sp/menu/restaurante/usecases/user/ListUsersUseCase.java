package br.senai.sp.menu.restaurante.usecases.user;

import br.senai.sp.menu.restaurante.dtos.user.output.UserDetailedOutputDTO;
import br.senai.sp.menu.restaurante.mappers.users.UserMapper;
import br.senai.sp.menu.restaurante.repositories.user.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListUsersUseCase {

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;

    public List<UserDetailedOutputDTO> execute() {
        return usersRepository.findAll()
                .stream()
                .map(userMapper::toUserDetailedOutputDTO)
                .toList();
    }
}
