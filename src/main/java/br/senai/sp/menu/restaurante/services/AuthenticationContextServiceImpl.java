package br.senai.sp.menu.restaurante.services;

import br.senai.sp.menu.restaurante.entities.Users;
import br.senai.sp.menu.restaurante.errors.exceptions.EntityNotFoundException;
import br.senai.sp.menu.restaurante.errors.exceptions.ForbiddenException;
import br.senai.sp.menu.restaurante.repositories.user.UsersRepository;
import br.senai.sp.menu.restaurante.security.dto.UsersDetailsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationContextServiceImpl implements UserDetailsService {

    private final UsersRepository usersRepository;

    // Usado na autenticação
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com e-mail: " + email));
        return new UsersDetailsDTO(user);
    }

    // Usado para recuperar o usuário logado
    public UsersDetailsDTO getData() {
        var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof Optional)
            return this.handleOptionalData((Optional<UsersDetailsDTO>) principal);

        if (principal instanceof UsersDetailsDTO)
            return (UsersDetailsDTO) principal;

        throw new ForbiddenException();
    }

    private UsersDetailsDTO handleOptionalData(Optional<UsersDetailsDTO> principal) {
        principal.orElseThrow(() -> new EntityNotFoundException(UsersDetailsDTO.class));
        return principal.get();
    }

    public Users getLoggedUser() {
        return this.getData().getUser();
    }
}
