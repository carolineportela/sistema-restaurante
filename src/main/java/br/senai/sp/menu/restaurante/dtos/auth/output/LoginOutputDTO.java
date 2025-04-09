/**
 * DTO de saída após o login do usuário.
 *
 * contém:
 * - token: o JWT gerado após autenticação bem-sucedida.
 */

package br.senai.sp.menu.restaurante.dtos.auth.output;

public record LoginOutputDTO(
        String token
) {
}
