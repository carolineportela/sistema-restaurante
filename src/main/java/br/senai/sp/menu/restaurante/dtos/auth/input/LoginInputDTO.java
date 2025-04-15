package br.senai.sp.menu.restaurante.dtos.auth.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginInputDTO {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
