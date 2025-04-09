//package br.senai.sp.menu.restaurante.security.dto;
//
//import br.senai.sp.menu.restaurante.entities.Users;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//
//@AllArgsConstructor
//@Getter
//public class UsersDetailsDTO implements UserDetails {
//
//    private Users user;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority(user.getRole().name()));
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    public Map<String, ?> toMap() {
//        return Map.of(
//                "id", user.getUserId(),
//                "username", user.getUsername(),
//                "role", user.getRole()
//        );
//    }
//}

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

    /**
     * aqui usamos o e-mail como identificador principal do usuário.
     */

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

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

    /**
     * Converte os dados do usuário em um mapa para uso no payload do token JWT.
     */

    public Map<String, ?> toMap() {
        return Map.of(
                "id", this.user.getUserId().toString(),
                "name", this.user.getUserName(),
                "email", user.getEmail(),
                "role", user.getRole().name()
        );
    }
}
