package br.senai.sp.menu.restaurante.security.dto;

import br.senai.sp.menu.restaurante.entities.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class UsersDetailsDTO implements UserDetails {

    private Users user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.user.getRole().name()));
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

    //esses metodos sao obrigatorios pra versao do spring boot q estou utilizando
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


     //converte os dados do usuário em um mapa para uso no payload do token JWT.


    public Map<String, ?> toMap() {
        return Map.of(
                "idUser", this.user.getIdUser().toString(),
                "name", this.user.getName(),
                "email", user.getEmail(),
                "role", user.getRole().name()
        );
    }

}
