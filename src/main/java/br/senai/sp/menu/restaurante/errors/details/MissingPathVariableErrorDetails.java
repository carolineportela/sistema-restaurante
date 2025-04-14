package br.senai.sp.menu.restaurante.errors.details;

public record MissingPathVariableErrorDetails(
        String variableName,
        String message
) {
}
