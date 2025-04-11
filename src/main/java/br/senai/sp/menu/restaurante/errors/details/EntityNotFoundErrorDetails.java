package br.senai.sp.menu.restaurante.errors.details;

import java.util.Map;

public record EntityNotFoundErrorDetails(
        String entityClass,
        Map<String, Object> parameters
) {
}
