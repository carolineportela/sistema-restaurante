/**
 * DTO de entrada para login do usuário.
 *
 * contém os dados necessários para autenticar um usuário:
 *
 * - email
 * - password
 *
 * essa classe é usada no corpo da requisição POST para o endpoint de login.
 */


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
