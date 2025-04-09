package br.senai.sp.menu.restaurante.mappers.users;

import br.senai.sp.menu.restaurante.dtos.user.input.CreateUserInputDTO;
import br.senai.sp.menu.restaurante.dtos.user.output.UserDetailedOutputDTO;
import br.senai.sp.menu.restaurante.entities.Users;
import org.mapstruct.Mapper;

//@Mapper(componentModel = "spring")
//public interface UserMapper {
//    UserDetailedOutputDTO toOutput(Users entity);
//    Users toEntity(CreateUserInputDTO dto);
//}


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDetailedOutputDTO toUserDetailedOutputDTO(Users entity);
    Users toEntity(CreateUserInputDTO dto);
}
