
/**
 * DTO de entrada para login do usuário.
 *
 * Contém os dados necessários para autenticar um usuário:
 * - username: nome de login.
 * - password: senha.
 *
 * Essa classe é usada no corpo da requisição POST para o endpoint de login.
 */


package br.senai.sp.menu.restaurante.dtos.auth.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginInputDTO {
    private String username;
    private String password;
}