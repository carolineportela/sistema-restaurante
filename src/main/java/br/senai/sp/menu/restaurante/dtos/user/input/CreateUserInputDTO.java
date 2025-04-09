package br.senai.sp.menu.restaurante.dtos.user.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserInputDTO {
    private String userName;
    private String email;
    private String password;
    private String role;
}
