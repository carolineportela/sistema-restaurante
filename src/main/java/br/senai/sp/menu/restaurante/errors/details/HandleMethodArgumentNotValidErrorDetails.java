package br.senai.sp.menu.restaurante.errors.details;

public record HandleMethodArgumentNotValidErrorDetails(
        String field,
        String[] messages
) {
}
