/**
 * DTO de saída após o login do usuário.
 *
 * Contém:
 * - token: o JWT gerado após autenticação bem-sucedida.
 *
 * Esse token será usado pelo cliente para acessar endpoints protegidos.
 */

//package br.senai.sp.menu.restaurante.dtos.auth.output;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@AllArgsConstructor
//public class LoginOutputDTO {
//    private String token;
//}

package br.senai.sp.menu.restaurante.dtos.auth.output;

public record LoginOutputDTO(
        String token
) {
}
