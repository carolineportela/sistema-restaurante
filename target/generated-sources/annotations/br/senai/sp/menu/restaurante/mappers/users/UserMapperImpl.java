package br.senai.sp.menu.restaurante.mappers.users;

import br.senai.sp.menu.restaurante.dtos.user.input.CreateUserInputDTO;
import br.senai.sp.menu.restaurante.dtos.user.output.UserDetailedOutputDTO;
import br.senai.sp.menu.restaurante.entities.Users;
import br.senai.sp.menu.restaurante.enums.UserRole;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-11T12:22:40-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDetailedOutputDTO toUserDetailedOutputDTO(Users entity) {
        if ( entity == null ) {
            return null;
        }

        Long userId = null;
        String userName = null;
        String email = null;

        userId = entity.getUserId();
        userName = entity.getUserName();
        email = entity.getEmail();

        UserDetailedOutputDTO userDetailedOutputDTO = new UserDetailedOutputDTO( userId, userName, email );

        return userDetailedOutputDTO;
    }

    @Override
    public Users toEntity(CreateUserInputDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Users users = new Users();

        users.setUserName( dto.getUserName() );
        users.setPassword( dto.getPassword() );
        users.setEmail( dto.getEmail() );
        if ( dto.getRole() != null ) {
            users.setRole( Enum.valueOf( UserRole.class, dto.getRole() ) );
        }

        return users;
    }
}
